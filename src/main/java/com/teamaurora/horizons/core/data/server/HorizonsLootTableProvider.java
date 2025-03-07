package com.teamaurora.horizons.core.data.server;

import com.google.common.collect.ImmutableList;
import com.teamaurora.horizons.common.block.CypressBranchBlock;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;
import static com.teamaurora.horizons.core.registry.HorizonsBlocks.POTTED_WHITE_MALLOW;

public class HorizonsLootTableProvider extends LootTableProvider {

    public HorizonsLootTableProvider(PackOutput output) {
        super(output, BuiltInLootTables.all(), ImmutableList.of(
                new LootTableProvider.SubProviderEntry(HorizonsBlockLoot::new, LootContextParamSets.BLOCK)
        ));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext context) {}

    private static class HorizonsBlockLoot extends BlockLootSubProvider {
        private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.PIGLIN_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(Collectors.toSet());

        protected HorizonsBlockLoot() {
            super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        public void generate() {
            this.dropSelf(RED_MALLOW.get());
            this.dropSelf(WHITE_MALLOW.get());
            this.dropSelf(MALLOW_BUSH.get());
            this.dropSelf(SUNNY_MARIGOLD.get());
            this.dropSelf(SHADY_MARIGOLD.get());
            this.add(MARIGOLD_BUSH.get(), (block)->createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
            this.dropSelf(AMARANTH.get());
            this.dropSelf(FIDDLENECK.get());
            this.add(HELICONIA.get(), (block)->createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
            this.dropSelf(FORGET_ME_NOT.get());

            this.dropPottedContents(POTTED_RED_MALLOW.get());
            this.dropPottedContents(POTTED_WHITE_MALLOW.get());
            this.dropPottedContents(POTTED_MALLOW_BUSH.get());
            this.dropPottedContents(POTTED_SUNNY_MARIGOLD.get());
            this.dropPottedContents(POTTED_SHADY_MARIGOLD.get());
            this.dropPottedContents(POTTED_MARIGOLD_BUSH.get());
            this.dropPottedContents(POTTED_AMARANTH.get());
            this.dropPottedContents(POTTED_FIDDLENECK.get());
            this.dropPottedContents(POTTED_HELICONIA.get());
            this.dropPottedContents(POTTED_FORGET_ME_NOT.get());

            this.dropSelf(BLUE_DAISY.get());
            this.dropSelf(ORANGE_DAISY.get());
            this.dropSelf(PINK_DAISY.get());
            this.dropSelf(PURPLE_DAISY.get());
            this.dropSelf(YELLOW_DAISY.get());

            this.dropPottedContents(POTTED_BLUE_DAISY.get());
            this.dropPottedContents(POTTED_ORANGE_DAISY.get());
            this.dropPottedContents(POTTED_PINK_DAISY.get());
            this.dropPottedContents(POTTED_PURPLE_DAISY.get());
            this.dropPottedContents(POTTED_YELLOW_DAISY.get());

            this.add(SHORT_TROPICAL_GRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);
            this.add(TALL_TROPICAL_GRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);
            this.add(SHORT_SWAMP_GRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);
            this.add(TALL_SWAMP_GRASS.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).when(HAS_SHEARS.and(LootItemBlockStatePropertyCondition.hasBlockStateProperties(TALL_SWAMP_GRASS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)))).add(LootItem.lootTableItem(TALL_SWAMP_GRASS.get()))));

            this.add(FLOWERING_OAK_LEAF_PILE.get(), this::createLeafPileDrops);
            this.add(FLOWERING_JUNGLE_LEAF_PILE.get(), this::createLeafPileDrops);

            this.dropSelf(ALGAE_THATCH.get());
            this.dropSelf(ALGAE_THATCH_STAIRS.get());
            this.add(ALGAE_THATCH_SLAB.get(), this::createSlabItemTable);

            this.add(ALGAE.get(), BlockLootSubProvider::createShearsOnlyDrop);

            this.dropSelf(GOOSEBERRY_BASKET.get());

            this.add(BEARD_MOSS.get(), BlockLootSubProvider::createShearsOnlyDrop);

            this.add(BLUE_WATER_LILY.get(), this::createLilyFlowerDrops);
            this.add(CYAN_WATER_LILY.get(), this::createLilyFlowerDrops);
            this.add(PINK_WATER_LILY.get(), this::createLilyFlowerDrops);
            this.add(PURPLE_WATER_LILY.get(), this::createLilyFlowerDrops);
            this.add(WHITE_WATER_LILY.get(), this::createLilyFlowerDrops);

            this.dropPottedContents(POTTED_BLUE_WATER_LILY.get());
            this.dropPottedContents(POTTED_CYAN_WATER_LILY.get());
            this.dropPottedContents(POTTED_PINK_WATER_LILY.get());
            this.dropPottedContents(POTTED_PURPLE_WATER_LILY.get());
            this.dropPottedContents(POTTED_WHITE_WATER_LILY.get());

            this.dropSelf(CYPRESS_PLANKS.get());
            this.dropSelf(CYPRESS_LOG.get());
            this.dropSelf(CYPRESS_WOOD.get());
            this.dropSelf(STRIPPED_CYPRESS_LOG.get());
            this.dropSelf(STRIPPED_CYPRESS_WOOD.get());
            this.dropSelf(CYPRESS_SIGNS.getFirst().get());
            this.dropSelf(CYPRESS_HANGING_SIGNS.getFirst().get());
            this.dropSelf(CYPRESS_PRESSURE_PLATE.get());
            this.dropSelf(CYPRESS_TRAPDOOR.get());
            this.dropSelf(CYPRESS_BUTTON.get());
            this.dropSelf(CYPRESS_STAIRS.get());
            this.dropSelf(CYPRESS_FENCE.get());
            this.dropSelf(CYPRESS_FENCE_GATE.get());
            this.dropSelf(CYPRESS_BOARDS.get());
            this.add(CYPRESS_LEAF_PILE.get(), this::createLeafPileDrops);
            this.add(HANGING_CYPRESS_LEAVES.get(), BlockLootSubProvider::createShearsOnlyDrop);
            this.add(CYPRESS_BRANCH.get(), (block) -> applyExplosionDecay(block, LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(CYPRESS_BRANCH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CypressBranchBlock.AGE, 2)))
                            .add(LootItem.lootTableItem(HorizonsItems.GOOSEBERRIES.get())))
                    .withPool(LootPool.lootPool()
                            .when(HAS_SHEARS.or(HAS_SILK_TOUCH))
                            .add(LootItem.lootTableItem(block)
                    )
            )));

            this.dropSelf(CYPRESS_LADDER.get());
            this.add(CYPRESS_SLAB.get(), this::createSlabItemTable);
            this.add(CYPRESS_DOOR.get(), this::createDoorTable);
            this.add(CYPRESS_BEEHIVE.get(), BlockLootSubProvider::createBeeHiveDrop);
            this.add(CYPRESS_CHEST.get(), this::createNameableBlockEntityTable);
            this.add(TRAPPED_CYPRESS_CHEST.get(), this::createNameableBlockEntityTable);
            this.add(CYPRESS_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0f)));
            this.dropWhenSilkTouch(CHISELED_CYPRESS_BOOKSHELF.get());
            this.add(CYPRESS_CABINET.get(), this::createNameableBlockEntityTable);

            this.dropSelf(JACARANDA_PLANKS.get());
            this.dropSelf(JACARANDA_LOG.get());
            this.dropSelf(JACARANDA_WOOD.get());
            this.dropSelf(STRIPPED_JACARANDA_LOG.get());
            this.dropSelf(STRIPPED_JACARANDA_WOOD.get());
            this.dropSelf(JACARANDA_SIGNS.getFirst().get());
            this.dropSelf(JACARANDA_HANGING_SIGNS.getFirst().get());
            this.dropSelf(JACARANDA_PRESSURE_PLATE.get());
            this.dropSelf(JACARANDA_TRAPDOOR.get());
            this.dropSelf(JACARANDA_BUTTON.get());
            this.dropSelf(JACARANDA_STAIRS.get());
            this.dropSelf(JACARANDA_FENCE.get());
            this.dropSelf(JACARANDA_FENCE_GATE.get());
            this.dropSelf(JACARANDA_BOARDS.get());
            this.add(JACARANDA_LEAF_PILE.get(), this::createLeafPileDrops);
            this.add(FLOWERING_JACARANDA_LEAF_PILE.get(), this::createLeafPileDrops);

            this.dropSelf(JACARANDA_LADDER.get());
            this.add(JACARANDA_SLAB.get(), this::createSlabItemTable);
            this.add(JACARANDA_DOOR.get(), this::createDoorTable);
            this.add(JACARANDA_BEEHIVE.get(), BlockLootSubProvider::createBeeHiveDrop);
            this.add(JACARANDA_CHEST.get(), this::createNameableBlockEntityTable);
            this.add(TRAPPED_JACARANDA_CHEST.get(), this::createNameableBlockEntityTable);
            this.add(JACARANDA_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0f)));
            this.dropWhenSilkTouch(CHISELED_JACARANDA_BOOKSHELF.get());
            this.add(JACARANDA_CABINET.get(), this::createNameableBlockEntityTable);


            this.dropSelf(REDWOOD_PLANKS.get());
            this.dropSelf(REDWOOD_LOG.get());
            this.dropSelf(REDWOOD_WOOD.get());
            this.dropSelf(STRIPPED_REDWOOD_LOG.get());
            this.dropSelf(STRIPPED_REDWOOD_WOOD.get());
            this.dropSelf(REDWOOD_SIGNS.getFirst().get());
            this.dropSelf(REDWOOD_HANGING_SIGNS.getFirst().get());
            this.dropSelf(REDWOOD_PRESSURE_PLATE.get());
            this.dropSelf(REDWOOD_TRAPDOOR.get());
            this.dropSelf(REDWOOD_BUTTON.get());
            this.dropSelf(REDWOOD_STAIRS.get());
            this.dropSelf(REDWOOD_FENCE.get());
            this.dropSelf(REDWOOD_FENCE_GATE.get());
            this.dropSelf(REDWOOD_BOARDS.get());
            this.add(REDWOOD_LEAF_PILE.get(), this::createLeafPileDrops);

            this.dropSelf(REDWOOD_LADDER.get());
            this.add(REDWOOD_SLAB.get(), this::createSlabItemTable);
            this.add(REDWOOD_DOOR.get(), this::createDoorTable);
            this.add(REDWOOD_BEEHIVE.get(), BlockLootSubProvider::createBeeHiveDrop);
            this.add(REDWOOD_CHEST.get(), this::createNameableBlockEntityTable);
            this.add(TRAPPED_REDWOOD_CHEST.get(), this::createNameableBlockEntityTable);
            this.add(REDWOOD_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0f)));
            this.dropWhenSilkTouch(CHISELED_REDWOOD_BOOKSHELF.get());
            this.add(REDWOOD_CABINET.get(), this::createNameableBlockEntityTable);


            this.dropSelf(FLOWERING_OAK_SAPLING.get());
            this.dropSelf(FLOWERING_JUNGLE_SAPLING.get());
            this.dropSelf(CYPRESS_SAPLING.get());
            this.dropSelf(JACARANDA_SAPLING.get());
            this.dropSelf(FLOWERING_JACARANDA_SAPLING.get());
            this.dropSelf(REDWOOD_SAPLING.get());

            this.dropPottedContents(POTTED_FLOWERING_OAK_SAPLING.get());
            this.dropPottedContents(POTTED_FLOWERING_JUNGLE_SAPLING.get());
            this.dropPottedContents(POTTED_CYPRESS_SAPLING.get());
            this.dropPottedContents(POTTED_JACARANDA_SAPLING.get());
            this.dropPottedContents(POTTED_FLOWERING_JACARANDA_SAPLING.get());
            this.dropPottedContents(POTTED_REDWOOD_SAPLING.get());

            this.add(FLOWERING_OAK_LEAVES.get(), (block) -> createLeavesDrops(block, FLOWERING_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
            this.add(FLOWERING_JUNGLE_LEAVES.get(), (block) -> createLeavesDrops(block, FLOWERING_JUNGLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
            this.add(CYPRESS_LEAVES.get(), (block) -> createLeavesDrops(block, CYPRESS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
            this.add(JACARANDA_LEAVES.get(), (block) -> createLeavesDrops(block, JACARANDA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
            this.add(FLOWERING_JACARANDA_LEAVES.get(), (block) -> createLeavesDrops(block, FLOWERING_JACARANDA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
            this.add(REDWOOD_LEAVES.get(), (block) -> createLeavesDrops(block, REDWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        }

        protected LootTable.Builder createLeafPileDrops(Block block) {
            return createMultifaceBlockDrops(block, MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS)));
        }

        protected LootTable.Builder createLilyFlowerDrops(Block block) {
            return LootTable.lootTable()
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.LILY_PAD)))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block)));
        }

        @Override
        public Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> ForgeRegistries.BLOCKS.getKey(block).getNamespace().equals(Horizons.MOD_ID)).collect(Collectors.toSet());
        }
    }
}
