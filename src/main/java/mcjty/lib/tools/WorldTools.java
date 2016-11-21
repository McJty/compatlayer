package mcjty.lib.tools;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class WorldTools {

    public static void spawnEntity(World world, Entity entity) {
        world.spawnEntityInWorld(entity);
    }

    public static WorldClient getWorld(Minecraft mc) {
        return mc.theWorld;
    }

}
