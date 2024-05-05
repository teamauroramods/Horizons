package com.teamaurora.horizons.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.integration.boatload.HorizonsBoatTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.modLoaded;
import static net.minecraft.world.item.CreativeModeTabs.TOOLS_AND_UTILITIES;
import static net.minecraft.world.item.crafting.Ingredient.of;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorizonsItems {
    public static final ItemSubRegistryHelper HELPER = Horizons.REGISTRY_HELPER.getItemSubHelper();

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
                .tab(TOOLS_AND_UTILITIES)
                .addItemsBefore(of(Items.BAMBOO_RAFT), CYPRESS_BOAT.getFirst(), CYPRESS_BOAT.getSecond())
                .addItemsBefore(modLoaded(Items.BAMBOO_RAFT, "boatload"), CYPRESS_FURNACE_BOAT, LARGE_CYPRESS_BOAT)
                .addItemsBefore(of(Items.BAMBOO_RAFT), JACARANDA_BOAT.getFirst(), JACARANDA_BOAT.getSecond())
                .addItemsBefore(modLoaded(Items.BAMBOO_RAFT, "boatload"), JACARANDA_FURNACE_BOAT, LARGE_JACARANDA_BOAT)
                .addItemsBefore(of(Items.BAMBOO_RAFT), REDWOOD_BOAT.getFirst(), REDWOOD_BOAT.getSecond())
                .addItemsBefore(modLoaded(Items.BAMBOO_RAFT, "boatload"), REDWOOD_FURNACE_BOAT, LARGE_REDWOOD_BOAT);
    }
}
