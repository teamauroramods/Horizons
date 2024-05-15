package com.teamaurora.horizons.core.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.HorizonsBlockFamilies;
import com.teamaurora.horizons.integration.farmers_delight.HorizonsFDCompat;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public class HorizonsBlockStateProvider extends BlueprintBlockStateProvider {
    public HorizonsBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, Horizons.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.blockFamily(HorizonsBlockFamilies.CYPRESS_PLANKS_FAMILY);
        this.blockFamily(HorizonsBlockFamilies.JACARANDA_PLANKS_FAMILY);
        this.blockFamily(HorizonsBlockFamilies.REDWOOD_PLANKS_FAMILY);

        this.logBlocks(CYPRESS_LOG, CYPRESS_WOOD);
        this.logBlocks(JACARANDA_LOG, JACARANDA_WOOD);
        this.logBlocks(REDWOOD_LOG, REDWOOD_WOOD);

        this.logBlocks(STRIPPED_CYPRESS_LOG, STRIPPED_CYPRESS_WOOD);
        this.logBlocks(STRIPPED_JACARANDA_LOG, STRIPPED_JACARANDA_WOOD);
        this.logBlocks(STRIPPED_REDWOOD_LOG, STRIPPED_REDWOOD_WOOD);

        this.hangingSignBlocks(STRIPPED_CYPRESS_LOG, CYPRESS_HANGING_SIGNS);
        this.hangingSignBlocks(STRIPPED_JACARANDA_LOG, JACARANDA_HANGING_SIGNS);
        this.hangingSignBlocks(STRIPPED_REDWOOD_LOG, REDWOOD_HANGING_SIGNS);

        this.leavesBlocks(CYPRESS_LEAVES, CYPRESS_LEAF_PILE);
        this.leavesBlocks(JACARANDA_LEAVES, JACARANDA_LEAF_PILE);
        this.leavesBlocks(FLOWERING_JACARANDA_LEAVES, FLOWERING_JACARANDA_LEAF_PILE);
        this.leavesBlocks(REDWOOD_LEAVES, REDWOOD_LEAF_PILE);

        this.crossBlockWithPot(FLOWERING_OAK_SAPLING, POTTED_FLOWERING_OAK_SAPLING);
        this.crossBlockWithPot(FLOWERING_JUNGLE_SAPLING, POTTED_FLOWERING_JUNGLE_SAPLING);
        this.crossBlockWithPot(CYPRESS_SAPLING, POTTED_CYPRESS_SAPLING);
        this.crossBlockWithPot(JACARANDA_SAPLING, POTTED_JACARANDA_SAPLING);
        this.crossBlockWithPot(FLOWERING_JACARANDA_SAPLING, POTTED_FLOWERING_JACARANDA_SAPLING);
        this.crossBlockWithPot(REDWOOD_SAPLING, POTTED_REDWOOD_SAPLING);

        this.woodworksBlocks(CYPRESS_PLANKS, CYPRESS_BOARDS, CYPRESS_LADDER, CYPRESS_BOOKSHELF, CYPRESS_BEEHIVE, CYPRESS_CHEST, TRAPPED_CYPRESS_CHEST);
        this.woodworksBlocks(JACARANDA_PLANKS, JACARANDA_BOARDS, JACARANDA_LADDER, JACARANDA_BOOKSHELF, JACARANDA_BEEHIVE, JACARANDA_CHEST, TRAPPED_JACARANDA_CHEST);
        this.woodworksBlocks(REDWOOD_PLANKS, REDWOOD_BOARDS, REDWOOD_LADDER, REDWOOD_BOOKSHELF, REDWOOD_BEEHIVE, REDWOOD_CHEST, TRAPPED_REDWOOD_CHEST);

        //TODO: chiseled bookshelves

        this.cabinet(CYPRESS_CABINET.get());
        this.cabinet(JACARANDA_CABINET.get());
        this.cabinet(REDWOOD_CABINET.get());

        this.directionalBlock(GOOSEBERRY_BASKET);
    }

    private void cabinet(Block cabinet) {
        ResourceLocation registryName = ForgeRegistries.BLOCKS.getKey(cabinet);
        if (registryName != null) {
            ResourceLocation name = this.prefix("block/", registryName);

            ModelFile cabinetModel = models().orientable(name(cabinet), suffix(name, "_side"), suffix(name, "_front"), suffix(name, "_top"));
            ModelFile cabinetOpenModel = models().orientable(name(cabinet) + "_open", suffix(name, "_side"), suffix(name, "_front_open"), suffix(name, "_top"));

            if (BlockSubRegistryHelper.areModsLoaded("farmersdelight")) {
                this.cabinetBlock(cabinet, cabinetModel, cabinetOpenModel);
                this.item(cabinet);
            }
        }
    }

    public void cabinetBlock(Block block, ModelFile cabinet, ModelFile cabinetOpen) {
        this.getVariantBuilder(block)
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(state.getValue(HorizonsFDCompat.cabinetOpenSupplier.get()) ? cabinetOpen : cabinet)
                        .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
                        .build()
                );
    }

    public void item(Block block) {
        this.simpleBlockItem(block, new ModelFile.ExistingModelFile(blockTexture(block), this.models().existingFileHelper));
    }
}
