package com.teamaurora.horizons.datagen;

import com.google.gson.JsonElement;
import com.teamaurora.horizons.core.registry.HorizonItems;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedItemModelGenerator;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class HorizonsItemModelProvider extends PollinatedItemModelGenerator {

    public HorizonsItemModelProvider(Consumer<BlockStateGenerator> blockStateOutput, BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput, Consumer<Item> skippedAutoModelsOutput) {
        super(modelOutput);
    }

    @Override
    public void run() {
        this.generateFlatItem(HorizonItems.CYPRESS_BOAT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(HorizonItems.GOOSEBERRIES.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(HorizonItems.GOOSEBERRY_JUICE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(HorizonItems.GOOSEBERRY_PIE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(HorizonItems.HONEY_GLAZED_GOOSEBERRIES.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(HorizonItems.GOOSEBERRY_JAM.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(HorizonItems.GOOSEBERRY_JAM_COOKIE.get(), ModelTemplates.FLAT_ITEM);
    }
}
