package mcjty.lib.jei;

import mezz.jei.api.recipe.IRecipeHandler;

public abstract class CompatRecipeHandler<T> implements IRecipeHandler<T> {

    private final String id;

    public CompatRecipeHandler(String id) {
        this.id = id;
    }

    @Override
    public String getRecipeCategoryUid(T recipe) {
        return id;
    }

    @Override
    public boolean isRecipeValid(T recipe) {
        return true;
    }
}
