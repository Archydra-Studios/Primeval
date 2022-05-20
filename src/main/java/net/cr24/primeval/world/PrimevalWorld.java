package net.cr24.primeval.world;

import net.cr24.primeval.PrimevalMain;
import net.cr24.primeval.world.gen.feature.PrimevalFeatures;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.List;

import static net.cr24.primeval.world.gen.feature.PrimevalFeatures.*;

public class PrimevalWorld {

    /* BIOMES */
    public static final BiomeEffects UNIVERSAL_EFFECTS = new BiomeEffects.Builder() .skyColor(7907327).fogColor(12638463).grassColor(9551193).waterColor(5404090).waterFogColor(329011).build();

    public static final List<RegistryEntry<PlacedFeature>> UNDERGROUND_FEATURES_NO_ZINC = List.of(
            NATIVE_COPPER_ORE_CLUSTER, MALACHITE_COPPER_ORE_CLUSTER, CASSITERITE_TIN_ORE_CLUSTER,
            DIRT_ORE_BLOBS, GRAVEL_ORE_BLOBS
    );
    public static final List<RegistryEntry<PlacedFeature>> UNDERGROUND_FEATURES_NO_TIN = List.of(
            NATIVE_COPPER_ORE_CLUSTER, MALACHITE_COPPER_ORE_CLUSTER, SPHALERITE_ZINC_ORE_CLUSTER,
            DIRT_ORE_BLOBS, GRAVEL_ORE_BLOBS
    );
    public static final List<RegistryEntry<PlacedFeature>> UNDERGROUND_FEATURES_ALL = List.of(
            NATIVE_COPPER_ORE_CLUSTER, MALACHITE_COPPER_ORE_CLUSTER, CASSITERITE_TIN_ORE_CLUSTER, SPHALERITE_ZINC_ORE_CLUSTER,
            DIRT_ORE_BLOBS, GRAVEL_ORE_BLOBS
    );

    // INLAND
    public static final RegistryEntry<Biome> PLAINS = registerBiome(getBiomeKey("inland/plains"), createBiome(
            buildGeneratorSettings(
                    UNDERGROUND_FEATURES_NO_TIN,
                    List.of(PLAINS_OAK_TRUNKED_TREE,
                            MOSS_RARE,
                            STICK_ITEM_PATCH, FLINT_ITEM_PATCH, ROCK_ITEM_PATCH,
                            NATIVE_COPPER_ITEM_PATCH, MALACHITE_COPPER_ITEM_PATCH, MIXED_COPPER_ITEM_PATCH, SPHALERITE_ZINC_ITEM_PATCH,
                            PLAINS_GRASS_PATCH, BUSH_PATCH, POPPY_PATCH, DANDELION_PATCH, OXEYE_DAISY_PATCH
                    )
            ),
            Biome.Category.PLAINS
    ));
    public static final RegistryEntry<Biome> OAK_FOREST = registerBiome(getBiomeKey("inland/oak_forest"), createBiome(
            buildGeneratorSettings(
                    UNDERGROUND_FEATURES_NO_ZINC,
                    List.of(FOREST_OAK_TRUNKED_TREE,
                            MOSS_RARE,
                            STICK_ITEM_PATCH, FLINT_ITEM_PATCH, ROCK_ITEM_PATCH,
                            NATIVE_COPPER_ITEM_PATCH, MALACHITE_COPPER_ITEM_PATCH, MIXED_COPPER_ITEM_PATCH, CASSITERITE_TIN_ITEM_PATCH,
                            OAK_FOREST_GRASS_PATCH, BUSH_PATCH, POPPY_PATCH
                    )
            ),
            Biome.Category.FOREST
    ));
    public static final RegistryEntry<Biome> DENSE_OAK_FOREST = registerBiome(getBiomeKey("inland/dense_oak_forest"), createBiome(
            buildGeneratorSettings(
                    UNDERGROUND_FEATURES_NO_ZINC,
                    List.of(FOREST_DENSE_OAK_TRUNKED_TREE,
                            MOSS_RARE,
                            STICK_ITEM_PATCH, FLINT_ITEM_PATCH, ROCK_ITEM_PATCH,
                            NATIVE_COPPER_ITEM_PATCH, MALACHITE_COPPER_ITEM_PATCH, MIXED_COPPER_ITEM_PATCH, CASSITERITE_TIN_ITEM_PATCH,
                            SPARSE_GRASS_PATCH, BUSH_PATCH, POPPY_PATCH
                    )
            ),
            Biome.Category.FOREST
    ));
    public static final RegistryEntry<Biome> BIRCH_FOREST = registerBiome(getBiomeKey("inland/birch_forest"), createBiome(
            buildGeneratorSettings(
                    UNDERGROUND_FEATURES_NO_ZINC,
                    List.of(FOREST_BIRCH_TRUNKED_TREE,
                            MOSS_RARE,
                            STICK_ITEM_PATCH, FLINT_ITEM_PATCH, ROCK_ITEM_PATCH,
                            NATIVE_COPPER_ITEM_PATCH, MALACHITE_COPPER_ITEM_PATCH, MIXED_COPPER_ITEM_PATCH, CASSITERITE_TIN_ITEM_PATCH,
                            PLAINS_GRASS_PATCH, DANDELION_PATCH, OXEYE_DAISY_PATCH
                    )
            ),
            Biome.Category.FOREST
    ));
    public static final RegistryEntry<Biome> ROCKY_OUTCROP = registerBiome(getBiomeKey("inland/rocky_outcrop"), createBiome(
            buildGeneratorSettings(
                    UNDERGROUND_FEATURES_ALL,
                    List.of(MOSS_RARE,
                            FLINT_ITEM_PATCH, ROCK_ITEM_PATCH,
                            NATIVE_COPPER_ITEM_PATCH, MALACHITE_COPPER_ITEM_PATCH, MIXED_COPPER_ITEM_PATCH, CASSITERITE_TIN_ITEM_PATCH, SPHALERITE_ZINC_ITEM_PATCH,
                            SPARSE_GRASS_PATCH, OXEYE_DAISY_PATCH
                    )
            ),
            Biome.Category.EXTREME_HILLS
    ));
    public static final RegistryEntry<Biome> CRUMBLING_CLIFFS = registerBiome(getBiomeKey("inland/crumbling_cliffs"), createBiome(
            buildGeneratorSettings(
                    UNDERGROUND_FEATURES_ALL,
                    List.of(FLINT_ITEM_PATCH, ROCK_ITEM_PATCH,
                            NATIVE_COPPER_ITEM_PATCH, MALACHITE_COPPER_ITEM_PATCH, MIXED_COPPER_ITEM_PATCH, CASSITERITE_TIN_ITEM_PATCH, SPHALERITE_ZINC_ITEM_PATCH
                    )
            ),
            Biome.Category.MOUNTAIN
    ));

    // COASTAL
    public static final RegistryEntry<Biome> SANDY_SHORE = registerBiome(getBiomeKey("coastal/sandy_shore"), createBiome(
            buildGeneratorSettings(
                    UNDERGROUND_FEATURES_NO_TIN,
                    List.of(STICK_ITEM_PATCH, ROCK_ITEM_PATCH,
                            SPARSE_GRASS_PATCH
                    )
            ),
            Biome.Category.BEACH
    ));
    public static final RegistryEntry<Biome> ROCKY_SHORE = registerBiome(getBiomeKey("coastal/rocky_shore"), createBiome(
            buildGeneratorSettings(
                    UNDERGROUND_FEATURES_NO_TIN,
                    List.of(STICK_ITEM_PATCH, FLINT_ITEM_PATCH, ROCK_ITEM_PATCH
                    )
            ),
            Biome.Category.BEACH
    ));

    // ETC
    public static final RegistryEntry<Biome> OCEAN = registerBiome(getBiomeKey("ocean"), createBiome(
            buildGeneratorSettings(
                    UNDERGROUND_FEATURES_ALL,
                    List.of()
            ),
            Biome.Category.OCEAN
    ));


    public static void init() {}

    private static Biome createBiome(GenerationSettings g, Biome.Category c) {
        return new Biome.Builder()
                .effects(UNIVERSAL_EFFECTS)
                .generationSettings(g)
                .spawnSettings(new SpawnSettings.Builder().build())
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(0.8f)
                .downfall(0.4f)
                .category(c)
                .build();
    }

    private static RegistryKey<Biome> getBiomeKey(String id) {
        return RegistryKey.of(Registry.BIOME_KEY, PrimevalMain.getId(id));
    }

    private static RegistryEntry<Biome> registerBiome(RegistryKey<Biome> key, Biome b) {
        return BuiltinRegistries.add(BuiltinRegistries.BIOME, key, b);
    }

    public static GenerationSettings buildGeneratorSettings(List<RegistryEntry<PlacedFeature>> undergroundOres, List<RegistryEntry<PlacedFeature>> vegetalDecoration) {
        GenerationSettings.Builder gen = new GenerationSettings.Builder();
        for (RegistryEntry<PlacedFeature> f : undergroundOres) {
            gen.feature(GenerationStep.Feature.UNDERGROUND_ORES, f);
        }
        for (RegistryEntry<PlacedFeature> f : vegetalDecoration) {
            gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, f);
        }
        return gen.build();
    }
}
