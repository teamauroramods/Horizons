package com.teamaurora.horizons.core.other;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;

public class HorizonsClientCompat {

    public static void registerRenderLayers() {
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.RED_MALLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.WHITE_MALLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.MALLOW_BUSH  .get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.SUNNY_MARIGOLD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.SHADY_MARIGOLD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.MARIGOLD_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.AMARANTH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.FIDDLENECK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.HELICONIA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.FORGET_ME_NOT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_RED_MALLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_WHITE_MALLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_MALLOW_BUSH  .get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_SUNNY_MARIGOLD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_SHADY_MARIGOLD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_MARIGOLD_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_AMARANTH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_FIDDLENECK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_HELICONIA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_FORGET_ME_NOT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.BLUE_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.ORANGE_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.PINK_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.PURPLE_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.YELLOW_DAISY.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_BLUE_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_ORANGE_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_PINK_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_PURPLE_DAISY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_YELLOW_DAISY.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.SHORT_TROPICAL_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.TALL_TROPICAL_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.SHORT_SWAMP_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.TALL_SWAMP_GRASS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.ALGAE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.ALGAE_THATCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.ALGAE_THATCH_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.ALGAE_THATCH_STAIRS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.JACARANDA_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.JACARANDA_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.REDWOOD_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.REDWOOD_TRAPDOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.FLOWERING_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.FLOWERING_JUNGLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.CYPRESS_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.JACARANDA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.FLOWERING_JACARANDA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.REDWOOD_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_FLOWERING_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_FLOWERING_JUNGLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_CYPRESS_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_JACARANDA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_FLOWERING_JACARANDA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_REDWOOD_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.HANGING_CYPRESS_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.CYPRESS_BRANCH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.BEARD_MOSS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.BLUE_WATER_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.CYAN_WATER_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.PINK_WATER_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.PURPLE_WATER_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.WHITE_WATER_LILY.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_BLUE_WATER_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_CYAN_WATER_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_PINK_WATER_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_PURPLE_WATER_LILY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HorizonsBlocks.POTTED_WHITE_WATER_LILY.get(), RenderType.cutout());
    }

    public static void registerBlockColors() {
        BlockColors blockcolors = Minecraft.getInstance().getBlockColors();
        ItemColors itemcolors = Minecraft.getInstance().getItemColors();

        blockcolors.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                HorizonsBlocks.FLOWERING_OAK_LEAVES.get(),
                HorizonsBlocks.FLOWERING_OAK_LEAF_PILE.get(),
                HorizonsBlocks.FLOWERING_JUNGLE_LEAVES.get(),
                HorizonsBlocks.FLOWERING_JUNGLE_LEAF_PILE.get(),
                HorizonsBlocks.CYPRESS_LEAVES.get(),
                HorizonsBlocks.CYPRESS_LEAF_PILE.get(),
                HorizonsBlocks.HANGING_CYPRESS_LEAVES.get()
        );
        blockcolors.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
                HorizonsBlocks.SHORT_TROPICAL_GRASS.get(),
                HorizonsBlocks.TALL_TROPICAL_GRASS.get(),
                HorizonsBlocks.SHORT_SWAMP_GRASS.get(),
                HorizonsBlocks.TALL_SWAMP_GRASS.get()
        );
        blockcolors.register((state, world, pos, tintIndex) -> world != null && pos != null ? 2129968 : 7455580,
                HorizonsBlocks.BLUE_WATER_LILY.get(),
                HorizonsBlocks.CYAN_WATER_LILY.get(),
                HorizonsBlocks.PINK_WATER_LILY.get(),
                HorizonsBlocks.PURPLE_WATER_LILY.get(),
                HorizonsBlocks.WHITE_WATER_LILY.get()
        );

        itemcolors.register((stack, tintIndex) -> {
            BlockState blockstate = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return blockcolors.getColor(blockstate, null, null, tintIndex);
        },
                HorizonsBlocks.FLOWERING_OAK_LEAVES.get(),
                HorizonsBlocks.FLOWERING_OAK_LEAF_PILE.get(),
                HorizonsBlocks.FLOWERING_JUNGLE_LEAVES.get(),
                HorizonsBlocks.FLOWERING_JUNGLE_LEAF_PILE.get(),
                HorizonsBlocks.CYPRESS_LEAVES.get(),
                HorizonsBlocks.CYPRESS_LEAF_PILE.get(),
                HorizonsBlocks.HANGING_CYPRESS_LEAVES.get(),
                HorizonsBlocks.SHORT_TROPICAL_GRASS.get(),
                HorizonsBlocks.TALL_TROPICAL_GRASS.get(),
                HorizonsBlocks.SHORT_SWAMP_GRASS.get(),
                HorizonsBlocks.TALL_SWAMP_GRASS.get()
        );
    }
}
