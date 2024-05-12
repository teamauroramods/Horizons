package com.teamaurora.horizons.common.levelgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public abstract class GroundPatchFeature extends BlockPatchFeature{
    public GroundPatchFeature(Codec<ProbabilityFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    Heightmap.Types getHeightmap() {
        return Heightmap.Types.WORLD_SURFACE;
    }

    @Override
    public boolean canReplace(BlockState state) {
        return isDirt(state);
    }

    @Override
    public int getHeightOffset() {
        return 0;
    }
}
