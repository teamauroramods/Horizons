package com.teamaurora.bayou_blues.core.fabric;

import com.teamaurora.bayou_blues.core.Horizons;
import net.fabricmc.api.ModInitializer;

public class HorizonsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Horizons.PLATFORM.setup();
    }
}
