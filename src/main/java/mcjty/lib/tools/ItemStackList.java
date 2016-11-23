package mcjty.lib.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemStackList extends NonNullList<ItemStack> {

    public static ItemStackList create(int size) {
        return (ItemStackList) ItemStackList.withSize(size, ItemStackTools.getEmptyStack());
    }

}