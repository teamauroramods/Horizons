package com.teamaurora.horizons.common.levelgen.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.jetbrains.annotations.Nullable;

public class HorizonsOverworldBiomes {

    protected static final int NORMAL_WATER_COLOR = 4159204;
    protected static final int NORMAL_WATER_FOG_COLOR = 329011;
    private static final int OVERWORLD_FOG_COLOR = 12638463;
    @Nullable
    private static final Music NORMAL_MUSIC = null;

    public static Biome tropicalRiver() {
        MobSpawnSettings.Builder builder = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5));
        BiomeDefaultFeatures.commonSpawns(builder);
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 100, 1, 1));
        BiomeGenerationSettings.Builder builder2 = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(builder2);
        BiomeDefaultFeatures.addDefaultOres(builder2);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder2);
        BiomeDefaultFeatures.addWaterTrees(builder2);
        BiomeDefaultFeatures.addDefaultFlowers(builder2);
        BiomeDefaultFeatures.addDefaultGrass(builder2);
        builder2.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
        BiomeDefaultFeatures.addDefaultMushrooms(builder2);
        BiomeDefaultFeatures.addDefaultExtraVegetation(builder2);
        builder2.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);
        return biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.RIVER, 0.8F, 0.5F, 4445678, 270131, builder, builder2, NORMAL_MUSIC);
    }

    public static Biome sandyRiver() {
        MobSpawnSettings.Builder builder = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5));
        BiomeDefaultFeatures.commonSpawns(builder);
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 100, 1, 1));
        BiomeGenerationSettings.Builder builder2 = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(builder2);
        BiomeDefaultFeatures.addDefaultOres(builder2);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder2);
        BiomeDefaultFeatures.addWaterTrees(builder2);
        BiomeDefaultFeatures.addDefaultFlowers(builder2);
        BiomeDefaultFeatures.addDefaultGrass(builder2);
        BiomeDefaultFeatures.addDefaultMushrooms(builder2);
        BiomeDefaultFeatures.addDefaultExtraVegetation(builder2);
        builder2.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);
        return biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.RIVER, 2.0F, 0.0F, 4566514, 267827, builder, builder2, NORMAL_MUSIC);
    }

    public static Biome coldRiver() {
        MobSpawnSettings.Builder builder = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5));
        BiomeDefaultFeatures.commonSpawns(builder);
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 100, 1, 1));
        BiomeGenerationSettings.Builder builder2 = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(builder2);
        BiomeDefaultFeatures.addDefaultOres(builder2);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder2);
        BiomeDefaultFeatures.addWaterTrees(builder2);
        BiomeDefaultFeatures.addDefaultFlowers(builder2);
        BiomeDefaultFeatures.addDefaultGrass(builder2);
        BiomeDefaultFeatures.addDefaultMushrooms(builder2);
        BiomeDefaultFeatures.addDefaultExtraVegetation(builder2);
        builder2.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);
        return biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.RIVER, 0.3F, 0.8F, 4020182, 329011, builder, builder2, NORMAL_MUSIC);
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory biomeCategory, float temperature, float downfall, MobSpawnSettings.Builder builder, BiomeGenerationSettings.Builder generation, @Nullable Music music) {
        return biome(precipitation, biomeCategory, temperature, downfall, 4159204, 329011, builder, generation, music);
    }

    private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory biomeCategory, float temperature, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder builder, BiomeGenerationSettings.Builder generation, @Nullable Music music) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(biomeCategory).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(builder.build()).generationSettings(generation.build()).build();
    }

    protected static int calculateSkyColor(float f) {
        float g = f / 3.0F;
        g = Mth.clamp(g, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }
}
