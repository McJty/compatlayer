package mcjty.lib.compat;

import net.minecraftforge.items.IItemHandlerModifiable;

public interface CompatItemHandlerModifiable extends IItemHandlerModifiable {

    int getSlotMaxLimit();

    @Override
    default int getSlotLimit(int slot) {
        return getSlotMaxLimit();
    }
}
