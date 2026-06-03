package net.minecarft.pebbles.mixin.EnchantmentsMixin;

import net.minecarft.pebbles.item.itemClasses.KnifeItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.KnockbackEnchantment;
import net.minecraft.world.item.enchantment.SweepingEdgeEnchantment;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(KnockbackEnchantment.class)
public class KnockBackEnchantmentMixin extends Enchantment {
    protected KnockBackEnchantmentMixin(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof KnifeItem || super.canEnchant(pStack);
    }
}