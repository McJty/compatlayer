package mcjty.lib.compat;

import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public abstract class CompatWorldProvider extends WorldProvider {

    public World getWorld() {
        return world;
    }

    protected void initialize() {
        super.createBiomeProvider();
    }

    @Override
    protected void createBiomeProvider() {
        initialize();
    }

    // No-op on 1.10.2
    public void disableSkyLight() {

    }
}
