package com.teamaurora.horizons.core;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsBoatTypes;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import com.teamaurora.horizons.datagen.HorizonsBlockModelProvider;
import com.teamaurora.horizons.datagen.HorizonsBlockTagProvider;
import com.teamaurora.horizons.datagen.HorizonsItemModelProvider;
import com.teamaurora.horizons.datagen.HorizonsItemTagProvider;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedModelProvider;
import gg.moonflower.pollen.api.datagen.provider.tags.PollinatedBlockTagsProvider;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.client.ColorRegistry;
import gg.moonflower.pollen.api.registry.client.RenderTypeRegistry;
import gg.moonflower.pollen.api.util.PollinatedModContainer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;

/**
 * @author ebo2022
 */
public class Horizons {

    public static final String MOD_ID = "horizons";
    public static final Platform PLATFORM = Platform.builder(MOD_ID)
            .clientInit(() -> Horizons::onClient)
            .clientPostInit(() -> Horizons::onClientPost)
            .commonInit(Horizons::onCommon)
            .dataInit(Horizons::onData)
            .build();

    public static void onClient() {
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : FoliageColor.getDefaultColor(), HorizonsBlocks.CYPRESS_LEAVES, HorizonsBlocks.HANGING_CYPRESS_LEAVES);
        ColorRegistry.register((stack, tintIndex) -> FoliageColor.getDefaultColor(), HorizonsBlocks.CYPRESS_LEAVES, HorizonsBlocks.HANGING_CYPRESS_LEAVES);
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.get(0.5D, 1.0D), HorizonsBlocks.GIANT_FERN);
        ColorRegistry.register((stack, tintIndex) -> GrassColor.get(0.5D, 1.0D), HorizonsBlocks.GIANT_FERN);
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? 2129968 : 7455580, HorizonsBlocks.BLUE_LILY, HorizonsBlocks.LIGHT_GRAY_LILY, HorizonsBlocks.CYAN_LILY, HorizonsBlocks.LIGHT_BLUE_LILY, HorizonsBlocks.MAGENTA_LILY, HorizonsBlocks.PINK_LILY, HorizonsBlocks.PURPLE_LILY, HorizonsBlocks.WHITE_LILY);
    }

    public static void onClientPost(Platform.ModSetupContext ctx) {
        RenderTypeRegistry.register(HorizonsBlocks.HANGING_CYPRESS_LEAVES.get(), RenderType.cutoutMipped());
        RenderTypeRegistry.register(HorizonsBlocks.CYPRESS_SAPLING.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.POTTED_CYPRESS_SAPLING.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.ALGAE.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.ALGAE_THATCH.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.ALGAE_THATCH_SLAB.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.ALGAE_THATCH_STAIRS.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.CYPRESS_KNEE.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.LARGE_CYPRESS_KNEE.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.CYPRESS_BRANCH.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.BLUE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.LIGHT_GRAY_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.CYAN_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.LIGHT_BLUE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.MAGENTA_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.PINK_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.PURPLE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.WHITE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.BEARD_MOSS.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.GIANT_FERN.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.POTTED_BLUE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.POTTED_LIGHT_GRAY_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.POTTED_CYAN_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.POTTED_LIGHT_BLUE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.POTTED_MAGENTA_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.POTTED_PINK_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.POTTED_PURPLE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonsBlocks.POTTED_WHITE_LILY.get(), RenderType.cutout());
    }

    private static void onCommon() {
        HorizonsBlocks.BLOCKS.register(PLATFORM);
        HorizonsItems.ITEMS.register(PLATFORM);
        HorizonsBoatTypes.BOAT_TYPES.register(PLATFORM);
    }

    private static void onData(Platform.DataSetupContext ctx) {
        DataGenerator generator = ctx.getGenerator();
        PollinatedModContainer container = ctx.getMod();
        PollinatedBlockTagsProvider blockTagsProvider = new HorizonsBlockTagProvider(generator, container);
        generator.addProvider(blockTagsProvider);
        generator.addProvider(new HorizonsItemTagProvider(generator, container, blockTagsProvider));
        PollinatedModelProvider modelProvider = new PollinatedModelProvider(generator, container);
        modelProvider.addGenerator(HorizonsBlockModelProvider::new);
        modelProvider.addGenerator(HorizonsItemModelProvider::new);
        generator.addProvider(modelProvider);
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
