package net.minecarft.pebbles.item.itemClasses.bottles;

import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeMod;

public class LavaUrnItem extends BottleItem{
    public LavaUrnItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties,Fluids.LAVA.getSource(),ModBlocks.URN.get(),1);
        EmptyBottleItem.bottleMap.get(ModBlocks.URN.get()).put(Fluids.LAVA, this.asItem());
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(!pLevel.isClientSide){
            pEntity.setSecondsOnFire(1);
            if(RandomSource.create().nextInt(100)==1){
                pStack.shrink(1);
                pLevel.playSound(null, pEntity.getOnPos(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1F,1F);
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

}
