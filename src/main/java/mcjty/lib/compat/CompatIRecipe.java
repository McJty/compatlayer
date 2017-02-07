/**
@author Chaz Kerby
*/
package mcjty.lib.compat;

import mcjty.lib.tools.ItemStackTools;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class CompatIRecipe implements IRecipe {

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return ItemStackTools.getEmptyStack();
	}

	@Override
	public int getRecipeSize() {
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return ItemStackTools.getEmptyStack();
	}

	@Override
	public ItemStack[] getRemainingItems(InventoryCrafting inv) {
		return getRemainingItemsCompat(inv);
	}
	
	public ItemStack[] getRemainingItemsCompat(InventoryCrafting inv) {
		return new ItemStack[1];
	}

}
