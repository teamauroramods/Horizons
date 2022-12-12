package com.teamaurora.bayou_blues.core.forge;

import com.teamaurora.bayou_blues.core.Horizons;
import net.minecraftforge.fml.common.Mod;

@Mod(Horizons.MOD_ID)
public class HorizonsForge {
    public HorizonsForge() {
        Horizons.PLATFORM.setup();
    }
}
