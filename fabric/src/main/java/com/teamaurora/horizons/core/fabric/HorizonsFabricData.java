package com.teamaurora.horizons.core.fabric;

import com.teamaurora.horizons.core.Horizons;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class HorizonsFabricData implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        Horizons.PLATFORM.dataSetup(fabricDataGenerator);
    }
}
