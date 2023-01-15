package com.teamaurora.horizons.common.item;

import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;
import java.util.function.Supplier;

public enum ItemTabPlacements implements Function<Block, Item> {
    STRIPPED_LOG(() -> Items.STRIPPED_WARPED_STEM, simpleTab(CreativeModeTab.TAB_BUILDING_BLOCKS)),
    STRIPPED_WOOD(() -> Items.STRIPPED_WARPED_HYPHAE, simpleTab(CreativeModeTab.TAB_BUILDING_BLOCKS)),
    LOG(() -> Items.WARPED_STEM, simpleTab(CreativeModeTab.TAB_BUILDING_BLOCKS)),
    WOOD(() -> Items.WARPED_HYPHAE, simpleTab(CreativeModeTab.TAB_BUILDING_BLOCKS)),
    PLANKS(() -> Items.WARPED_PLANKS, simpleTab(CreativeModeTab.TAB_BUILDING_BLOCKS)),
    SLAB(() -> Items.WARPED_SLAB, simpleTab(CreativeModeTab.TAB_BUILDING_BLOCKS)),
    STAIRS(() -> Items.WARPED_STAIRS, simpleTab(CreativeModeTab.TAB_BUILDING_BLOCKS)),
    WOOD_PRESSURE_PLATE(() -> Items.WARPED_PRESSURE_PLATE, simpleTab(CreativeModeTab.TAB_REDSTONE)),
    WOOD_BUTTON(() -> Items.WARPED_BUTTON, simpleTab(CreativeModeTab.TAB_REDSTONE)),
    WOOD_FENCE(() -> Items.WARPED_FENCE, simpleTab(CreativeModeTab.TAB_DECORATIONS)),
    WOOD_FENCE_GATE(() -> Items.WARPED_FENCE_GATE, simpleTab(CreativeModeTab.TAB_REDSTONE)),
    DOOR(() -> Items.WARPED_DOOR, simpleTab(CreativeModeTab.TAB_REDSTONE)),
    TRAPDOOR(() -> Items.WARPED_TRAPDOOR, simpleTab(CreativeModeTab.TAB_REDSTONE)),
    LEAVES(() -> Items.AZALEA_LEAVES, simpleTab(CreativeModeTab.TAB_DECORATIONS)),
    SAPLING(() -> Items.DARK_OAK_SAPLING, simpleTab(CreativeModeTab.TAB_DECORATIONS)),
    BEARD_MOSS(() -> Items.MOSS_BLOCK, simpleTab(CreativeModeTab.TAB_DECORATIONS)),
    GIANT_FERN(() -> Items.LARGE_FERN, simpleTab(CreativeModeTab.TAB_DECORATIONS));




    private final Function<Block, Item> function;

    ItemTabPlacements(Supplier<Item> item, Item.Properties properties) {
        this.function = block -> new TabInsertBlockItem(item.get(), block, properties);
    }

    @Override
    public Item apply(Block block) {
        return this.function.apply(block);
    }

    public static Item.Properties simpleTab(CreativeModeTab tab) {
        return new Item.Properties().tab(tab);
    }
}
