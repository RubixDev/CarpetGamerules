# List of Rules in the WORLD_UPDATES Category

For a list of all implemented Rules go [here](../README.md)
## Index
Count: 8
- [doDaylightCycle](#dodaylightcycle)
- [doFireTick](#dofiretick)
- [doVinesSpread](#dovinesspread)
- [doWeatherCycle](#doweathercycle)
- [lavaSourceConversion](#lavasourceconversion)
- [randomTickSpeed](#randomtickspeed)
- [snowAccumulationHeight](#snowaccumulationheight)
- [waterSourceConversion](#watersourceconversion)

## Rules in WORLD_UPDATES Category

### doDaylightCycle
Advance time of day

Whether the daylight cycle and moon phases progress
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `WORLD_UPDATES`

### doFireTick
Update fire

Whether fire should spread and naturally extinguish
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `WORLD_UPDATES`

### doVinesSpread
Vines spread

Controls whether or not the Vines block spreads randomly to adjacent blocks. Does not affect other type of vine blocks such as Weeping Vines, Twisting Vines, etc.
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `WORLD_UPDATES`

### doWeatherCycle
Update weather

Whether the weather can change naturally. The `/weather` command can still change weather
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `WORLD_UPDATES`

### lavaSourceConversion
Lava converts to source

When flowing lava is surrounded on two sides by lava sources it converts into a source.
- Type: `boolean`
- Default value: `false`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `WORLD_UPDATES`

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

### snowAccumulationHeight
Snow accumulation height

When it snows, layers of snow form on the ground up to at most this number of layers.
- Type: `int`
- Default value: `1`
- Suggested options: `0`, `1`, `8`
- Categories: `GAMERULE`, `WORLD_UPDATES`

### waterSourceConversion
Water converts to source

When flowing water is surrounded on two sides by water sources it converts into a source.
- Type: `boolean`
- Default value: `true`
- Required options: `true`, `false`
- Categories: `GAMERULE`, `WORLD_UPDATES`
