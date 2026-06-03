package net.minecarft.pebbles.mixin;

import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

import static java.lang.Math.max;

@Mixin(BlockBehaviour.Properties.class)
public class MixinBlockProperties{
    @ModifyVariable(method = "strength(FF)Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", at = @At("HEAD"), ordinal = 0)
    public float inject(float pDestroyTime){
        return max(pDestroyTime*15f, 1.5f);
    }
    @Redirect(method = "instabreak", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;strength(F)Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"))
    public BlockBehaviour.Properties inject2(BlockBehaviour.Properties instance, float pStrength){
        return instance.strength(0.1f, pStrength);
    }
}
