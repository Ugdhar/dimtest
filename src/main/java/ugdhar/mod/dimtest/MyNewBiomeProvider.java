package ugdhar.mod.dimtest;

import java.util.Set;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

public class MyNewBiomeProvider extends BiomeProvider {
	
	public MyNewBiomeProvider(Set<Biome> biomesIn) {
		super(biomesIn);
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return Biomes.PLAINS;
	}

}
