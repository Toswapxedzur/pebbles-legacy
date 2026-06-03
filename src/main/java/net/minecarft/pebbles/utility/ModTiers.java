package net.minecarft.pebbles.utility;

import net.minecarft.pebbles.item.ModMoreItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ModTiers {
    public static final Tier FLINT = new Tier() {
        @Override
        public int getUses() {
            return 26;
        }

        @Override
        public float getSpeed() {
            return 1F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 0F;
        }

        @Override
        public int getLevel() {
            return 0;
        }

        @Override
        public int getEnchantmentValue() {
            return 12;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.FLINT);
        }
    };

    public static final Tier STURDY = new Tier() {
        @Override
        public int getUses() {
            return 143;
        }

        @Override
        public float getSpeed() {
            return 2.5F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 1F;
        }

        @Override
        public int getLevel() {
            return 1;
        }

        @Override
        public int getEnchantmentValue() {
            return 6;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(ModMoreItems.STURDYROCK.get());
        }
    };
}
