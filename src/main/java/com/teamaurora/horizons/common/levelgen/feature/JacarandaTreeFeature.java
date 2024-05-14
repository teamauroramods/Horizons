package com.teamaurora.horizons.common.levelgen.feature;

import com.mojang.serialization.Codec;
import com.teamabnormals.blueprint.common.levelgen.feature.BlueprintTreeFeature;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class JacarandaTreeFeature extends BlueprintTreeFeature {

    public JacarandaTreeFeature(Codec<TreeConfiguration> config) {
        super(config);
    }

    @Override
    public void doPlace(FeaturePlaceContext<TreeConfiguration> context) {
        TreeConfiguration config = context.config();
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        int height = config.trunkPlacer.getTreeHeight(random);

        // Trunk
        for (int i = 0; i <= height; i++) {
            this.addLog(origin.above(i));
        }

        // Branches
        for (int i = 2; i <= height - 2; i++) {
            Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            createBranch(origin.above(i), dir, random);
        }
        createLeafBlob(origin.above(height));
    }

    private void createCanopy(BlockPos pos, int leafSize) {
        for (int i = -leafSize; i <= leafSize; i++) {
            for (int k = -leafSize; k <= leafSize; k++) {
                if (Math.abs(i) != leafSize || Math.abs(k) != leafSize)
                    this.addFoliage(pos.offset(i, 0, k));
            }
        }
    }

    private void createLeafBlob(BlockPos pos) {
        createCanopy(pos.below(), 1);
        createCanopy(pos, 2);
        createCanopy(pos.above(), 2);
        createCanopy(pos.above(2), 1);
    }

    private void createBranch(BlockPos pos, Direction dir, RandomSource rand) {
        this.addLog(pos.relative(dir));
        int i = rand.nextInt(3) - 1;
        BlockPos pos2 = pos.relative(dir, 2).relative(dir.getClockWise(), i);
        this.addLog(pos2);
        createLeafBlob(pos2);
    }

    @Override
    public BlockState getSapling() {
        return HorizonsBlocks.JACARANDA_SAPLING.get().defaultBlockState();
    }
}
