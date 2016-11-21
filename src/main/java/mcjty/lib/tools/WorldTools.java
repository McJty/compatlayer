package mcjty.lib.tools;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldTools {

    public static void spawnEntity(World world, Entity entity) {
        world.spawnEntity(entity);
    }

    public static void neighborChanged(World world, EnumFacing offset, Block block, BlockPos pos) {
        world.neighborChanged(pos.offset(offset), block, pos);
    }

    public static void notifyNeighborsOfStateChange(World world, BlockPos pos, Block block) {
        world.notifyNeighborsOfStateChange(pos, block, false);
    }
}
