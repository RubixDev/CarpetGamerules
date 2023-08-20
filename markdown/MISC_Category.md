# List of Rules in the MISC Category

For a list of all implemented Rules go [here](../README.md)
## Index
Count: 4
- [commandModificationBlockLimit](#commandmodificationblocklimit)
- [globalSoundEvents](#globalsoundevents)
- [maxCommandChainLength](#maxcommandchainlength)
- [reducedDebugInfo](#reduceddebuginfo)

## Rules in MISC Category

### commandModificationBlockLimit
Command Modification Block Limit

Number of blocks that can be changed at once by one command, such as fill or clone.
- Type: `int`
- Default value: `32768`
- Suggested options: `32768`, `1000000`, `2147483647`
- Categories: `GAMERULE`, `MISC`

### globalSoundEvents
Global sound events

When certain game events happen, like a boss spawning, the sound is heard everywhere.
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `MISC`

### maxCommandChainLength
Command chain size limit

The maximum length of a chain of commands that can be executed during one tick. Applies to command blocks and functions
- Type: `int`
- Default value: `65536`
- Suggested options: `65536`
- Categories: `GAMERULE`, `MISC`

### reducedDebugInfo
Reduce debug info

Limits contents of debug screen
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `MISC`
