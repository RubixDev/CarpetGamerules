package de.rubixdev.carpetgamerules;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.settings.ParsedRule;
import carpet.settings.Rule;
import carpet.settings.SettingsManager;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.ParsedArgument;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.world.GameRules;
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
    public SettingsManager customSettingsManager() {
        return settingsManager;
    }

    @Override
    public void onServerLoadedWorlds(MinecraftServer server) {
        Set<String> allGameRules = new HashSet<>();

        GameRules.accept(new GameRules.Visitor() {
            @Override
            public <T extends GameRules.Rule<T>> void visit(GameRules.Key<T> key, GameRules.Type<T> type) {
                allGameRules.add(key.getName());
                ParsedRule<?> carpetRule = settingsManager.getRule(key.getName());
                if (carpetRule == null) {
                    LOGGER.warn("No associated carpet rule found for `" + key.getName() + "`, skipping");
                    return;
                }
                boolean isNonDefaultInConfig = !carpetRule.getAsString().equals(gameruleDefaults.get(key.getName()));

                if (isNonDefaultInConfig) {
                    updateGameruleValue(carpetRule, key, server);
                } else {
                    carpetRule.set(
                            server.getCommandSource(),
                            server.getGameRules().get(key).toString());
                }

                LOGGER.info("Read gamerule " + key.getName() + " with value " + carpetRule.getAsString());

                settingsManager.addRuleObserver((source, rule, s) -> {
                    if (rule.name.equals(key.getName())) {
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
            if (!allGameRules.contains(f.getName())) {
                LOGGER.error("No associated gamerule exists for carpet rule `" + f.getName() + "`");
            }
        }
    }

    private void updateGameruleValue(ParsedRule<?> carpetRule, GameRules.Key<?> key, MinecraftServer server) {
        if (carpetRule.type == boolean.class) {
            GameRules.BooleanRule gamerule =
                    (GameRules.BooleanRule) server.getGameRules().get(key);
            gamerule.set(carpetRule.getBoolValue(), server);
        } else {
            GameRules.IntRule gamerule =
                    (GameRules.IntRule) server.getGameRules().get(key);
            // the only public `set` method takes a command context, so we spoof one with just the relevant information
            CommandContext<ServerCommandSource> context = new CommandContext<>(
                    server.getCommandSource(),
                    "",
                    Map.of("value", new ParsedArgument<>(0, 0, (Integer) carpetRule.get())),
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    false);
            gamerule.set(context, "value");
        }
    }
}
