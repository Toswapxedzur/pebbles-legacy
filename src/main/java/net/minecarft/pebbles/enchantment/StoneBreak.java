package net.minecarft.pebbles.enchantment;

import net.minecarft.pebbles.item.itemClasses.KnifeItem;
import net.minecarft.pebbles.utility.ModTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.MendingEnchantment;

public class StoneBreak extends Enchantment {
    public static final EnchantmentCategory ADVANCEKNIFE = EnchantmentCategory.create("ADVANCEKNIFE", item -> (item instanceof KnifeItem));
    protected StoneBreak(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, ADVANCEKNIFE , pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 90;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return 120;
    }

    public boolean isTreasureOnly() {
        return true;
    }
}
