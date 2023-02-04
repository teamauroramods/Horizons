package com.teamaurora.horizons.datagen;

import com.google.gson.JsonElement;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
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
        this.woodProvider(HorizonsBlocks.CYPRESS_LOG.get()).logWithHorizontal(HorizonsBlocks.CYPRESS_LOG.get()).wood(HorizonsBlocks.CYPRESS_WOOD.get());
        this.woodProvider(HorizonsBlocks.STRIPPED_CYPRESS_LOG.get()).logWithHorizontal(HorizonsBlocks.STRIPPED_CYPRESS_LOG.get()).wood(HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get());
        this.family(HorizonsBlocks.CYPRESS_PLANKS.get())
                .stairs(HorizonsBlocks.CYPRESS_STAIRS.get())
                .slab(HorizonsBlocks.CYPRESS_SLAB.get())
                .sign(HorizonsBlocks.CYPRESS_SIGN.getFirst().get(), HorizonsBlocks.CYPRESS_SIGN.getSecond().get())
                .pressurePlate(HorizonsBlocks.CYPRESS_PRESSURE_PLATE.get())
                .button(HorizonsBlocks.CYPRESS_BUTTON.get())
                .fence(HorizonsBlocks.CYPRESS_FENCE.get())
                .fenceGate(HorizonsBlocks.CYPRESS_FENCE_GATE.get());
        this.createDoor(HorizonsBlocks.CYPRESS_DOOR.get());
        this.createOrientableTrapdoor(HorizonsBlocks.CYPRESS_TRAPDOOR.get());
        this.createDoublePlant(HorizonsBlocks.GIANT_FERN.get(), BlockModelGenerators.TintState.TINTED);
        this.createDoublePlant(HorizonsBlocks.BEARD_MOSS.get(), BlockModelGenerators.TintState.NOT_TINTED);
        this.createDoublePlant(HorizonsBlocks.LARGE_CYPRESS_KNEE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        this.createCrossBlockWithDefaultItem(HorizonsBlocks.CYPRESS_KNEE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        this.createTrivialBlock(HorizonsBlocks.CYPRESS_LEAVES.get(), TexturedModel.LEAVES);
        this.createTrivialBlock(HorizonsBlocks.BEARD_MOSS_BLOCK.get(), TexturedModel.LEAVES);
        this.createSimpleFlatItemModel(HorizonsBlocks.ALGAE.get());
        this.createSimpleFlatItemModel(HorizonsBlocks.CYPRESS_BRANCH.get(), "_0");
        this.createPlant(HorizonsBlocks.CYPRESS_SAPLING.get(), HorizonsBlocks.POTTED_CYPRESS_SAPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);
        this.createFlowerWithoutBlockModel(HorizonsBlocks.BLUE_LILY.get(), HorizonsBlocks.POTTED_BLUE_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonsBlocks.LIGHT_GRAY_LILY.get(), HorizonsBlocks.POTTED_LIGHT_GRAY_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonsBlocks.CYAN_LILY.get(), HorizonsBlocks.POTTED_CYAN_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonsBlocks.LIGHT_BLUE_LILY.get(), HorizonsBlocks.POTTED_LIGHT_BLUE_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonsBlocks.MAGENTA_LILY.get(), HorizonsBlocks.POTTED_MAGENTA_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonsBlocks.PURPLE_LILY.get(), HorizonsBlocks.POTTED_PURPLE_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonsBlocks.PINK_LILY.get(), HorizonsBlocks.POTTED_PINK_LILY.get());
        this.createFlowerWithoutBlockModel(HorizonsBlocks.WHITE_LILY.get(), HorizonsBlocks.POTTED_WHITE_LILY.get());
        this.createSimpleFlatItemModel(HorizonsBlocks.HANGING_CYPRESS_LEAVES.get());
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
