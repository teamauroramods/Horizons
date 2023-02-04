package com.teamaurora.horizons.datagen;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import gg.moonflower.pollen.api.datagen.provider.tags.PollinatedBlockTagsProvider;
import gg.moonflower.pollen.api.util.PollinatedModContainer;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;

public class HorizonsBlockTagProvider extends PollinatedBlockTagsProvider {

    public HorizonsBlockTagProvider(DataGenerator generator, PollinatedModContainer container) {
        super(generator, container);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.FLOWER_POTS).add(HorizonsBlocks.POTTED_BLUE_LILY.get(),
                HorizonsBlocks.POTTED_CYAN_LILY.get(),
                HorizonsBlocks.POTTED_LIGHT_BLUE_LILY.get(),
                HorizonsBlocks.POTTED_MAGENTA_LILY.get(),
                HorizonsBlocks.POTTED_PINK_LILY.get(),
                HorizonsBlocks.POTTED_PURPLE_LILY.get(),
                HorizonsBlocks.POTTED_WHITE_LILY.get(),
                HorizonsBlocks.POTTED_CYPRESS_SAPLING.get());
        this.tag(BlockTags.LEAVES).add(HorizonsBlocks.CYPRESS_LEAVES.get());
        this.tag(BlockTags.LOGS_THAT_BURN).add(HorizonsBlocks.CYPRESS_LOG.get(),
                HorizonsBlocks.STRIPPED_CYPRESS_LOG.get(),
                HorizonsBlocks.CYPRESS_WOOD.get(),
                HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get());
        this.tag(BlockTags.PLANKS).add(HorizonsBlocks.CYPRESS_PLANKS.get());
        this.tag(BlockTags.SAPLINGS).add(HorizonsBlocks.CYPRESS_SAPLING.get());
        this.tag(BlockTags.SLABS).add(HorizonsBlocks.ALGAE_THATCH_SLAB.get());
        this.tag(BlockTags.SMALL_FLOWERS).add(HorizonsBlocks.BLUE_LILY.get(),
                HorizonsBlocks.CYAN_LILY.get(),
                HorizonsBlocks.LIGHT_BLUE_LILY.get(),
                HorizonsBlocks.MAGENTA_LILY.get(),
                HorizonsBlocks.PINK_LILY.get(),
                HorizonsBlocks.PURPLE_LILY.get(),
                HorizonsBlocks.WHITE_LILY.get());
        this.tag(BlockTags.STAIRS).add(HorizonsBlocks.ALGAE_THATCH_STAIRS.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(HorizonsBlocks.CYPRESS_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS).add(HorizonsBlocks.CYPRESS_DOOR.get());
        this.tag(BlockTags.WOODEN_FENCES).add(HorizonsBlocks.CYPRESS_FENCE.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(HorizonsBlocks.CYPRESS_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_SLABS).add(HorizonsBlocks.CYPRESS_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(HorizonsBlocks.CYPRESS_STAIRS.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(HorizonsBlocks.CYPRESS_TRAPDOOR.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(HorizonsBlocks.CYPRESS_KNEE.get(),
                HorizonsBlocks.LARGE_CYPRESS_KNEE.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(HorizonsBlocks.ALGAE_THATCH.get(),
                HorizonsBlocks.ALGAE_THATCH_SLAB.get(),
                HorizonsBlocks.ALGAE_THATCH_STAIRS.get());
    }
}
