# List of Rules in the PLAYER Category

For a list of all implemented Rules go [here](../README.md)
## Index
Count: 16
- [disableElytraMovementCheck](#disableelytramovementcheck)
- [disablePlayerMovementCheck](#disableplayermovementcheck)
- [doImmediateRespawn](#doimmediaterespawn)
- [doLimitedCrafting](#dolimitedcrafting)
- [drowningDamage](#drowningdamage)
- [enderPearlsVanishOnDeath](#enderpearlsvanishondeath)
- [fallDamage](#falldamage)
- [fireDamage](#firedamage)
- [freezeDamage](#freezedamage)
- [keepInventory](#keepinventory)
- [naturalRegeneration](#naturalregeneration)
- [playersNetherPortalCreativeDelay](#playersnetherportalcreativedelay)
- [playersNetherPortalDefaultDelay](#playersnetherportaldefaultdelay)
- [playersSleepingPercentage](#playerssleepingpercentage)
- [spawnRadius](#spawnradius)
- [spectatorsGenerateChunks](#spectatorsgeneratechunks)

## Rules in PLAYER Category

### disableElytraMovementCheck
Disable elytra movement check

Whether the server should skip checking player speed when the player is wearing elytra. Often helps with jittering due to lag in multiplayer
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### disablePlayerMovementCheck
Disable player movement check
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### doImmediateRespawn
Respawn immediately

Players respawn immediately without showing the death screen
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### doLimitedCrafting
Require recipe for crafting

If enabled, players will be able to craft only unlocked recipes
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### drowningDamage
Deal drowning damage

Whether the player should take damage when drowning
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### enderPearlsVanishOnDeath
Thrown ender pearls vanish on death

Whether ender pearls thrown by a player vanish when that player dies
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

### naturalRegeneration
Regenerate health

Whether the player can regenerate health naturally if their hunger is full enough  
Doesn't affect external healing, such as golden apples, the Regeneration effect, etc.
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `PLAYER`

### playersNetherPortalCreativeDelay
Player's Nether portal delay in creative mode

Time (in ticks) that a creative mode player needs to stand in a Nether portal before changing dimensions
- Type: `int`
- Default value: `1`
- Required options: ``
- Categories: `GAMERULE`, `PLAYER`

### playersNetherPortalDefaultDelay
Player's Nether portal delay in non-creative mode

Time (in ticks) that a non-creative mode player needs to stand in a Nether portal before changing dimensions
- Type: `int`
- Default value: `80`
- Required options: ``
- Categories: `GAMERULE`, `PLAYER`

### playersSleepingPercentage
Sleep percentage

The percentage of players who must be sleeping to skip the night
- Type: `int`
- Default value: `100`
- Suggested options: `0`, `25`, `50`, `75`, `100`
- Categories: `GAMERULE`, `PLAYER`

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
