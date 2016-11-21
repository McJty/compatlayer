package mcjty.lib.inventory;

import net.minecraft.inventory.IInventory;

public interface CompatInventory extends IInventory {

    @Override
    default boolean isEmpty() {
        return false;
    }

}
