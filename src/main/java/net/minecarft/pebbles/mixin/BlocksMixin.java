package net.minecarft.pebbles.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Blocks.class)
public abstract class BlocksMixin {
    @Redirect(method = "log(Lnet/minecraft/world/level/material/MapColor;Lnet/minecraft/world/level/material/MapColor;)Lnet/minecraft/world/level/block/RotatedPillarBlock;", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"))
    private static BlockBehaviour.Properties inject2(){
        return BlockBehaviour.Properties.of().requiresCorrectToolForDrops();
    }
    @Redirect(method = "log(Lnet/minecraft/world/level/material/MapColor;Lnet/minecraft/world/level/material/MapColor;Lnet/minecraft/world/level/block/SoundType;)Lnet/minecraft/world/level/block/RotatedPillarBlock;", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"))
    private static BlockBehaviour.Properties inject3(){
        return BlockBehaviour.Properties.of().requiresCorrectToolForDrops();
    }

}
