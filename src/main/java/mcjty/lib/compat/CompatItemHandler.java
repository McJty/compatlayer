package mcjty.lib.compat;

import net.minecraftforge.items.IItemHandler;

public interface CompatItemHandler extends IItemHandler {

    int getSlotMaxLimit();

    @Override
    default int getSlotLimit(int slot) {
        return getSlotMaxLimit();
    }
}
