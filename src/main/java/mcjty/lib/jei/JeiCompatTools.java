package mcjty.lib.jei;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.ingredients.IIngredients;

import java.util.List;

public class JeiCompatTools {

    public static void addRecipes(IModRegistry modRegistry, List recipes) {
        modRegistry.addRecipes(recipes);
    }

    public static <T> List<T> getOutputs(IIngredients ingredients, Class<T> clazz) {
        return ingredients.getOutputs(clazz);
    }

}
