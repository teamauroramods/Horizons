package com.teamaurora.horizons.datagen;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import gg.moonflower.pollen.api.datagen.provider.tags.PollinatedBlockTagsProvider;
import gg.moonflower.pollen.api.datagen.provider.tags.PollinatedItemTagsProvider;
import gg.moonflower.pollen.api.util.PollinatedModContainer;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

public class HorizonsItemTagProvider extends PollinatedItemTagsProvider {



    public HorizonsItemTagProvider(DataGenerator dataGenerator, PollinatedModContainer container, PollinatedBlockTagsProvider blockTagsProvider) {
        super(dataGenerator, container, blockTagsProvider);
    }

    @Override
    protected void addTags() {
        this.tag(ItemTags.BOATS).add(HorizonsItems.CYPRESS_BOAT.get());
        this.tag(ItemTags.LEAVES).add(HorizonsBlocks.CYPRESS_LEAVES.get().asItem());
        this.tag(ItemTags.LOGS_THAT_BURN).add(HorizonsBlocks.CYPRESS_LOG.get().asItem(),
                HorizonsBlocks.STRIPPED_CYPRESS_LOG.get().asItem(),
                HorizonsBlocks.CYPRESS_WOOD.get().asItem(),
                HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get().asItem());
        this.tag(ItemTags.PLANKS).add(HorizonsBlocks.CYPRESS_PLANKS.get().asItem());
        this.tag(ItemTags.SAPLINGS).add(HorizonsBlocks.CYPRESS_SAPLING.get().asItem());
        this.tag(ItemTags.SLABS).add(HorizonsBlocks.ALGAE_THATCH_SLAB.get().asItem());
        this.tag(ItemTags.SMALL_FLOWERS).add(HorizonsBlocks.BLUE_LILY.get().asItem(),
                HorizonsBlocks.CYAN_LILY.get().asItem(),
                HorizonsBlocks.LIGHT_BLUE_LILY.get().asItem(),
                HorizonsBlocks.MAGENTA_LILY.get().asItem(),
                HorizonsBlocks.PINK_LILY.get().asItem(),
                HorizonsBlocks.PURPLE_LILY.get().asItem(),
                HorizonsBlocks.WHITE_LILY.get().asItem());
        this.tag(ItemTags.STAIRS).add(HorizonsBlocks.ALGAE_THATCH_STAIRS.get().asItem());
        this.tag(ItemTags.WOODEN_BUTTONS).add(HorizonsBlocks.CYPRESS_BUTTON.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS).add(HorizonsBlocks.CYPRESS_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_FENCES).add(HorizonsBlocks.CYPRESS_FENCE.get().asItem());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(HorizonsBlocks.CYPRESS_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.WOODEN_SLABS).add(HorizonsBlocks.CYPRESS_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS).add(HorizonsBlocks.CYPRESS_STAIRS.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(HorizonsBlocks.CYPRESS_TRAPDOOR.get().asItem());
    }
}
