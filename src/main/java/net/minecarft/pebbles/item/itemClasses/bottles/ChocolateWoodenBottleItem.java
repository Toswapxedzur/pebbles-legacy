package net.minecarft.pebbles.item.itemClasses.bottles;

import com.simibubi.create.AllFluids;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.world.level.block.Block;

public class ChocolateWoodenBottleItem extends BottleItem{
    public ChocolateWoodenBottleItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties,AllFluids.CHOCOLATE.get().getSource(), ModBlocks.WOODENBOTTLE.get(),0);
        EmptyBottleItem.bottleMap.get(ModBlocks.WOODENBOTTLE.get()).put(AllFluids.CHOCOLATE.get().getSource(), this.asItem());
    }
}
