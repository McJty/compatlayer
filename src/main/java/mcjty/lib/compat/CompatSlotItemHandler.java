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
        return super.onTake(player, stack);
    }

    @Override
    public ItemStack onTake(EntityPlayer player, ItemStack stack) {
        return onPickup(player, stack);
    }
}
