package com.teamaurora.horizons.core.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintItemModelProvider;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.teamaurora.horizons.core.registry.HorizonsItems.*;

public class HorizonsItemModelProvider extends BlueprintItemModelProvider {

    public HorizonsItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, Horizons.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        this.generatedItem(GOOSEBERRIES, GLAZED_GOOSEBERRIES, GOOSEBERRY_COOKIE, GOOSEBERRY_PIE, GOOSEBERRY_JUICE);
        this.generatedItem(CYPRESS_BOAT.getFirst(), CYPRESS_BOAT.getSecond(), CYPRESS_FURNACE_BOAT, LARGE_CYPRESS_BOAT);
        this.generatedItem(JACARANDA_BOAT.getFirst(), JACARANDA_BOAT.getSecond(), JACARANDA_FURNACE_BOAT, LARGE_JACARANDA_BOAT);
        this.generatedItem(REDWOOD_BOAT.getFirst(), REDWOOD_BOAT.getSecond(), REDWOOD_FURNACE_BOAT, LARGE_REDWOOD_BOAT);
    }
}
