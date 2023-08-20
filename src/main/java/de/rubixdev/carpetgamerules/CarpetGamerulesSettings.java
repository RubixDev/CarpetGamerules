package de.rubixdev.carpetgamerules;

import carpet.settings.Rule;

public class CarpetGamerulesSettings {
    public static final String GAMERULE = "gamerule";
    public static final String PLAYER = "player";
    public static final String MOBS = "mobs";
    public static final String SPAWNING = "spawning";
    public static final String DROPS = "drops";
    public static final String WORLD_UPDATES = "world_updates";
    public static final String CHAT = "chat";
    public static final String MISC = "miscellaneous";

    @Rule(
            desc = "Announce advancements",
            extra = "Whether advancements should be announced in chat",
            category = {GAMERULE, CHAT})
    public static boolean announceAdvancements = true;

    @Rule(
            desc = "Broadcast command block output",
            extra = "Whether command blocks should notify admins when they perform commands",
            category = {GAMERULE, CHAT})
    public static boolean commandBlockOutput = true;

    @Rule(
            desc = "Disable elytra movement check",
            extra =
                    "Whether the server should skip checking player speed when the player is wearing elytra. Often helps with jittering due to lag in multiplayer",
            category = {GAMERULE, PLAYER})
    public static boolean disableElytraMovementCheck = false;

    @Rule(
            desc = "Disable raids",
            extra = "Whether raids are disabled",
            category = {GAMERULE, MOBS})
    public static boolean disableRaids = false;

    @Rule(
            desc = "Advance time of day",
            extra = "Whether the daylight cycle and moon phases progress",
            category = {GAMERULE, WORLD_UPDATES})
    public static boolean doDaylightCycle = true;

    @Rule(
            desc = "Drop entity equipment",
            extra = "Controls drops from minecarts (including inventories), item frames, boats, etc.",
            category = {GAMERULE, DROPS})
    public static boolean doEntityDrops = true;

    @Rule(
            desc = "Update fire",
            extra = "Whether fire should spread and naturally extinguish",
            category = {GAMERULE, WORLD_UPDATES})
    public static boolean doFireTick = true;

    @Rule(
            desc = "Respawn immediately",
            extra = "Players respawn immediately without showing the death screen",
            category = {GAMERULE, PLAYER})
    public static boolean doImmediateRespawn = false;

    @Rule(
            desc = "Spawn phantoms",
            extra = "Whether phantoms can spawn in the nighttime",
            category = {GAMERULE, SPAWNING})
    public static boolean doInsomnia = true;

    @Rule(
            desc = "Require recipe for crafting",
            extra = "If enabled, players will be able to craft only unlocked recipes",
            category = {GAMERULE, PLAYER})
    public static boolean doLimitedCrafting = false;

    @Rule(
            desc = "Drop mob loot",
            extra = "Controls resource drops from mobs, including experience orbs",
            category = {GAMERULE, DROPS})
    public static boolean doMobLoot = true;

    @Rule(
            desc = "Spawn mobs",
            extra = "Some entities might have seperate rules. Does not affect monster spawners",
            category = {GAMERULE, SPAWNING})
    public static boolean doMobSpawning = true;

    @Rule(
            desc = "Spawn pillager patrols",
            extra = "Whether pillager patrols can spawn",
            category = {GAMERULE, SPAWNING})
    public static boolean doPatrolSpawning = true;

    @Rule(
            desc = "Drop blocks",
            extra = "Controls resource drops from blocks, including experience orbs",
            category = {GAMERULE, DROPS})
    public static boolean doTileDrops = true;

    @Rule(
            desc = "Spawn wandering traders",
            extra = "Whether wandering traders can spawn",
            category = {GAMERULE, SPAWNING})
    public static boolean doTraderSpawning = true;

    @Rule(
            desc = "Update weather",
            extra = "Whether the weather can change naturally. The `/weather` command can still change weather",
            category = {GAMERULE, WORLD_UPDATES})
    public static boolean doWeatherCycle = true;

    @Rule(
            desc = "Deal drowning damage",
            extra = "Whether the player should take damage when drowning",
            category = {GAMERULE, PLAYER})
    public static boolean drowningDamage = true;

    @Rule(
            desc = "Deal fall damage",
            extra = "Whether the player should take fall damage",
            category = {GAMERULE, PLAYER})
    public static boolean fallDamage = true;

    @Rule(
            desc = "Deal fire damage",
            extra = "Whether the player should take damage in fire, lava, campfires, or on magma blocks",
            category = {GAMERULE, PLAYER})
    public static boolean fireDamage = true;

    @Rule(
            desc = "Forgive dead players",
            extra = "Angered neutral mobs stop being angry when the targeted player dies nearby",
            category = {GAMERULE, MOBS})
    public static boolean forgiveDeadPlayers = true;

    @Rule(
            desc = "Deal freeze damage",
            extra = "Whether the player should take damage when inside powder snow",
            category = {GAMERULE, PLAYER})
    public static boolean freezeDamage = true;

    @Rule(
            desc = "Keep inventory after death",
            extra = "Whether the player should keep items and experience in their inventory after death",
            category = {GAMERULE, PLAYER})
    public static boolean keepInventory = false;

    @Rule(
            desc = "Broadcast admin commands",
            extra = "Whether to log admin commands to server log",
            category = {GAMERULE, CHAT})
    public static boolean logAdminCommands = true;

    @Rule(
            desc = "Command chain size limit",
            extra =
                    "The maximum length of a chain of commands that can be executed during one tick. Applies to command blocks and functions",
            category = {GAMERULE, MISC},
            strict = false,
            options = {"65536"})
    public static int maxCommandChainLength = 65536;

    @Rule(
            desc = "Entity cramming threshold",
            extra = {
                "The maximum number of pushable entities a mob or player can push, before taking 3 suffocation damage per half-second.",
                "Setting to 0 or lower disables the rule.",
                "Damage affects survival-mode or adventure-mode players, and all mobs but bats. Pushable entities include non-spectator-mode players, any mob except bats, as well as boats and minecarts."
            },
            category = {GAMERULE, MOBS},
            strict = false,
            options = {"0", "12", "24", "100"})
    public static int maxEntityCramming = 24;

    @Rule(
            desc = "Allow destructive mob actions",
            extra = {
                "Whether creepers, zombies, endermen, ghasts, withers, ender dragons, rabbits, sheep, villagers, silverfish, snow golems, and end crystals should be able to change blocks and whether mobs can pick up items, which also disables bartering",
                "This also affects the capability of zombie-like creatures like zombified piglins and drowned to pathfind to turtle eggs"
            },
            category = {GAMERULE, MOBS})
    public static boolean mobGriefing = true;

    @Rule(
            desc = "Regenerate health",
            extra = {
                "Whether the player can regenerate health naturally if their hunger is full enough",
                "Doesn't affect external healing, such as golden apples, the Regeneration effect, etc."
            },
            category = {GAMERULE, PLAYER})
    public static boolean naturalRegeneration = true;

    @Rule(
            desc = "Sleep percentage",
            extra = "The percentage of players who must be sleeping to skip the night",
            category = {GAMERULE, PLAYER},
            strict = false,
            options = {"0", "25", "50", "75", "100"})
    public static int playersSleepingPercentage = 100;

    @Rule(
            desc = "Random tick speed rate",
            extra = {
                "How often a random block tick occurs (such as plant growth, leaf decay, etc.) per chunk section per game tick",
                "0 and negative values disables random ticks, higher numbers increase random ticks",
                "Setting to a high integer results in high speeds of decay and growth",
                "Numbers over 4096 make plant growth or leaf decay instantaneous"
            },
            category = {GAMERULE, WORLD_UPDATES},
            strict = false,
            options = {"0", "3", "30", "300", "3000", "4096"})
    public static int randomTickSpeed = 3;

    @Rule(
            desc = "Reduce debug info",
            extra = "Limits contents of debug screen",
            category = {GAMERULE, MISC})
    public static boolean reducedDebugInfo = false;

    @Rule(
            desc = "Send command feedback",
            extra = {
                "Whether the feedback from commands executed by a player should show up in chat",
                "Also affects the default behavior of whether command blocks store their output text"
            },
            category = {GAMERULE, CHAT})
    public static boolean sendCommandFeedback = true;

    @Rule(
            desc = "Show death messages",
            extra = {
                "Whether death messages are put into chat when a player dies",
                "Also affects whether a message is sent to the pet's owner when the pet dies"
            },
            category = {GAMERULE, CHAT})
    public static boolean showDeathMessages = true;

    @Rule(
            desc = "Respawn location radius",
            extra =
                    "The number of blocks outward from the world spawn coordinates that a player spawns in when first joining a server or when dying without a personal spawnpoint",
            category = {GAMERULE, PLAYER},
            strict = false,
            options = {"0", "1", "5", "10", "50"})
    public static int spawnRadius = 10;

    @Rule(
            desc = "Allow spectators to generate terrain",
            extra = "Whether players in spectator mode can generate chunks",
            category = {GAMERULE, PLAYER})
    public static boolean spectatorsGenerateChunks = true;

    @Rule(
            desc = "Universal anger",
            extra =
                    "Angered neutral mobs attack any nearby player, not just the player that angered them. Works best if `forgiveDeadPlayers` is disabled",
            category = {GAMERULE, MOBS})
    public static boolean universalAnger = false;
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
