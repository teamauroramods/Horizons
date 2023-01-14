package com.teamaurora.horizons.common.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;

/**
 * @author JustinPlayzz
 * @author Steven
 * @author ebo2022
 */
public class JamItem extends DrinkItem {
    public JamItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }
}