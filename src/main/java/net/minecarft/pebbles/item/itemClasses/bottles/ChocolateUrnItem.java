package net.minecarft.pebbles.item.itemClasses.bottles;

import com.simibubi.create.AllFluids;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;

public class ChocolateUrnItem extends BottleItem{
    public ChocolateUrnItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties,AllFluids.CHOCOLATE.get().getSource(), ModBlocks.URN.get(),0);
        EmptyBottleItem.bottleMap.get(ModBlocks.URN.get()).put(AllFluids.CHOCOLATE.get().getSource(), this.asItem());
    }
}
