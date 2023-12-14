# List of Rules in the MOBS Category

For a list of all implemented Rules go [here](../README.md)
## Index
Count: 5
- [disableRaids](#disableraids)
- [forgiveDeadPlayers](#forgivedeadplayers)
- [maxEntityCramming](#maxentitycramming)
- [mobGriefing](#mobgriefing)
- [universalAnger](#universalanger)

## Rules in MOBS Category

### disableRaids
Disable raids

Whether raids are disabled
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `MOBS`

### forgiveDeadPlayers
Forgive dead players

Angered neutral mobs stop being angry when the targeted player dies nearby
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `MOBS`

### maxEntityCramming
Entity cramming threshold

The maximum number of pushable entities a mob or player can push, before taking 3 suffocation damage per half-second.  
Setting to 0 or lower disables the rule.  
Damage affects survival-mode or adventure-mode players, and all mobs but bats. Pushable entities include non-spectator-mode players, any mob except bats, as well as boats and minecarts.
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

### universalAnger
Universal anger

Angered neutral mobs attack any nearby player, not just the player that angered them. Works best if `forgiveDeadPlayers` is disabled
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `MOBS`
