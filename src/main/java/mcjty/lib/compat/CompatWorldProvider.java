package mcjty.lib.compat;

import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public abstract class CompatWorldProvider extends WorldProvider {

    public World getWorld() {
        return worldObj;
    }

    protected void initialize() {
        super.createBiomeProvider();
    }

    @Override
    protected void createBiomeProvider() {
        initialize();
    }
}
