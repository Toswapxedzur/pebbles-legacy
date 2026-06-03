package net.minecarft.pebbles.item.itemClasses.bottles;

import com.simibubi.create.AllFluids;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecarft.pebbles.utility.ModTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class MilkUrnItem extends BottleItem{
    public MilkUrnItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties, ForgeMod.MILK.get(),ModBlocks.URN.get(),0);
        EmptyBottleItem.bottleMap.get(ModBlocks.URN.get()).put(ForgeMod.MILK.get(), this.asItem());
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 16;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide){
            for(MobEffectInstance effect : pEntityLiving.getActiveEffects()){
                effect = new MobEffectInstance(effect.getEffect(), Math.max((effect.getDuration()-15),1), effect.getAmplifier(), effect.isAmbient(), effect.isVisible(), effect.showIcon());
            }
        }
        if (pEntityLiving instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (pEntityLiving instanceof Player player && !((Player)pEntityLiving).getAbilities().instabuild) {
            pStack.shrink(1);
            player.getInventory().add(new ItemStack(ModBlocks.URN.get()));
            player.displayClientMessage(Component.literal("yesss"),false);
        }
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pStack;
    }
}
