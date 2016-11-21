package mcjty.lib.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;

public class InventoryTools {

    public static boolean isUsable(EntityPlayer player, IInventory inventory) {
        return inventory.isUsableByPlayer(player);
    }
}
