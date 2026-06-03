package net.minecarft.pebbles.entity.custom.knifeProjectile;

import net.minecarft.pebbles.entity.ModEntities;
import net.minecarft.pebbles.entity.custom.KnifeProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DiamondKnifeProjectileEntity extends KnifeProjectileEntity {
    public DiamondKnifeProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DiamondKnifeProjectileEntity(LivingEntity pShooter, Level pLevel, ItemStack knifeType) {
        super(pShooter, pLevel, knifeType, ModEntities.DIAMONDKNIFEPROJECTILE.get());
    }

    @Override
    public int getProjectileDamage() {
        return 8;
    }
}
