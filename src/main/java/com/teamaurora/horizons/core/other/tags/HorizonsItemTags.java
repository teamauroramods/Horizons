package com.teamaurora.horizons.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class HorizonsItemTags {
    public static final TagKey<Item> CYPRESS_LOGS = TagUtil.itemTag(Horizons.MOD_ID, "cypress_logs");
    public static final TagKey<Item> JACARANDA_LOGS = TagUtil.itemTag(Horizons.MOD_ID, "jacaranda_logs");
    public static final TagKey<Item> REDWOOD_LOGS = TagUtil.itemTag(Horizons.MOD_ID, "redwood_logs");
}
