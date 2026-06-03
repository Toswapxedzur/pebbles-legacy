package net.minecarft.pebbles.item.itemClasses.bottles;

import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;

public class WaterUrnItem extends BottleItem{
    public WaterUrnItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties, Fluids.WATER, ModBlocks.URN.get(),0);
        EmptyBottleItem.bottleMap.get(ModBlocks.URN.get()).put(Fluids.WATER, this.asItem());
    }
}
