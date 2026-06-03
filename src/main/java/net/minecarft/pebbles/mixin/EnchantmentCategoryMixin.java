package net.minecarft.pebbles.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantmentCategory.class)
public class EnchantmentCategoryMixin {
    //@Redirect(method = "canEnchant", @At(value = "INVOKE", target = ""))
}
