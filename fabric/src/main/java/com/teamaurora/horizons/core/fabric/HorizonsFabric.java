package com.teamaurora.horizons.core.fabric;

import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsSurfaceRules;
import net.fabricmc.api.ModInitializer;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class HorizonsFabric implements ModInitializer, TerraBlenderApi {
    @Override
    public void onInitialize() {
        Horizons.PLATFORM.setup();
    }

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new HorizonsFabricRegion(Horizons.location("overworld"), 3));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Horizons.MOD_ID, HorizonsSurfaceRules.BAYOU);
    }
}
