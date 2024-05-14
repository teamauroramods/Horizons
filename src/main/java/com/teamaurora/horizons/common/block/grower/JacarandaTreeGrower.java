package com.teamaurora.horizons.common.block.grower;

import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

public class JacarandaTreeGrower extends AbstractTreeGrower {
    private final boolean flowering;

    public JacarandaTreeGrower(boolean flowering) {
        super();
        this.flowering = flowering;
    }

    @Override
    @Nullable
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean beehive) {
        if (flowering)
            return beehive ? HorizonsFeatures.Configured.FLOWERING_JACARANDA_BEES_005 : HorizonsFeatures.Configured.FLOWERING_JACARANDA;
        return beehive ? HorizonsFeatures.Configured.JACARANDA_BEES_005 : HorizonsFeatures.Configured.JACARANDA;
    }
}
