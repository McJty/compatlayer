package mcjty.lib.compat;

import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public abstract class CompatWorldProvider extends WorldProvider {

    public World getWorld() {
        return world;
    }

    protected void initialize() {
        super.init();
    }

    @Override
    protected void init() {
        initialize();
    }
}
