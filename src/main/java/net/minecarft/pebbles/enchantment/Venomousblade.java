package net.minecarft.pebbles.enchantment;

import net.minecarft.pebbles.item.itemClasses.KnifeItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Venomousblade extends Enchantment {
    public static final EnchantmentCategory KNIFE = EnchantmentCategory.create("KNIFE", item -> (item instanceof KnifeItem));
    public Venomousblade(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, KNIFE, pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 20 + 20 * (pEnchantmentLevel - 1);
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return super.getMinCost(pEnchantmentLevel) + 50;
    }

    public int getMaxLevel() {
        return 5;
    }

    //Inflict poison to target upon stab
    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if(!pAttacker.level().isClientSide){
            if (pTarget instanceof LivingEntity livingEntity){
                switch (pLevel){
                    case 1:
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 20, 1));
                        break;
                    case 2:
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 1));
                        break;
                    case 3:
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1));
                        break;
                    case 4:
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 2));
                        break;
                    default:
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 140, 2));
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
