package mcjty.lib.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;

public interface CompatSidedInventory extends ISidedInventory {

    boolean isUsable(EntityPlayer player);

    @Override
    default boolean isUsableByPlayer(EntityPlayer player) {
        return isUsable(player);
    }

    @Override
    default boolean isEmpty() {
        return false;
    }

}
