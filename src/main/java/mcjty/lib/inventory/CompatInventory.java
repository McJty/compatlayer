package mcjty.lib.inventory;

import net.minecraft.inventory.IInventory;

public interface CompatInventory extends IInventory {

    @Override
    default boolean func_191420_l() {
        return false;
    }

}
