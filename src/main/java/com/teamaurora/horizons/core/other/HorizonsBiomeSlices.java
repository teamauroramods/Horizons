package com.teamaurora.horizons.core.other;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.world.modification.ModdedBiomeSlice;
import com.teamabnormals.blueprint.core.registry.BlueprintBiomes;
import com.teamabnormals.blueprint.core.registry.BlueprintDataPackRegistries;
import com.teamabnormals.blueprint.core.util.BiomeUtil;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.dimension.LevelStem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HorizonsBiomeSlices {
    public static final ResourceKey<ModdedBiomeSlice> HORIZONS = createKey("horizons");

    private static final ResourceKey<Biome> BAYOU_LOW = HorizonsBiomes.createKey("bayou_low");
    private static final ResourceKey<Biome> BAYOU_MID = HorizonsBiomes.createKey("bayou_mid");

    public static void bootstrap(BootstapContext<ModdedBiomeSlice> context) {
        List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> entries = new ArrayList<>();
        new HorizonsBiomeBuilder().addBiomesToSlice(entries::add);

        context.register(HORIZONS, new ModdedBiomeSlice(20,
                BiomeUtil.MultiNoiseModdedBiomeProvider.builder()
                        .biomes(entries::forEach)
                        .area(BAYOU_LOW, HorizonsBiomes.BAYOU)
                        .area(BAYOU_MID, HorizonsBiomes.BAYOU)
                        .build(), LevelStem.OVERWORLD));
    }

    public static ResourceKey<ModdedBiomeSlice> createKey(String name) {
        return ResourceKey.create(BlueprintDataPackRegistries.MODDED_BIOME_SLICES, new ResourceLocation(Horizons.MOD_ID, name));
    }

    @SuppressWarnings("unchecked")
    private static final class HorizonsBiomeBuilder {
        private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
        private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
        private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
        private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
        private final Climate.Parameter FROZEN_RANGE;
        private final Climate.Parameter UNFROZEN_RANGE;
        private final Climate.Parameter mushroomFieldsContinentalness;
        private final Climate.Parameter deepOceanContinentalness;
        private final Climate.Parameter oceanContinentalness;
        private final Climate.Parameter coastContinentalness;
        private final Climate.Parameter inlandContinentalness;
        private final Climate.Parameter nearInlandContinentalness;
        private final Climate.Parameter midInlandContinentalness;
        private final Climate.Parameter farInlandContinentalness;
        private final ResourceKey<Biome> VANILLA = BlueprintBiomes.ORIGINAL_SOURCE_MARKER;
        private final ResourceKey<Biome>[][] OCEANS;
        private final ResourceKey<Biome>[][] MIDDLE_BIOMES;
        private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT;
        private final ResourceKey<Biome>[][] PLATEAU_BIOMES;
        private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT;
        private final ResourceKey<Biome>[][] SHATTERED_BIOMES;

        public HorizonsBiomeBuilder() {
            this.FROZEN_RANGE = this.temperatures[0];
            this.UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
            this.mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
            this.deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
            this.oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
            this.coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
            this.inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
            this.nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
            this.midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
            this.farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);
            //this.OCEANS = new ResourceKey[][]{{Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN}, {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN}};
            this.OCEANS = new ResourceKey[][]{{  VANILLA                 , VANILLA               , VANILLA          , VANILLA                   , VANILLA          }, {VANILLA            , VANILLA          , VANILLA     , VANILLA              , VANILLA          }};
            //this.MIDDLE_BIOMES = new ResourceKey[][]{{Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA}, {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA}, {Biomes.FLOWER_FOREST, Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST}, {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE}, {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}};
            this.MIDDLE_BIOMES = new ResourceKey[][]{{  VANILLA            , VANILLA            , VANILLA            , VANILLA           , VANILLA     }, {VANILLA      , VANILLA      , VANILLA      , VANILLA     , VANILLA                       }, {VANILLA             , VANILLA      , VANILLA      , VANILLA            , VANILLA           }, {VANILLA       , VANILLA       , VANILLA      , VANILLA      , VANILLA      }, {VANILLA      , VANILLA      , VANILLA      , VANILLA      , VANILLA      }};
            //this.MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{{Biomes.ICE_SPIKES, null, Biomes.SNOWY_TAIGA, null, null}, {null, null, null, null, Biomes.OLD_GROWTH_PINE_TAIGA}, {Biomes.SUNFLOWER_PLAINS, null, null, Biomes.OLD_GROWTH_BIRCH_FOREST, null}, {null, null, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE}, {null, null, null, null, null}};
            this.MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{{            VANILLA, null, VANILLA           , null, null}, {null, null, null, null, VANILLA                     }, {VANILLA                , null, null, VANILLA                       , null}, {null, null, VANILLA      , VANILLA             , VANILLA             }, {null, null, null, null, null}};
            //this.PLATEAU_BIOMES = new ResourceKey[][]{{Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA}, {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA}, {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST}, {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE}, {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}};
            this.PLATEAU_BIOMES = new ResourceKey[][]{{  VANILLA            , VANILLA            , VANILLA            , VANILLA           , VANILLA           }, {VANILLA      , VANILLA      , VANILLA      , VANILLA     , VANILLA                       }, {VANILLA      , VANILLA      , VANILLA      , VANILLA      , VANILLA           }, {VANILLA               , VANILLA               , VANILLA      , VANILLA      , VANILLA      }, {VANILLA        , VANILLA        , VANILLA        , VANILLA               , VANILLA               }};
            //this.PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{{Biomes.ICE_SPIKES, null, null, null, null}, {Biomes.CHERRY_GROVE, null, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA}, {Biomes.CHERRY_GROVE, Biomes.CHERRY_GROVE, Biomes.FOREST, Biomes.BIRCH_FOREST, null}, {null, null, null, null, null}, {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, null, null, null}};
            this.PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{{  VANILLA          , null, null, null, null}, {VANILLA            , null, VANILLA      , VANILLA      , VANILLA                     }, {VANILLA            , VANILLA            , VANILLA      , VANILLA            , null}, {null, null, null, null, null}, {VANILLA               , VANILLA               , null, null, null}};
            //this.SHATTERED_BIOMES = new ResourceKey[][]{{Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, {null, null, null, null, null}, {null, null, null, null, null}};
            this.SHATTERED_BIOMES = new ResourceKey[][]{{  VANILLA                        , VANILLA                        , VANILLA               , VANILLA                , VANILLA                }, {VANILLA                        , VANILLA                        , VANILLA               , VANILLA                , VANILLA                }, {VANILLA               , VANILLA               , VANILLA               , VANILLA                , VANILLA                }, {null, null, null, null, null}, {null, null, null, null, null}};
        }

        public List<Climate.ParameterPoint> spawnTarget() {
            Climate.Parameter $$0 = Climate.Parameter.point(0.0F);
            float $$1 = 0.16F;
            return List.of(new Climate.ParameterPoint(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), this.FULL_RANGE, $$0, Climate.Parameter.span(-1.0F, -0.16F), 0L), new Climate.ParameterPoint(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), this.FULL_RANGE, $$0, Climate.Parameter.span(0.16F, 1.0F), 0L));
        }

        private void addBiomesToSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
            this.addOffCoastBiomes(consumer);
            this.addInlandBiomes(consumer);
            this.addUndergroundBiomes(consumer);
        }

        private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
            this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, /*Biomes.MUSHROOM_FIELDS*/ VANILLA);

            for(int $$1 = 0; $$1 < this.temperatures.length; ++$$1) {
                Climate.Parameter $$2 = this.temperatures[$$1];
                this.addSurfaceBiome(consumer, $$2, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[0][$$1]);
                this.addSurfaceBiome(consumer, $$2, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[1][$$1]);
            }

        }

        private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
            this.addMidSlice(consumer, Climate.Parameter.span(-1.0F, -0.93333334F));
            this.addHighSlice(consumer, Climate.Parameter.span(-0.93333334F, -0.7666667F));
            this.addPeaks(consumer, Climate.Parameter.span(-0.7666667F, -0.56666666F));
            this.addHighSlice(consumer, Climate.Parameter.span(-0.56666666F, -0.4F));
            this.addMidSlice(consumer, Climate.Parameter.span(-0.4F, -0.26666668F));
            this.addLowSlice(consumer, Climate.Parameter.span(-0.26666668F, -0.05F));
            this.addValleys(consumer, Climate.Parameter.span(-0.05F, 0.05F));
            this.addLowSlice(consumer, Climate.Parameter.span(0.05F, 0.26666668F));
            this.addMidSlice(consumer, Climate.Parameter.span(0.26666668F, 0.4F));
            this.addHighSlice(consumer, Climate.Parameter.span(0.4F, 0.56666666F));
            this.addPeaks(consumer, Climate.Parameter.span(0.56666666F, 0.7666667F));
            this.addHighSlice(consumer, Climate.Parameter.span(0.7666667F, 0.93333334F));
            this.addMidSlice(consumer, Climate.Parameter.span(0.93333334F, 1.0F));
        }

        private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
            for(int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter temperature = this.temperatures[i];

                for(int j = 0; j < this.humidities.length; ++j) {
                    Climate.Parameter humidity = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, weirdness);
                    ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, weirdness, resourcekey4);
                    ResourceKey<Biome> resourcekey6 = this.pickPeakBiome(i, j, weirdness);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], weirdness, 0.0F, resourcekey2);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], weirdness, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], weirdness, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.midInlandContinentalness, this.erosions[3], weirdness, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.farInlandContinentalness, this.erosions[3], weirdness, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey5);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey4);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
                }
            }

        }

        private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
            for(int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter temperature = this.temperatures[i];

                for(int j = 0; j < this.humidities.length; ++j) {
                    Climate.Parameter humidity = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, weirdness);
                    ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, weirdness, resourcekey);
                    ResourceKey<Biome> resourcekey6 = this.pickSlopeBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey7 = this.pickPeakBiome(i, j, weirdness);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, this.erosions[0], weirdness, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, resourcekey7);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, this.erosions[1], weirdness, 0.0F, resourcekey2);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], weirdness, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], weirdness, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.midInlandContinentalness, this.erosions[3], weirdness, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.farInlandContinentalness, this.erosions[3], weirdness, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey5);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey4);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
                }
            }

        }

        private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
            this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, /*Biomes.STONY_SHORE*/ VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, /*Biomes.SWAMP*/ VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, /*Biomes.MANGROVE_SWAMP*/ BAYOU_MID);

            for(int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter temperature = this.temperatures[i];

                for(int j = 0; j < this.humidities.length; ++j) {
                    Climate.Parameter humidity = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, weirdness);
                    ResourceKey<Biome> resourcekey3 = this.pickShatteredBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey4 = this.pickPlateauBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey5 = this.pickBeachBiome(i, j);
                    ResourceKey<Biome> resourcekey6 = this.maybePickWindsweptSavannaBiome(i, j, weirdness, resourcekey);
                    ResourceKey<Biome> resourcekey7 = this.pickShatteredCoastBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey8 = this.pickSlopeBiome(i, j, weirdness);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, resourcekey8);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], weirdness, 0.0F, resourcekey2);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.farInlandContinentalness, this.erosions[1], weirdness, 0.0F, i == 0 ? resourcekey8 : resourcekey4);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.midInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.farInlandContinentalness, this.erosions[2], weirdness, 0.0F, resourcekey4);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], weirdness, 0.0F, resourcekey1);
                    if (weirdness.max() < 0L) {
                        this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[4], weirdness, 0.0F, resourcekey5);
                        this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
                    } else {
                        this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
                    }

                    this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey7);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey3);
                    if (weirdness.max() < 0L) {
                        this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey5);
                    } else {
                        this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey);
                    }

                    if (i == 0) {
                        this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
                    }
                }
            }

        }

        private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
            this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, /*Biomes.STONY_SHORE*/ VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, /*Biomes.SWAMP*/ BAYOU_LOW);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, /*Biomes.MANGROVE_SWAMP*/ BAYOU_LOW);

            for(int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter temperature = this.temperatures[i];

                for(int j = 0; j < this.humidities.length; ++j) {
                    Climate.Parameter humidity = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, weirdness);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, weirdness);
                    ResourceKey<Biome> resourcekey3 = this.pickBeachBiome(i, j);
                    ResourceKey<Biome> resourcekey4 = this.maybePickWindsweptSavannaBiome(i, j, weirdness, resourcekey);
                    ResourceKey<Biome> resourcekey5 = this.pickShatteredCoastBiome(i, j, weirdness);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey2);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), weirdness, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey5);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, resourcekey4);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, resourcekey3);
                    if (i == 0) {
                        this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, resourcekey);
                    }
                }
            }

        }

        private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter weirdness) {
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, weirdness.max() < 0L ? /*Biomes.STONY_SHORE*/ VANILLA : /*Biomes.FROZEN_RIVER*/ VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, weirdness.max() < 0L ? /*Biomes.STONY_SHORE*/ VANILLA : /*Biomes.RIVER*/ VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, /*Biomes.FROZEN_RIVER*/ VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, /*Biomes.RIVER*/ VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, /*Biomes.FROZEN_RIVER*/ VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, /*Biomes.RIVER*/ VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, /*Biomes.FROZEN_RIVER*/ VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, /*Biomes.RIVER*/ VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, /*Biomes.SWAMP*/ VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, /*Biomes.MANGROVE_SWAMP*/ VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, /*Biomes.FROZEN_RIVER*/ VANILLA);

            for(int i = 0; i < this.temperatures.length; ++i) {
                Climate.Parameter temperature = this.temperatures[i];

                for(int j = 0; j < this.humidities.length; ++j) {
                    Climate.Parameter humidity = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiomeOrBadlandsIfHot(i, j, weirdness);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, resourcekey);
                }
            }

        }

        private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
            this.addUndergroundBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, /*Biomes.DRIPSTONE_CAVES*/ VANILLA);
            this.addUndergroundBiome(consumer, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, /*Biomes.LUSH_CAVES*/ VANILLA);
            this.addBottomBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[0], this.erosions[1]), this.FULL_RANGE, 0.0F, /*Biomes.DEEP_DARK*/ VANILLA);
        }

        private ResourceKey<Biome> pickMiddleBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
            if (weirdness.max() < 0L) {
                return this.MIDDLE_BIOMES[temperatureIndex][humidityIndex];
            } else {
                ResourceKey<Biome> $$3 = this.MIDDLE_BIOMES_VARIANT[temperatureIndex][humidityIndex];
                return $$3 == null ? this.MIDDLE_BIOMES[temperatureIndex][humidityIndex] : $$3;
            }
        }

        private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
            return temperatureIndex == 4 ? this.pickBadlandsBiome(humidityIndex, weirdness) : this.pickMiddleBiome(temperatureIndex, humidityIndex, weirdness);
        }

        private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
            return temperatureIndex == 0 ? this.pickSlopeBiome(temperatureIndex, humidityIndex, weirdness) : this.pickMiddleBiomeOrBadlandsIfHot(temperatureIndex, humidityIndex, weirdness);
        }

        private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness, ResourceKey<Biome> resourcekey) {
            return temperatureIndex > 1 && humidityIndex < 4 && weirdness.max() >= 0L ? /*Biomes.WINDSWEPT_SAVANNA*/ VANILLA : resourcekey;
        }

        private ResourceKey<Biome> pickShatteredCoastBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
            ResourceKey<Biome> resourcekey = weirdness.max() >= 0L ? this.pickMiddleBiome(temperatureIndex, humidityIndex, weirdness) : this.pickBeachBiome(temperatureIndex, humidityIndex);
            return this.maybePickWindsweptSavannaBiome(temperatureIndex, humidityIndex, weirdness, resourcekey);
        }

        private ResourceKey<Biome> pickBeachBiome(int temperatureIndex, int humidityIndex) {
            if (temperatureIndex == 0) {
                return /*Biomes.SNOWY_BEACH*/ VANILLA;
            } else {
                return temperatureIndex == 4 ? /*Biomes.DESERT*/ VANILLA : /*Biomes.BEACH*/ VANILLA;
            }
        }

        private ResourceKey<Biome> pickBadlandsBiome(int humidityIndex, Climate.Parameter weirdness) {
            if (humidityIndex < 2) {
                return weirdness.max() < 0L ? /*Biomes.BADLANDS*/ VANILLA : /*Biomes.ERODED_BADLANDS*/ VANILLA;
            } else {
                return humidityIndex < 3 ? /*Biomes.BADLANDS*/ VANILLA : /*Biomes.WOODED_BADLANDS*/ VANILLA;
            }
        }

        private ResourceKey<Biome> pickPlateauBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
            if (weirdness.max() >= 0L) {
                ResourceKey<Biome> $$3 = this.PLATEAU_BIOMES_VARIANT[temperatureIndex][humidityIndex];
                if ($$3 != null) {
                    return $$3;
                }
            }

            return this.PLATEAU_BIOMES[temperatureIndex][humidityIndex];
        }

        private ResourceKey<Biome> pickPeakBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
            if (temperatureIndex <= 2) {
                return weirdness.max() < 0L ? /*Biomes.JAGGED_PEAKS*/ VANILLA : /*Biomes.FROZEN_PEAKS*/ VANILLA;
            } else {
                return temperatureIndex == 3 ? /*Biomes.STONY_PEAKS*/ VANILLA : this.pickBadlandsBiome(humidityIndex, weirdness);
            }
        }

        private ResourceKey<Biome> pickSlopeBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
            if (temperatureIndex >= 3) {
                return this.pickPlateauBiome(temperatureIndex, humidityIndex, weirdness);
            } else {
                return humidityIndex <= 1 ? /*Biomes.SNOWY_SLOPES*/ VANILLA : /*Biomes.GROVE*/ VANILLA;
            }
        }

        private ResourceKey<Biome> pickShatteredBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
            ResourceKey<Biome> resourcekey = this.SHATTERED_BIOMES[temperatureIndex][humidityIndex];
            return resourcekey == null ? this.pickMiddleBiome(temperatureIndex, humidityIndex, weirdness) : resourcekey;
        }

        private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float unused, ResourceKey<Biome> resourcekey) {
            consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), weirdness, unused), resourcekey));
            consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), weirdness, unused), resourcekey));
        }

        private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float unused, ResourceKey<Biome> resourcekey) {
            consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.span(0.2F, 0.9F), weirdness, unused), resourcekey));
        }

        private void addBottomBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float unused, ResourceKey<Biome> resourcekey) {
            consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.1F), weirdness, unused), resourcekey));
        }
    }
}
