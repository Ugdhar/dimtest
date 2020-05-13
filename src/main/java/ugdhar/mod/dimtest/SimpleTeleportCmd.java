package ugdhar.mod.dimtest;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;

public class SimpleTeleportCmd implements Command<CommandSource>{

	private static final SimpleTeleportCmd CMD = new SimpleTeleportCmd();
	
	public static LiteralArgumentBuilder<CommandSource> register() {
		LiteralArgumentBuilder<CommandSource> results = Commands.literal("dimtest")
				.requires(cs -> cs.hasPermissionLevel(0))
				.executes(CMD);
		return results;
	}

	@Override
	public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
		ServerPlayerEntity player = context.getSource().asPlayer();
		if(player.dimension.equals(DimensionTest.MY_NEW_DIM_TYPE)) {
			ServerWorld newWorld = player.getServer().getWorld(DimensionType.OVERWORLD);
			//send to overworld
			BlockPos tpPos = newWorld.getSpawnPoint();
			player.teleport(newWorld, tpPos.getX(), tpPos.getY(), tpPos.getZ(), player.cameraYaw, player.rotationPitch);
		} else {
			ServerWorld newWorld = player.getServer().getWorld(DimensionTest.MY_NEW_DIM_TYPE);
			player.teleport(newWorld, 0, 66, 0, player.cameraYaw, player.rotationPitch);
		}
		return 0;
	}

}
