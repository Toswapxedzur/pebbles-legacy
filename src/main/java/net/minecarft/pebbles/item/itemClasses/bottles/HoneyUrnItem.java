package net.minecarft.pebbles.item.itemClasses.bottles;

import com.simibubi.create.AllFluids;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.world.level.block.Block;

public class HoneyUrnItem extends BottleItem{
    public HoneyUrnItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties, AllFluids.HONEY.get().getSource(), ModBlocks.URN.get(),0);
        EmptyBottleItem.bottleMap.get(ModBlocks.URN.get()).put(AllFluids.HONEY.get().getSource(), this.asItem());
    }
}
