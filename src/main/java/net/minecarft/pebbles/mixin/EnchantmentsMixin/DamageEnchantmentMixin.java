package net.minecarft.pebbles.mixin.EnchantmentsMixin;

import net.minecarft.pebbles.item.itemClasses.KnifeItem;
import net.minecarft.pebbles.utility.ModTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin extends Enchantment {
    protected DamageEnchantmentMixin(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }
    /**
     * @author
     * @reason
     */
    @Overwrite
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof AxeItem || pStack.getItem() instanceof KnifeItem || super.canEnchant(pStack);
    }
}