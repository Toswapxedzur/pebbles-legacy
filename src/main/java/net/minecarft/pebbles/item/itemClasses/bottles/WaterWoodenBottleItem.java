package net.minecarft.pebbles.item.itemClasses.bottles;

import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;

public class WaterWoodenBottleItem extends BottleItem{
    public WaterWoodenBottleItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties, Fluids.WATER, ModBlocks.WOODENBOTTLE.get(),0);
        EmptyBottleItem.bottleMap.get(ModBlocks.WOODENBOTTLE.get()).put(Fluids.WATER, this.asItem());
    }
}
