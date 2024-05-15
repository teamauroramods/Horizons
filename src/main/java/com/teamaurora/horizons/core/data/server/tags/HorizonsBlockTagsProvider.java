package com.teamaurora.horizons.core.data.server.tags;

import com.teamabnormals.blueprint.core.other.tags.BlueprintBlockTags;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public class HorizonsBlockTagsProvider extends BlockTagsProvider {

    public HorizonsBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Horizons.MOD_ID, helper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.PLANKS).add(CYPRESS_PLANKS.get(), JACARANDA_PLANKS.get(), REDWOOD_PLANKS.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTags(HorizonsBlockTags.CYPRESS_LOGS, HorizonsBlockTags.JACARANDA_LOGS, HorizonsBlockTags.REDWOOD_LOGS);
        this.tag(BlockTags.WOODEN_SLABS).add(CYPRESS_SLAB.get(), JACARANDA_SLAB.get(), REDWOOD_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(CYPRESS_STAIRS.get(), JACARANDA_STAIRS.get(), REDWOOD_STAIRS.get());
        this.tag(BlockTags.WOODEN_FENCES).add(CYPRESS_FENCE.get(), JACARANDA_FENCE.get(), REDWOOD_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(CYPRESS_FENCE_GATE.get(), JACARANDA_FENCE_GATE.get(), REDWOOD_FENCE_GATE.get());
        this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(CYPRESS_FENCE_GATE.get(), JACARANDA_FENCE_GATE.get(), REDWOOD_FENCE_GATE.get());
        this.tag(BlockTags.WOODEN_DOORS).add(CYPRESS_DOOR.get(), JACARANDA_DOOR.get(), REDWOOD_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(CYPRESS_TRAPDOOR.get(), JACARANDA_TRAPDOOR.get(), REDWOOD_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(CYPRESS_BUTTON.get(), JACARANDA_BUTTON.get(), REDWOOD_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(CYPRESS_PRESSURE_PLATE.get(), JACARANDA_PRESSURE_PLATE.get(), REDWOOD_PRESSURE_PLATE.get());
        this.tag(BlockTags.STANDING_SIGNS).add(CYPRESS_SIGNS.getFirst().get(), JACARANDA_SIGNS.getFirst().get(), REDWOOD_SIGNS.getFirst().get());
        this.tag(BlockTags.WALL_SIGNS).add(CYPRESS_SIGNS.getSecond().get(), JACARANDA_SIGNS.getSecond().get(), REDWOOD_SIGNS.getSecond().get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(CYPRESS_HANGING_SIGNS.getFirst().get(), JACARANDA_HANGING_SIGNS.getFirst().get(), REDWOOD_HANGING_SIGNS.getFirst().get());
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(CYPRESS_HANGING_SIGNS.getSecond().get(), JACARANDA_HANGING_SIGNS.getSecond().get(), REDWOOD_HANGING_SIGNS.getSecond().get());
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(CYPRESS_LOG.get(), JACARANDA_LOG.get(), REDWOOD_LOG.get());

        this.tag(BlockTags.LEAVES).add(FLOWERING_OAK_LEAVES.get(), FLOWERING_JUNGLE_LEAVES.get(), CYPRESS_LEAVES.get(), JACARANDA_LEAVES.get(), FLOWERING_JACARANDA_LEAVES.get(), REDWOOD_LEAVES.get());
        this.tag(BlockTags.SAPLINGS).add(FLOWERING_OAK_SAPLING.get(), FLOWERING_JUNGLE_SAPLING.get(), CYPRESS_SAPLING.get(), JACARANDA_SAPLING.get(), FLOWERING_JACARANDA_SAPLING.get(), REDWOOD_SAPLING.get());
        this.tag(BlockTags.FLOWER_POTS).add(
                POTTED_FLOWERING_OAK_SAPLING.get(), POTTED_FLOWERING_JUNGLE_SAPLING.get(), POTTED_CYPRESS_SAPLING.get(), POTTED_JACARANDA_SAPLING.get(), POTTED_FLOWERING_JACARANDA_SAPLING.get(), POTTED_REDWOOD_SAPLING.get(),
                POTTED_BLUE_WATER_LILY.get(), POTTED_CYAN_WATER_LILY.get(), POTTED_PINK_WATER_LILY.get(), POTTED_PURPLE_WATER_LILY.get(), POTTED_WHITE_WATER_LILY.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(FLOWERING_OAK_LEAVES.get(), FLOWERING_JUNGLE_LEAVES.get(), CYPRESS_LEAVES.get(), HANGING_CYPRESS_LEAVES.get(), JACARANDA_LEAVES.get(), FLOWERING_JACARANDA_LEAVES.get(), REDWOOD_LEAVES.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(CYPRESS_CABINET.get(), JACARANDA_CABINET.get(), REDWOOD_CABINET.get());

        this.tag(BlockTags.REPLACEABLE).add(HANGING_CYPRESS_LEAVES.get());

        this.tag(HorizonsBlockTags.CYPRESS_LOGS).add(CYPRESS_LOG.get(), STRIPPED_CYPRESS_LOG.get(), CYPRESS_WOOD.get(), STRIPPED_CYPRESS_WOOD.get());
        this.tag(HorizonsBlockTags.JACARANDA_LOGS).add(JACARANDA_LOG.get(), STRIPPED_JACARANDA_LOG.get(), JACARANDA_WOOD.get(), STRIPPED_JACARANDA_WOOD.get());
        this.tag(HorizonsBlockTags.REDWOOD_LOGS).add(REDWOOD_LOG.get(), STRIPPED_REDWOOD_LOG.get(), REDWOOD_WOOD.get(), STRIPPED_REDWOOD_WOOD.get());

        this.tag(BlueprintBlockTags.WOODEN_BOARDS).add(CYPRESS_BOARDS.get(), JACARANDA_BOARDS.get(), REDWOOD_BOARDS.get());
        this.tag(BlueprintBlockTags.WOODEN_CHESTS).add(CYPRESS_CHEST.get(), JACARANDA_CHEST.get(), REDWOOD_CHEST.get());
        this.tag(BlueprintBlockTags.WOODEN_TRAPPED_CHESTS).add(TRAPPED_CYPRESS_CHEST.get(), TRAPPED_JACARANDA_CHEST.get(), TRAPPED_REDWOOD_CHEST.get());
        this.tag(BlueprintBlockTags.WOODEN_BEEHIVES).add(CYPRESS_BEEHIVE.get(), JACARANDA_BEEHIVE.get(), REDWOOD_BEEHIVE.get());
        this.tag(BlueprintBlockTags.WOODEN_LADDERS).add(CYPRESS_LADDER.get(), JACARANDA_LADDER.get(), REDWOOD_LADDER.get());
        this.tag(BlueprintBlockTags.WOODEN_BOOKSHELVES).add(CYPRESS_BOOKSHELF.get(), JACARANDA_BOOKSHELF.get(), REDWOOD_BOOKSHELF.get());
        this.tag(BlueprintBlockTags.WOODEN_CHISELED_BOOKSHELVES).add(CHISELED_CYPRESS_BOOKSHELF.get(), CHISELED_JACARANDA_BOOKSHELF.get(), CHISELED_REDWOOD_BOOKSHELF.get());
        this.tag(BlueprintBlockTags.LEAF_PILES).add(FLOWERING_OAK_LEAF_PILE.get(), FLOWERING_JUNGLE_LEAF_PILE.get(), CYPRESS_LEAF_PILE.get(), JACARANDA_LEAF_PILE.get(), FLOWERING_JACARANDA_LEAF_PILE.get(), REDWOOD_LEAF_PILE.get());
    }
}
