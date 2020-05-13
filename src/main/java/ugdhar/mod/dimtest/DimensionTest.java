package ugdhar.mod.dimtest;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("dimtest")
public class DimensionTest {
	
	public static ResourceLocation DIM_RES = new ResourceLocation("dimtest", "my_new_dimension");
	
	public static DimensionType MY_NEW_DIM_TYPE;
	
	public static final DeferredRegister<ModDimension> MOD_DIM_REG = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, "dimtest");
	
	public static RegistryObject<ModDimensions> NEW_MOD_DIMENSIONS = MOD_DIM_REG.register("my_new_dimension", () -> new ModDimensions());
	
	public DimensionTest() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
		forgeEventBus.addListener(this::registerDimensionTypes);
		forgeEventBus.addListener(this::serverStart);
		MOD_DIM_REG.register(modEventBus);
	}

	private void serverStart(FMLServerStartingEvent args) {
		args.getCommandDispatcher().register(SimpleTeleportCmd.register());
	}
	
	private void registerDimensionTypes(RegisterDimensionsEvent args) {
		DimensionTest.MY_NEW_DIM_TYPE = DimensionManager.registerOrGetDimension(DIM_RES, NEW_MOD_DIMENSIONS.get(), null, true);
	}

	
	
}