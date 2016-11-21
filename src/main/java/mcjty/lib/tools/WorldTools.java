package mcjty.lib.tools;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldTools {

    public static void spawnEntity(World world, Entity entity) {
        world.spawnEntityInWorld(entity);
    }

    public static WorldClient getWorld(Minecraft mc) {
        return mc.theWorld;
    }

    public static void neighborChanged(World world, EnumFacing offset, Block block, BlockPos pos) {
        world.notifyBlockOfStateChange(pos.offset(offset), block);
    }

}
