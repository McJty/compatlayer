package mcjty.lib.tools;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class WorldTools {

    public static void spawnEntity(World world, Entity entity) {
        world.spawnEntityInWorld(entity);
    }
}
