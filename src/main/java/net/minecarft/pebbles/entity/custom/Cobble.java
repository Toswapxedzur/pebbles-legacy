package net.minecarft.pebbles.entity.custom;

import net.minecarft.pebbles.entity.ModEntities;
import net.minecarft.pebbles.item.ModMoreItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Cobble extends ThrowableItemProjectile {
    public Cobble(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public Cobble(Level pLevel) {
        super(ModEntities.COBBLE.get(), pLevel);
    }

    public Cobble(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.COBBLE.get(), livingEntity ,pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModMoreItems.COBBLE.get();
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (ParticleOptions)(itemstack.isEmpty() ? ParticleTypes.ASH : new ItemParticleOption(ParticleTypes.ITEM, itemstack));
    }

    public void handleEntityEvent(byte pId) {
        if (pId == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        if(entity instanceof LivingEntity livingEntity) {
            entity.hurt(this.damageSources().thrown(this, this.getOwner()), 4F);
            if (RandomSource.create().nextInt(5) == 1) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5));
            }
        }
    }

    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
        this.level().playSound((Player) null ,pResult.getLocation().x, pResult.getLocation().y, pResult.getLocation().z, SoundEvents.STONE_BREAK, SoundSource.AMBIENT, 5F, 1F);
    }
}
