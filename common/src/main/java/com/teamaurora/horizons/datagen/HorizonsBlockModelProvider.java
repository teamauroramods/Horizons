package com.teamaurora.horizons.datagen;

import com.google.gson.JsonElement;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonBlocks;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedBlockModelGenerator;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class HorizonsBlockModelProvider extends PollinatedBlockModelGenerator {

    public HorizonsBlockModelProvider(Consumer<BlockStateGenerator> blockStateOutput, BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput, Consumer<Item> skippedAutoModelsOutput) {
        super(blockStateOutput, modelOutput, skippedAutoModelsOutput);
    }

    @Override
    public void run() {

        this.woodProvider(HorizonBlocks.CYPRESS_LOG.get()).logWithHorizontal(HorizonBlocks.CYPRESS_LOG.get()).wood(HorizonBlocks.CYPRESS_WOOD.get());
        this.woodProvider(HorizonBlocks.STRIPPED_CYPRESS_LOG.get()).logWithHorizontal(HorizonBlocks.STRIPPED_CYPRESS_LOG.get()).wood(HorizonBlocks.STRIPPED_CYPRESS_WOOD.get());
        this.family(HorizonBlocks.CYPRESS_PLANKS.get())
                .stairs(HorizonBlocks.CYPRESS_STAIRS.get())
                .slab(HorizonBlocks.CYPRESS_SLAB.get())
                .sign(HorizonBlocks.CYPRESS_SIGN.getFirst().get(), HorizonBlocks.CYPRESS_SIGN.getSecond().get())
                .pressurePlate(HorizonBlocks.CYPRESS_PRESSURE_PLATE.get())
                .button(HorizonBlocks.CYPRESS_BUTTON.get())
                .fence(HorizonBlocks.CYPRESS_FENCE.get())
                .fenceGate(HorizonBlocks.CYPRESS_FENCE_GATE.get());
    }
}
