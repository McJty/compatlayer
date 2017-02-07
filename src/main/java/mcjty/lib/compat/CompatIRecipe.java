/**
@author Chaz Kerby
*/
package mcjty.lib.compat;

import mcjty.lib.tools.ItemStackTools;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
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
	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
		return makeNonNullList(getRemainingItemsCompat(inv));
	}
	
	public ItemStack[] getRemainingItemsCompat(InventoryCrafting inv) {
		return new ItemStack[1];
	}
	
	private NonNullList<ItemStack> makeNonNullList(ItemStack[] items) {
		NonNullList<ItemStack> nnl = NonNullList.<ItemStack>withSize(items.length, ItemStack.EMPTY);
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				nnl.set(i, items[i]);
			}
		}
		return nnl;
	}

}
