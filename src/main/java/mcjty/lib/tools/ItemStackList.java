package mcjty.lib.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.apache.commons.lang3.Validate;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class ItemStackList extends NonNullList<ItemStack> {

    public static ItemStackList create(int size) {
        Validate.notNull(ItemStackTools.getEmptyStack());
        ItemStack[] aobject = new ItemStack[size];
        Arrays.fill(aobject, ItemStackTools.getEmptyStack());
        return new ItemStackList(Arrays.asList(aobject), ItemStackTools.getEmptyStack());
    }

    public ItemStackList(List<ItemStack> delegateIn, @Nullable ItemStack stack) {
        super(delegateIn, stack);
    }
}