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
import net.minecraft.world.level.block.state.BlockState;

public class HorizonsClientCompat {

    public static void registerRenderLayers() {
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
                HorizonsBlocks.HANGING_CYPRESS_LEAVES.get()
        );
    }
}
