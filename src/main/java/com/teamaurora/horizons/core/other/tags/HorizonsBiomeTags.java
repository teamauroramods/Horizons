package com.teamaurora.horizons.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class HorizonsBiomeTags {
    public static final TagKey<Biome> HAS_MALLOW = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/mallow");
    public static final TagKey<Biome> HAS_MARIGOLD = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/marigold");
    public static final TagKey<Biome> HAS_AMARANTH = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/amaranth");
    public static final TagKey<Biome> HAS_FORGET_ME_NOT = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/forget_me_not");
    public static final TagKey<Biome> HAS_HELICONIA = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/heliconia");
    public static final TagKey<Biome> HAS_FIDDLENECK = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/fiddleneck");
    public static final TagKey<Biome> HAS_WATERLILY = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/waterlily");
    public static final TagKey<Biome> HAS_DAISY = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/daisy");

    public static final TagKey<Biome> HAS_TROPICAL_GRASS = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/tropical_grass");
    public static final TagKey<Biome> HAS_SWAMP_GRASS = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/swamp_grass");

    public static final TagKey<Biome> HAS_FLOWERING_OAK = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/flowering_oak");
    public static final TagKey<Biome> HAS_FLOWERING_JUNGLE = TagUtil.biomeTag(Horizons.MOD_ID, "has_feature/flowering_jungle");
}
