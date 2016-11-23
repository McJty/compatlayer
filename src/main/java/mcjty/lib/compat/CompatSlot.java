package mcjty.lib.compat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class CompatSlot extends Slot {

    public CompatSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    protected ItemStack onPickup(EntityPlayer player, ItemStack stack) {
        return super.onTake(player, stack);
    }

    @Override
    public ItemStack onTake(EntityPlayer player, ItemStack stack) {
        return onPickup(player, stack);
    }

    public static int getX(Slot slot) {
        return slot.xPos;
    }

    public static int getY(Slot slot) {
        return slot.yPos;
    }

    public static void setX(Slot slot, int x) {
        slot.xPos = x;
    }

    public static void setY(Slot slot, int y) {
        slot.yPos = y;
    }
}
