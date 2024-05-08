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
import net.minecraftforge.common.IPlantable;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;

public class CypressTreeFeature extends BlueprintTreeFeature {

    public CypressTreeFeature(Codec<TreeConfiguration> config) {
        super(config);
    }

    @Override
    public void doPlace(FeaturePlaceContext<TreeConfiguration> context) {
        TreeConfiguration config = context.config();
        RandomSource random = context.random();
        BlockPos origin = context.origin();

        int branches = 1 + random.nextInt(2);
        int trunkHeight = config.trunkPlacer.getTreeHeight(random);

        boolean bald = random.nextInt(33) == 0;

        for (int y = 0; y < trunkHeight; y++) {
            this.addLog(origin.above(y));
        }
        for (Direction direction : Direction.Plane.HORIZONTAL)
        {
            BlockPos offsetPos = origin.relative(direction).below();
            BlockState offsetBlockState = context.level().getBlockState(offsetPos);
            if (HorizonsBlocks.CYPRESS_SAPLING.get().canSustainPlant(offsetBlockState, context.level(), offsetPos, Direction.UP, (IPlantable)HorizonsBlocks.CYPRESS_SAPLING.get())) {
                int height = random.nextInt(5) + 1;
                for (int y = 0; y < height; y++) {
                    this.addLog(origin.relative(direction).above(y));
                }
            }
        }

        if (!bald) {
            this.createCanopy(origin.above(trunkHeight - 1), 3);
            this.createCanopy(origin.above(trunkHeight), 2);
        }

        ArrayList<Direction> directions = Lists.newArrayList();
        while (directions.size() < branches) {
            Direction newDir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            if (!directions.contains(newDir))
                directions.add(newDir);
        }

        for (Direction direction : directions) {
            int height = random.nextIntBetweenInclusive(5, trunkHeight - 3);

            this.createBranch(origin.above(height), direction, config, random);
        }
    }

    private void createCanopy(BlockPos pos, int leafSize) {
        for (int i = -leafSize; i <= leafSize; i++) {
            for (int k = -leafSize; k <= leafSize; k++) {
                if (Math.abs(i) != leafSize || Math.abs(k) != leafSize)
                    this.addFoliage(pos.offset(i, 0, k));
            }
        }
    }

    private void createBranch(BlockPos pos, Direction direction, TreeConfiguration config, RandomSource random) {
        int wobble = random.nextInt(3) - 1;
        int wobbleStart = random.nextInt(3);
        for (int i = 0; i < 3; i++) {
            BlockPos pos2;
            if (i >= wobbleStart)
                pos2 = pos.relative(direction, i+1).relative(direction.getClockWise(), wobble);
            else
                pos2 = pos.relative(direction, i+1);

            if (i == 2) {
                pos2 = pos2.above();
                createCanopy(pos2, 3);
                createCanopy(pos2.above(), 2);
            }

            this.addAxisLog(pos2, direction, config, random);
        }
    }

    @Override
    public BlockState getSapling() {
        return HorizonsBlocks.CYPRESS_SAPLING.get().defaultBlockState();
    }
}
