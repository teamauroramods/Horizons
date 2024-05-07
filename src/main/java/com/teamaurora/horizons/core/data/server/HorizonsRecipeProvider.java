package com.teamaurora.horizons.core.data.server;

import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import com.teamabnormals.boatload.core.data.server.BoatloadRecipeProvider;
import com.teamabnormals.woodworks.core.data.server.WoodworksRecipeProvider;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.HorizonsBlockFamilies;
import com.teamaurora.horizons.core.other.tags.HorizonsItemTags;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import com.teamaurora.horizons.integration.boatload.HorizonsBoatTypes;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.function.Consumer;

import static com.teamabnormals.woodworks.core.data.server.WoodworksRecipeProvider.leafPileRecipes;
import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public class HorizonsRecipeProvider extends BlueprintRecipeProvider {
    public HorizonsRecipeProvider(PackOutput packOutput) {
        super(Horizons.MOD_ID, packOutput);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ALGAE_THATCH.get(), 4).define('#', ALGAE.get()).pattern("##").pattern("##").unlockedBy(getHasName(ALGAE.get()), has(ALGAE.get())).save(consumer);
        generateRecipes(consumer, HorizonsBlockFamilies.ALGAE_THATCH_FAMILY);

        generateRecipes(consumer, HorizonsBlockFamilies.CYPRESS_PLANKS_FAMILY);
        planksFromLogs(consumer, CYPRESS_PLANKS.get(), HorizonsItemTags.CYPRESS_LOGS, 4);
        woodFromLogs(consumer, CYPRESS_WOOD.get(), CYPRESS_LOG.get());
        woodFromLogs(consumer, STRIPPED_CYPRESS_WOOD.get(), STRIPPED_CYPRESS_LOG.get());
        hangingSign(consumer, CYPRESS_HANGING_SIGNS.getFirst().get(), STRIPPED_CYPRESS_LOG.get());
        leafPileRecipes(consumer, CYPRESS_LEAVES.get(), CYPRESS_LEAF_PILE.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, HANGING_CYPRESS_LEAVES.get(), 3).define('#', CYPRESS_LEAVES.get()).pattern("#").pattern("#").pattern("#").unlockedBy(getHasName(CYPRESS_LEAVES.get()), has(CYPRESS_LEAVES.get())).save(consumer);

        generateRecipes(consumer, HorizonsBlockFamilies.JACARANDA_PLANKS_FAMILY);
        planksFromLogs(consumer, JACARANDA_PLANKS.get(), HorizonsItemTags.JACARANDA_LOGS, 4);
        woodFromLogs(consumer, JACARANDA_WOOD.get(), JACARANDA_LOG.get());
        woodFromLogs(consumer, STRIPPED_JACARANDA_WOOD.get(), STRIPPED_JACARANDA_LOG.get());
        hangingSign(consumer, JACARANDA_HANGING_SIGNS.getFirst().get(), STRIPPED_JACARANDA_LOG.get());
        leafPileRecipes(consumer, JACARANDA_LEAVES.get(), JACARANDA_LEAF_PILE.get());

        generateRecipes(consumer, HorizonsBlockFamilies.REDWOOD_PLANKS_FAMILY);
        planksFromLogs(consumer, REDWOOD_PLANKS.get(), HorizonsItemTags.REDWOOD_LOGS, 4);
        woodFromLogs(consumer, REDWOOD_WOOD.get(), REDWOOD_LOG.get());
        woodFromLogs(consumer, STRIPPED_REDWOOD_WOOD.get(), STRIPPED_REDWOOD_LOG.get());
        hangingSign(consumer, REDWOOD_HANGING_SIGNS.getFirst().get(), STRIPPED_REDWOOD_LOG.get());
        leafPileRecipes(consumer, REDWOOD_LEAVES.get(), REDWOOD_LEAF_PILE.get());

        BoatloadRecipeProvider.boatRecipes(consumer, HorizonsBoatTypes.CYPRESS);
        WoodworksRecipeProvider.baseRecipes(consumer, CYPRESS_PLANKS.get(), CYPRESS_SLAB.get(), CYPRESS_BOARDS.get(), CYPRESS_BOOKSHELF.get(), CHISELED_CYPRESS_BOOKSHELF.get(), CYPRESS_LADDER.get(), CYPRESS_BEEHIVE.get(), CYPRESS_CHEST.get(), TRAPPED_CYPRESS_CHEST.get(), Horizons.MOD_ID);
        WoodworksRecipeProvider.sawmillRecipes(consumer, HorizonsBlockFamilies.CYPRESS_PLANKS_FAMILY, HorizonsItemTags.CYPRESS_LOGS, CYPRESS_BOARDS.get(), CYPRESS_LADDER.get(), Horizons.MOD_ID);

        BoatloadRecipeProvider.boatRecipes(consumer, HorizonsBoatTypes.JACARANDA);
        WoodworksRecipeProvider.baseRecipes(consumer, JACARANDA_PLANKS.get(), JACARANDA_SLAB.get(), JACARANDA_BOARDS.get(), JACARANDA_BOOKSHELF.get(), CHISELED_JACARANDA_BOOKSHELF.get(), JACARANDA_LADDER.get(), JACARANDA_BEEHIVE.get(), JACARANDA_CHEST.get(), TRAPPED_JACARANDA_CHEST.get(), Horizons.MOD_ID);
        WoodworksRecipeProvider.sawmillRecipes(consumer, HorizonsBlockFamilies.JACARANDA_PLANKS_FAMILY, HorizonsItemTags.JACARANDA_LOGS, JACARANDA_BOARDS.get(), JACARANDA_LADDER.get(), Horizons.MOD_ID);

        BoatloadRecipeProvider.boatRecipes(consumer, HorizonsBoatTypes.REDWOOD);
        WoodworksRecipeProvider.baseRecipes(consumer, REDWOOD_PLANKS.get(), REDWOOD_SLAB.get(), REDWOOD_BOARDS.get(), REDWOOD_BOOKSHELF.get(), CHISELED_REDWOOD_BOOKSHELF.get(), REDWOOD_LADDER.get(), REDWOOD_BEEHIVE.get(), REDWOOD_CHEST.get(), TRAPPED_REDWOOD_CHEST.get(), Horizons.MOD_ID);
        WoodworksRecipeProvider.sawmillRecipes(consumer, HorizonsBlockFamilies.REDWOOD_PLANKS_FAMILY, HorizonsItemTags.REDWOOD_LOGS, REDWOOD_BOARDS.get(), REDWOOD_LADDER.get(), Horizons.MOD_ID);

        conditionalStorageRecipes(consumer, new ModLoadedCondition("berry_good"), RecipeCategory.FOOD, HorizonsItems.GOOSEBERRIES.get(), RecipeCategory.BUILDING_BLOCKS, GOOSEBERRY_BASKET.get());
    }
}
