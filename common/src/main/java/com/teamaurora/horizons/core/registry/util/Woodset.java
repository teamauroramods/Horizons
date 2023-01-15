package com.teamaurora.horizons.core.registry.util;

import com.teamaurora.horizons.common.block.base.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

/**
 * @author Steven
 * @author Exoplanetary
 */
public record Woodset(MaterialColor logColor, MaterialColor woodColor) {
    private static Boolean never(BlockState arg, BlockGetter arg2, BlockPos arg3, EntityType<?> arg4) {
        return false;
    }

    private RotatedPillarBlock baseLog(MaterialColor arg, MaterialColor arg2) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (arg3) -> arg3.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? arg : arg2).strength(2.0F).sound(SoundType.WOOD));
    }

    private RotatedPillarBlock baseWood(MaterialColor arg) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, arg).strength(2.0F).sound(SoundType.WOOD));
    }

    public Supplier<Block> log() {
        return () -> baseLog(woodColor, logColor);
    }

    public Supplier<Block> wood() {
        return () -> baseWood(logColor);
    }

    public Supplier<Block> strippedLog() {
        return () -> baseLog(woodColor, woodColor);
    }

    public Supplier<Block> strippedWood() {
        return () -> baseWood(woodColor);
    }

    public Supplier<Block> planks() {
        return () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, woodColor).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }

    public Supplier<Block> slab() {
        return () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, woodColor).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }

    public Supplier<Block> stairs(Supplier<Block> planks) {
        return () -> new HorizonStairBlock(planks.get().defaultBlockState(), BlockBehaviour.Properties.copy(planks.get()));
    }

    public Supplier<Block> pressurePlate() {
        return () -> new HorizonPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, woodColor).noCollission().strength(0.5F).sound(SoundType.WOOD));
    }

    public Supplier<Block> button() {
        return () -> new HorizonWoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD));
    }

    public Supplier<Block> fence() {
        return () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, woodColor).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }

    public Supplier<Block> fenceGate() {
        return () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, woodColor).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }

    public Supplier<Block> door() {
        return () -> new HorizonDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, woodColor).strength(3.0F).sound(SoundType.WOOD).noOcclusion());
    }

    public Supplier<Block> trapdoor() {
        return () -> new HorizonTrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, woodColor).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(Woodset::never));
    }
}