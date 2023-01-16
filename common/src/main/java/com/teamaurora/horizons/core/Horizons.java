package com.teamaurora.horizons.core;

import com.teamaurora.horizons.core.registry.HorizonBlocks;
import com.teamaurora.horizons.core.registry.HorizonBoatTypes;
import com.teamaurora.horizons.core.registry.HorizonItems;
import com.teamaurora.horizons.datagen.HorizonsBlockModelProvider;
import com.teamaurora.horizons.datagen.HorizonsItemModelProvider;
import gg.moonflower.pollen.api.datagen.provider.loot_table.PollinatedLootTableProvider;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedModelProvider;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.util.PollinatedModContainer;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

/**
 * @author ebo2022
 */
public class Horizons {

    public static final String MOD_ID = "horizons";
    public static final Platform PLATFORM = Platform.builder(MOD_ID)
            .commonInit(Horizons::onCommon)
            .dataInit(Horizons::onData)
            .build();

    private static void onCommon() {
        HorizonBlocks.BLOCKS.register(PLATFORM);
        HorizonItems.ITEMS.register(PLATFORM);
        HorizonBoatTypes.BOAT_TYPES.register(PLATFORM);
    }

    private static void onData(Platform.DataSetupContext ctx) {
        DataGenerator generator = ctx.getGenerator();
        PollinatedModContainer container = ctx.getMod();
        PollinatedModelProvider modelProvider = new PollinatedModelProvider(generator, container);
        modelProvider.addGenerator(HorizonsBlockModelProvider::new);
        modelProvider.addGenerator(HorizonsItemModelProvider::new);
        generator.addProvider(modelProvider);
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
