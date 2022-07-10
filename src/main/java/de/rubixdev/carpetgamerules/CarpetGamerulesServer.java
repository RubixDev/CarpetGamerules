package de.rubixdev.carpetgamerules;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.settings.ParsedRule;
import carpet.settings.Rule;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CarpetGamerulesServer implements CarpetExtension, ModInitializer {
    public static final String VERSION = "1.1.1";
    public static final Logger LOGGER = LogManager.getLogger("CarpetGamerules");

    public static boolean ruleChangeIsFromGameruleCommand = false;

    private static final Map<String, String> gameruleDefaults = new HashMap<>();

    @Override
    public String version() {
        return "carpetgamerules";
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
        LOGGER.info("CarpetGamerules Mod v" + VERSION + " loaded!");

        CarpetServer.settingsManager.parseSettingsClass(CarpetGamerulesSettings.class);
    }

    @Override
    public void onServerLoadedWorlds(MinecraftServer server) {
        GameRules.accept(new GameRules.Visitor() {
            @Override
            public <T extends GameRules.Rule<T>> void visit(GameRules.Key<T> key, GameRules.Type<T> type) {
                ParsedRule<?> carpetRule = CarpetServer.settingsManager.getRule(key.getName());
                if (carpetRule == null) {
                    LOGGER.warn("No associated carpet rule found for `" + key.getName() + "`, skipping");
                    return;
                }
                boolean isNonDefaultInConfig = !carpetRule.getAsString().equals(gameruleDefaults.get(key.getName()));

                if (isNonDefaultInConfig) {
                    updateGameruleValue(carpetRule, key, server);
                } else {
                    carpetRule.set(server.getCommandSource(), server.getGameRules().get(key).toString());
                }

                LOGGER.info("Read gamerule " + key.getName() + " with value " + carpetRule.getAsString());

                CarpetServer.settingsManager.addRuleObserver((source, rule, s) -> {
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
    }

    private void updateGameruleValue(ParsedRule<?> carpetRule, GameRules.Key<?> key, MinecraftServer server) {
        if (carpetRule.type == boolean.class) {
            GameRules.BooleanRule gamerule = (GameRules.BooleanRule) server.getGameRules().get(key);
            gamerule.set(carpetRule.getBoolValue(), server);
        } else {
            GameRules.IntRule gamerule = (GameRules.IntRule) server.getGameRules().get(key);
            gamerule.set((Integer) carpetRule.get(), server);
        }
    }
}
