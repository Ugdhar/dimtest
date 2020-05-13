Minecraft/Forge 1.15.2 Dimension Test


Just a simple custom dimension test

Create a class that extends Dimension; this is where your dimension gets its characteristics from.
createChunkGenerator() is probably the most important method here.
Don't leave getFogColor() null, it will crash.

So we need a class extending ChunkGenerator. (NoiseChunkGenerator is the class that does all the fancy stuff for terrain generation.)
Also something extending GenerationSettings for cfg.
We're just going to essentially make a flat chunk generator for testing, bedrock at 0, stone from 1 to 65
The generateSurface method seems to be the place to build.

Need a class extending BiomeProvider. Despite vanilla having a single-biome provider already, should probably create one for testing.
would seem getNoiseBiome method returns the biome for chunk x/y/z (hardcoding plains for now)

Need a class that extends ModDimension, getFactory() method is the important part, could be used to return multiple dimensions.
Register the ModDimension subclass using MOD_DIMENSIONS forge registry w/DeferredRegister.

register dimension type in forge RegisterDimensionsEvent using DimensionManager.registerOrGet

Made a little dimtest command to teleport to the new dimension, or back to the overworld spawn point, if already there.