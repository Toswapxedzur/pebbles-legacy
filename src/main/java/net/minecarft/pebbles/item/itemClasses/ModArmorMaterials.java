package net.minecarft.pebbles.item.itemClasses;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.item.ModMoreItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    STURDY("sturdy", 30, 5, SoundEvents.AMETHYST_BLOCK_PLACE, 1f, 0.5f, ()->Ingredient.of(ModMoreItems.STURDYROCK.get()),new int[]{3,5,4,2});

    private final String name;
    private final int durabilityMultiplier;
    private final int enchant;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackRes;
    private final Supplier<Ingredient> repairItem;
    private final int[] protectionAmounts;

    public static final int[] BASE_DURABILITY = {11,16,15,13};

    ModArmorMaterials(String name, int durabilityMultiplier, int enchant, SoundEvent equipSound, float toughness, float knockbackRes, Supplier<Ingredient> repairItem, int[] protectionAmounts) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.enchant = enchant;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackRes = knockbackRes;
        this.repairItem = repairItem;
        this.protectionAmounts = protectionAmounts;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()]*durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchant;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairItem.get();
    }

    @Override
    public String getName() {
        return Pebbles.MODID+":"+this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackRes;
    }
}
