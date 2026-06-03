package net.minecarft.pebbles.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.extensions.IForgePlayer;
import net.minecraftforge.event.ForgeEventFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import javax.annotation.Nullable;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity{
    protected PlayerMixin(EntityType<? extends LivingEntity> pEntityType, Level pLevel, Inventory inventory) {
        super(pEntityType, pLevel);
        this.inventory = inventory;
    }

    @Shadow
    private final Inventory inventory;

    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public float getDigSpeed(BlockState pState, @Nullable BlockPos pos) {
        float f = this.inventory.getDestroySpeed(pState);
        if (f > 1.0F) {
            int i = EnchantmentHelper.getBlockEfficiency(this);
            ItemStack itemstack = this.getMainHandItem();
            if (i > 0 && !itemstack.isEmpty()) {
                f += ((float)(i * i)) / 5f;
            }
        }

        if (MobEffectUtil.hasDigSpeed(this)) {
            f *= 1.0F + (float)(MobEffectUtil.getDigSpeedAmplification(this) + 1) * 0.1F;
        }

        if (this.hasEffect(MobEffects.DIG_SLOWDOWN)) {
            float f1;
            switch (this.getEffect(MobEffects.DIG_SLOWDOWN).getAmplifier()) {
                case 0:
                    f1 = 0.3F;
                    break;
                case 1:
                    f1 = 0.09F;
                    break;
                case 2:
                    f1 = 0.0027F;
                    break;
                case 3:
                default:
                    f1 = 8.1E-4F;
            }

            f *= f1;
        }

        if (this.isEyeInFluid(FluidTags.WATER) && !EnchantmentHelper.hasAquaAffinity(this)) {
            f /= 5.0F;
        }

        if (!this.onGround()) {
            f /= 2.0F;
        }

        f = ForgeEventFactory.getBreakSpeed((Player) (Object)this, pState, f, pos);
        return f;
    }

//    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 20))
//    private static int inject(int pMax){
//        return 6;
//    }
//    @ModifyConstant(method = "createAttributes", constant = @Constant(floatValue = 0.1F))
//    private static float inject2(float pMovement){
//        return 0.01F;
//    }
}
