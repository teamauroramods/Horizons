package com.teamaurora.horizons.common.levelgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import org.jetbrains.annotations.NotNull;

public abstract class BlockPatchFeature extends Feature<ProbabilityFeatureConfiguration> {

    public BlockPatchFeature(Codec<ProbabilityFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
        return this.doPlace(context, this.getBlockState());
    }

    abstract BlockState getBlockState();

    abstract Heightmap.Types getHeightmap();

    abstract boolean canReplace(BlockState state);

    abstract int getSize();

    abstract int getHeightOffset();

    public boolean doPlace(FeaturePlaceContext<ProbabilityFeatureConfiguration> context, BlockState state) {
        ProbabilityFeatureConfiguration config = context.config();
        WorldGenLevel level = context.level();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();

        BlockPos.MutableBlockPos blockPos$mutable = pos.mutable();
        int i = 0;
        if (rand.nextFloat() < config.probability) {
            int size = getSize();
            for (int xo = -size; xo <= size; xo++) {
                for (int zo = -size; zo <= size; zo++) {
                    if (rand.nextFloat() > (float) (xo * xo + zo * zo) / (size * size)) {
                        int x = xo + pos.getX();
                        int z = zo + pos.getZ();
                        blockPos$mutable.set(x, level.getHeight(getHeightmap(), x, z) - 1, z);
                        if (canReplace(level.getBlockState(blockPos$mutable))) {
                            blockPos$mutable.move(0, getHeightOffset(), 0);
                            level.setBlock(blockPos$mutable, state, 2);
                        }
                    }
                }
            }
            i++;
        }
        return i > 0;
    }
}
