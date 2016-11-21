package mcjty.lib.inventory;

import net.minecraft.inventory.ISidedInventory;

public interface CompatSidedInventory extends ISidedInventory {

    @Override
    default boolean isEmpty() {
        return false;
    }

}
