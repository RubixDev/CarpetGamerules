# Carpet Gamerules

[![GitHub all releases](https://img.shields.io/github/downloads/RubixDev/CarpetGamerules/total?style=for-the-badge)](https://github.com/RubixDev/CarpetGamerules/releases)
[![GitHub release (latest by date)](https://img.shields.io/github/downloads/RubixDev/CarpetGamerules/latest/total?style=for-the-badge)](https://github.com/RubixDev/CarpetGamerules/releases/latest)
[![License](https://img.shields.io/github/license/RubixDev/CarpetGamerules?style=for-the-badge)](https://github.com/RubixDev/CarpetGamerules/blob/main/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/RubixDev/CarpetGamerules?style=for-the-badge)](https://github.com/RubixDev/CarpetGamerules/issues)
[![GitHub closed issues](https://img.shields.io/github/issues-closed/RubixDev/CarpetGamerules?style=for-the-badge)](https://github.com/RubixDev/CarpetGamerules/issues?q=is%3Aissue+is%3Aclosed)
[![CurseForge Total Downloads](http://cf.way2muchnoise.eu/full_504123_downloads.svg?badge_style=for_the_badge)](https://www.curseforge.com/minecraft/mc-mods/carpetgamerules/files)
[![CurseForge All Versions](http://cf.way2muchnoise.eu/versions/For%20MC_504123_all.svg?badge_style=for_the_badge)](https://www.curseforge.com/minecraft/mc-mods/carpetgamerules)
[![Modrinth](https://img.shields.io/modrinth/dt/carpetgamerules?color=%231bd96a&label=Modrinth%20downloads&style=for-the-badge)](https://modrinth.com/mod/carpetgamerules)

![Icon](https://raw.githubusercontent.com/RubixDev/CarpetGamerules/main/src/main/resources/assets/carpetgamerules/icon.png)

An extension for [gnembon's Carpet Mod](https://github.com/gnembon/fabric-carpet) that adds all vanilla gamerules to the carpet settings.

## Related Mods and Tools

[![Carpet Mod](https://github-readme-stats.vercel.app/api/pin/?username=gnembon&repo=fabric-carpet&theme=dracula&show_owner=true)](https://github.com/gnembon/fabric-carpet)

[![Rug](https://github-readme-stats.vercel.app/api/pin/?username=RubixDev&repo=Rug&theme=dracula&show_owner=true)](https://github.com/RubixDev/Rug)

[![CarpetConfigCreator](https://github-readme-stats.vercel.app/api/pin/?username=RubixDev&repo=CarpetConfigCreator&theme=dracula&show_owner=true)](https://github.com/RubixDev/CarpetConfigCreator)

## Lists of Categories
- [`CHAT`](markdown/CHAT_Category.md)
- [`DROPS`](markdown/DROPS_Category.md)
- [`MISC`](markdown/MISC_Category.md)
- [`MOBS`](markdown/MOBS_Category.md)
- [`PLAYER`](markdown/PLAYER_Category.md)
- [`SPAWNING`](markdown/SPAWNING_Category.md)
- [`WORLD_UPDATES`](markdown/WORLD_UPDATES_Category.md)

## Index
Count: 36
- [announceAdvancements](#announceadvancements)
- [commandBlockOutput](#commandblockoutput)
- [disableElytraMovementCheck](#disableelytramovementcheck)
- [disableRaids](#disableraids)
- [doDaylightCycle](#dodaylightcycle)
- [doEntityDrops](#doentitydrops)
- [doFireTick](#dofiretick)
- [doImmediateRespawn](#doimmediaterespawn)
- [doInsomnia](#doinsomnia)
- [doLimitedCrafting](#dolimitedcrafting)
- [doMobLoot](#domobloot)
- [doMobSpawning](#domobspawning)
- [doPatrolSpawning](#dopatrolspawning)
- [doTileDrops](#dotiledrops)
- [doTraderSpawning](#dotraderspawning)
- [doWardenSpawning](#dowardenspawning)
- [doWeatherCycle](#doweathercycle)
- [drowningDamage](#drowningdamage)
- [fallDamage](#falldamage)
- [fireDamage](#firedamage)
- [forgiveDeadPlayers](#forgivedeadplayers)
- [freezeDamage](#freezedamage)
- [keepInventory](#keepinventory)
- [logAdminCommands](#logadmincommands)
- [maxCommandChainLength](#maxcommandchainlength)
- [maxEntityCramming](#maxentitycramming)
- [mobGriefing](#mobgriefing)
- [naturalRegeneration](#naturalregeneration)
- [playersSleepingPercentage](#playerssleepingpercentage)
- [randomTickSpeed](#randomtickspeed)
- [reducedDebugInfo](#reduceddebuginfo)
- [sendCommandFeedback](#sendcommandfeedback)
- [showDeathMessages](#showdeathmessages)
- [spawnRadius](#spawnradius)
- [spectatorsGenerateChunks](#spectatorsgeneratechunks)
- [universalAnger](#universalanger)

## Implemented Rules

### announceAdvancements
Announce advancements

Whether advancements should be announced in chat
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `CHAT`, `GAMERULE`

### commandBlockOutput
Broadcast command block output

Whether command blocks should notify admins when they perform commands
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `CHAT`, `GAMERULE`

### disableElytraMovementCheck
Disable elytra movement check

Whether the server should skip checking player speed when the player is wearing elytra. Often helps with jittering due to lag in multiplayer
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### disableRaids
Disable raids

Whether raids are disabled
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `MOBS`

### doDaylightCycle
Advance time of day

Whether the daylight cycle and moon phases progress
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `WORLD_UPDATES`

### doEntityDrops
Drop entity equipment

Controls drops from minecarts (including inventories), item frames, boats, etc.
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `DROPS`, `GAMERULE`

### doFireTick
Update fire

Whether fire should spread and naturally extinguish
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `WORLD_UPDATES`

### doImmediateRespawn
Respawn immediately

Players respawn immediately without showing the death screen
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### doInsomnia
Spawn phantoms

Whether phantoms can spawn in the nighttime
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `SPAWNING`

### doLimitedCrafting
Require recipe for crafting

If enabled, players will be able to craft only unlocked recipes
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### doMobLoot
Drop mob loot

Controls resource drops from mobs, including experience orbs
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `DROPS`, `GAMERULE`

### doMobSpawning
Spawn mobs

Some entities might have seperate rules. Does not affect monster spawners
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `SPAWNING`

### doPatrolSpawning
Spawn pillager patrols

Whether pillager patrols can spawn
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `SPAWNING`

### doTileDrops
Drop blocks

Controls resource drops from blocks, including experience orbs
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `DROPS`, `GAMERULE`

### doTraderSpawning
Spawn wandering traders

Whether wandering traders can spawn
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `SPAWNING`

### doWardenSpawning
Spawn wardens

Whether wardens can spawn
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `SPAWNING`

### doWeatherCycle
Update weather

Whether the weather can change naturally. The `/weather` command can still change weather
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `WORLD_UPDATES`

### drowningDamage
Deal drowning damage

Whether the player should take damage when drowning
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### fallDamage
Deal fall damage

Whether the player should take fall damage
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### fireDamage
Deal fire damage

Whether the player should take damage in fire, lava, campfires, or on magma blocks
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### forgiveDeadPlayers
Forgive dead players

Angered neutral mobs stop being angry when the targeted player dies nearby
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `MOBS`

### freezeDamage
Deal freeze damage

Whether the player should take damage when inside powder snow
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### keepInventory
Keep inventory after death

Whether the player should keep items and experience in their inventory after death
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### logAdminCommands
Broadcast admin commands

Whether to log admin commands to server log
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `CHAT`, `GAMERULE`

### maxCommandChainLength
Command chain size limit

The maximum length of a chain of commands that can be executed during one tick. Applies to command blocks and functions
- Type: `int`
- Default value: `65536`
- Suggested options: `65536`
- Categories: `GAMERULE`, `MISC`

### maxEntityCramming
Entity cramming threshold

The maximum number of pushable entities a mob or player can push, before taking 3 suffocation damage per half-second  
Setting to 0 or lower disables the rule  
Damage affects survival-mode or adventure-mode players, and all mobs but bats. Pushable entities include non-spectator-mode players, any mob except bats, as well as boats and minecarts
- Type: `int`
- Default value: `24`
- Suggested options: `0`, `12`, `24`, `100`
- Categories: `GAMERULE`, `MOBS`

### mobGriefing
Allow destructive mob actions

Whether creepers, zombies, endermen, ghasts, withers, ender dragons, rabbits, sheep, villagers, silverfish, snow golems, and end crystals should be able to change blocks and whether mobs can pick up items, which also disables bartering  
This also affects the capability of zombie-like creatures like zombified piglins and drowned to pathfind to turtle eggs
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `MOBS`

### naturalRegeneration
Regenerate health

Whether the player can regenerate health naturally if their hunger is full enough  
Doesn't affect external healing, such as golden apples, the Regeneration effect, etc.
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### playersSleepingPercentage
Sleep percentage

The percentage of players who must be sleeping to skip the night
- Type: `int`
- Default value: `100`
- Suggested options: `0`, `25`, `50`, `75`, `100`
- Categories: `GAMERULE`, `PLAYER`

### randomTickSpeed
Random tick speed rate

How often a random block tick occurs (such as plant growth, leaf decay, etc.) per chunk section per game tick  
0 and negative values disables random ticks, higher numbers increase random ticks  
Setting to a high integer results in high speeds of decay and growth  
Numbers over 4096 make plant growth or leaf decay instantaneous
- Type: `int`
- Default value: `3`
- Suggested options: `0`, `3`, `30`, `300`, `3000`, `4096`
- Categories: `GAMERULE`, `WORLD_UPDATES`

### reducedDebugInfo
Reduce debug info

Limits contents of debug screen
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `MISC`

### sendCommandFeedback
Send command feedback

Whether the feedback from commands executed by a player should show up in chat  
Also affects the default behavior of whether command blocks store their output text
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `CHAT`, `GAMERULE`

### showDeathMessages
Show death messages

Whether death messages are put into chat when a player dies  
Also affects whether a message is sent to the pet's owner when the pet dies
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `CHAT`, `GAMERULE`

### spawnRadius
Respawn location radius

The number of blocks outward from the world spawn coordinates that a player spawns in when first joining a server or when dying without a personal spawnpoint
- Type: `int`
- Default value: `10`
- Suggested options: `0`, `1`, `5`, `10`, `50`
- Categories: `GAMERULE`, `PLAYER`

### spectatorsGenerateChunks
Allow spectators to generate terrain

Whether players in spectator mode can generate chunks
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### universalAnger
Universal anger

Angered neutral mobs attack any nearby player, not just the player that angered them. Works best if `forgiveDeadPlayers` is disabled
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `MOBS`
