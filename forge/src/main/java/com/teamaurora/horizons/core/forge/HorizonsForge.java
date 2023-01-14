package com.teamaurora.horizons.core.forge;

import com.teamaurora.horizons.core.Horizons;
import net.minecraftforge.fml.common.Mod;

@Mod(Horizons.MOD_ID)
public class HorizonsForge {
    public HorizonsForge() {
        Horizons.PLATFORM.setup();
    }
}
