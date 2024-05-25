package com.teamaurora.horizons.core.other;

import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;

public class HorizonsCompat {

    public static void registerCompat() {
        registerCompostables();
        registerFlammables();
    }

    public static void registerCompostables() {
        DataUtil.registerCompostable(HorizonsBlocks.RED_MALLOW.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.WHITE_MALLOW.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.MALLOW_BUSH.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.SUNNY_MARIGOLD.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.SHADY_MARIGOLD.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.MARIGOLD_BUSH.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.AMARANTH.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.FIDDLENECK.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.HELICONIA.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.FORGET_ME_NOT.get(), 0.65f);

        DataUtil.registerCompostable(HorizonsBlocks.BLUE_DAISY.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.ORANGE_DAISY.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.PINK_DAISY.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.PURPLE_DAISY.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.YELLOW_DAISY.get(), 0.65f);

        DataUtil.registerCompostable(HorizonsBlocks.SHORT_TROPICAL_GRASS.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.SHORT_SWAMP_GRASS.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.TALL_TROPICAL_GRASS.get(), 0.5f);
        DataUtil.registerCompostable(HorizonsBlocks.TALL_SWAMP_GRASS.get(), 0.5f);

        DataUtil.registerCompostable(HorizonsBlocks.ALGAE.get(), 0.65f);

        DataUtil.registerCompostable(HorizonsBlocks.ALGAE_THATCH.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.ALGAE_THATCH_SLAB.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.ALGAE_THATCH_STAIRS.get(), 0.65f);

        DataUtil.registerCompostable(HorizonsItems.GOOSEBERRIES.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.GOOSEBERRY_BASKET.get(), 1.0f);

        DataUtil.registerCompostable(HorizonsBlocks.BEARD_MOSS.get(), 0.3f);

        DataUtil.registerCompostable(HorizonsBlocks.BLUE_WATER_LILY.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.CYAN_WATER_LILY.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.PINK_WATER_LILY.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.PURPLE_WATER_LILY.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.WHITE_WATER_LILY.get(), 0.65f);

        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_OAK_LEAVES.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_JUNGLE_LEAVES.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.CYPRESS_LEAVES.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.JACARANDA_LEAVES.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_JACARANDA_LEAVES.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.REDWOOD_LEAVES.get(), 0.3f);

        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_OAK_SAPLING.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_JUNGLE_SAPLING.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.CYPRESS_SAPLING.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.JACARANDA_SAPLING.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_JACARANDA_SAPLING.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.REDWOOD_SAPLING.get(), 0.3f);
    }

    public static void registerFlammables() {
        // Grass
        DataUtil.registerFlammable(HorizonsBlocks.SHORT_TROPICAL_GRASS.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.TALL_TROPICAL_GRASS.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.SHORT_SWAMP_GRASS.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.TALL_SWAMP_GRASS.get(), 60, 100);

        // Thatch
        DataUtil.registerFlammable(HorizonsBlocks.ALGAE_THATCH.get(), 60, 20);
        DataUtil.registerFlammable(HorizonsBlocks.ALGAE_THATCH_SLAB.get(), 60, 20);
        DataUtil.registerFlammable(HorizonsBlocks.ALGAE_THATCH_STAIRS.get(), 60, 20);

        // Gooseberry stuff
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_BRANCH.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.GOOSEBERRY_BASKET.get(), 60, 20);

        // Beard moss
        DataUtil.registerFlammable(HorizonsBlocks.BEARD_MOSS.get(), 15, 100);

        // Cypress woodset
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_LOG.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_CYPRESS_LOG.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_FENCE_GATE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_LEAF_PILE.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_BEEHIVE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_BOARDS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_BOOKSHELF.get(), 30, 20);

        // Jacaranda woodset
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_LOG.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_JACARANDA_LOG.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_JACARANDA_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_FENCE_GATE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_LEAF_PILE.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.FLOWERING_JACARANDA_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.FLOWERING_JACARANDA_LEAF_PILE.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_BEEHIVE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_BOARDS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.JACARANDA_BOOKSHELF.get(), 30, 20);

        // Redwood woodset
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_LOG.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_REDWOOD_LOG.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_REDWOOD_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_FENCE_GATE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_LEAF_PILE.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_BEEHIVE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_BOARDS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_BOOKSHELF.get(), 30, 20);
    }
}
