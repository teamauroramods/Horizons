package com.teamaurora.horizons.core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = Horizons.MOD_ID)
public class HorizonsConfig {
    public static class Common {
        public final ForgeConfigSpec.BooleanValue enableMallows;
        public final ForgeConfigSpec.BooleanValue enableMarigolds;
        public final ForgeConfigSpec.BooleanValue enableAmaranths;
        public final ForgeConfigSpec.BooleanValue enableForgetMeNots;
        public final ForgeConfigSpec.BooleanValue enableHeliconias;
        public final ForgeConfigSpec.BooleanValue enableFiddlenecks;
        public final ForgeConfigSpec.BooleanValue enableDaisies;
        public final ForgeConfigSpec.BooleanValue enableWaterlilies;
        public final ForgeConfigSpec.BooleanValue enableAlternateGrasses;
        public final ForgeConfigSpec.BooleanValue enableFloweringOak;
        public final ForgeConfigSpec.BooleanValue enableFloweringJungle;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("flora");
            enableMallows = builder.comment("Whether mallow flowers should be enabled").define("Mallows", true);
            enableMarigolds = builder.comment("Whether marigolds should be enabled").define("Marigolds", true);
            enableAmaranths = builder.comment("Whether amaranths should be enabled").define("Amaranths", true);
            enableForgetMeNots = builder.comment("Whether forget-me-nots should be enabled").define("Forget-me-nots", true);
            enableHeliconias = builder.comment("Whether heliconias should be enabled").define("Heliconias", true);
            enableFiddlenecks = builder.comment("Whether fiddlenecks should be enabled").define("Fiddlenecks", true);
            enableDaisies = builder.comment("Whether blue, orange, pink, purple, and yellow daisies should be enabled").define("More daisies", true);
            enableWaterlilies = builder.comment("Whether waterlily flowers should be enabled").define("Waterlilies", true);
            enableAlternateGrasses = builder.comment("Whether tropical grass and swamp grass should be enabled").define("More grasses", true);
            enableFloweringOak = builder.comment("Whether flowering oak trees should be enabled").define("Flowering oak trees", true);
            enableFloweringJungle = builder.comment("Whether flowering jungle trees should be enabled").define("Flowering jungle trees", true);
            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}
