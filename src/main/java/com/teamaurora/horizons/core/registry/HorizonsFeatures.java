package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.common.levelgen.feature.CypressTreeFeature;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(modid = Horizons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorizonsFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Horizons.MOD_ID);

    public static final RegistryObject<Feature<TreeConfiguration>> CYPRESS_TREE = FEATURES.register("cypress_tree", ()->new CypressTreeFeature(TreeConfiguration.CODEC));

    public static final class Configs {
        private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
        private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);

        public static final TreeConfiguration CYPRESS = createCypress().build();
        public static final TreeConfiguration CYPRESS_BEES_0002 = createCypress().decorators(List.of(BEEHIVE_0002)).build();
        public static final TreeConfiguration CYPRESS_BEES_005 = createCypress().decorators(List.of(BEEHIVE_005)).build();

        private static TreeConfiguration.TreeConfigurationBuilder createCypress() {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LOG.get()),
                    new StraightTrunkPlacer(12, 1, 5),
                    BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                    new TwoLayersFeatureSize(0, 0, 0)
            ).ignoreVines();
        }
    }

    public static final class Configured {
        public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS = createKey("cypress");
        public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_BEES_0002 = createKey("cypress_bees_0002");
        public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_BEES_005 = createKey("cypress_bees_005");

        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
            HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

            register(context, CYPRESS, HorizonsFeatures.CYPRESS_TREE.get(), Configs.CYPRESS);
            register(context, CYPRESS_BEES_0002, HorizonsFeatures.CYPRESS_TREE.get(), Configs.CYPRESS_BEES_0002);
            register(context, CYPRESS_BEES_005, HorizonsFeatures.CYPRESS_TREE.get(), Configs.CYPRESS_BEES_005);
        }

        public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Horizons.MOD_ID, name));
        }

        public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
            context.register(key, new ConfiguredFeature<>(feature, config));
        }
    }
}
