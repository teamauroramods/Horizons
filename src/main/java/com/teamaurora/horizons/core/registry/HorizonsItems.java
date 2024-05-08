package com.teamaurora.horizons.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.integration.boatload.HorizonsBoatTypes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.modLoaded;
import static net.minecraft.world.item.CreativeModeTabs.*;
import static net.minecraft.world.item.crafting.Ingredient.of;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorizonsItems {
    public static final ItemSubRegistryHelper HELPER = Horizons.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> ALGAE = HELPER.createItem("algae", ()->new PlaceOnWaterBlockItem(HorizonsBlocks.ALGAE.get(), new Item.Properties()));

    public static final RegistryObject<Item> GOOSEBERRIES = HELPER.createItem("gooseberries", ()->new Item(new Item.Properties().food(Foods.GOOSEBERRIES)));
    public static final RegistryObject<Item> GOOSEBERRY_JUICE = HELPER.createItem("gooseberry_juice", ()->new DrinkableItem(new Item.Properties().food(Foods.GOOSEBERRY_JUICE).stacksTo(16)));
    public static final RegistryObject<Item> GOOSEBERRY_PIE = HELPER.createItem("gooseberry_pie", ()->new Item(new Item.Properties().food(Foods.GOOSEBERRY_PIE)));
    public static final RegistryObject<Item> GLAZED_GOOSEBERRIES = HELPER.createItem("glazed_gooseberries", ()->new Item(new Item.Properties().food(Foods.GLAZED_GOOSEBERRIES)));
    public static final RegistryObject<Item> GOOSEBERRY_COOKIE = HELPER.createItem("gooseberry_cookie", ()->new Item(new Item.Properties().food(Foods.GOOSEBERRY_COOKIE)));

    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> CYPRESS_BOAT = HELPER.createBoatAndChestBoatItem("cypress", HorizonsBlocks.CYPRESS_PLANKS);
    public static final RegistryObject<Item> CYPRESS_FURNACE_BOAT = HELPER.createItem("cypress_furnace_boat", ModList.get().isLoaded("boatload") ? HorizonsBoatTypes.CYPRESS_FURNACE_BOAT : () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_CYPRESS_BOAT = HELPER.createItem("large_cypress_boat", ModList.get().isLoaded("boatload") ? HorizonsBoatTypes.LARGE_CYPRESS_BOAT : () -> new Item(new Item.Properties()));

    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> JACARANDA_BOAT = HELPER.createBoatAndChestBoatItem("jacaranda", HorizonsBlocks.JACARANDA_PLANKS);
    public static final RegistryObject<Item> JACARANDA_FURNACE_BOAT = HELPER.createItem("jacaranda_furnace_boat", ModList.get().isLoaded("boatload") ? HorizonsBoatTypes.JACARANDA_FURNACE_BOAT : () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_JACARANDA_BOAT = HELPER.createItem("large_jacaranda_boat", ModList.get().isLoaded("boatload") ? HorizonsBoatTypes.LARGE_JACARANDA_BOAT : () -> new Item(new Item.Properties()));

    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> REDWOOD_BOAT = HELPER.createBoatAndChestBoatItem("redwood", HorizonsBlocks.REDWOOD_PLANKS);
    public static final RegistryObject<Item> REDWOOD_FURNACE_BOAT = HELPER.createItem("redwood_furnace_boat", ModList.get().isLoaded("boatload") ? HorizonsBoatTypes.REDWOOD_FURNACE_BOAT : () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_REDWOOD_BOAT = HELPER.createItem("large_redwood_boat", ModList.get().isLoaded("boatload") ? HorizonsBoatTypes.LARGE_REDWOOD_BOAT : () -> new Item(new Item.Properties()));

    public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(Horizons.MOD_ID)
                .tab(NATURAL_BLOCKS)
                .addItemsBefore(of(Items.LILY_PAD), ALGAE)
                .tab(TOOLS_AND_UTILITIES)
                .addItemsBefore(of(Items.BAMBOO_RAFT), CYPRESS_BOAT.getFirst(), CYPRESS_BOAT.getSecond())
                .addItemsBefore(modLoaded(Items.BAMBOO_RAFT, "boatload"), CYPRESS_FURNACE_BOAT, LARGE_CYPRESS_BOAT)
                .addItemsBefore(of(Items.BAMBOO_RAFT), JACARANDA_BOAT.getFirst(), JACARANDA_BOAT.getSecond())
                .addItemsBefore(modLoaded(Items.BAMBOO_RAFT, "boatload"), JACARANDA_FURNACE_BOAT, LARGE_JACARANDA_BOAT)
                .addItemsBefore(of(Items.BAMBOO_RAFT), REDWOOD_BOAT.getFirst(), REDWOOD_BOAT.getSecond())
                .addItemsBefore(modLoaded(Items.BAMBOO_RAFT, "boatload"), REDWOOD_FURNACE_BOAT, LARGE_REDWOOD_BOAT)
                .tab(FOOD_AND_DRINKS)
                .addItemsAfter(of(Items.GLOW_BERRIES), GOOSEBERRIES, GLAZED_GOOSEBERRIES)
                .addItemsAfter(of(Items.PUMPKIN_PIE), GOOSEBERRY_PIE)
                .addItemsAfter(of(Items.COOKIE), GOOSEBERRY_COOKIE)
                .addItemsAfter(of(Items.HONEY_BOTTLE), GOOSEBERRY_JUICE);
    }

    public static class Foods {
        public static final FoodProperties GOOSEBERRIES = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).build();
        public static final FoodProperties GOOSEBERRY_JUICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build();
        public static final FoodProperties GOOSEBERRY_PIE = new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build();
        public static final FoodProperties GLAZED_GOOSEBERRIES = new FoodProperties.Builder().nutrition(7).saturationMod(0.3F).build();
        public static final FoodProperties GOOSEBERRY_COOKIE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).fast().build();
    }
}
