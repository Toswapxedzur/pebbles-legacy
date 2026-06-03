package net.minecarft.pebbles.mixin.EnchantmentsMixin;

import net.minecarft.pebbles.item.itemClasses.KnifeItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.TridentLoyaltyEnchantment;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TridentLoyaltyEnchantment.class)
public class LoyaltyEnchantmentMixin extends Enchantment {
    protected LoyaltyEnchantmentMixin(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof TridentItem || pStack.getItem() instanceof KnifeItem || super.canEnchant(pStack);
    }
}