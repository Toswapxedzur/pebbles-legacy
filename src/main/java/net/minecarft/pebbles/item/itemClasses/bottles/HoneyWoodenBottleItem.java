package net.minecarft.pebbles.item.itemClasses.bottles;

import com.simibubi.create.AllFluids;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.world.level.block.Block;

public class HoneyWoodenBottleItem extends BottleItem{
    public HoneyWoodenBottleItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties, AllFluids.HONEY.get().getSource(), ModBlocks.WOODENBOTTLE.get(),0);
        EmptyBottleItem.bottleMap.get(ModBlocks.WOODENBOTTLE.get()).put(AllFluids.HONEY.get().getSource(), this.asItem());
    }
}
