package com.teamaurora.horizons.core.data.server.modifiers;

import com.teamabnormals.blueprint.common.advancement.modification.AdvancementModifierProvider;
import com.teamabnormals.blueprint.common.advancement.modification.modifiers.CriteriaModifier;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class HorizonsAdvancementModifierProvider extends AdvancementModifierProvider {

    public HorizonsAdvancementModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(Horizons.MOD_ID, output, provider);
    }

    @Override
    protected void registerEntries(HolderLookup.Provider provider) {
        CriteriaModifier.Builder balancedDiet = CriteriaModifier.builder(this.modId);
        HorizonsItems.HELPER.getDeferredRegister().getEntries().forEach(registryObject -> {
            Item item = registryObject.get();
            if (item.isEdible()) {
                balancedDiet.addCriterion(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(item));
            }
        });
        this.entry("husbandry/balanced_diet").selects("husbandry/balanced_diet").addModifier(balancedDiet.requirements(RequirementsStrategy.AND).build());

        CriteriaModifier.Builder adventuringTime = CriteriaModifier.builder(this.modId);
        for (ResourceKey<Biome> biome : List.of(HorizonsBiomes.BAYOU)) {
            adventuringTime.addCriterion(biome.location().toString(), PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(biome)));
        }
        this.entry("adventure/adventuring_time").selects("adventure/adventuring_time").addModifier(adventuringTime.requirements(RequirementsStrategy.AND).build());
    }
}
