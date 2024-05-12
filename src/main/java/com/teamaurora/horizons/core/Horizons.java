package com.teamaurora.horizons.core;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamaurora.horizons.core.data.client.HorizonsBlockStateProvider;
import com.teamaurora.horizons.core.data.client.HorizonsItemModelProvider;
import com.teamaurora.horizons.core.data.server.HorizonsDatapackBuiltinEntriesProvider;
import com.teamaurora.horizons.core.data.server.HorizonsLootTableProvider;
import com.teamaurora.horizons.core.data.server.HorizonsRecipeProvider;
import com.teamaurora.horizons.core.data.server.modifiers.HorizonsAdvancementModifierProvider;
import com.teamaurora.horizons.core.data.server.tags.HorizonsBiomeTagsProvider;
import com.teamaurora.horizons.core.data.server.tags.HorizonsBlockTagsProvider;
import com.teamaurora.horizons.core.data.server.tags.HorizonsItemTagsProvider;
import com.teamaurora.horizons.core.other.HorizonsClientCompat;
import com.teamaurora.horizons.core.other.HorizonsCompat;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(Horizons.MOD_ID)
public class Horizons
{
    public static final String MOD_ID = "horizons";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public Horizons() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext context = ModLoadingContext.get();
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_HELPER.register(bus);
        HorizonsFeatures.FEATURES.register(bus);
        HorizonsFeatures.TREE_DECORATORS.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::dataSetup);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            HorizonsBlocks.setupTabEditors();
            HorizonsItems.setupTabEditors();
        });
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            HorizonsCompat.registerCompat();
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            HorizonsClientCompat.registerRenderLayers();
            HorizonsClientCompat.registerBlockColors();
        });
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean includeServer = event.includeServer();

        HorizonsDatapackBuiltinEntriesProvider datapackEntries = new HorizonsDatapackBuiltinEntriesProvider(output, provider);
        generator.addProvider(includeServer, datapackEntries);
        provider = datapackEntries.getRegistryProvider();

        HorizonsBlockTagsProvider blockTags = new HorizonsBlockTagsProvider(output, provider, helper);
        generator.addProvider(includeServer, blockTags);
        generator.addProvider(includeServer, new HorizonsItemTagsProvider(output, provider, blockTags.contentsGetter(), helper));
        generator.addProvider(includeServer, new HorizonsBiomeTagsProvider(output, provider, helper));
        generator.addProvider(includeServer, new HorizonsRecipeProvider(output));
        generator.addProvider(includeServer, new HorizonsLootTableProvider(output));
        generator.addProvider(includeServer, new HorizonsAdvancementModifierProvider(output, provider));

        boolean includeClient = event.includeClient();
        generator.addProvider(includeClient, new HorizonsBlockStateProvider(output, helper));
        generator.addProvider(includeClient, new HorizonsItemModelProvider(output, helper));
    }
}
