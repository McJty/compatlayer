package mcjty.lib.tools;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemStackTools {

    /**
     * Add (or decrease) a number of items from a stack.
     * If the number of items drops below 0 then null will be returned on 1.10 and the
     * 'null' itemstack on 1.11. Otherwise the same modified stack is returned.
     */
    @Nullable
    public static ItemStack incStackSize(@Nonnull ItemStack stack, int amount) {
        stack.stackSize += amount;
        if (stack.stackSize <= 0) {
            return null;
        }
        return stack;
    }

    /**
     * Make a safe copy of an itemstack
     */
    @Nullable
    public static ItemStack safeCopy(@Nullable ItemStack stack) {
        if (stack == null) {
            return null;
        }
        stack = stack.copy();
        // Safety
        if (stack.stackSize == 0) {
            stack.stackSize = 1;
        }
        return stack;
    }


    /**
     * Get the stacksize from a stack
     */
    public static int getStackSize(@Nullable ItemStack stack) {
        if (stack == null) {
            return 0;
        }
        return stack.stackSize;
    }

    /**
     * Set the stacksize on a stack. Returns the same stack or null if the new
     * amount was 0. On 1.11 it will return the 'null' itemstack.
     * Note that this will modify the stack also if amount == 0. On 1.10
     * the stacksize will be set to 0 and on 1.11 the stack will become the EMPTY
     * stack.
     */
    @Nullable
    public static ItemStack setStackSize(@Nonnull ItemStack stack, int amount) {
        if (amount <= 0) {
            stack.stackSize = 0;
            return null;
        }
        stack.stackSize = amount;
        return stack;
    }

    /**
     * Check if this is a valid stack. Tests for null on 1.10.
     */
    public static boolean isValid(@Nullable ItemStack stack) {
        if (stack == null) {
            return false;
        }
        return stack.stackSize > 0;
    }

    /**
     * Check if this is an empty stack. Tests for null on 1.10.
     */
    public static boolean isEmpty(@Nullable ItemStack stack) {
        if (stack == null) {
            return true;
        }
        return stack.stackSize <= 0;
    }

    public static void makeEmpty(@Nonnull ItemStack stack) {
        stack.stackSize = 0;
    }

    /**
     * Load an ItemStack from NBT.
     */
    @Nullable
    public static ItemStack loadFromNBT(@Nonnull NBTTagCompound nbt) {
        return ItemStack.loadItemStackFromNBT(nbt);
    }

    @Nullable
    public static ItemStack getEmptyStack() {
        return null;
    }

    /**
     * Extract itemstack out of a slot and return a new stack.
     * Supports both IItemHandler as IInventory
     * @param tileEntity
     * @param slot
     * @param amount
     */
    @Nullable
    public static ItemStack extractItem(@Nullable TileEntity tileEntity, int slot, int amount) {
        if (tileEntity != null && tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
            IItemHandler capability = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            return capability.extractItem(slot, amount, false);
        } else if (tileEntity instanceof IInventory) {
            IInventory inventory = (IInventory) tileEntity;
            return inventory.decrStackSize(slot, amount);
        }
        return ItemStackTools.getEmptyStack();
    }

    /**
     * Get an item from an inventory
     * Supports both IItemHandler as IInventory
     * @param tileEntity
     * @param slot
     */
    @Nullable
    public static ItemStack getStack(@Nullable TileEntity tileEntity, int slot) {
        if (tileEntity != null && tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
            IItemHandler capability = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            return capability.getStackInSlot(slot);
        } else if (tileEntity instanceof IInventory) {
            IInventory inventory = (IInventory) tileEntity;
            return inventory.getStackInSlot(slot);
        }
        return ItemStackTools.getEmptyStack();
    }

    /**
     * Set a stack in a specific slot. This will totally replace whatever was in the slot before
     * Supports both IItemHandler as IInventory. Does not check for failure
     * @param tileEntity
     * @param slot
     * @param stack
     */
    public static void setStack(@Nullable TileEntity tileEntity, int slot, @Nullable ItemStack stack) {
        if (tileEntity != null && tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
            IItemHandler capability = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            capability.extractItem(slot, 64, false);        // Clear slot
            if (stack != null) {
                capability.insertItem(slot, stack, false);
            }
        } else if (tileEntity instanceof IInventory) {
            IInventory inventory = (IInventory) tileEntity;
            inventory.setInventorySlotContents(slot, stack);
        }
    }

    public static List<ItemStack> getOres(String name) {
        return OreDictionary.getOres(name);
    }

    public static List<ItemStack> getOres(String name, boolean alwaysCreateEntry) {
        return OreDictionary.getOres(name, alwaysCreateEntry);
    }
}
