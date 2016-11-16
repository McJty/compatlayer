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
    @Nonnull
    public static ItemStack incStackSize(@Nonnull ItemStack stack, int amount) {
        stack.func_190917_f(amount);
        return stack;
    }

    /**
     * Make a safe copy of an itemstack
     */
    @Nonnull
    public static ItemStack safeCopy(@Nonnull ItemStack stack) {
        return stack.copy();
    }

    /**
     * Get the stacksize from a stack
     */
    public static int getStackSize(@Nullable ItemStack stack) {
        if (stack == null) {
            return 0;
        }
        return stack.func_190916_E();
    }

    /**
     * Set the stacksize on a stack. Returns the same stack or null if the new
     * amount was 0. On 1.11 it will return the 'null' itemstack
     */
    @Nonnull
    public static ItemStack setStackSize(@Nonnull ItemStack stack, int amount) {
        if (amount <= 0) {
            return ItemStack.field_190927_a;
        }
        stack.func_190920_e(amount);
        return stack;
    }

    /**
     * Check if this is a valid stack. Tests for null on 1.10.
     */
    public static boolean isValid(@Nullable ItemStack stack) {
        if (stack == null) {
            return false;
        }
        return !stack.func_190926_b();
    }

    /**
     * Load an ItemStack from NBT.
     */
    @Nullable
    public static ItemStack loadFromNBT(@Nonnull NBTTagCompound nbt) {
        return new ItemStack(nbt);
    }

    @Nonnull
    public static ItemStack getEmptyStack() {
        return ItemStack.field_190927_a;
    }

}
