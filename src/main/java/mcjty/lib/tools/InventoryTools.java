package mcjty.lib.tools;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class InventoryTools {

    public static boolean isUsable(EntityPlayer player, IInventory inventory) {
        return inventory.isUseableByPlayer(player);
    }

    public static ItemStack onPickup(Slot slot, EntityPlayer player, ItemStack stack) {
        slot.onPickupFromSlot(player, stack);
        return stack;
    }

    public static EnumActionResult onItemUseWithStack(Item item, ItemStack stack, EntityPlayer player,
                                                      World world, BlockPos pos, EnumHand hand, EnumFacing facing,
                                                      float hitX, float hitY, float hitZ) {
        player.setHeldItem(hand, stack);
        return item.onItemUse(stack, player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    public static List<ItemStack> getRemainingItems(IRecipe recipe, InventoryCrafting inventoryCrafting) {
        return Lists.newArrayList(recipe.getRemainingItems(inventoryCrafting));
    }

    public static List<ItemStack> getRemainingItems(InventoryCrafting workInventory, World world) {
        return Lists.newArrayList(CraftingManager.getInstance().getRemainingItems(workInventory, world));
    }

    public static List<ItemStack> getContainerItemStacks(Container container) {
        return container.inventoryItemStacks;
    }

    // Get a read-only list for the players inventory!
    public static List<ItemStack> getMainInventory(EntityPlayer player) {
        return Collections.unmodifiableList(Lists.newArrayList(player.inventory.mainInventory));
    }

    public static void setItemMainInventory(EntityPlayer player, int index, @Nullable ItemStack item) {
        player.inventory.mainInventory[index] = item;
    }
}
