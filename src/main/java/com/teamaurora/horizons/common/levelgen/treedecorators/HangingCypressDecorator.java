package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class HangingCypressDecorator extends TreeDecorator {
    public static final Codec<HangingCypressDecorator> CODEC;
    public static final HangingCypressDecorator INSTANCE = new HangingCypressDecorator();

    @Override
    protected TreeDecoratorType<?> type() {
        return HorizonsFeatures.HANGING_CYPRESS_LEAVES.get();
    }

    @Override
    public void place(Context context) {
        for (BlockPos pos : context.leaves()) {
            if (context.level().isStateAtPosition(pos.below(), BlockState::isAir)) {
                if (context.random().nextInt(3) == 0) {
                    context.setBlock(pos.below(), HorizonsBlocks.HANGING_CYPRESS_LEAVES.get().defaultBlockState());
                }
            }
        }
    }

    static {
        CODEC = Codec.unit(() -> INSTANCE);
    }
}
