package net.minecarft.pebbles.item.itemClasses.bottles;

import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;

public class LavaWoodenBottleItem extends BottleItem{
    public LavaWoodenBottleItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties,Fluids.LAVA.getSource(),ModBlocks.WOODENBOTTLE.get(),1);
        EmptyBottleItem.bottleMap.get(ModBlocks.WOODENBOTTLE.get()).put(Fluids.LAVA, this.asItem());
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(!pLevel.isClientSide){
            pEntity.setSecondsOnFire(2);
            if(RandomSource.create().nextInt(10)==1){
                pStack.shrink(1);
                pLevel.playSound(null, pEntity.getOnPos(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1F,1F);
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

}
