package de.rubixdev.carpetgamerules;

import carpet.api.settings.Rule;

public class CarpetGamerulesSettings {
    public static final String GAMERULE = "gamerule";
    public static final String PLAYER = "player";
    public static final String MOBS = "mobs";
    public static final String SPAWNING = "spawning";
    public static final String DROPS = "drops";
    public static final String WORLD_UPDATES = "world_updates";
    public static final String CHAT = "chat";
    public static final String MISC = "miscellaneous";

    @Rule(categories = {GAMERULE, CHAT})
    public static boolean announceAdvancements = true;

    @Rule(categories = {GAMERULE, DROPS})
    public static boolean blockExplosionDropDecay = true;

    @Rule(categories = {GAMERULE, CHAT})
    public static boolean commandBlockOutput = true;

    @Rule(
            categories = {GAMERULE, MISC},
            strict = false,
            options = {"32768", "1000000", "2147483647"})
    public static int commandModificationBlockLimit = 32768;

    @Rule(categories = {GAMERULE, PLAYER})
    public static boolean disableElytraMovementCheck = false;

    @Rule(categories = {GAMERULE, MOBS})
    public static boolean disableRaids = false;

    @Rule(categories = {GAMERULE, WORLD_UPDATES})
    public static boolean doDaylightCycle = true;

    @Rule(categories = {GAMERULE, DROPS})
    public static boolean doEntityDrops = true;

    @Rule(categories = {GAMERULE, WORLD_UPDATES})
    public static boolean doFireTick = true;

    @Rule(categories = {GAMERULE, PLAYER})
    public static boolean doImmediateRespawn = false;

    @Rule(categories = {GAMERULE, SPAWNING})
    public static boolean doInsomnia = true;

    @Rule(categories = {GAMERULE, PLAYER})
    public static boolean doLimitedCrafting = false;

    @Rule(categories = {GAMERULE, DROPS})
    public static boolean doMobLoot = true;

    @Rule(categories = {GAMERULE, SPAWNING})
    public static boolean doMobSpawning = true;

    @Rule(categories = {GAMERULE, SPAWNING})
    public static boolean doPatrolSpawning = true;

    @Rule(categories = {GAMERULE, DROPS})
    public static boolean doTileDrops = true;

    @Rule(categories = {GAMERULE, SPAWNING})
    public static boolean doTraderSpawning = true;

    @Rule(categories = {GAMERULE, WORLD_UPDATES})
    public static boolean doVinesSpread = true;

    @Rule(categories = {GAMERULE, SPAWNING})
    public static boolean doWardenSpawning = true;

    @Rule(categories = {GAMERULE, WORLD_UPDATES})
    public static boolean doWeatherCycle = true;

    @Rule(categories = {GAMERULE, PLAYER})
    public static boolean drowningDamage = true;

    @Rule(categories = {GAMERULE, PLAYER})
    public static boolean fallDamage = true;

    @Rule(categories = {GAMERULE, PLAYER})
    public static boolean fireDamage = true;

    @Rule(categories = {GAMERULE, MOBS})
    public static boolean forgiveDeadPlayers = true;

    @Rule(categories = {GAMERULE, PLAYER})
    public static boolean freezeDamage = true;

    @Rule(categories = {GAMERULE, MISC})
    public static boolean globalSoundEvents = true;

    @Rule(categories = {GAMERULE, PLAYER})
    public static boolean keepInventory = false;

    @Rule(categories = {GAMERULE, WORLD_UPDATES})
    public static boolean lavaSourceConversion = false;

    @Rule(categories = {GAMERULE, CHAT})
    public static boolean logAdminCommands = true;

    @Rule(
            categories = {GAMERULE, MISC},
            strict = false,
            options = {"65536"})
    public static int maxCommandChainLength = 65536;

    @Rule(
            categories = {GAMERULE, MOBS},
            strict = false,
            options = {"0", "12", "24", "100"})
    public static int maxEntityCramming = 24;

    @Rule(categories = {GAMERULE, DROPS})
    public static boolean mobExplosionDropDecay = true;

    @Rule(categories = {GAMERULE, MOBS})
    public static boolean mobGriefing = true;

    @Rule(categories = {GAMERULE, PLAYER})
    public static boolean naturalRegeneration = true;

    @Rule(
            categories = {GAMERULE, PLAYER},
            strict = false,
            options = {"0", "25", "50", "75", "100"})
    public static int playersSleepingPercentage = 100;

    @Rule(
            categories = {GAMERULE, WORLD_UPDATES},
            strict = false,
            options = {"0", "3", "30", "300", "3000", "4096"})
    public static int randomTickSpeed = 3;

    @Rule(categories = {GAMERULE, MISC})
    public static boolean reducedDebugInfo = false;

    @Rule(categories = {GAMERULE, CHAT})
    public static boolean sendCommandFeedback = true;

    @Rule(categories = {GAMERULE, CHAT})
    public static boolean showDeathMessages = true;

    @Rule(
            categories = {GAMERULE, WORLD_UPDATES},
            strict = false,
            options = {"0", "1", "8"})
    public static int snowAccumulationHeight = 1;

    @Rule(
            categories = {GAMERULE, PLAYER},
            strict = false,
            options = {"0", "1", "5", "10", "50"})
    public static int spawnRadius = 10;

    @Rule(categories = {GAMERULE, PLAYER})
    public static boolean spectatorsGenerateChunks = true;

    @Rule(categories = {GAMERULE, DROPS})
    public static boolean tntExplosionDropDecay = false;

    @Rule(categories = {GAMERULE, MOBS})
    public static boolean universalAnger = false;

    @Rule(categories = {GAMERULE, WORLD_UPDATES})
    public static boolean waterSourceConversion = true;
}

// BUGFIX
// COMMAND
// EXPERIMENTAL
// FEATURE
// CREATIVE
// CLIENT
// DISPENSER
// OPTIMIZATION
// SCARPET
// SURVIVAL
// TNT
