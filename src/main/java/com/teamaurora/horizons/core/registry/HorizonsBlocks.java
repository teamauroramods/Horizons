package com.teamaurora.horizons.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.BlueprintBeehiveBlock;
import com.teamabnormals.blueprint.common.block.BlueprintDirectionalBlock;
import com.teamabnormals.blueprint.common.block.LeafPileBlock;
import com.teamabnormals.blueprint.common.block.LogBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintCeilingHangingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallHangingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchSlabBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchStairBlock;
import com.teamabnormals.blueprint.core.api.BlockSetTypeRegistryHelper;
import com.teamabnormals.blueprint.core.api.WoodTypeRegistryHelper;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamaurora.horizons.common.block.*;
import com.teamaurora.horizons.common.block.grower.CypressTreeGrower;
import com.teamaurora.horizons.common.block.grower.FloweringJungleTreeGrower;
import com.teamaurora.horizons.common.block.grower.FloweringOakTreeGrower;
import com.teamaurora.horizons.common.block.grower.JacarandaTreeGrower;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.HorizonsConfig;
import com.teamaurora.horizons.core.other.HorizonsConstants;
import com.teamaurora.horizons.integration.farmers_delight.HorizonsFDCompat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Predicate;

import static net.minecraft.world.item.CreativeModeTabs.*;
import static net.minecraft.world.item.crafting.Ingredient.of;

@Mod.EventBusSubscriber(modid = Horizons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorizonsBlocks {
    public static final BlockSubRegistryHelper HELPER = Horizons.REGISTRY_HELPER.getBlockSubHelper();

    //
    // MISC
    //

    // Flowering Trees //
    public static final RegistryObject<Block> FLOWERING_OAK_LEAVES = HELPER.createBlock("flowering_oak_leaves", ()->new LeavesBlock(HorizonsProperties.VANILLA_LEAVES.leaves()));
    public static final RegistryObject<Block> FLOWERING_OAK_SAPLING = HELPER.createBlock("flowering_oak_sapling", ()->new SaplingBlock(new FloweringOakTreeGrower(), HorizonsProperties.VANILLA_LEAVES.sapling()));
    public static final RegistryObject<Block> POTTED_FLOWERING_OAK_SAPLING = HELPER.createBlockNoItem("potted_flowering_oak_sapling", ()->new FlowerPotBlock(FLOWERING_OAK_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> FLOWERING_OAK_LEAF_PILE = HELPER.createBlock("flowering_oak_leaf_pile", ()->new LeafPileBlock(HorizonsProperties.VANILLA_LEAVES.leafPile()));

    public static final RegistryObject<Block> FLOWERING_JUNGLE_LEAVES = HELPER.createBlock("flowering_jungle_leaves", ()->new LeavesBlock(HorizonsProperties.VANILLA_LEAVES.leaves()));
    public static final RegistryObject<Block> FLOWERING_JUNGLE_SAPLING = HELPER.createBlock("flowering_jungle_sapling", ()->new SaplingBlock(new FloweringJungleTreeGrower(), HorizonsProperties.VANILLA_LEAVES.sapling()));
    public static final RegistryObject<Block> POTTED_FLOWERING_JUNGLE_SAPLING = HELPER.createBlockNoItem("potted_flowering_jungle_sapling", ()->new FlowerPotBlock(FLOWERING_JUNGLE_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> FLOWERING_JUNGLE_LEAF_PILE = HELPER.createBlock("flowering_jungle_leaf_pile", ()->new LeafPileBlock(HorizonsProperties.VANILLA_LEAVES.leafPile()));

    // Lots of flowers
    public static final RegistryObject<Block> RED_MALLOW = HELPER.createBlock("red_mallow", ()->new FlowerBlock(MobEffects.MOVEMENT_SPEED, 16, PropertyUtil.flower()));
    public static final RegistryObject<Block> WHITE_MALLOW = HELPER.createBlock("white_mallow", ()->new FlowerBlock(MobEffects.MOVEMENT_SPEED, 16, PropertyUtil.flower()));
    public static final RegistryObject<Block> MALLOW_BUSH = HELPER.createBlock("mallow_bush", ()->new FlowerBlock(MobEffects.MOVEMENT_SPEED, 16, PropertyUtil.flower()));
    public static final RegistryObject<Block> SUNNY_MARIGOLD = HELPER.createBlock("sunny_marigold", ()->new FlowerBlock(MobEffects.MOVEMENT_SPEED, 16, PropertyUtil.flower()));
    public static final RegistryObject<Block> SHADY_MARIGOLD = HELPER.createBlock("shady_marigold", ()->new FlowerBlock(MobEffects.MOVEMENT_SPEED, 16, PropertyUtil.flower()));
    public static final RegistryObject<Block> MARIGOLD_BUSH = HELPER.createBlock("marigold_bush", ()->new TallFlowerBlock(PropertyUtil.flower()));
    public static final RegistryObject<Block> AMARANTH = HELPER.createBlock("amaranth", ()->new FlowerBlock(MobEffects.MOVEMENT_SPEED, 16, PropertyUtil.flower()));
    public static final RegistryObject<Block> FIDDLENECK = HELPER.createBlock("fiddleneck", ()->new FlowerBlock(MobEffects.MOVEMENT_SPEED, 16, PropertyUtil.flower()));
    public static final RegistryObject<Block> HELICONIA = HELPER.createBlock("heliconia", ()->new TallFlowerBlock(PropertyUtil.flower()));
    public static final RegistryObject<Block> FORGET_ME_NOT = HELPER.createBlock("forget_me_not", ()->new FlowerBlock(MobEffects.MOVEMENT_SPEED, 16, PropertyUtil.flower()));

    public static final RegistryObject<Block> POTTED_RED_MALLOW = HELPER.createBlockNoItem("potted_red_mallow", ()->new FlowerPotBlock(RED_MALLOW.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_WHITE_MALLOW = HELPER.createBlockNoItem("potted_white_mallow", ()->new FlowerPotBlock(WHITE_MALLOW.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_MALLOW_BUSH = HELPER.createBlockNoItem("potted_mallow_bush", ()->new FlowerPotBlock(MALLOW_BUSH.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_SUNNY_MARIGOLD = HELPER.createBlockNoItem("potted_sunny_marigold", ()->new FlowerPotBlock(SUNNY_MARIGOLD.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_SHADY_MARIGOLD = HELPER.createBlockNoItem("potted_shady_marigold", ()->new FlowerPotBlock(SHADY_MARIGOLD.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_MARIGOLD_BUSH = HELPER.createBlockNoItem("potted_marigold_bush", ()->new FlowerPotBlock(MARIGOLD_BUSH.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_AMARANTH = HELPER.createBlockNoItem("potted_amaranth", ()->new FlowerPotBlock(AMARANTH.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_FIDDLENECK = HELPER.createBlockNoItem("potted_fiddleneck", ()->new FlowerPotBlock(FIDDLENECK.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_HELICONIA = HELPER.createBlockNoItem("potted_heliconia", ()->new FlowerPotBlock(HELICONIA.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_FORGET_ME_NOT = HELPER.createBlockNoItem("potted_forget_me_not", ()->new FlowerPotBlock(FORGET_ME_NOT.get(), PropertyUtil.flowerPot()));

    // HI IM DAISY
    public static final RegistryObject<Block> BLUE_DAISY = HELPER.createBlock("blue_daisy", ()->new FlowerBlock(MobEffects.REGENERATION, 8, PropertyUtil.flower()));
    public static final RegistryObject<Block> ORANGE_DAISY = HELPER.createBlock("orange_daisy", ()->new FlowerBlock(MobEffects.REGENERATION, 8, PropertyUtil.flower()));
    public static final RegistryObject<Block> PINK_DAISY = HELPER.createBlock("pink_daisy", ()->new FlowerBlock(MobEffects.REGENERATION, 8, PropertyUtil.flower()));
    public static final RegistryObject<Block> PURPLE_DAISY = HELPER.createBlock("purple_daisy", ()->new FlowerBlock(MobEffects.REGENERATION, 8, PropertyUtil.flower()));
    public static final RegistryObject<Block> YELLOW_DAISY = HELPER.createBlock("yellow_daisy", ()->new FlowerBlock(MobEffects.REGENERATION, 8, PropertyUtil.flower()));

    public static final RegistryObject<Block> POTTED_BLUE_DAISY = HELPER.createBlockNoItem("potted_blue_daisy", ()->new FlowerPotBlock(BLUE_DAISY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_ORANGE_DAISY = HELPER.createBlockNoItem("potted_orange_daisy", ()->new FlowerPotBlock(ORANGE_DAISY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_PINK_DAISY = HELPER.createBlockNoItem("potted_pink_daisy", ()->new FlowerPotBlock(PINK_DAISY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_PURPLE_DAISY = HELPER.createBlockNoItem("potted_purple_daisy", ()->new FlowerPotBlock(PURPLE_DAISY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_YELLOW_DAISY = HELPER.createBlockNoItem("potted_yellow_daisy", ()->new FlowerPotBlock(YELLOW_DAISY.get(), PropertyUtil.flowerPot()));

    // Grass
    public static final RegistryObject<Block> SHORT_TROPICAL_GRASS = HELPER.createBlock("short_tropical_grass", ()->new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));
    public static final RegistryObject<Block> TALL_TROPICAL_GRASS = HELPER.createBlock("tall_tropical_grass", ()->new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));
    public static final RegistryObject<Block> SHORT_SWAMP_GRASS = HELPER.createBlock("short_swamp_grass", ()->new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));
    public static final RegistryObject<Block> TALL_SWAMP_GRASS = HELPER.createBlock("tall_swamp_grass", ()->new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));

    //=============================================================//
    //                            BAYOU                            //
    //=============================================================//

    // Cypress //
    public static final RegistryObject<Block> STRIPPED_CYPRESS_LOG = HELPER.createBlock("stripped_cypress_log", ()->new RotatedPillarBlock(HorizonsProperties.CYPRESS.log()));
    public static final RegistryObject<Block> STRIPPED_CYPRESS_WOOD = HELPER.createBlock("stripped_cypress_wood", ()->new RotatedPillarBlock(HorizonsProperties.CYPRESS.log()));
    public static final RegistryObject<Block> CYPRESS_LOG = HELPER.createBlock("cypress_log", ()->new LogBlock(STRIPPED_CYPRESS_LOG, HorizonsProperties.CYPRESS.log()));
    public static final RegistryObject<Block> CYPRESS_WOOD = HELPER.createBlock("cypress_wood", ()->new LogBlock(STRIPPED_CYPRESS_WOOD, HorizonsProperties.CYPRESS.log()));
    public static final RegistryObject<Block> CYPRESS_PLANKS = HELPER.createBlock("cypress_planks", ()->new Block(HorizonsProperties.CYPRESS.planks()));
    public static final RegistryObject<Block> CYPRESS_STAIRS = HELPER.createBlock("cypress_stairs", ()->new StairBlock(()->CYPRESS_PLANKS.get().defaultBlockState(), HorizonsProperties.CYPRESS.planks()));
    public static final RegistryObject<Block> CYPRESS_SLAB = HELPER.createBlock("cypress_slab", ()->new SlabBlock(HorizonsProperties.CYPRESS.planks()));
    public static final RegistryObject<Block> CYPRESS_PRESSURE_PLATE = HELPER.createBlock("cypress_pressure_plate", ()->new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HorizonsProperties.CYPRESS.pressurePlate(), HorizonsProperties.CYPRESS_BLOCK_SET));
    public static final RegistryObject<Block> CYPRESS_BUTTON = HELPER.createBlock("cypress_button", ()->new ButtonBlock(HorizonsProperties.CYPRESS.button(), HorizonsProperties.CYPRESS_BLOCK_SET, 30, true));
    public static final RegistryObject<Block> CYPRESS_FENCE = HELPER.createFuelBlock("cypress_fence", ()->new FenceBlock(HorizonsProperties.CYPRESS.planks()), 300);
    public static final RegistryObject<Block> CYPRESS_FENCE_GATE = HELPER.createFuelBlock("cypress_fence_gate", ()->new FenceGateBlock(HorizonsProperties.CYPRESS.planks(), HorizonsProperties.CYPRESS_WOOD_TYPE), 300);
    public static final RegistryObject<Block> CYPRESS_DOOR = HELPER.createBlock("cypress_door", ()->new DoorBlock(HorizonsProperties.CYPRESS.door(), HorizonsProperties.CYPRESS_BLOCK_SET));
    public static final RegistryObject<Block> CYPRESS_TRAPDOOR = HELPER.createBlock("cypress_trapdoor", ()->new TrapDoorBlock(HorizonsProperties.CYPRESS.trapdoor(), HorizonsProperties.CYPRESS_BLOCK_SET));
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> CYPRESS_SIGNS = HELPER.createSignBlock("cypress", HorizonsProperties.CYPRESS_WOOD_TYPE, HorizonsProperties.CYPRESS.sign());
    public static final Pair<RegistryObject<BlueprintCeilingHangingSignBlock>, RegistryObject<BlueprintWallHangingSignBlock>> CYPRESS_HANGING_SIGNS = HELPER.createHangingSignBlock("cypress", HorizonsProperties.CYPRESS_WOOD_TYPE, HorizonsProperties.CYPRESS.hangingSign());

    public static final RegistryObject<Block> CYPRESS_BOARDS = HELPER.createFuelBlock("cypress_boards", ()->new RotatedPillarBlock(HorizonsProperties.CYPRESS.planks()), 300);
    public static final RegistryObject<Block> CYPRESS_BOOKSHELF = HELPER.createFuelBlock("cypress_bookshelf", ()->new Block(HorizonsProperties.CYPRESS.bookshelf()), 300);
    public static final RegistryObject<Block> CHISELED_CYPRESS_BOOKSHELF = HELPER.createFuelBlock("chiseled_cypress_bookshelf", ()->new ChiseledBookShelfBlock(HorizonsProperties.CYPRESS.chiseledBookshelf()), 300);
    public static final RegistryObject<Block> CYPRESS_LADDER = HELPER.createFuelBlock("cypress_ladder", ()->new LadderBlock(HorizonsProperties.CYPRESS.ladder()), 300);
    public static final RegistryObject<Block> CYPRESS_BEEHIVE = HELPER.createBlock("cypress_beehive", ()->new BlueprintBeehiveBlock(HorizonsProperties.CYPRESS.beehive()));
    public static final RegistryObject<BlueprintChestBlock> CYPRESS_CHEST = HELPER.createChestBlock("cypress", HorizonsProperties.CYPRESS.chest());
    public static final RegistryObject<BlueprintTrappedChestBlock> TRAPPED_CYPRESS_CHEST = HELPER.createTrappedChestBlock("cypress", HorizonsProperties.CYPRESS.chest());
    public static final RegistryObject<Block> CYPRESS_CABINET = HELPER.createFuelBlock("cypress_cabinet", ItemSubRegistryHelper.areModsLoaded("farmersdelight") ? HorizonsFDCompat.CABINET_SUPPLIER : () -> new Block(BlockBehaviour.Properties.copy(Blocks.BARREL)), 300);

    public static final RegistryObject<Block> CYPRESS_LEAVES = HELPER.createBlock("cypress_leaves", ()->new LeavesBlock(HorizonsProperties.CYPRESS.leaves()));
    public static final RegistryObject<Block> CYPRESS_SAPLING = HELPER.createBlock("cypress_sapling", ()->new SaplingBlock(new CypressTreeGrower(), HorizonsProperties.CYPRESS.sapling()));
    public static final RegistryObject<Block> POTTED_CYPRESS_SAPLING = HELPER.createBlockNoItem("potted_cypress_sapling", ()->new FlowerPotBlock(CYPRESS_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> CYPRESS_LEAF_PILE = HELPER.createBlock("cypress_leaf_pile", ()->new LeafPileBlock(HorizonsProperties.CYPRESS.leafPile()));
    public static final RegistryObject<Block> HANGING_CYPRESS_LEAVES = HELPER.createBlock("hanging_cypress_leaves", ()->new HangingLeavesBlock(HorizonsProperties.CYPRESS.leaves().noCollission()));

    // Gooseberries //
    public static final RegistryObject<Block> CYPRESS_BRANCH = HELPER.createBlock("cypress_branch", ()->new CypressBranchBlock(HorizonsProperties.CYPRESS_BRANCH));
    public static final RegistryObject<Block> GOOSEBERRY_BASKET = HELPER.createBlock("gooseberry_basket", ()->new BlueprintDirectionalBlock(HorizonsProperties.GOOSEBERRY_BASKET));

    // Beard Moss //
    public static final RegistryObject<Block> BEARD_MOSS = HELPER.createBlock("beard_moss", ()->new BeardMossBlock(HorizonsProperties.BEARD_MOSS));

    // Algae //
    public static final RegistryObject<Block> ALGAE = HELPER.createBlockNoItem("algae", ()->new AlgaeBlock(HorizonsProperties.ALGAE));
    public static final RegistryObject<Block> ALGAE_THATCH = HELPER.createBlock("algae_thatch", ()->new ThatchBlock(HorizonsProperties.ALGAE_THATCH));
    public static final RegistryObject<Block> ALGAE_THATCH_SLAB = HELPER.createBlock("algae_thatch_slab", ()->new ThatchSlabBlock(HorizonsProperties.ALGAE_THATCH));
    public static final RegistryObject<Block> ALGAE_THATCH_STAIRS = HELPER.createBlock("algae_thatch_stairs", ()->new ThatchStairBlock(ALGAE_THATCH.get().defaultBlockState(), HorizonsProperties.ALGAE_THATCH));

    // Lily Flowers //
    public static final RegistryObject<Block> BLUE_WATER_LILY = HELPER.createBlockNoItem("blue_water_lily", ()->new WaterLilyBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> CYAN_WATER_LILY = HELPER.createBlockNoItem("cyan_water_lily", ()->new WaterLilyBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> PINK_WATER_LILY = HELPER.createBlockNoItem("pink_water_lily", ()->new WaterLilyBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> PURPLE_WATER_LILY = HELPER.createBlockNoItem("purple_water_lily", ()->new WaterLilyBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> WHITE_WATER_LILY = HELPER.createBlockNoItem("white_water_lily", ()->new WaterLilyBlock(HorizonsProperties.LILY));

    public static final RegistryObject<Block> POTTED_BLUE_WATER_LILY = HELPER.createBlockNoItem("potted_blue_water_lily", ()->new FlowerPotBlock(BLUE_WATER_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_CYAN_WATER_LILY = HELPER.createBlockNoItem("potted_cyan_water_lily", ()->new FlowerPotBlock(CYAN_WATER_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_PINK_WATER_LILY = HELPER.createBlockNoItem("potted_pink_water_lily", ()->new FlowerPotBlock(PINK_WATER_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_PURPLE_WATER_LILY = HELPER.createBlockNoItem("potted_purple_water_lily", ()->new FlowerPotBlock(PURPLE_WATER_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_WHITE_WATER_LILY = HELPER.createBlockNoItem("potted_white_water_lily", ()->new FlowerPotBlock(WHITE_WATER_LILY.get(), PropertyUtil.flowerPot()));

    //=============================================================//
    //                      JACARANDA FOREST                       //
    //=============================================================//
    public static final RegistryObject<Block> STRIPPED_JACARANDA_LOG = HELPER.createBlock("stripped_jacaranda_log", ()->new RotatedPillarBlock(HorizonsProperties.JACARANDA.log()));
    public static final RegistryObject<Block> STRIPPED_JACARANDA_WOOD = HELPER.createBlock("stripped_jacaranda_wood", ()->new RotatedPillarBlock(HorizonsProperties.JACARANDA.log()));
    public static final RegistryObject<Block> JACARANDA_LOG = HELPER.createBlock("jacaranda_log", ()->new LogBlock(STRIPPED_JACARANDA_LOG, HorizonsProperties.JACARANDA.log()));
    public static final RegistryObject<Block> JACARANDA_WOOD = HELPER.createBlock("jacaranda_wood", ()->new LogBlock(STRIPPED_JACARANDA_WOOD, HorizonsProperties.JACARANDA.log()));
    public static final RegistryObject<Block> JACARANDA_PLANKS = HELPER.createBlock("jacaranda_planks", ()->new Block(HorizonsProperties.JACARANDA.planks()));
    public static final RegistryObject<Block> JACARANDA_STAIRS = HELPER.createBlock("jacaranda_stairs", ()->new StairBlock(()->JACARANDA_PLANKS.get().defaultBlockState(), HorizonsProperties.JACARANDA.planks()));
    public static final RegistryObject<Block> JACARANDA_SLAB = HELPER.createBlock("jacaranda_slab", ()->new SlabBlock(HorizonsProperties.JACARANDA.planks()));
    public static final RegistryObject<Block> JACARANDA_PRESSURE_PLATE = HELPER.createBlock("jacaranda_pressure_plate", ()->new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HorizonsProperties.JACARANDA.pressurePlate(), HorizonsProperties.JACARANDA_BLOCK_SET));
    public static final RegistryObject<Block> JACARANDA_BUTTON = HELPER.createBlock("jacaranda_button", ()->new ButtonBlock(HorizonsProperties.JACARANDA.button(), HorizonsProperties.JACARANDA_BLOCK_SET, 30, true));
    public static final RegistryObject<Block> JACARANDA_FENCE = HELPER.createFuelBlock("jacaranda_fence", ()->new FenceBlock(HorizonsProperties.JACARANDA.planks()), 300);
    public static final RegistryObject<Block> JACARANDA_FENCE_GATE = HELPER.createFuelBlock("jacaranda_fence_gate", ()->new FenceGateBlock(HorizonsProperties.JACARANDA.planks(), HorizonsProperties.JACARANDA_WOOD_TYPE), 300);
    public static final RegistryObject<Block> JACARANDA_DOOR = HELPER.createBlock("jacaranda_door", ()->new DoorBlock(HorizonsProperties.JACARANDA.door(), HorizonsProperties.JACARANDA_BLOCK_SET));
    public static final RegistryObject<Block> JACARANDA_TRAPDOOR = HELPER.createBlock("jacaranda_trapdoor", ()->new TrapDoorBlock(HorizonsProperties.JACARANDA.trapdoor(), HorizonsProperties.JACARANDA_BLOCK_SET));
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> JACARANDA_SIGNS = HELPER.createSignBlock("jacaranda", HorizonsProperties.JACARANDA_WOOD_TYPE, HorizonsProperties.JACARANDA.sign());
    public static final Pair<RegistryObject<BlueprintCeilingHangingSignBlock>, RegistryObject<BlueprintWallHangingSignBlock>> JACARANDA_HANGING_SIGNS = HELPER.createHangingSignBlock("jacaranda", HorizonsProperties.JACARANDA_WOOD_TYPE, HorizonsProperties.JACARANDA.hangingSign());

    public static final RegistryObject<Block> JACARANDA_BOARDS = HELPER.createFuelBlock("jacaranda_boards", ()->new RotatedPillarBlock(HorizonsProperties.JACARANDA.planks()), 300);
    public static final RegistryObject<Block> JACARANDA_BOOKSHELF = HELPER.createFuelBlock("jacaranda_bookshelf", ()->new Block(HorizonsProperties.JACARANDA.bookshelf()), 300);
    public static final RegistryObject<Block> CHISELED_JACARANDA_BOOKSHELF = HELPER.createFuelBlock("chiseled_jacaranda_bookshelf", ()->new ChiseledBookShelfBlock(HorizonsProperties.JACARANDA.chiseledBookshelf()), 300);
    public static final RegistryObject<Block> JACARANDA_LADDER = HELPER.createFuelBlock("jacaranda_ladder", ()->new LadderBlock(HorizonsProperties.JACARANDA.ladder()), 300);
    public static final RegistryObject<Block> JACARANDA_BEEHIVE = HELPER.createBlock("jacaranda_beehive", ()->new BlueprintBeehiveBlock(HorizonsProperties.JACARANDA.beehive()));
    public static final RegistryObject<BlueprintChestBlock> JACARANDA_CHEST = HELPER.createChestBlock("jacaranda", HorizonsProperties.JACARANDA.chest());
    public static final RegistryObject<BlueprintTrappedChestBlock> TRAPPED_JACARANDA_CHEST = HELPER.createTrappedChestBlock("jacaranda", HorizonsProperties.JACARANDA.chest());
    public static final RegistryObject<Block> JACARANDA_CABINET = HELPER.createFuelBlock("jacaranda_cabinet", ItemSubRegistryHelper.areModsLoaded("farmersdelight") ? HorizonsFDCompat.CABINET_SUPPLIER : () -> new Block(BlockBehaviour.Properties.copy(Blocks.BARREL)), 300);

    public static final RegistryObject<Block> JACARANDA_LEAVES = HELPER.createBlock("jacaranda_leaves", ()->new LeavesBlock(HorizonsProperties.JACARANDA.leaves()));
    public static final RegistryObject<Block> JACARANDA_SAPLING = HELPER.createBlock("jacaranda_sapling", ()->new SaplingBlock(new JacarandaTreeGrower(false), HorizonsProperties.JACARANDA.sapling()));
    public static final RegistryObject<Block> POTTED_JACARANDA_SAPLING = HELPER.createBlockNoItem("potted_jacaranda_sapling", ()->new FlowerPotBlock(JACARANDA_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> JACARANDA_LEAF_PILE = HELPER.createBlock("jacaranda_leaf_pile", ()->new LeafPileBlock(HorizonsProperties.JACARANDA.leafPile()));

    public static final RegistryObject<Block> FLOWERING_JACARANDA_LEAVES = HELPER.createBlock("flowering_jacaranda_leaves", ()->new LeavesBlock(HorizonsProperties.JACARANDA.leaves()));
    public static final RegistryObject<Block> FLOWERING_JACARANDA_SAPLING = HELPER.createBlock("flowering_jacaranda_sapling", ()->new SaplingBlock(new JacarandaTreeGrower(true), HorizonsProperties.JACARANDA.sapling()));
    public static final RegistryObject<Block> POTTED_FLOWERING_JACARANDA_SAPLING = HELPER.createBlockNoItem("potted_flowering_jacaranda_sapling", ()->new FlowerPotBlock(FLOWERING_JACARANDA_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> FLOWERING_JACARANDA_LEAF_PILE = HELPER.createBlock("flowering_jacaranda_leaf_pile", ()->new LeafPileBlock(HorizonsProperties.JACARANDA.leafPile()));


    //=============================================================//
    //                       REDWOOD FOREST                        //
    //=============================================================//
    public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = HELPER.createBlock("stripped_redwood_log", ()->new RotatedPillarBlock(HorizonsProperties.REDWOOD.log()));
    public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = HELPER.createBlock("stripped_redwood_wood", ()->new RotatedPillarBlock(HorizonsProperties.REDWOOD.log()));
    public static final RegistryObject<Block> REDWOOD_LOG = HELPER.createBlock("redwood_log", ()->new LogBlock(STRIPPED_REDWOOD_LOG, HorizonsProperties.REDWOOD.log()));
    public static final RegistryObject<Block> REDWOOD_WOOD = HELPER.createBlock("redwood_wood", ()->new LogBlock(STRIPPED_REDWOOD_WOOD, HorizonsProperties.REDWOOD.log()));
    public static final RegistryObject<Block> REDWOOD_PLANKS = HELPER.createBlock("redwood_planks", ()->new Block(HorizonsProperties.REDWOOD.planks()));
    public static final RegistryObject<Block> REDWOOD_STAIRS = HELPER.createBlock("redwood_stairs", ()->new StairBlock(()->REDWOOD_PLANKS.get().defaultBlockState(), HorizonsProperties.REDWOOD.planks()));
    public static final RegistryObject<Block> REDWOOD_SLAB = HELPER.createBlock("redwood_slab", ()->new SlabBlock(HorizonsProperties.REDWOOD.planks()));
    public static final RegistryObject<Block> REDWOOD_PRESSURE_PLATE = HELPER.createBlock("redwood_pressure_plate", ()->new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HorizonsProperties.REDWOOD.pressurePlate(), HorizonsProperties.REDWOOD_BLOCK_SET));
    public static final RegistryObject<Block> REDWOOD_BUTTON = HELPER.createBlock("redwood_button", ()->new ButtonBlock(HorizonsProperties.REDWOOD.button(), HorizonsProperties.REDWOOD_BLOCK_SET, 30, true));
    public static final RegistryObject<Block> REDWOOD_FENCE = HELPER.createFuelBlock("redwood_fence", ()->new FenceBlock(HorizonsProperties.REDWOOD.planks()), 300);
    public static final RegistryObject<Block> REDWOOD_FENCE_GATE = HELPER.createFuelBlock("redwood_fence_gate", ()->new FenceGateBlock(HorizonsProperties.REDWOOD.planks(), HorizonsProperties.REDWOOD_WOOD_TYPE), 300);
    public static final RegistryObject<Block> REDWOOD_DOOR = HELPER.createBlock("redwood_door", ()->new DoorBlock(HorizonsProperties.REDWOOD.door(), HorizonsProperties.REDWOOD_BLOCK_SET));
    public static final RegistryObject<Block> REDWOOD_TRAPDOOR = HELPER.createBlock("redwood_trapdoor", ()->new TrapDoorBlock(HorizonsProperties.REDWOOD.trapdoor(), HorizonsProperties.REDWOOD_BLOCK_SET));
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> REDWOOD_SIGNS = HELPER.createSignBlock("redwood", HorizonsProperties.REDWOOD_WOOD_TYPE, HorizonsProperties.REDWOOD.sign());
    public static final Pair<RegistryObject<BlueprintCeilingHangingSignBlock>, RegistryObject<BlueprintWallHangingSignBlock>> REDWOOD_HANGING_SIGNS = HELPER.createHangingSignBlock("redwood", HorizonsProperties.REDWOOD_WOOD_TYPE, HorizonsProperties.REDWOOD.hangingSign());

    public static final RegistryObject<Block> REDWOOD_BOARDS = HELPER.createFuelBlock("redwood_boards", ()->new RotatedPillarBlock(HorizonsProperties.REDWOOD.planks()), 300);
    public static final RegistryObject<Block> REDWOOD_BOOKSHELF = HELPER.createFuelBlock("redwood_bookshelf", ()->new Block(HorizonsProperties.REDWOOD.bookshelf()), 300);
    public static final RegistryObject<Block> CHISELED_REDWOOD_BOOKSHELF = HELPER.createFuelBlock("chiseled_redwood_bookshelf", ()->new ChiseledBookShelfBlock(HorizonsProperties.REDWOOD.chiseledBookshelf()), 300);
    public static final RegistryObject<Block> REDWOOD_LADDER = HELPER.createFuelBlock("redwood_ladder", ()->new LadderBlock(HorizonsProperties.REDWOOD.ladder()), 300);
    public static final RegistryObject<Block> REDWOOD_BEEHIVE = HELPER.createBlock("redwood_beehive", ()->new BlueprintBeehiveBlock(HorizonsProperties.REDWOOD.beehive()));
    public static final RegistryObject<BlueprintChestBlock> REDWOOD_CHEST = HELPER.createChestBlock("redwood", HorizonsProperties.REDWOOD.chest());
    public static final RegistryObject<BlueprintTrappedChestBlock> TRAPPED_REDWOOD_CHEST = HELPER.createTrappedChestBlock("redwood", HorizonsProperties.REDWOOD.chest());
    public static final RegistryObject<Block> REDWOOD_CABINET = HELPER.createFuelBlock("redwood_cabinet", ItemSubRegistryHelper.areModsLoaded("farmersdelight") ? HorizonsFDCompat.CABINET_SUPPLIER : () -> new Block(BlockBehaviour.Properties.copy(Blocks.BARREL)), 300);

    public static final RegistryObject<Block> REDWOOD_LEAVES = HELPER.createBlock("redwood_leaves", ()->new LeavesBlock(HorizonsProperties.REDWOOD.leaves()));
    public static final RegistryObject<Block> REDWOOD_SAPLING = HELPER.createBlock("redwood_sapling", ()->new SaplingBlock(new OakTreeGrower(), HorizonsProperties.REDWOOD.sapling()));
    public static final RegistryObject<Block> POTTED_REDWOOD_SAPLING = HELPER.createBlockNoItem("potted_redwood_sapling", ()->new FlowerPotBlock(REDWOOD_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> REDWOOD_LEAF_PILE = HELPER.createBlock("redwood_leaf_pile", ()->new LeafPileBlock(HorizonsProperties.REDWOOD.leafPile()));



    public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(Horizons.MOD_ID)
                .tab(BUILDING_BLOCKS)
                .addItemsBefore(of(Blocks.BAMBOO_BLOCK), CYPRESS_LOG, CYPRESS_WOOD, STRIPPED_CYPRESS_LOG, STRIPPED_CYPRESS_WOOD, CYPRESS_PLANKS)
                .addItemsBefore(modLoaded(Blocks.BAMBOO_BLOCK, "woodworks"), CYPRESS_BOARDS)
                .addItemsBefore(of(Blocks.BAMBOO_BLOCK), CYPRESS_STAIRS, CYPRESS_SLAB, CYPRESS_FENCE, CYPRESS_FENCE_GATE, CYPRESS_DOOR, CYPRESS_TRAPDOOR, CYPRESS_PRESSURE_PLATE, CYPRESS_BUTTON)
                .addItemsBefore(of(Blocks.BAMBOO_BLOCK), JACARANDA_LOG, JACARANDA_WOOD, STRIPPED_JACARANDA_LOG, STRIPPED_JACARANDA_WOOD, JACARANDA_PLANKS)
                .addItemsBefore(modLoaded(Blocks.BAMBOO_BLOCK, "woodworks"), JACARANDA_BOARDS)
                .addItemsBefore(of(Blocks.BAMBOO_BLOCK), JACARANDA_STAIRS, JACARANDA_SLAB, JACARANDA_FENCE, JACARANDA_FENCE_GATE, JACARANDA_DOOR, JACARANDA_TRAPDOOR, JACARANDA_PRESSURE_PLATE, JACARANDA_BUTTON)
                .addItemsBefore(of(Blocks.BAMBOO_BLOCK), REDWOOD_LOG, REDWOOD_WOOD, STRIPPED_REDWOOD_LOG, STRIPPED_REDWOOD_WOOD, REDWOOD_PLANKS)
                .addItemsBefore(modLoaded(Blocks.BAMBOO_BLOCK, "woodworks"), REDWOOD_BOARDS)
                .addItemsBefore(of(Blocks.BAMBOO_BLOCK), REDWOOD_STAIRS, REDWOOD_SLAB, REDWOOD_FENCE, REDWOOD_FENCE_GATE, REDWOOD_DOOR, REDWOOD_TRAPDOOR, REDWOOD_PRESSURE_PLATE, REDWOOD_BUTTON)
                .addItemsBefore(of(Blocks.SANDSTONE), ALGAE_THATCH, ALGAE_THATCH_STAIRS, ALGAE_THATCH_SLAB)

                .tab(NATURAL_BLOCKS)
                .addItemsBefore(of(Blocks.MUSHROOM_STEM), CYPRESS_LOG, JACARANDA_LOG, REDWOOD_LOG)
                .addItemsBefore(of(Blocks.AZALEA_LEAVES), CYPRESS_LEAVES)
                .addItemsBefore(modLoaded(Blocks.AZALEA_LEAVES, "woodworks"), CYPRESS_LEAF_PILE)
                .addItemsBefore(of(Blocks.AZALEA_LEAVES), HANGING_CYPRESS_LEAVES)
                .addItemsBefore(of(Blocks.AZALEA_LEAVES), JACARANDA_LEAVES)
                .addItemsBefore(modLoaded(Blocks.AZALEA_LEAVES, "woodworks"), JACARANDA_LEAF_PILE)
                .addItemsBefore(of(Blocks.AZALEA_LEAVES), FLOWERING_JACARANDA_LEAVES)
                .addItemsBefore(modLoaded(Blocks.AZALEA_LEAVES, "woodworks"), FLOWERING_JACARANDA_LEAF_PILE)
                .addItemsBefore(of(Blocks.AZALEA_LEAVES), REDWOOD_LEAVES)
                .addItemsBefore(modLoaded(Blocks.AZALEA_LEAVES, "woodworks"), REDWOOD_LEAF_PILE)
                .addItemsBefore(of(Blocks.AZALEA), CYPRESS_SAPLING, JACARANDA_SAPLING, FLOWERING_JACARANDA_SAPLING, REDWOOD_SAPLING)
                .addItemsAfter(modLoadedWithConfig(Blocks.OAK_LEAVES, HorizonsConfig.COMMON.enableFloweringOak, "woodworks"), FLOWERING_OAK_LEAF_PILE)
                .addItemsAfter(withConfig(Blocks.OAK_LEAVES, HorizonsConfig.COMMON.enableFloweringOak), FLOWERING_OAK_LEAVES)
                .addItemsAfter(modLoadedWithConfig(Blocks.JUNGLE_LEAVES, HorizonsConfig.COMMON.enableFloweringJungle, "woodworks"), FLOWERING_JUNGLE_LEAF_PILE)
                .addItemsAfter(withConfig(Blocks.JUNGLE_LEAVES, HorizonsConfig.COMMON.enableFloweringJungle), FLOWERING_JUNGLE_LEAVES)
                .addItemsAfter(withConfig(Blocks.OAK_SAPLING, HorizonsConfig.COMMON.enableFloweringOak), FLOWERING_OAK_SAPLING)
                .addItemsAfter(withConfig(Blocks.JUNGLE_SAPLING, HorizonsConfig.COMMON.enableFloweringJungle), FLOWERING_JUNGLE_SAPLING)
                .addItemsBefore(of(Items.GLOW_BERRIES), CYPRESS_BRANCH)
                .addItemsAfter(modLoaded(Blocks.HAY_BLOCK, "berry_good"), GOOSEBERRY_BASKET)
                .addItemsAfter(of(Items.VINE), BEARD_MOSS)
                .addItemsAfter(withConfig(Items.LILY_PAD, HorizonsConfig.COMMON.enableWaterlilies), BLUE_WATER_LILY, CYAN_WATER_LILY, PINK_WATER_LILY, PURPLE_WATER_LILY, WHITE_WATER_LILY)
                .addItemsAfter(withConfig(Items.OXEYE_DAISY, HorizonsConfig.COMMON.enableDaisies), BLUE_DAISY, ORANGE_DAISY, PINK_DAISY, PURPLE_DAISY, YELLOW_DAISY)
                .addItemsAfter(withConfig(Items.LILY_OF_THE_VALLEY, HorizonsConfig.COMMON.enableForgetMeNots), FORGET_ME_NOT)
                .addItemsAfter(withConfig(Items.LILY_OF_THE_VALLEY, HorizonsConfig.COMMON.enableFiddlenecks), FIDDLENECK)
                .addItemsAfter(withConfig(Items.LILY_OF_THE_VALLEY, HorizonsConfig.COMMON.enableAmaranths), AMARANTH)
                .addItemsAfter(withConfig(Items.LILY_OF_THE_VALLEY, HorizonsConfig.COMMON.enableMarigolds), SUNNY_MARIGOLD, SHADY_MARIGOLD, MARIGOLD_BUSH)
                .addItemsAfter(withConfig(Items.LILY_OF_THE_VALLEY, HorizonsConfig.COMMON.enableMallows), RED_MALLOW, WHITE_MALLOW, MALLOW_BUSH)
                .addItemsAfter(withConfig(Items.PEONY, HorizonsConfig.COMMON.enableHeliconias), HELICONIA)
                .addItemsAfter(withConfig(Items.GRASS, HorizonsConfig.COMMON.enableAlternateGrasses), SHORT_SWAMP_GRASS, SHORT_TROPICAL_GRASS)
                .addItemsAfter(withConfig(Items.TALL_GRASS, HorizonsConfig.COMMON.enableAlternateGrasses), TALL_SWAMP_GRASS, TALL_TROPICAL_GRASS)

                .tab(FUNCTIONAL_BLOCKS)
                .addItemsBefore(of(Blocks.BAMBOO_SIGN), CYPRESS_SIGNS.getFirst(), CYPRESS_HANGING_SIGNS.getFirst(), JACARANDA_SIGNS.getFirst(), JACARANDA_HANGING_SIGNS.getFirst(), REDWOOD_SIGNS.getFirst(), REDWOOD_HANGING_SIGNS.getFirst());

        if (ItemSubRegistryHelper.areModsLoaded("farmersdelight")) {
            CreativeModeTabContentsPopulator.mod(Horizons.MOD_ID)
                    .predicate(HorizonsFDCompat::fdGroupPredicate)
                    .addItemsBefore(ofID(HorizonsConstants.BAMBOO_CABINET), CYPRESS_CABINET, JACARANDA_CABINET, REDWOOD_CABINET);
        }

        CreativeModeTabContentsPopulator.mod("woodworks_1")
                .tab(FUNCTIONAL_BLOCKS)
                .addItemsBefore(ofID(HorizonsConstants.BAMBOO_LADDER), CYPRESS_LADDER, JACARANDA_LADDER, REDWOOD_LADDER)
                .addItemsBefore(ofID(HorizonsConstants.BAMBOO_BEEHIVE), CYPRESS_BEEHIVE, JACARANDA_BEEHIVE, REDWOOD_BEEHIVE)
                .addItemsBefore(ofID(HorizonsConstants.BAMBOO_BOOKSHELF), CYPRESS_BOOKSHELF, CHISELED_CYPRESS_BOOKSHELF, JACARANDA_BOOKSHELF, CHISELED_JACARANDA_BOOKSHELF, REDWOOD_BOOKSHELF, CHISELED_REDWOOD_BOOKSHELF)
                .addItemsBefore(ofID(HorizonsConstants.BAMBOO_CLOSET), CYPRESS_CHEST, JACARANDA_CHEST, REDWOOD_CHEST)
                .tab(REDSTONE_BLOCKS)
                .addItemsBefore(ofID(HorizonsConstants.TRAPPED_BAMBOO_CLOSET), TRAPPED_CYPRESS_CHEST, TRAPPED_JACARANDA_CHEST, TRAPPED_REDWOOD_CHEST);
    }

    public static Predicate<ItemStack> withConfig(ItemLike item, ForgeConfigSpec.BooleanValue bool) {
        return stack -> of(item).test(stack) && bool.get();
    }

    public static Predicate<ItemStack> modLoaded(ItemLike item, String... modids) {
        return stack -> of(item).test(stack) && BlockSubRegistryHelper.areModsLoaded(modids);
    }

    public static Predicate<ItemStack> modLoadedWithConfig(ItemLike item, ForgeConfigSpec.BooleanValue bool, String... modids) {
        return stack -> of(item).test(stack) && bool.get() && BlockSubRegistryHelper.areModsLoaded(modids);
    }

    public static Predicate<ItemStack> ofID(ResourceLocation location, ItemLike fallback, String... modids) {
        return stack -> (BlockSubRegistryHelper.areModsLoaded(modids) ? of(ForgeRegistries.ITEMS.getValue(location)) : of(fallback)).test(stack);
    }

    public static Predicate<ItemStack> ofID(ResourceLocation location, String... modids) {
        return stack -> (BlockSubRegistryHelper.areModsLoaded(modids) && of(ForgeRegistries.ITEMS.getValue(location)).test(stack));
    }


    public static class HorizonsProperties {
        public static final PropertyUtil.WoodSetProperties VANILLA_LEAVES = PropertyUtil.WoodSetProperties.builder(MapColor.PLANT).build();

        public static final BlockSetType CYPRESS_BLOCK_SET = BlockSetTypeRegistryHelper.register(new BlockSetType(Horizons.MOD_ID + ":cypress"));
        public static final WoodType CYPRESS_WOOD_TYPE = WoodTypeRegistryHelper.registerWoodType(new WoodType(Horizons.MOD_ID + ":cypress", CYPRESS_BLOCK_SET));
        public static final PropertyUtil.WoodSetProperties CYPRESS = PropertyUtil.WoodSetProperties.builder(MapColor.COLOR_LIGHT_GREEN).build();

        public static final BlockSetType JACARANDA_BLOCK_SET = BlockSetTypeRegistryHelper.register(new BlockSetType(Horizons.MOD_ID + ":jacaranda"));
        public static final WoodType JACARANDA_WOOD_TYPE = WoodTypeRegistryHelper.registerWoodType(new WoodType(Horizons.MOD_ID + ":jacaranda", JACARANDA_BLOCK_SET));
        public static final PropertyUtil.WoodSetProperties JACARANDA = PropertyUtil.WoodSetProperties.builder(MapColor.COLOR_PURPLE).build();

        public static final BlockSetType REDWOOD_BLOCK_SET = BlockSetTypeRegistryHelper.register(new BlockSetType(Horizons.MOD_ID + ":redwood"));
        public static final WoodType REDWOOD_WOOD_TYPE = WoodTypeRegistryHelper.registerWoodType(new WoodType(Horizons.MOD_ID + ":redwood", REDWOOD_BLOCK_SET));
        public static final PropertyUtil.WoodSetProperties REDWOOD = PropertyUtil.WoodSetProperties.builder(MapColor.COLOR_RED).build();

        public static final BlockBehaviour.Properties CYPRESS_BRANCH = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.BAMBOO_SAPLING);
        public static final BlockBehaviour.Properties GOOSEBERRY_BASKET = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASS).strength(1.5F).sound(SoundType.WOOD);

        public static final BlockBehaviour.Properties ALGAE = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.0F).noCollission().sound(SoundType.LILY_PAD);
        public static final BlockBehaviour.Properties ALGAE_THATCH = PropertyUtil.thatch(MapColor.COLOR_LIGHT_GREEN, SoundType.GRASS);

        public static final BlockBehaviour.Properties BEARD_MOSS = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.MOSS).noOcclusion().noCollission().randomTicks();

        public static final BlockBehaviour.Properties LILY = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.LILY_PAD).noOcclusion();
    }
}
