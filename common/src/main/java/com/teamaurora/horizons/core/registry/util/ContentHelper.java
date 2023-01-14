package com.teamaurora.horizons.core.registry.util;

import com.teamaurora.horizons.core.registry.HorizonBlocks;
import gg.moonflower.pollen.api.registry.client.RenderTypeRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public final class ContentHelper {

    private static Boolean never(BlockState arg, BlockGetter arg2, BlockPos arg3, EntityType<?> arg4) {
        return false;
    }

    private static Supplier<Block> createFlowerPot(Supplier<Block> block) {
        return () -> new FlowerPotBlock(block.get(), HorizonBlocks.Properties.POTTED_PLANT);
    }

    public record WoodsetRecord(Supplier<Block> log, Supplier<Block> wood, Supplier<Block> planks, Supplier<Block> slab,
                                Supplier<Block> stairs, Supplier<Block> pressurePlate, Supplier<Block> button, Supplier<Block> fence,
                                Supplier<Block> fenceGate, Supplier<Block> door, Supplier<Block> trapdoor, Supplier<Block> leaves, Supplier<Block> sapling, Supplier<Block> pottedSapling) {

        public void clientSetup(boolean transparentDoor, boolean transparentTrapdoor) {
            RenderTypeRegistry.register(this.sapling().get(), RenderType.cutout());
            RenderTypeRegistry.register(this.pottedSapling().get(), RenderType.cutout());
            if (transparentDoor)
                RenderTypeRegistry.register(this.door().get(), RenderType.cutoutMipped());
            if (transparentTrapdoor)
                RenderTypeRegistry.register(this.trapdoor().get(), RenderType.cutoutMipped());
        }

        public void commonSetup() {

        }
    }
}
