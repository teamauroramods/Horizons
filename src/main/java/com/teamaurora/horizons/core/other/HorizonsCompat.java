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
        DataUtil.registerCompostable(HorizonsBlocks.ALGAE.get(), 0.65f);

        DataUtil.registerCompostable(HorizonsBlocks.ALGAE_THATCH.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.ALGAE_THATCH_SLAB.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.ALGAE_THATCH_STAIRS.get(), 0.65f);

        DataUtil.registerCompostable(HorizonsItems.GOOSEBERRIES.get(), 0.65f);
        DataUtil.registerCompostable(HorizonsBlocks.GOOSEBERRY_BASKET.get(), 1.0f);

        DataUtil.registerCompostable(HorizonsBlocks.BEARD_MOSS.get(), 0.3f);

        DataUtil.registerCompostable(HorizonsBlocks.CYPRESS_LEAVES.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.JACARANDA_LEAVES.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.REDWOOD_LEAVES.get(), 0.3f);

        DataUtil.registerCompostable(HorizonsBlocks.CYPRESS_SAPLING.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.JACARANDA_SAPLING.get(), 0.3f);
        DataUtil.registerCompostable(HorizonsBlocks.REDWOOD_SAPLING.get(), 0.3f);
    }

    public static void registerFlammables() {
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
