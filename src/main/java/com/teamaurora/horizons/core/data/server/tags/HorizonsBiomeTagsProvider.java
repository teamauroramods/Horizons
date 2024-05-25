package com.teamaurora.horizons.core.data.server.tags;

import com.teamabnormals.blueprint.core.other.tags.BlueprintBiomeTags;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class HorizonsBiomeTagsProvider extends BiomeTagsProvider {

    public HorizonsBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Horizons.MOD_ID, helper);
    }

    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BiomeTags.IS_OVERWORLD).add(HorizonsBiomes.BAYOU);
        this.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(HorizonsBiomes.BAYOU);
        this.tag(BiomeTags.HAS_MINESHAFT).add(HorizonsBiomes.BAYOU);

        this.tag(HorizonsBiomeTags.HAS_MALLOW).add(Biomes.MANGROVE_SWAMP, HorizonsBiomes.BAYOU);
        this.tag(HorizonsBiomeTags.HAS_MARIGOLD).add(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
        this.tag(HorizonsBiomeTags.HAS_AMARANTH).addTag(BiomeTags.IS_JUNGLE);
        this.tag(HorizonsBiomeTags.HAS_FORGET_ME_NOT).addTag(BiomeTags.IS_FOREST).add(Biomes.SWAMP);
        this.tag(HorizonsBiomeTags.HAS_HELICONIA).addTag(BiomeTags.IS_JUNGLE);
        this.tag(HorizonsBiomeTags.HAS_FIDDLENECK).addTag(BiomeTags.IS_SAVANNA).add(Biomes.SPARSE_JUNGLE);
        this.tag(HorizonsBiomeTags.HAS_WATERLILY).add(Biomes.SWAMP, Biomes.MANGROVE_SWAMP, HorizonsBiomes.BAYOU); // todo: add environmental + atmospheric compat
        this.tag(HorizonsBiomeTags.HAS_DAISY).add(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.FLOWER_FOREST, Biomes.MEADOW);

        this.tag(HorizonsBiomeTags.HAS_TROPICAL_GRASS).addTag(BiomeTags.IS_JUNGLE);
        this.tag(HorizonsBiomeTags.HAS_SWAMP_GRASS).add(Biomes.SWAMP, Biomes.MANGROVE_SWAMP, HorizonsBiomes.BAYOU);

        this.tag(HorizonsBiomeTags.HAS_FLOWERING_OAK).addTag(BiomeTags.IS_FOREST);
        this.tag(HorizonsBiomeTags.HAS_FLOWERING_JUNGLE).addTag(BiomeTags.IS_JUNGLE);
    }
}
