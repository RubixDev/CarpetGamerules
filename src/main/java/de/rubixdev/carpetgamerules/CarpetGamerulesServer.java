package de.rubixdev.carpetgamerules;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.api.settings.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mojang.brigadier.CommandDispatcher;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.world.GameRules;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarpetGamerulesServer implements CarpetExtension, ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("CarpetGamerules");

    public static final String MOD_ID = "carpetgamerules";
    private static final String MOD_NAME;
    private static final String MOD_VERSION;

    public static boolean ruleChangeIsFromGameruleCommand = false;
    public static SettingsManager settingsManager;

    private static final Map<String, String> gameruleDefaults = new HashMap<>();

    static {
        ModMetadata metadata = FabricLoader.getInstance()
                .getModContainer(MOD_ID)
                .orElseThrow(RuntimeException::new)
                .getMetadata();
        MOD_NAME = metadata.getName();
        MOD_VERSION = metadata.getVersion().getFriendlyString();
        settingsManager = new SettingsManager(MOD_VERSION, MOD_ID, MOD_NAME);
    }

    @Override
    public String version() {
        return MOD_ID;
    }

    @Override
    public void onInitialize() {
        for (Field f : CarpetGamerulesSettings.class.getDeclaredFields()) {
            if (f.getAnnotation(Rule.class) == null) continue;
            try {
                gameruleDefaults.put(f.getName(), f.get(null).toString());
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }

        CarpetServer.manageExtension(new CarpetGamerulesServer());
    }

    @Override
    public void onGameStarted() {
        LOGGER.info(MOD_NAME + " v" + MOD_VERSION + " loaded!");
        settingsManager.parseSettingsClass(CarpetGamerulesSettings.class);
    }

    @Override
    public SettingsManager extensionSettingsManager() {
        return settingsManager;
    }

    @Override
    public Map<String, String> canHasTranslations(String lang) {
        InputStream langFile = CarpetGamerulesServer.class
                .getClassLoader()
                .getResourceAsStream("assets/" + MOD_ID + "/lang/%s.json".formatted(lang));
        if (langFile == null) {
            // we don't have that language
            return Collections.emptyMap();
        }
        String jsonData;
        try {
            jsonData = IOUtils.toString(langFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return Collections.emptyMap();
        }
        Gson gson = new GsonBuilder().setLenient().create(); // lenient allows for comments
        return gson.fromJson(jsonData, new TypeToken<Map<String, String>>() {}.getType());
    }

    @Override
    public void onServerLoadedWorlds(MinecraftServer server) {
        GameRules.accept(new GameRules.Visitor() {
            @Override
            public <T extends GameRules.Rule<T>> void visit(GameRules.Key<T> key, GameRules.Type<T> type) {
                CarpetRule<?> carpetRule = settingsManager.getCarpetRule(key.getName());
                if (carpetRule == null) {
                    LOGGER.warn("No associated carpet rule found for `" + key.getName() + "`, skipping");
                    return;
                }
                boolean isNonDefaultInConfig =
                        !RuleHelper.toRuleString(carpetRule.value()).equals(gameruleDefaults.get(key.getName()));

                if (isNonDefaultInConfig) {
                    updateGameruleValue(carpetRule, key, server);
                } else {
                    try {
                        carpetRule.set(
                                server.getCommandSource(),
                                server.getGameRules().get(key).toString());
                    } catch (InvalidRuleValueException e) {
                        throw new RuntimeException(e);
                    }
                }

                LOGGER.info("Read gamerule " + key.getName() + " with value "
                        + RuleHelper.toRuleString(carpetRule.value()));

                settingsManager.registerRuleObserver((source, rule, s) -> {
                    if (rule.name().equals(key.getName())) {
                        if (ruleChangeIsFromGameruleCommand) {
                            ruleChangeIsFromGameruleCommand = false;
                            return;
                        }
                        updateGameruleValue(rule, key, server);
                    }
                });
            }
        });
    }

    private void updateGameruleValue(CarpetRule<?> carpetRule, GameRules.Key<?> key, MinecraftServer server) {
        if (carpetRule.type() == Boolean.class) {
            GameRules.BooleanRule gamerule =
                    (GameRules.BooleanRule) server.getGameRules().get(key);
            gamerule.set(RuleHelper.getBooleanValue(carpetRule), server);
        } else {
            GameRules.IntRule gamerule =
                    (GameRules.IntRule) server.getGameRules().get(key);
            gamerule.set((Integer) carpetRule.value(), server);
        }
    }
}
