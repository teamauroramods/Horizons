package com.teamaurora.horizons.core.fabric;

import com.teamaurora.horizons.core.Horizons;
import net.fabricmc.api.ModInitializer;

public class HorizonsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Horizons.PLATFORM.setup();
    }
}
