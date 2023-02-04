package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.core.Horizons;
import gg.moonflower.pollen.api.PollenRegistries;
import gg.moonflower.pollen.api.entity.PollinatedBoatType;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;

import java.util.function.Supplier;

public class HorizonsBoatTypes {

    public static final PollinatedRegistry<PollinatedBoatType> BOAT_TYPES = PollinatedRegistry.create(PollenRegistries.BOAT_TYPE_REGISTRY, Horizons.MOD_ID);
    public static final Supplier<PollinatedBoatType> CYPRESS = BOAT_TYPES.register("cypress_boat", () -> new PollinatedBoatType(Horizons.location("textures/entity/boat/cypress_boat.png")));

}
