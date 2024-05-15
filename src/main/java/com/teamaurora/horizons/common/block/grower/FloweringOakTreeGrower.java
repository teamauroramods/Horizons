package com.teamaurora.horizons.common.block.grower;

import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

public class FloweringOakTreeGrower extends AbstractTreeGrower {
    @Override
    @Nullable
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean beehive) {
        if (random.nextInt(10) == 0) {
            return beehive ? HorizonsFeatures.Configured.FLOWERING_FANCY_OAK_BEES_005 : HorizonsFeatures.Configured.FLOWERING_FANCY_OAK;
        } else {
            return beehive ? HorizonsFeatures.Configured.FLOWERING_OAK_BEES_005 : HorizonsFeatures.Configured.FLOWERING_OAK;
        }
    }
}
