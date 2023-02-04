package com.teamaurora.horizons.datagen;

import com.google.gson.JsonElement;
import com.teamaurora.horizons.core.registry.HorizonBlocks;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedBlockModelGenerator;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

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
        this.createDoor(HorizonBlocks.CYPRESS_DOOR.get());
        this.createOrientableTrapdoor(HorizonBlocks.CYPRESS_TRAPDOOR.get());
        this.createDoublePlant(HorizonBlocks.GIANT_FERN.get(), BlockModelGenerators.TintState.TINTED);
        this.createDoublePlant(HorizonBlocks.BEARD_MOSS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        this.createDoublePlant(HorizonBlocks.LARGE_CYPRESS_KNEE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        this.createCrossBlockWithDefaultItem(HorizonBlocks.CYPRESS_KNEE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        this.createTrivialBlock(HorizonBlocks.CYPRESS_LEAVES.get(), TexturedModel.LEAVES);
        this.createTrivialBlock(HorizonBlocks.BEARD_MOSS_BLOCK.get(), TexturedModel.LEAVES);
        this.createSimpleFlatItemModel(HorizonBlocks.ALGAE.get());
        this.createSimpleFlatItemModel(HorizonBlocks.CYPRESS_BRANCH.get(), "_0");
        this.createPlant(HorizonBlocks.CYPRESS_SAPLING.get(), HorizonBlocks.POTTED_CYPRESS_SAPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);
        this.createFlowerWithoutBlockModel(HorizonBlocks.BLUE_LILY.get(), HorizonBlocks.POTTED_BLUE_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonBlocks.LIGHT_GRAY_LILY.get(), HorizonBlocks.POTTED_LIGHT_GRAY_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonBlocks.CYAN_LILY.get(), HorizonBlocks.POTTED_CYAN_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonBlocks.LIGHT_BLUE_LILY.get(), HorizonBlocks.POTTED_LIGHT_BLUE_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonBlocks.MAGENTA_LILY.get(), HorizonBlocks.POTTED_MAGENTA_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonBlocks.PURPLE_LILY.get(), HorizonBlocks.POTTED_PURPLE_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonBlocks.PINK_LILY.get(), HorizonBlocks.POTTED_PINK_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonBlocks.WHITE_LILY.get(), HorizonBlocks.POTTED_WHITE_LILY.get());
        this.createSimpleFlatItemModel(HorizonBlocks.HANGING_CYPRESS_LEAVES.get());
    }

    private void createFlowerWithoutBlockModel(Block flower, Block pottedPlantBlock) {
        this.createSimpleFlatItemModel(flower);
        TextureMapping textureMapping = TextureMapping.plant(flower);
        ResourceLocation resourceLocation = BlockModelGenerators.TintState.NOT_TINTED.getCrossPot().create(pottedPlantBlock, textureMapping, this.getModelOutput());
        this.getBlockStateOutput().accept(createSimpleBlock(pottedPlantBlock, resourceLocation));
    }

    private void createDoublePlant(Block block, BlockModelGenerators.TintState tintState) {
        this.createSimpleFlatItemModel(block, "_top");
        ResourceLocation resourceLocation = this.createSuffixedVariant(block, "_top", tintState.getCross(), TextureMapping::cross);
        ResourceLocation resourceLocation2 = this.createSuffixedVariant(block, "_bottom", tintState.getCross(), TextureMapping::cross);
        this.createDoubleBlock(block, resourceLocation, resourceLocation2);
    }

    private void createDoubleBlock(Block block, ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        this.getBlockStateOutput().accept(MultiVariantGenerator.multiVariant(block).with(PropertyDispatch.property(BlockStateProperties.DOUBLE_BLOCK_HALF).select(DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, resourceLocation2)).select(DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, resourceLocation))));
    }
}
