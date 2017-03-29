package mcjty.lib.tools;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.WorldServer;

import java.util.List;

public class WorldTools {

    public static void spawnEntity(World world, Entity entity) {
        world.spawnEntity(entity);
    }

    public static WorldClient getWorld(Minecraft mc) {
        return mc.world;
    }

    public static void neighborChanged(World world, EnumFacing offset, Block block, BlockPos pos) {
        world.notifyBlockOfStateChange(pos.offset(offset), block);
    }

    public static void notifyBlockOfStateChange(World world, BlockPos pos, Block block, BlockPos fromPos) {
        world.notifyBlockOfStateChange(pos, block);
    }

    public static void notifyNeighborsOfStateChange(World world, BlockPos pos, Block block) {
        world.notifyNeighborsOfStateChange(pos, block);
    }

    public static List<EntityPlayerMP> getPlayerList(WorldServer world) {
        return world.getMinecraftServer().getPlayerList().getPlayers();
    }

    public static <T extends WorldSavedData> T loadData(World world, Class<? extends T> clazz, String dataID) {
        return (T) world.loadData(clazz, dataID);
    }

    public static <T extends WorldSavedData> void saveData(World world, String dataID, T data) {
        world.setData(dataID, data);
    }
}
