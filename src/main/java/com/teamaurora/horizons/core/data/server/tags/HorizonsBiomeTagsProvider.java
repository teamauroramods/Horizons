package com.teamaurora.horizons.core.data.server.tags;

import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
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
    }
}
