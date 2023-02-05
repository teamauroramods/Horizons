package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.core.Horizons;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import java.util.function.Supplier;

public class HorizonsBiomes {

    public static final PollinatedRegistry<Biome> BIOMES = PollinatedRegistry.create(BuiltinRegistries.BIOME, Horizons.MOD_ID);

    public static ResourceKey<Biome> register(String name, Supplier<Biome> biomeSupplier) {
        ResourceLocation id = Horizons.location(name);
        BIOMES.register(name, biomeSupplier);
        return ResourceKey.create(Registry.BIOME_REGISTRY, id);
    }
}
