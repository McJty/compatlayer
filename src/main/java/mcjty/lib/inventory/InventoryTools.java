package mcjty.lib.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class InventoryTools {

    public static boolean isUsable(EntityPlayer player, IInventory inventory) {
        return inventory.isUseableByPlayer(player);
    }

    public static ItemStack onPickup(Slot slot, EntityPlayer player, ItemStack stack) {
        slot.onPickupFromSlot(player, stack);
        return stack;
    }

}
