package com.teamaurora.horizons.core.registry;

import com.google.common.collect.ImmutableList;
import com.teamaurora.horizons.common.levelgen.feature.AlgaePatchFeature;
import com.teamaurora.horizons.common.levelgen.feature.CypressTreeFeature;
import com.teamaurora.horizons.common.levelgen.feature.JacarandaTreeFeature;
import com.teamaurora.horizons.common.levelgen.treedecorators.BeardMossDecorator;
import com.teamaurora.horizons.common.levelgen.treedecorators.CypressBranchDecorator;
import com.teamaurora.horizons.common.levelgen.treedecorators.HangingCypressDecorator;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.OptionalInt;

@Mod.EventBusSubscriber(modid = Horizons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorizonsFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Horizons.MOD_ID);
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, Horizons.MOD_ID);

    public static final RegistryObject<Feature<TreeConfiguration>> CYPRESS_TREE = FEATURES.register("cypress_tree", ()->new CypressTreeFeature(TreeConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeConfiguration>> JACARANDA_TREE = FEATURES.register("jacaranda_tree", ()->new JacarandaTreeFeature(TreeConfiguration.CODEC));

    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> ALGAE = FEATURES.register("algae", ()->new AlgaePatchFeature(ProbabilityFeatureConfiguration.CODEC));

    public static final RegistryObject<TreeDecoratorType<?>> HANGING_CYPRESS_LEAVES = TREE_DECORATORS.register("hanging_cypress_leaves", ()->new TreeDecoratorType<>(HangingCypressDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<?>> CYPRESS_BRANCH = TREE_DECORATORS.register("cypress_branch", ()->new TreeDecoratorType<>(CypressBranchDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<?>> BEARD_MOSS = TREE_DECORATORS.register("beard_moss", ()->new TreeDecoratorType<>(BeardMossDecorator.CODEC));

    public static final class Configs {
        private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
        private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);
        private static final HangingCypressDecorator HANGING_CYPRESS_LEAVES = new HangingCypressDecorator();
        private static final BeardMossDecorator BEARD_MOSS = new BeardMossDecorator();
        private static final CypressBranchDecorator CYPRESS_BRANCH = new CypressBranchDecorator(0.02F);
        private static final LeaveVineDecorator LEAVE_VINE_025 = new LeaveVineDecorator(0.25F);

        public static final TreeConfiguration FLOWERING_OAK = createFloweringOak().build();
        public static final TreeConfiguration FLOWERING_OAK_BEES_0002 = createFloweringOak().decorators(List.of(BEEHIVE_0002)).build();
        public static final TreeConfiguration FLOWERING_OAK_BEES_005 = createFloweringOak().decorators(List.of(BEEHIVE_005)).build();
        public static final TreeConfiguration FLOWERING_FANCY_OAK = createFloweringFancyOak().build();
        public static final TreeConfiguration FLOWERING_FANCY_OAK_BEES_0002 = createFloweringFancyOak().decorators(List.of(BEEHIVE_0002)).build();
        public static final TreeConfiguration FLOWERING_FANCY_OAK_BEES_005 = createFloweringFancyOak().decorators(List.of(BEEHIVE_005)).build();

        public static final TreeConfiguration FLOWERING_JUNGLE = createFloweringJungle().build();
        public static final TreeConfiguration FLOWERING_MEGA_JUNGLE = createFloweringMegaJungle().build();

        public static final TreeConfiguration CYPRESS = createCypress().decorators(List.of(CYPRESS_BRANCH, HANGING_CYPRESS_LEAVES, LEAVE_VINE_025)).build();
        public static final TreeConfiguration CYPRESS_BEES_0002 = createCypress().decorators(List.of(CYPRESS_BRANCH, HANGING_CYPRESS_LEAVES, LEAVE_VINE_025, BEEHIVE_0002)).build();
        public static final TreeConfiguration CYPRESS_BEES_005 = createCypress().decorators(List.of(CYPRESS_BRANCH, HANGING_CYPRESS_LEAVES, LEAVE_VINE_025, BEEHIVE_005)).build();
        public static final TreeConfiguration CYPRESS_MOSS = createCypress().decorators(List.of(CYPRESS_BRANCH, HANGING_CYPRESS_LEAVES, BEARD_MOSS, LEAVE_VINE_025)).build();
        public static final TreeConfiguration CYPRESS_BEES_0002_MOSS = createCypress().decorators(List.of(CYPRESS_BRANCH, HANGING_CYPRESS_LEAVES, LEAVE_VINE_025, BEARD_MOSS, BEEHIVE_0002)).build();
        public static final TreeConfiguration CYPRESS_BEES_005_MOSS = createCypress().decorators(List.of(CYPRESS_BRANCH, HANGING_CYPRESS_LEAVES, LEAVE_VINE_025, BEARD_MOSS, BEEHIVE_005)).build();
        public static final TreeConfiguration CYPRESS_BUSH = createBush(HorizonsBlocks.CYPRESS_LOG.get(), HorizonsBlocks.CYPRESS_LEAVES.get()).build();

        public static final TreeConfiguration JACARANDA = createJacaranda().build();
        public static final TreeConfiguration JACARANDA_BEES_0002 = createJacaranda().decorators(List.of(BEEHIVE_0002)).build();
        public static final TreeConfiguration JACARANDA_BEES_005 = createJacaranda().decorators(List.of(BEEHIVE_005)).build();
        public static final TreeConfiguration FLOWERING_JACARANDA = createFloweringJacaranda().build();
        public static final TreeConfiguration FLOWERING_JACARANDA_BEES_0002 = createFloweringJacaranda().decorators(List.of(BEEHIVE_0002)).build();
        public static final TreeConfiguration FLOWERING_JACARANDA_BEES_005 = createFloweringJacaranda().decorators(List.of(BEEHIVE_005)).build();

        private static TreeConfiguration.TreeConfigurationBuilder createFloweringOak() {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new StraightTrunkPlacer(4, 2, 0),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 2).add(HorizonsBlocks.FLOWERING_OAK_LEAVES.get().defaultBlockState(), 6).build()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines();
        }

        private static TreeConfiguration.TreeConfigurationBuilder createFloweringFancyOak() {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new FancyTrunkPlacer(3, 11, 0),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 2).add(HorizonsBlocks.FLOWERING_OAK_LEAVES.get().defaultBlockState(), 6).build()),
                    new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                    new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
            ).ignoreVines();
        }

        private static TreeConfiguration.TreeConfigurationBuilder createFloweringJungle() {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(Blocks.JUNGLE_LOG),
                    new StraightTrunkPlacer(4, 8, 0),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.JUNGLE_LEAVES.defaultBlockState(), 2).add(HorizonsBlocks.FLOWERING_JUNGLE_LEAVES.get().defaultBlockState(), 6).build()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines();
        }

        private static TreeConfiguration.TreeConfigurationBuilder createFloweringMegaJungle() {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(Blocks.JUNGLE_LOG),
                    new MegaJungleTrunkPlacer(10, 2, 19),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.JUNGLE_LEAVES.defaultBlockState(), 2).add(HorizonsBlocks.FLOWERING_JUNGLE_LEAVES.get().defaultBlockState(), 6).build()),
                    new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                    new TwoLayersFeatureSize(1, 1, 2)
            ).decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F)));
        }

        private static TreeConfiguration.TreeConfigurationBuilder createCypress() {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LOG.get()),
                    new StraightTrunkPlacer(12, 1, 5),
                    BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                    new TwoLayersFeatureSize(0, 0, 0)
            ).ignoreVines();
        }

        private static TreeConfiguration.TreeConfigurationBuilder createJacaranda() {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(HorizonsBlocks.JACARANDA_LOG.get()),
                    new StraightTrunkPlacer(4, 3, 0),
                    BlockStateProvider.simple(HorizonsBlocks.JACARANDA_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                    new TwoLayersFeatureSize(0, 0, 0)
            );
        }

        private static TreeConfiguration.TreeConfigurationBuilder createFloweringJacaranda() {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(HorizonsBlocks.JACARANDA_LOG.get()),
                    new StraightTrunkPlacer(4, 3, 0),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(HorizonsBlocks.JACARANDA_LEAVES.get().defaultBlockState(), 2).add(HorizonsBlocks.FLOWERING_JACARANDA_LEAVES.get().defaultBlockState(), 6).build()),
                    new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                    new TwoLayersFeatureSize(0, 0, 0)
            );
        }

        private static TreeConfiguration.TreeConfigurationBuilder createBush(Block logBlock, Block leafBlock) {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(logBlock),
                    new StraightTrunkPlacer(1, 0, 0),
                    BlockStateProvider.simple(leafBlock),
                    new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                    new TwoLayersFeatureSize(0, 0, 0)
            );
        }
    }

    public static final class Configured {

        // Trees & Bushes //

        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_OAK = createKey("flowering_oak");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_OAK_BEES_0002 = createKey("flowering_oak_bees_0002");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_OAK_BEES_005 = createKey("flowering_oak_bees_005");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_FANCY_OAK = createKey("flowering_fancy_oak");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_FANCY_OAK_BEES_0002 = createKey("flowering_fancy_oak_bees_0002");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_FANCY_OAK_BEES_005 = createKey("flowering_fancy_oak_bees_005");

        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_JUNGLE = createKey("flowering_jungle");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_MEGA_JUNGLE = createKey("flowering_mega_jungle");

        public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS = createKey("cypress");
        public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_BEES_0002 = createKey("cypress_bees_0002");
        public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_BEES_005 = createKey("cypress_bees_005");
        public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_MOSS = createKey("cypress_moss");
        public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_BEES_0002_MOSS = createKey("cypress_bees_0002_moss");
        public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_BEES_005_MOSS = createKey("cypress_bees_005_moss");
        public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_BUSH = createKey("cypress_bush");

        public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA = createKey("jacaranda");
        public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_BEES_0002 = createKey("jacaranda_bees_0002");
        public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_BEES_005 = createKey("jacaranda_bees_005");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_JACARANDA = createKey("flowering_jacaranda");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_JACARANDA_BEES_0002 = createKey("flowering_jacaranda_bees_0002");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_JACARANDA_BEES_005 = createKey("flowering_jacaranda_bees_005");


        // Bayou //

        public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_MUD = createKey("disk_mud");
        public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_PODZOL = createKey("disk_podzol");

        public static final ResourceKey<ConfiguredFeature<?, ?>> ALGAE = createKey("algae");

        public static final ResourceKey<ConfiguredFeature<?, ?>> BAYOU_VEGETATION = createKey("bayou_vegetation");
        public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GRASS_BAYOU = createKey("patch_grass_bayou");
        public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_LILIES = createKey("water_lilies");

        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
            HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

            // Disks //
            register(context, DISK_MUD, Feature.DISK, new DiskConfiguration(
                    RuleBasedBlockStateProvider.simple(Blocks.MUD),
                    BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK)),
                    UniformInt.of(2, 6),
                    2
            ));
            register(context, DISK_PODZOL, Feature.DISK, new DiskConfiguration(
                    RuleBasedBlockStateProvider.simple(Blocks.PODZOL),
                    BlockPredicate.matchesBlocks(Blocks.GRASS_BLOCK),
                    UniformInt.of(2, 6),
                    2
            ));

            // Trees & Bushes //
            register(context, FLOWERING_OAK, Feature.TREE, Configs.FLOWERING_OAK);
            register(context, FLOWERING_OAK_BEES_0002, Feature.TREE, Configs.FLOWERING_OAK_BEES_0002);
            register(context, FLOWERING_OAK_BEES_005, Feature.TREE, Configs.FLOWERING_OAK_BEES_005);
            register(context, FLOWERING_FANCY_OAK, Feature.TREE, Configs.FLOWERING_FANCY_OAK);
            register(context, FLOWERING_FANCY_OAK_BEES_0002, Feature.TREE, Configs.FLOWERING_FANCY_OAK_BEES_0002);
            register(context, FLOWERING_FANCY_OAK_BEES_005, Feature.TREE, Configs.FLOWERING_FANCY_OAK_BEES_005);

            register(context, FLOWERING_JUNGLE, Feature.TREE, Configs.FLOWERING_JUNGLE);
            register(context, FLOWERING_MEGA_JUNGLE, Feature.TREE, Configs.FLOWERING_MEGA_JUNGLE);

            register(context, CYPRESS, HorizonsFeatures.CYPRESS_TREE.get(), Configs.CYPRESS);
            register(context, CYPRESS_BEES_0002, HorizonsFeatures.CYPRESS_TREE.get(), Configs.CYPRESS_BEES_0002);
            register(context, CYPRESS_BEES_005, HorizonsFeatures.CYPRESS_TREE.get(), Configs.CYPRESS_BEES_005);
            register(context, CYPRESS_MOSS, HorizonsFeatures.CYPRESS_TREE.get(), Configs.CYPRESS_MOSS);
            register(context, CYPRESS_BEES_0002_MOSS, HorizonsFeatures.CYPRESS_TREE.get(), Configs.CYPRESS_BEES_0002_MOSS);
            register(context, CYPRESS_BEES_005_MOSS, HorizonsFeatures.CYPRESS_TREE.get(), Configs.CYPRESS_BEES_005_MOSS);
            register(context, CYPRESS_BUSH, Feature.TREE, Configs.CYPRESS_BUSH);

            register(context, JACARANDA, HorizonsFeatures.JACARANDA_TREE.get(), Configs.JACARANDA);
            register(context, JACARANDA_BEES_0002, HorizonsFeatures.JACARANDA_TREE.get(), Configs.JACARANDA_BEES_0002);
            register(context, JACARANDA_BEES_005, HorizonsFeatures.JACARANDA_TREE.get(), Configs.JACARANDA_BEES_005);
            register(context, FLOWERING_JACARANDA, HorizonsFeatures.JACARANDA_TREE.get(), Configs.FLOWERING_JACARANDA);
            register(context, FLOWERING_JACARANDA_BEES_0002, HorizonsFeatures.JACARANDA_TREE.get(), Configs.FLOWERING_JACARANDA_BEES_0002);
            register(context, FLOWERING_JACARANDA_BEES_005, HorizonsFeatures.JACARANDA_TREE.get(), Configs.FLOWERING_JACARANDA_BEES_005);

            // Bayou //
            register(context, ALGAE, HorizonsFeatures.ALGAE.get(), new ProbabilityFeatureConfiguration(0.5F));
            register(context, WATER_LILIES, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(
                    SimpleWeightedRandomList.<BlockState>builder()
                            .add(HorizonsBlocks.BLUE_WATER_LILY.get().defaultBlockState(), 1)
                            .add(HorizonsBlocks.CYAN_WATER_LILY.get().defaultBlockState(), 1)
                            .add(HorizonsBlocks.PINK_WATER_LILY.get().defaultBlockState(), 1)
                            .add(HorizonsBlocks.PURPLE_WATER_LILY.get().defaultBlockState(), 1)
                            .add(HorizonsBlocks.WHITE_WATER_LILY.get().defaultBlockState(), 1)
                            .build()
            )))));

            register(context, BAYOU_VEGETATION, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(placedFeatures.getOrThrow(Placed.CYPRESS_BUSH), 0.1f),
                    new WeightedPlacedFeature(placedFeatures.getOrThrow(Placed.MANGROVE), 0.2f),
                    new WeightedPlacedFeature(placedFeatures.getOrThrow(Placed.CYPRESS_BEES_0002_MOSS), 0.3f)
            ), placedFeatures.getOrThrow(Placed.CYPRESS_BEES_0002)));
            register(context, PATCH_GRASS_BAYOU, Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(Blocks.GRASS.defaultBlockState(), 1)
                    .add(Blocks.FERN.defaultBlockState(), 1)
                    .add(Blocks.TALL_GRASS.defaultBlockState(), 4)
                    .add(Blocks.LARGE_FERN.defaultBlockState(), 2)
            ), 32));
        }

        private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
            return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
        }

        public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Horizons.MOD_ID, name));
        }

        public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
            context.register(key, new ConfiguredFeature<>(feature, config));
        }
    }

    public static final class Placed {
        public static final ResourceKey<PlacedFeature> DISK_MUD = createKey("disk_mud");
        public static final ResourceKey<PlacedFeature> DISK_PODZOL = createKey("disk_podzol");

        public static final ResourceKey<PlacedFeature> CYPRESS_BEES_0002 = createKey("cypress_bees_0002");
        public static final ResourceKey<PlacedFeature> CYPRESS_BEES_0002_MOSS = createKey("cypress_bees_0002_moss");
        public static final ResourceKey<PlacedFeature> CYPRESS_BUSH = createKey("cypress_bush");
        public static final ResourceKey<PlacedFeature> MANGROVE = createKey("mangrove");

        public static final ResourceKey<PlacedFeature> BAYOU_VEGETATION = createKey("bayou_vegetation");
        public static final ResourceKey<PlacedFeature> ALGAE_BAYOU = createKey("algae_bayou");
        public static final ResourceKey<PlacedFeature> PATCH_GRASS_BAYOU = createKey("patch_grass_bayou");
        public static final ResourceKey<PlacedFeature> WATER_LILIES_BAYOU = createKey("water_lilies_bayou");

        public static void bootstrap(BootstapContext<PlacedFeature> context) {
            register(context, DISK_MUD, Configured.DISK_MUD, List.of(CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(new Block[]{Blocks.GRASS_BLOCK, Blocks.DIRT})), BiomeFilter.biome()));
            register(context, DISK_PODZOL, Configured.DISK_PODZOL, List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(new Block[]{Blocks.GRASS_BLOCK})), BiomeFilter.biome()));

            register(context, CYPRESS_BEES_0002, Configured.CYPRESS_BEES_0002, List.of(PlacementUtils.filteredByBlockSurvival(Blocks.MANGROVE_PROPAGULE)));
            register(context, CYPRESS_BEES_0002_MOSS, Configured.CYPRESS_BEES_0002_MOSS, List.of(PlacementUtils.filteredByBlockSurvival(Blocks.MANGROVE_PROPAGULE)));
            register(context, CYPRESS_BUSH, Configured.CYPRESS_BUSH, List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)));
            register(context, MANGROVE, TreeFeatures.MANGROVE, List.of(PlacementUtils.filteredByBlockSurvival(Blocks.MANGROVE_PROPAGULE)));

            register(context, BAYOU_VEGETATION, Configured.BAYOU_VEGETATION, List.of(PlacementUtils.countExtra(20, 0.1f, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()));
            register(context, WATER_LILIES_BAYOU, Configured.WATER_LILIES, List.of(RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(new Block[]{Blocks.WATER})), BiomeFilter.biome()));
            register(context, ALGAE_BAYOU, Configured.ALGAE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
            register(context, PATCH_GRASS_BAYOU, Configured.PATCH_GRASS_BAYOU, List.of(CountPlacement.of(30), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        }

        public static ResourceKey<PlacedFeature> createKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Horizons.MOD_ID, name));
        }

        public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
            context.register(key, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(feature), modifiers));
        }

        public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
            register(context, key, feature, List.of(modifiers));
        }
    }
}
