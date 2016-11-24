package mcjty.lib.tools;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemStackList extends AbstractList<ItemStack> {

    private final List<ItemStack> delegate;

    public static ItemStackList create() {
        return new ItemStackList();
    }

    public static ItemStackList create(int size) {
        ItemStack[] aobject = new ItemStack[size];
        Arrays.fill(aobject, null);
        return new ItemStackList(Arrays.asList(aobject));
    }

    protected ItemStackList() {
        this(new ArrayList<>());
    }

    protected ItemStackList(List<ItemStack> delegateIn) {
        this.delegate = delegateIn;
    }

    @Nonnull
    public ItemStack get(int idx) {
        return this.delegate.get(idx);
    }

    public ItemStack set(int idx, ItemStack stack) {
        return this.delegate.set(idx, stack);
    }

    public void add(int idx, ItemStack stack) {
        this.delegate.add(idx, stack);
    }

    public ItemStack remove(int idx) {
        return this.delegate.remove(idx);
    }

    public int size() {
        return this.delegate.size();
    }

}