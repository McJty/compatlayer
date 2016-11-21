package mcjty.lib.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
     * amount was 0. On 1.11 it will return the 'null' itemstack
     */
    @Nullable
    public static ItemStack setStackSize(@Nonnull ItemStack stack, int amount) {
        if (amount <= 0) {
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

}
