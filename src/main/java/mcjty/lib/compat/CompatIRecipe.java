/**
@author Chaz Kerby
*/
package mcjty.lib.compat;

import mcjty.lib.tools.ItemStackList;
import mcjty.lib.tools.ItemStackTools;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public interface CompatIRecipe extends IRecipe {

	@Override
	default boolean matches(InventoryCrafting inv, World worldIn) {
		return false;
	}

	@Override
	default ItemStack getCraftingResult(InventoryCrafting inv) {
		return ItemStackTools.getEmptyStack();
	}

	@Override
	default int getRecipeSize() {
		return 0;
	}

	@Override
	default ItemStack getRecipeOutput() {
		return ItemStackTools.getEmptyStack();
	}

	@Override
	default ItemStack[] getRemainingItems(InventoryCrafting inv) {
		ItemStackList items = getRemainingItemsCompat(inv);
		return items.toArray(new ItemStack[items.size()]);
	}

	@Nonnull
	default ItemStackList getRemainingItemsCompat(InventoryCrafting inv) {
		return ItemStackList.EMPTY;
	}

}
