package ugdhar.mod.dimtest;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.gen.WorldGenRegion;

public class MyNewChunkGenerator extends ChunkGenerator<MyNewChunkGenerator.MyChunkGenConfig> {
	
	public MyNewChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn) {
		super(worldIn, biomeProviderIn, MyChunkGenConfig.defaultConfig());
	}

	@Override
	public void generateSurface(WorldGenRegion worldGenReg, IChunk iChunk) {
		BlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
		BlockState STONE = Blocks.STONE.getDefaultState();
		//ChunkPos chunkPos = iChunk.getPos();
		
		BlockPos.Mutable pos = new BlockPos.Mutable();
		
		int x;
		int z;
		
		// Make layer 0 all bedrock
		for(x = 0; x < 16; x++)
			for(z = 0; z < 16; z++) {
				iChunk.setBlockState(pos.setPos(x, 0, z), BEDROCK, false);
				//int trueX = chunkPos.x * 16 + x;
				//int trueZ = chunkPos.z * 16 + z;
				int groundHeight = 65;
				for(int y = 1; y <= groundHeight; y++)
					iChunk.setBlockState(pos.setPos(x, y, z), STONE, false);
			}
	}

	@Override
	public int getGroundHeight() {
		return world.getSeaLevel() + 1;
	}

	@Override
	public void makeBase(IWorld worldIn, IChunk chunkIn) {
		
	}

	@Override
	public int func_222529_a(int p_222529_1_, int p_222529_2_, Type heightmapType) {
		return 0;
	}

	/* Configuration Class */
	public static class MyChunkGenConfig extends GenerationSettings {
		public static MyChunkGenConfig defaultConfig() {
			MyChunkGenConfig cfg = new MyChunkGenConfig();
			cfg.setDefaultBlock(Blocks.STONE.getDefaultState());
			cfg.setDefaultFluid(Blocks.WATER.getDefaultState());
			return cfg;
		}
	}

}
