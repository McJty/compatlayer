package mcjty.lib.tools;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeTools {

    public static boolean isBiomeOfType(Biome biome, BiomeDictionary.Type type) {
        return BiomeDictionary.isBiomeOfType(biome, type);
    }
    
    public static Biome[] getBiomesForType(BiomeDictionary.Type type) {
        return BiomeDictionary.getBiomesForType(type);
    }
    
}
