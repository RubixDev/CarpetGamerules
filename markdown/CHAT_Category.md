# List of Rules in the CHAT Category

For a list of all implemented Rules go [here](../README.md)
## Index
Count: 5
- [announceAdvancements](#announceadvancements)
- [commandBlockOutput](#commandblockoutput)
- [logAdminCommands](#logadmincommands)
- [sendCommandFeedback](#sendcommandfeedback)
- [showDeathMessages](#showdeathmessages)

## Rules in CHAT Category

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

### logAdminCommands
Broadcast admin commands

Whether to log admin commands to server log
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `CHAT`, `GAMERULE`

### sendCommandFeedback
Send command feedback

Whether the feedback from commands executed by a player should show up in chat\
Also affects the default behavior of whether command blocks store their output text
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `CHAT`, `GAMERULE`

### showDeathMessages
Show death messages

Whether death messages are put into chat when a player dies\
Also affects whether a message is sent to the pet's owner when the pet dies
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `CHAT`, `GAMERULE`
