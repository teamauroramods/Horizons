package com.teamaurora.horizons.core;

import com.teamaurora.horizons.core.registry.HorizonBlocks;
import com.teamaurora.horizons.core.registry.HorizonBoatTypes;
import com.teamaurora.horizons.core.registry.HorizonItems;
import com.teamaurora.horizons.datagen.HorizonsBlockModelProvider;
import com.teamaurora.horizons.datagen.HorizonsItemModelProvider;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedModelProvider;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.client.ColorRegistry;
import gg.moonflower.pollen.api.registry.client.RenderTypeRegistry;
import gg.moonflower.pollen.api.util.PollinatedModContainer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
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
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : FoliageColor.getDefaultColor(), HorizonBlocks.CYPRESS_LEAVES, HorizonBlocks.HANGING_CYPRESS_LEAVES);
        ColorRegistry.register((stack, tintIndex) -> FoliageColor.getDefaultColor(), HorizonBlocks.CYPRESS_LEAVES, HorizonBlocks.HANGING_CYPRESS_LEAVES);
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.get(0.5D, 1.0D), HorizonBlocks.GIANT_FERN);
        ColorRegistry.register((stack, tintIndex) -> GrassColor.get(0.5D, 1.0D), HorizonBlocks.GIANT_FERN);
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? 2129968 : 7455580, HorizonBlocks.BLUE_LILY, HorizonBlocks.LIGHT_GRAY_LILY, HorizonBlocks.CYAN_LILY, HorizonBlocks.LIGHT_BLUE_LILY, HorizonBlocks.MAGENTA_LILY, HorizonBlocks.PINK_LILY, HorizonBlocks.PURPLE_LILY, HorizonBlocks.WHITE_LILY);
    }

    public static void onClientPost(Platform.ModSetupContext ctx) {
        RenderTypeRegistry.register(HorizonBlocks.HANGING_CYPRESS_LEAVES.get(), RenderType.cutoutMipped());
        RenderTypeRegistry.register(HorizonBlocks.CYPRESS_SAPLING.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.POTTED_CYPRESS_SAPLING.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.ALGAE.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.ALGAE_THATCH.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.ALGAE_THATCH_SLAB.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.ALGAE_THATCH_STAIRS.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.CYPRESS_KNEE.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.LARGE_CYPRESS_KNEE.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.CYPRESS_BRANCH.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.BLUE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.LIGHT_GRAY_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.CYAN_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.LIGHT_BLUE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.MAGENTA_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.PINK_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.PURPLE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.WHITE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.BEARD_MOSS.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.GIANT_FERN.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.POTTED_BLUE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.POTTED_LIGHT_GRAY_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.POTTED_CYAN_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.POTTED_LIGHT_BLUE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.POTTED_MAGENTA_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.POTTED_PINK_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.POTTED_PURPLE_LILY.get(), RenderType.cutout());
        RenderTypeRegistry.register(HorizonBlocks.POTTED_WHITE_LILY.get(), RenderType.cutout());
    }

    private static void onCommon() {
        HorizonBlocks.BLOCKS.register(PLATFORM);
        HorizonItems.ITEMS.register(PLATFORM);
        HorizonBoatTypes.BOAT_TYPES.register(PLATFORM);
    }

    private static void onData(Platform.DataSetupContext ctx) {
        DataGenerator generator = ctx.getGenerator();
        PollinatedModContainer container = ctx.getMod();
        PollinatedModelProvider modelProvider = new PollinatedModelProvider(generator, container);
        modelProvider.addGenerator(HorizonsBlockModelProvider::new);
        modelProvider.addGenerator(HorizonsItemModelProvider::new);
        generator.addProvider(modelProvider);
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
