package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.common.block.BeardMossBlock;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class BeardMossDecorator extends TreeDecorator {
    public static final Codec<BeardMossDecorator> CODEC;
    public static final BeardMossDecorator INSTANCE = new BeardMossDecorator();

    @Override
    protected TreeDecoratorType<?> type() {
        return HorizonsFeatures.BEARD_MOSS.get();
    }

    @Override
    public void place(Context context) {
        for (BlockPos pos : context.leaves()) {
            if (context.level().isStateAtPosition(pos.below(), BlockState::isAir)) {
                if (context.random().nextInt(2) == 0) {
                    int size = context.random().nextInt(5) + 1;
                    for (int i = 1; i < size; i++) {
                        context.setBlock(pos.below(i), HorizonsBlocks.BEARD_MOSS.get().defaultBlockState().setValue(BeardMossBlock.HALF, DoubleBlockHalf.UPPER));
                    }
                    context.setBlock(pos.below(size), HorizonsBlocks.BEARD_MOSS.get().defaultBlockState().setValue(BeardMossBlock.HALF, DoubleBlockHalf.LOWER));
                }
            }
        }
    }

    static {
        CODEC = Codec.unit(() -> INSTANCE);
    }
}
