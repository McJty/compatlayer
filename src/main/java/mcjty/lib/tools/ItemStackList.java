package mcjty.lib.tools;

import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.Validate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemStackList extends AbstractList<ItemStack> {

    private final List<ItemStack> delegate;
    private final ItemStack defaultStack;

    public static ItemStackList create() {
        return new ItemStackList();
    }

    public static ItemStackList withSize(int size, ItemStack fill) {
        Validate.notNull(fill);
        ItemStack[] aobject = new ItemStack[size];
        Arrays.fill(aobject, fill);
        return new ItemStackList(Arrays.asList(aobject), fill);
    }

    protected ItemStackList() {
        this(new ArrayList<>(), ItemStackTools.getEmptyStack());
    }

    protected ItemStackList(List<ItemStack> delegateIn, @Nullable ItemStack stack) {
        this.delegate = delegateIn;
        this.defaultStack = stack;
    }

    @Nonnull
    public ItemStack get(int idx) {
        return this.delegate.get(idx);
    }

    public ItemStack set(int idx, ItemStack stack) {
        Validate.notNull(stack);
        return this.delegate.set(idx, stack);
    }

    public void add(int idx, ItemStack stack) {
        Validate.notNull(stack);
        this.delegate.add(idx, stack);
    }

    public ItemStack remove(int idx) {
        return this.delegate.remove(idx);
    }

    public int size() {
        return this.delegate.size();
    }

    public void clear() {
        if (this.defaultStack == null) {
            super.clear();
        } else {
            for (int i = 0; i < this.size(); ++i) {
                this.set(i, this.defaultStack);
            }
        }
    }
}