package com.teamaurora.horizons.common.block.grower;

import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

public class FloweringJungleTreeGrower extends AbstractMegaTreeGrower {
    @Override
    @Nullable
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean beehive) {
        return HorizonsFeatures.Configured.FLOWERING_JUNGLE;
    }

    @Override
    @Nullable
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
        return HorizonsFeatures.Configured.FLOWERING_MEGA_JUNGLE;
    }
}
