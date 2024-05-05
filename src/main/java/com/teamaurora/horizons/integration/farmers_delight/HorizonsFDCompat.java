package com.teamaurora.horizons.integration.farmers_delight;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.function.Supplier;

public class HorizonsFDCompat {
    public static final Supplier<Block> CABINET_SUPPLIER = () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL));

    public static boolean fdGroupPredicate(BuildCreativeModeTabContentsEvent event) {
        return event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey();
    }

    public static Supplier<Item> fdCabinetSupplier = () -> ModItems.BAMBOO_CABINET.get();
    public static Supplier<BooleanProperty> cabinetOpenSupplier = () -> CabinetBlock.OPEN;
    public static Supplier<TagKey<Item>> cabinetTagSupplier = () -> ModTags.WOODEN_CABINETS;
}
