package mcjty.lib.compat;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class CompatCreativeTabs extends CreativeTabs {

    public CompatCreativeTabs(String label) {
        super(label);
    }

    protected abstract Item getItem();

    @Override
    public Item getTabIconItem() {
        return getItem();
    }
}
