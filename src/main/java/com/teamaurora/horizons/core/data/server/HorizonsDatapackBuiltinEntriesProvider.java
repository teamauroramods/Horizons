package com.teamaurora.horizons.core.data.server;

import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class HorizonsDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, HorizonsFeatures.Configured::bootstrap);

    public HorizonsDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of(Horizons.MOD_ID));
    }
}
