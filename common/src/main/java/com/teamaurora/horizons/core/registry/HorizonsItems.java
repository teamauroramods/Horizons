package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.common.item.DrinkItem;
import com.teamaurora.horizons.common.item.JamItem;
import com.teamaurora.horizons.core.Horizons;
import gg.moonflower.pollen.api.item.PollinatedBoatItem;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class HorizonsItems {

    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, Horizons.MOD_ID);

    public static final Supplier<Item> CYPRESS_BOAT = ITEMS.register("cypress_boat", () -> new PollinatedBoatItem(HorizonsBoatTypes.CYPRESS, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final Supplier<Item> GOOSEBERRIES = ITEMS.register("gooseberries", () -> new Item(new Item.Properties().food(Foods.GOOSEBERRIES).tab(CreativeModeTab.TAB_FOOD)));
    public static final Supplier<Item> GOOSEBERRY_JUICE = ITEMS.register("gooseberry_juice", () -> new DrinkItem(new Item.Properties().food(Foods.GOOSEBERRY_JUICE).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final Supplier<Item> GOOSEBERRY_PIE = ITEMS.register("gooseberry_pie", () -> new Item(new Item.Properties().food(Foods.GOOSEBERRY_PIE).tab(CreativeModeTab.TAB_FOOD)));
    public static final Supplier<Item> HONEY_GLAZED_GOOSEBERRIES = ITEMS.register("honey_glazed_gooseberries", () -> new Item(new Item.Properties().food(Foods.HONEY_GLAZED_GOOSEBERRIES).tab(CreativeModeTab.TAB_FOOD)));
    public static final Supplier<Item> GOOSEBERRY_JAM = ITEMS.register("gooseberry_jam", () -> new JamItem(new Item.Properties().food(Foods.GOOSEBERRY_JAM).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final Supplier<Item> GOOSEBERRY_JAM_COOKIE = ITEMS.register("gooseberry_jam_cookie", () -> new Item(new Item.Properties().food(Platform.isModLoaded("farmersdelight") ? Foods.GOOSEBERRY_JAM_COOKIE_FAST : Foods.GOOSEBERRY_JAM_COOKIE).tab(CreativeModeTab.TAB_FOOD)));

    public static final class Foods {
        public static final FoodProperties GOOSEBERRIES = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).build();
        public static final FoodProperties GOOSEBERRY_JUICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build();
        public static final FoodProperties GOOSEBERRY_PIE = new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build();

        public static final FoodProperties HONEY_GLAZED_GOOSEBERRIES = new FoodProperties.Builder().nutrition(7).saturationMod(0.3F).build();
        public static final FoodProperties GOOSEBERRY_JAM = new FoodProperties.Builder().nutrition(2).saturationMod(0.25F).build();
        public static final FoodProperties GOOSEBERRY_JAM_COOKIE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();
        public static final FoodProperties GOOSEBERRY_JAM_COOKIE_FAST = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).fast().build();
    }
}
