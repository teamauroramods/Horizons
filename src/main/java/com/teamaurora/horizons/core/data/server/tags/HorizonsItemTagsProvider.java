package com.teamaurora.horizons.core.data.server.tags;

import com.teamabnormals.blueprint.core.data.server.tags.BlueprintItemTagsProvider;
import com.teamabnormals.blueprint.core.other.tags.BlueprintItemTags;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsBlockTags;
import com.teamaurora.horizons.core.other.tags.HorizonsItemTags;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public class HorizonsItemTagsProvider extends BlueprintItemTagsProvider {

    public HorizonsItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookup, ExistingFileHelper fileHelper) {
        super(Horizons.MOD_ID, output, lookupProvider, tagLookup, fileHelper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.copyWoodsetTags();

        this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
        this.copy(BlockTags.TALL_FLOWERS, ItemTags.TALL_FLOWERS);

        this.copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);

        this.tag(ItemTags.BOATS).add(HorizonsItems.CYPRESS_BOAT.getFirst().get(), HorizonsItems.JACARANDA_BOAT.getFirst().get(), HorizonsItems.REDWOOD_BOAT.getFirst().get());
        this.tag(ItemTags.CHEST_BOATS).add(HorizonsItems.CYPRESS_BOAT.getSecond().get(), HorizonsItems.JACARANDA_BOAT.getSecond().get(), HorizonsItems.REDWOOD_BOAT.getSecond().get());
        this.tag(BlueprintItemTags.FURNACE_BOATS).add(HorizonsItems.CYPRESS_FURNACE_BOAT.get(), HorizonsItems.JACARANDA_FURNACE_BOAT.get(), HorizonsItems.REDWOOD_FURNACE_BOAT.get());
        this.tag(BlueprintItemTags.LARGE_BOATS).add(HorizonsItems.LARGE_CYPRESS_BOAT.get(), HorizonsItems.LARGE_JACARANDA_BOAT.get(), HorizonsItems.LARGE_REDWOOD_BOAT.get());

        this.copy(HorizonsBlockTags.CYPRESS_LOGS, HorizonsItemTags.CYPRESS_LOGS);
        this.copy(HorizonsBlockTags.JACARANDA_LOGS, HorizonsItemTags.JACARANDA_LOGS);
        this.copy(HorizonsBlockTags.REDWOOD_LOGS, HorizonsItemTags.REDWOOD_LOGS);
    }
}
