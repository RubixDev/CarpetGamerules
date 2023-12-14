# List of Rules in the DROPS Category

For a list of all implemented Rules go [here](../README.md)
## Index
Count: 7
- [blockExplosionDropDecay](#blockexplosiondropdecay)
- [doEntityDrops](#doentitydrops)
- [doMobLoot](#domobloot)
- [doTileDrops](#dotiledrops)
- [mobExplosionDropDecay](#mobexplosiondropdecay)
- [projectilesCanBreakBlocks](#projectilescanbreakblocks)
- [tntExplosionDropDecay](#tntexplosiondropdecay)

## Rules in DROPS Category

### blockExplosionDropDecay
In block interaction explosions, some blocks won't drop their loot

Some of the drops from blocks destroyed by explosions caused by block interactions are lost in the explosion.
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `DROPS`, `GAMERULE`

### doEntityDrops
Drop entity equipment

Controls drops from minecarts (including inventories), item frames, boats, etc.
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `DROPS`, `GAMERULE`

### doMobLoot
Drop mob loot

Controls resource drops from mobs, including experience orbs
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `DROPS`, `GAMERULE`

### doTileDrops
Drop blocks

Controls resource drops from blocks, including experience orbs
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `DROPS`, `GAMERULE`

### mobExplosionDropDecay
In mob explosions, some blocks won't drop their loot

Some of the drops from blocks destroyed by explosions caused by mobs are lost in the explosion.
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `DROPS`, `GAMERULE`

### projectilesCanBreakBlocks
Projectiles can break blocks

Controls whether impact projectiles will destroy blocks that are destructible by them
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `DROPS`, `GAMERULE`

### tntExplosionDropDecay
In TNT explosions, some blocks won't drop their loot

Some of the drops from blocks destroyed by explosions caused by TNT are lost in the explosion.
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `DROPS`, `GAMERULE`
