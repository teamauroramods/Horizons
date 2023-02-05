package com.teamaurora.horizons.core.registry;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class HorizonsSurfaceRules {

    public static final SurfaceRules.ConditionSource Y_IS_62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
    public static final SurfaceRules.ConditionSource Y_IS_64 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(64), 0);

    public static final SurfaceRules.RuleSource SEA_LEVEL_WATER_NOISE = SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
            SurfaceRules.ifTrue(Y_IS_62,
                    SurfaceRules.ifTrue(SurfaceRules.not(Y_IS_64),
                            SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D),
                                    SurfaceRules.state(Blocks.WATER.defaultBlockState())
                            )
                    )
            )
    );

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double d) {
        return SurfaceRules.noiseCondition(Noises.SWAMP, d / 8.25, Double.MAX_VALUE);
    }

    public static final SurfaceRules.RuleSource BAYOU = SurfaceRules.ifTrue(SurfaceRules.isBiome(HorizonsBiomes.BAYOU), SurfaceRules.sequence(SEA_LEVEL_WATER_NOISE,
            SurfaceRules.ifTrue(surfaceNoiseAbove(2),
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.MOSS_BLOCK.defaultBlockState()))
            )
    ));
}
