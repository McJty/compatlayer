package mcjty.lib.compat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;

public interface CompatInventory extends IInventory {

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
