package com.teamaurora.horizons.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class HorizonsBlockTags {
    public static final TagKey<Block> CYPRESS_LOGS = TagUtil.blockTag(Horizons.MOD_ID, "cypress_logs");
    public static final TagKey<Block> JACARANDA_LOGS = TagUtil.blockTag(Horizons.MOD_ID, "jacaranda_logs");
    public static final TagKey<Block> REDWOOD_LOGS = TagUtil.blockTag(Horizons.MOD_ID, "redwood_logs");
}
