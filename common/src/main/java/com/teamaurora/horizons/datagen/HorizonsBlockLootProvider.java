package com.teamaurora.horizons.datagen;

import com.mojang.datafixers.util.Pair;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import gg.moonflower.pollen.api.block.PollinatedStandingSignBlock;
import gg.moonflower.pollen.api.block.PollinatedWallSignBlock;
import gg.moonflower.pollen.api.datagen.provider.loot_table.PollinatedBlockLootGenerator;
import gg.moonflower.pollen.api.util.PollinatedModContainer;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.Supplier;

public class HorizonsBlockLootProvider extends PollinatedBlockLootGenerator {

    public HorizonsBlockLootProvider(PollinatedModContainer container) {
        super(container);
    }

    @Override
    protected void run() {
        this.dropSelf(HorizonsBlocks.STRIPPED_CYPRESS_LOG.get());
        this.dropSelf(HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get());
        this.dropSelf(HorizonsBlocks.CYPRESS_LOG.get());
        this.dropSelf(HorizonsBlocks.CYPRESS_WOOD.get());
        this.dropSelf(HorizonsBlocks.CYPRESS_PLANKS.get());
        this.add(HorizonsBlocks.CYPRESS_SLAB.get(), HorizonsBlockLootProvider::createSlabItemTable);
        this.dropSelf(HorizonsBlocks.CYPRESS_STAIRS.get());
        this.dropSelf(HorizonsBlocks.CYPRESS_PRESSURE_PLATE.get());
        this.dropSelf(HorizonsBlocks.CYPRESS_BUTTON.get());
        this.dropSelf(HorizonsBlocks.CYPRESS_FENCE.get());
        this.dropSelf(HorizonsBlocks.CYPRESS_FENCE_GATE.get());
        this.add(HorizonsBlocks.CYPRESS_DOOR.get(), HorizonsBlockLootProvider::createDoorTable);
        this.dropSelf(HorizonsBlocks.CYPRESS_TRAPDOOR.get());
        this.dropSign(HorizonsBlocks.CYPRESS_SIGN);
        this.add(HorizonsBlocks.CYPRESS_LEAVES.get(), block -> createLeavesDrops(block, HorizonsBlocks.CYPRESS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(HorizonsBlocks.CYPRESS_SAPLING.get());
        this.dropPottedContents(HorizonsBlocks.POTTED_CYPRESS_SAPLING.get());
        this.add(HorizonsBlocks.HANGING_CYPRESS_LEAVES.get(), block -> createLeavesDrops(block, HorizonsBlocks.CYPRESS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(HorizonsBlocks.CYPRESS_KNEE.get());
        this.add(HorizonsBlocks.LARGE_CYPRESS_KNEE.get(), block -> createSinglePropConditionTable(block, BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
        this.add(HorizonsBlocks.CYPRESS_BRANCH.get(), block -> noDrop());
        this.dropLilyItems(HorizonsBlocks.BLUE_LILY.get());
        this.dropLilyItems(HorizonsBlocks.LIGHT_GRAY_LILY.get());
        this.dropLilyItems(HorizonsBlocks.CYAN_LILY.get());
        this.dropLilyItems(HorizonsBlocks.LIGHT_BLUE_LILY.get());
        this.dropLilyItems(HorizonsBlocks.MAGENTA_LILY.get());
        this.dropLilyItems(HorizonsBlocks.PINK_LILY.get());
        this.dropLilyItems(HorizonsBlocks.PURPLE_LILY.get());
        this.dropLilyItems(HorizonsBlocks.WHITE_LILY.get());
        this.dropPottedContents(HorizonsBlocks.POTTED_BLUE_LILY.get());
        this.dropPottedContents(HorizonsBlocks.POTTED_LIGHT_GRAY_LILY.get());
        this.dropPottedContents(HorizonsBlocks.POTTED_CYAN_LILY.get());
        this.dropPottedContents(HorizonsBlocks.POTTED_LIGHT_BLUE_LILY.get());
        this.dropPottedContents(HorizonsBlocks.POTTED_MAGENTA_LILY.get());
        this.dropPottedContents(HorizonsBlocks.POTTED_PINK_LILY.get());
        this.dropPottedContents(HorizonsBlocks.POTTED_PURPLE_LILY.get());
        this.dropPottedContents(HorizonsBlocks.POTTED_WHITE_LILY.get());

        this.dropSelf(HorizonsBlocks.ALGAE.get());
        this.dropSelf(HorizonsBlocks.ALGAE_THATCH.get());
        this.add(HorizonsBlocks.ALGAE_THATCH_SLAB.get(), HorizonsBlockLootProvider::createSlabItemTable);
        this.dropSelf(HorizonsBlocks.ALGAE_THATCH_STAIRS.get());
        this.dropSelf(HorizonsBlocks.BEARD_MOSS.get());
        this.dropSelf(HorizonsBlocks.BEARD_MOSS_BLOCK.get());
        this.add(HorizonsBlocks.GIANT_FERN.get(), block -> createDoublePlantWithSeedDrops(block, Blocks.FERN));
    }

    private void dropSign(Pair<Supplier<PollinatedStandingSignBlock>, Supplier<PollinatedWallSignBlock>> signs) {
        this.dropSelf(signs.getFirst().get());
        this.dropSelf(signs.getSecond().get());
    }

    private void dropLilyItems(Block block) {
        this.add(block, HorizonsBlockLootProvider::createLilyItemTable);
    }

    public static LootTable.Builder createLilyItemTable(ItemLike itemLike) {
        return LootTable.lootTable().withPool(applyExplosionCondition(Blocks.LILY_PAD, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Blocks.LILY_PAD)))).withPool(applyExplosionCondition(itemLike, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))));
    }
}
