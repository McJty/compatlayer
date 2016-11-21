package mcjty.lib.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;

public interface CompatInventory extends IInventory {

    boolean isUsable(EntityPlayer player);

    @Override
    default boolean isUseableByPlayer(EntityPlayer player) {
        return isUsable(player);
    }


}
