package net.minecarft.pebbles.item.itemClasses;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFlintPickaxe extends PickaxeItem {

    public ItemFlintPickaxe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    CompoundTag nbtData = new CompoundTag();

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced){
        //pTooltipComponents.add(Component.translatable("item.pebbles.flint_pickaxe.tooltip.one"));
        if(nbtData.getInt("pebbles.tyingmaterial") == 1){
            pTooltipComponents.add(Component.translatable("item.pebbles.flint_pickaxe.tooltip.one.zero").withStyle(ChatFormatting.WHITE));
        }else if(nbtData.getInt("pebbles.tyingmaterial") == 2){
            pTooltipComponents.add(Component.translatable("item.pebbles.flint_pickaxe.tooltip.one.one").withStyle(ChatFormatting.GREEN));
        }else if(nbtData.getInt("pebbles.tyingmaterial") == 3){
            pTooltipComponents.add(Component.translatable("item.pebbles.flint_pickaxe.tooltip.one.two").withStyle(ChatFormatting.GOLD));
        }else{
            pTooltipComponents.add(Component.translatable("item.pebbles.flint_pickaxe.tooltip.one.none").withStyle(ChatFormatting.RED));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
