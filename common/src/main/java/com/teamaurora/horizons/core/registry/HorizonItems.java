package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.core.Horizons;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public class HorizonItems {

    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, Horizons.MOD_ID);
}
