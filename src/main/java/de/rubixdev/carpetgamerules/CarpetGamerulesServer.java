package de.rubixdev.carpetgamerules;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import java.lang.reflect.Field;
import java.util.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//#if MC >= 11901
import carpet.api.settings.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
//#else
//$$ import carpet.settings.ParsedRule;
//$$ import carpet.settings.SettingsManager;
//$$ import carpet.settings.Rule;
//#endif

//#if MC >= 11700
//#else
//$$ import com.mojang.brigadier.context.CommandContext;
//$$ import com.mojang.brigadier.context.ParsedArgument;
//$$ import net.minecraft.server.command.ServerCommandSource;
//#endif

public class CarpetGamerulesServer implements CarpetExtension, ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("CarpetGamerules");
    public static final CarpetGamerulesServer INSTANCE = new CarpetGamerulesServer();

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

        CarpetServer.manageExtension(INSTANCE);
    }

    @Override
    public void onGameStarted() {
        LOGGER.info(MOD_NAME + " v" + MOD_VERSION + " loaded!");
        settingsManager.parseSettingsClass(CarpetGamerulesSettings.class);
    }

    //#if MC >= 11901
    @Override
    public SettingsManager extensionSettingsManager() {
        return settingsManager;
    }
    //#else
    //$$ @Override
    //$$ public SettingsManager customSettingsManager() {
    //$$     return settingsManager;
    //$$ }
    //#endif

    //#if MC >= 11901
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
        Gson gson = new Gson();
        return gson.fromJson(jsonData, new TypeToken<Map<String, String>>() {}.getType());
    }
    //#endif

    //#if MC >= 11500
    @Override
    //#endif
    public void onServerLoadedWorlds(MinecraftServer server) {
        Set<String> allGamerules = new HashSet<>();

        GameRules.accept(new GameRules.Visitor() {
            @Override
            public <T extends GameRules.Rule<T>> void visit(GameRules.Key<T> key, GameRules.Type<T> type) {
                allGamerules.add(key.getName());
                //#if MC >= 11901
                CarpetRule<?> carpetRule = settingsManager.getCarpetRule(key.getName());
                //#else
                //$$ ParsedRule<?> carpetRule = settingsManager.getRule(key.getName());
                //#endif
                if (carpetRule == null) {
                    LOGGER.warn("No associated carpet rule found for `" + key.getName() + "`, skipping");
                    return;
                }
                //#if MC >= 11901
                String stringValue = RuleHelper.toRuleString(carpetRule.value());
                //#else
                //$$ String stringValue = carpetRule.getAsString();
                //#endif
                boolean isNonDefaultInConfig = !stringValue.equals(gameruleDefaults.get(key.getName()));

                if (isNonDefaultInConfig) {
                    updateGameruleValue(carpetRule, key, server);
                } else {
                    //#if MC >= 11901
                    try {
                        carpetRule.set(
                                server.getCommandSource(),
                                server.getGameRules().get(key).toString());
                    } catch (InvalidRuleValueException e) {
                        throw new RuntimeException(e);
                    }
                    //#else
                    //$$ carpetRule.set(
                    //$$         server.getCommandSource(),
                    //$$         server.getGameRules().get(key).toString());
                    //#endif
                }

                LOGGER.info("Read gamerule " + key.getName() + " with value " + stringValue);

                //#if MC >= 11901
                settingsManager.registerRuleObserver((source, rule, s) -> {
                    if (rule.name().equals(key.getName())) {
                //#else
                //$$ settingsManager.addRuleObserver((source, rule, s) -> {
                //$$     if (rule.name.equals(key.getName())) {
                //#endif
                        if (ruleChangeIsFromGameruleCommand) {
                            ruleChangeIsFromGameruleCommand = false;
                            return;
                        }
                        updateGameruleValue(rule, key, server);
                    }
                });
            }
        });

        for (Field f : CarpetGamerulesSettings.class.getDeclaredFields()) {
            if (f.getAnnotation(Rule.class) == null) continue;
            if (!allGamerules.contains(f.getName())) {
                LOGGER.error("No associated gamerule exists for carpet rule `" + f.getName() + "`");
            }
        }
    }

    private void updateGameruleValue(
            //#if MC >= 11901
            CarpetRule<?> carpetRule,
            //#else
            //$$ ParsedRule<?> carpetRule,
            //#endif
            GameRules.Key<?> key,
            MinecraftServer server
    ) {
        if (
                //#if MC >= 11901
                carpetRule.type() == Boolean.class
                //#else
                //$$ carpetRule.type == boolean.class
                //#endif
        ) {
            GameRules.BooleanRule gamerule =
                    (GameRules.BooleanRule) server.getGameRules().get(key);
            gamerule.set(
                    //#if MC >= 11901
                    RuleHelper.getBooleanValue(carpetRule),
                    //#else
                    //$$ carpetRule.getBoolValue(),
                    //#endif
                    server
            );
        } else {
            GameRules.IntRule gamerule =
                    (GameRules.IntRule) server.getGameRules().get(key);
            //#if MC >= 11700
            gamerule.set(
                    //#if MC >= 11901
                    (Integer) carpetRule.value(),
                    //#else
                    //$$ (Integer) carpetRule.get(),
                    //#endif
                    server
            );
            //#else
            //$$ // the only public `set` method takes a command context, so we spoof one with just the relevant information
            //$$ Map<String, ParsedArgument<ServerCommandSource, ?>> map = new HashMap<>();
            //$$ map.put("value", new ParsedArgument<>(0, 0, (Integer) carpetRule.get()));
            //$$ CommandContext<ServerCommandSource> context =
            //$$         new CommandContext<>(server.getCommandSource(), "", map, null, null, null, null, null, null, false);
            //$$ gamerule.set(context, "value");
            //#endif
        }
    }
}
