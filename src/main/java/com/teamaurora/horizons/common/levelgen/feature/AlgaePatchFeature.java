package com.teamaurora.horizons.common.levelgen.feature;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public class AlgaePatchFeature extends BlockPatchFeature {
    public AlgaePatchFeature(Codec<ProbabilityFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    BlockState getBlockState() {
        return HorizonsBlocks.ALGAE.get().defaultBlockState();
    }

    @Override
    Heightmap.Types getHeightmap() {
        return Heightmap.Types.WORLD_SURFACE;
    }

    @Override
    int getHeightOffset() {
        return 1;
    }

    @Override
    boolean canReplace(BlockState state) {
        return state.is(Blocks.WATER);
    }

    @Override
    int getSize() {
        return 6;
    }
}
