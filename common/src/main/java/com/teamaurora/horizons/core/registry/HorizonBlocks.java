package com.teamaurora.horizons.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamaurora.horizons.common.block.*;
import com.teamaurora.horizons.common.block.base.HorizonSaplingBlock;
import com.teamaurora.horizons.common.block.thatch.ThatchBlock;
import com.teamaurora.horizons.common.block.thatch.ThatchSlabBlock;
import com.teamaurora.horizons.common.block.thatch.ThatchStairBlock;
import com.teamaurora.horizons.common.item.AlgaeItem;
import com.teamaurora.horizons.common.item.ItemTabPlacements;
import com.teamaurora.horizons.common.item.LilyItem;
import com.teamaurora.horizons.common.item.TabInsertBlockItem;
import com.teamaurora.horizons.core.registry.util.DeferredSoundType;
import com.teamaurora.horizons.core.registry.util.Woodset;
import gg.moonflower.pollen.api.block.PollinatedStandingSignBlock;
import gg.moonflower.pollen.api.block.PollinatedWallSignBlock;
import gg.moonflower.pollen.api.registry.PollinatedBlockRegistry;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Function;
import java.util.function.Supplier;

public class HorizonBlocks {

    public static final DeferredSoundType ALGAE_SOUND_TYPE = new DeferredSoundType(1F, 2.0F, () -> SoundEvents.LILY_PAD_PLACE, () -> SoundEvents.MOSS_CARPET_STEP, () -> SoundEvents.LILY_PAD_PLACE, () -> SoundEvents.MOSS_CARPET_HIT, () -> SoundEvents.MOSS_CARPET_FALL);
    public static final DeferredSoundType ALGAE_THATCH_SOUND_TYPE = new DeferredSoundType(1.0F, 0.7F, () -> SoundEvents.ROOTS_BREAK, () -> SoundEvents.ROOTS_STEP, () -> SoundEvents.ROOTS_PLACE, () -> SoundEvents.GRASS_HIT, () -> SoundEvents.ROOTS_FALL);

    public static final PollinatedBlockRegistry BLOCKS = PollinatedRegistry.createBlock(HorizonItems.ITEMS);

    private static final Woodset CYPRESS = new Woodset(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_GREEN);

    public static final Supplier<Block> STRIPPED_CYPRESS_LOG = BLOCKS.registerWithItem("stripped_cypress_log", CYPRESS.strippedLog(), ItemTabPlacements.STRIPPED_LOG);
    public static final Supplier<Block> STRIPPED_CYPRESS_WOOD = BLOCKS.registerWithItem("stripped_cypress_wood", CYPRESS.strippedWood(), ItemTabPlacements.STRIPPED_WOOD);
    public static final Supplier<Block> CYPRESS_LOG = BLOCKS.registerWithItem("cypress_log", CYPRESS.log(), ItemTabPlacements.LOG);
    public static final Supplier<Block> CYPRESS_WOOD = BLOCKS.registerWithItem("cypress_wood", CYPRESS.wood(), ItemTabPlacements.WOOD);

    public static final Supplier<Block> CYPRESS_PLANKS = BLOCKS.registerWithItem("cypress_planks", CYPRESS.planks(), ItemTabPlacements.PLANKS);
    public static final Supplier<Block> CYPRESS_SLAB = BLOCKS.registerWithItem("cypress_slab", CYPRESS.slab(), ItemTabPlacements.SLAB);
    public static final Supplier<Block> CYPRESS_STAIRS = BLOCKS.registerWithItem("cypress_stairs", CYPRESS.stairs(CYPRESS_PLANKS), ItemTabPlacements.STAIRS);
    public static final Supplier<Block> CYPRESS_PRESSURE_PLATE = BLOCKS.registerWithItem("cypress_pressure_plate", CYPRESS.pressurePlate(), ItemTabPlacements.WOOD_PRESSURE_PLATE);
    public static final Supplier<Block> CYPRESS_BUTTON = BLOCKS.registerWithItem("cypress_button", CYPRESS.button(), ItemTabPlacements.WOOD_BUTTON);
    public static final Supplier<Block> CYPRESS_FENCE = BLOCKS.registerWithItem("cypress_fence", CYPRESS.fence(), ItemTabPlacements.WOOD_FENCE);
    public static final Supplier<Block> CYPRESS_FENCE_GATE = BLOCKS.registerWithItem("cypress_fence_gate", CYPRESS.fenceGate(), ItemTabPlacements.WOOD_FENCE_GATE);
    public static final Supplier<Block> CYPRESS_DOOR = BLOCKS.registerWithItem("cypress_door", CYPRESS.door(), ItemTabPlacements.DOOR);
    public static final Supplier<Block> CYPRESS_TRAPDOOR = BLOCKS.registerWithItem("cypress_trapdoor", CYPRESS.trapdoor(), ItemTabPlacements.TRAPDOOR);
    public static final Pair<Supplier<PollinatedStandingSignBlock>, Supplier<PollinatedWallSignBlock>> CYPRESS_SIGN = BLOCKS.registerSign("cypress", Material.WOOD, MaterialColor.COLOR_GREEN);

    public static final Supplier<Block> CYPRESS_LEAVES = BLOCKS.registerWithItem("cypress_leaves", () -> new LeavesBlock(Properties.CYPRESS_LEAVES), ItemTabPlacements.LEAVES);
    public static final Supplier<Block> CYPRESS_SAPLING = BLOCKS.registerWithItem("cypress_sapling", () -> new HorizonSaplingBlock(new OakTreeGrower(), Properties.CYPRESS_SAPLING), ItemTabPlacements.SAPLING);
    public static final Supplier<Block> POTTED_CYPRESS_SAPLING = BLOCKS.register("potted_cypress_sapling", createFlowerPot(CYPRESS_SAPLING));

    public static final Supplier<Block> HANGING_CYPRESS_LEAVES = BLOCKS.registerWithItem("hanging_cypress_leaves", () -> new HangingCypressLeavesBlock(Properties.CYPRESS_LEAVES), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> CYPRESS_KNEE = BLOCKS.registerWithItem("cypress_knee", () -> new CypressKneeBlock(Properties.CYPRESS_KNEE), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> LARGE_CYPRESS_KNEE = BLOCKS.registerWithItem("large_cypress_knee", () -> new DoubleCypressKneeBlock(Properties.CYPRESS_KNEE), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final Supplier<Block> CYPRESS_BRANCH = BLOCKS.registerWithItem("cypress_branch", () -> new CypressBranchBlock(Properties.CYPRESS_BRANCH), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    public static final Supplier<Block> BLUE_LILY = BLOCKS.registerWithItem("blue_lily", () -> new LilyFlowerBlock(Properties.LILY), object -> new LilyItem(object, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> LIGHT_GRAY_LILY = BLOCKS.registerWithItem("light_gray_lily", () -> new LilyFlowerBlock(Properties.LILY), object -> new LilyItem(object, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> CYAN_LILY = BLOCKS.registerWithItem("cyan_lily", () -> new LilyFlowerBlock(Properties.LILY), object -> new LilyItem(object, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));;
    public static final Supplier<Block> LIGHT_BLUE_LILY = BLOCKS.registerWithItem("light_blue_lily", () -> new LilyFlowerBlock(Properties.LILY), object -> new LilyItem(object, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> MAGENTA_LILY = BLOCKS.registerWithItem("magenta_lily", () -> new LilyFlowerBlock(Properties.LILY), object -> new LilyItem(object, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> PINK_LILY = BLOCKS.registerWithItem("pink_lily", () -> new LilyFlowerBlock(Properties.LILY), object -> new LilyItem(object, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> PURPLE_LILY = BLOCKS.registerWithItem("purple_lily", () -> new LilyFlowerBlock(Properties.LILY), object -> new LilyItem(object, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> WHITE_LILY = BLOCKS.registerWithItem("white_lily", () -> new LilyFlowerBlock(Properties.LILY), object -> new LilyItem(object, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));;

    public static final Supplier<Block> POTTED_BLUE_LILY = BLOCKS.register("potted_blue_lily", createFlowerPot(BLUE_LILY));
    public static final Supplier<Block> POTTED_LIGHT_GRAY_LILY = BLOCKS.register("potted_light_gray_lily", createFlowerPot(LIGHT_GRAY_LILY));
    public static final Supplier<Block> POTTED_CYAN_LILY = BLOCKS.register("potted_cyan_lily", createFlowerPot(CYAN_LILY));
    public static final Supplier<Block> POTTED_LIGHT_BLUE_LILY = BLOCKS.register("potted_light_blue_lily", createFlowerPot(LIGHT_BLUE_LILY));
    public static final Supplier<Block> POTTED_MAGENTA_LILY = BLOCKS.register("potted_magenta_lily", createFlowerPot(MAGENTA_LILY));
    public static final Supplier<Block> POTTED_PINK_LILY = BLOCKS.register("potted_pink_lily", createFlowerPot(PINK_LILY));
    public static final Supplier<Block> POTTED_PURPLE_LILY = BLOCKS.register("potted_purple_lily", createFlowerPot(PURPLE_LILY));
    public static final Supplier<Block> POTTED_WHITE_LILY = BLOCKS.register("potted_white_lily", createFlowerPot(WHITE_LILY));

    public static final Supplier<Block> ALGAE = BLOCKS.registerWithItem("algae", () -> new AlgaeBlock(Properties.ALGAE), object -> new AlgaeItem(object, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final Supplier<Block> ALGAE_THATCH = BLOCKS.registerWithItem("algae_thatch", () -> new ThatchBlock(Properties.ALGAE_THATCH), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> ALGAE_THATCH_SLAB = BLOCKS.registerWithItem("algae_thatch_slab", () -> new ThatchSlabBlock(Properties.ALGAE_THATCH), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final Supplier<Block> ALGAE_THATCH_STAIRS = BLOCKS.registerWithItem("algae_thatch_stairs" ,() -> new ThatchStairBlock(ALGAE_THATCH.get().defaultBlockState(), Properties.ALGAE_THATCH), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final Supplier<Block> BEARD_MOSS = BLOCKS.registerWithItem("beard_moss", () -> new BeardMossBlock(Properties.BEARD_MOSS), ItemTabPlacements.BEARD_MOSS);
    public static final Supplier<Block> BEARD_MOSS_BLOCK = BLOCKS.registerWithItem("beard_moss_block", () -> new BeardMossBlockBlock(Properties.BEARD_MOSS_BLOCK), ItemTabPlacements.BEARD_MOSS);
    public static final Supplier<Block> GIANT_FERN = BLOCKS.registerWithItem("giant_fern", () -> new DoublePlantBlock(Properties.DOUBLE_PLANT), ItemTabPlacements.GIANT_FERN);

    private static Supplier<Block> createFlowerPot(Supplier<Block> block) {
        return () -> new FlowerPotBlock(block.get(), HorizonBlocks.Properties.POTTED_PLANT);
    }

    public static final class Properties {
        public static final BlockBehaviour.Properties CYPRESS_LEAVES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES);
        public static final BlockBehaviour.Properties CYPRESS_SAPLING = BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING);
        public static final BlockBehaviour.Properties CYPRESS_KNEE = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD).noOcclusion();
        public static final BlockBehaviour.Properties CYPRESS_BRANCH = BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.BAMBOO_SAPLING);
        public static final BlockBehaviour.Properties LILY = BlockBehaviour.Properties.copy(Blocks.LILY_PAD);
        public static final BlockBehaviour.Properties POTTED_PLANT = BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM);
        public static final BlockBehaviour.Properties ALGAE = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(ALGAE_SOUND_TYPE).noOcclusion().noCollission();
        public static final BlockBehaviour.Properties ALGAE_THATCH = BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_LIGHT_GREEN).strength(0.5F).sound(ALGAE_THATCH_SOUND_TYPE).noOcclusion();
        public static final BlockBehaviour.Properties BEARD_MOSS_BLOCK = BlockBehaviour.Properties.of(Material.PLANT).strength(0.1F).sound(SoundType.MOSS);
        public static final BlockBehaviour.Properties BEARD_MOSS = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.MOSS).noOcclusion().noCollission().randomTicks();
        public static final BlockBehaviour.Properties DOUBLE_PLANT = BlockBehaviour.Properties.copy(Blocks.TALL_GRASS);
    }
}
