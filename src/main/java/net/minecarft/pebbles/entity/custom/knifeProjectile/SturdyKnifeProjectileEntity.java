package net.minecarft.pebbles.entity.custom.knifeProjectile;

import net.minecarft.pebbles.entity.ModEntities;
import net.minecarft.pebbles.entity.custom.KnifeProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SturdyKnifeProjectileEntity extends KnifeProjectileEntity {
    public SturdyKnifeProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SturdyKnifeProjectileEntity(LivingEntity pShooter, Level pLevel, ItemStack knifeType) {
        super(pShooter, pLevel, knifeType, ModEntities.STURDYKNIFEPROJECTILE.get());
    }

    @Override
    public int getProjectileDamage() {
        return 5;
    }
}
