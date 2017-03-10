package mcjty.lib.compat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CompatSlotItemHandler extends SlotItemHandler {

    public CompatSlotItemHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    protected ItemStack onPickup(EntityPlayer player, ItemStack stack) {
        super.onPickupFromSlot(player, stack);
        return stack;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
        onPickup(player, stack);
    }

}
