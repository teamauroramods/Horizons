package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.common.block.CypressBranchBlock;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class CypressBranchDecorator extends TreeDecorator {
    public static final Codec<CypressBranchDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(CypressBranchDecorator::new, (decorator) -> decorator.probability).codec();
    private final float probability;

    public CypressBranchDecorator(float probability) {
        this.probability = probability;
    }


    @Override
    protected TreeDecoratorType<?> type() {
        return HorizonsFeatures.CYPRESS_BRANCH.get();
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        if (random.nextFloat() < probability) {
            int branchCount = random.nextInt(10) + 1;
            for (int i = 0; i < branchCount; i++) {
                int j = random.nextInt(context.logs().size());
                BlockPos pos = context.logs().get(j);
                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                BlockPos offsetPos = pos.relative(direction);
                if (context.isAir(offsetPos)) {
                    context.setBlock(offsetPos, HorizonsBlocks.CYPRESS_BRANCH.get().defaultBlockState().setValue(CypressBranchBlock.AGE, 2).setValue(CypressBranchBlock.FACING, direction.getOpposite()));
                }
            }
        }
    }
}
