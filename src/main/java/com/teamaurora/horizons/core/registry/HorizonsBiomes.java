package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

// Is this class readable? No. Will this class ever be readable? Also no.
// Send your complaints to the nearest Mojang office by asking them why JSON worldgen was ever a good idea.
public class HorizonsBiomes {
    public static final ResourceKey<Biome> BAYOU = createKey("bayou");

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> features = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carvers = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(BAYOU, bayou(features, carvers));
    }

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(Horizons.MOD_ID, name));
    }

    private static Biome bayou(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
        MobSpawnSettings.Builder spawns = spawnsBayou();
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder(features, carvers);
        OverworldBiomes.globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addSwampClayDisk(generation);

        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placed.BAYOU_VEGETATION);
        BiomeDefaultFeatures.addDefaultFlowers(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placed.PATCH_GRASS_BAYOU);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placed.ALGAE_BAYOU);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placed.WATER_LILIES_BAYOU);

        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_SWAMP);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_SWAMP);

        BiomeDefaultFeatures.addSwampExtraVegetation(generation);

        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);

        generation.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, HorizonsFeatures.Placed.DISK_MUD);
        generation.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, HorizonsFeatures.Placed.DISK_PODZOL);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.8f)
                .downfall(0.9f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x396e86)
                        .waterFogColor(0x3D5156)
                        .fogColor(0xA0E2E5)
                        .skyColor(calculateSkyColor(0.8F))
                        .foliageColorOverride(0x69AA2F)
                        .grassColorOverride(0x6CC147)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP))
                        .build())
                .mobSpawnSettings(spawns.build())
                .generationSettings(generation.build())
                .build();
    }

    private static MobSpawnSettings.Builder spawnsBayou() {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawns);
        BiomeDefaultFeatures.farmAnimals(spawns);
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
        return spawns;
    }

    private static int calculateSkyColor(float temperature) {
        float clampedTemp = Mth.clamp(temperature / 3.0F, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - clampedTemp * 0.05F, 0.5F + clampedTemp * 0.1F, 1.0F);
    }
}
