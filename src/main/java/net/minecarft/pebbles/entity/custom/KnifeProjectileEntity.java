package net.minecarft.pebbles.entity.custom;

import net.minecarft.pebbles.item.ModMoreItems;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class KnifeProjectileEntity extends AbstractArrow {
    private float rot;
    public Vec2 groundOffset;
    public ItemStack knifeItem = new ItemStack(ModMoreItems.FLINTKNIFE.get());
    public boolean loyal;
    private boolean dealtDamage;

    public KnifeProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public KnifeProjectileEntity(LivingEntity pShooter, Level pLevel, ItemStack knifeType, EntityType<? extends KnifeProjectileEntity> knifeEntity) {
        super(knifeEntity, pShooter, pLevel);
        this.knifeItem = knifeType;
        this.rot=0;
        this.loyal = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.LOYALTY, knifeType)>0;
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.knifeItem.copy();
    }

    public boolean isGrounded(){
        return inGround;
    }

    public int getProjectileDamage(){
        return 1;
    }

    public boolean isFoil() {
        return this.knifeItem.hasFoil();
    }

    public float getRot(){
        if(!isGrounded()) {
            rot += 20F;
        }
        return rot;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
//        super.onHitEntity(pResult);
        ((Player)this.getOwner()).displayClientMessage(Component.literal(knifeItem.toString()), false);
        Entity entity = pResult.getEntity();
        Entity owner = this.getOwner();
        DamageSource damagesource = this.damageSources().thrown(this, owner);
        SoundEvent soundEvent = SoundEvents.METAL_HIT;
        float f = getProjectileDamage();
        if (entity instanceof LivingEntity livingentity) {
            f += EnchantmentHelper.getDamageBonus(knifeItem, livingentity.getMobType());
        }
        if (entity.hurt(damagesource, f)){
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity) {
                LivingEntity livingentity1 = (LivingEntity)entity;
                if (owner instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingentity1, owner);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)owner, livingentity1);
                }
                this.doPostHurtEffects(livingentity1);
            }
        }
        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));

        this.playSound(soundEvent);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        Item tool = this.knifeItem.getItem();
        Level world = this.level();
        BlockState state = world.getBlockState(pResult.getBlockPos());
        SoundEvent soundEvent = SoundEvents.STONE_BREAK;
        if(!world.isClientSide) {
            if (tool.isCorrectToolForDrops(state)) {
                world.destroyBlock(pResult.getBlockPos(), true);
                this.knifeItem.hurtAndBreak(5, (Player) this.getOwner(), entity->entity.broadcastBreakEvent(InteractionHand.MAIN_HAND));
            }
            this.knifeItem.hurtAndBreak(2, (Player) this.getOwner(), entity->entity.broadcastBreakEvent(InteractionHand.MAIN_HAND));
        }

        this.playSound(soundEvent);
    }

    protected boolean tryPickup(Player pPlayer) {
        return (super.tryPickup(pPlayer) && (!loyal)) || this.ownedBy(pPlayer) ;
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }
        Entity entity = this.getOwner();
        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.LOYALTY, this.knifeItem);
        if (i > 1 && (this.dealtDamage||this.isNoPhysics()) && entity != null) {
            this.setNoPhysics(true);
            Vec3 vec3 = entity.getEyePosition().subtract(this.position());
            this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.005D * (double) i, this.getZ());
            if (this.level().isClientSide) {
                this.yOld = this.getY();
            }

            double d0 = 0.02D * (double) i;
            this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(vec3.normalize().scale(d0)));
        }
        super.tick();
    }
}
