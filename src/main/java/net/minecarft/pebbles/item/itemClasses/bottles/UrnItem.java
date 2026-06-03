package net.minecarft.pebbles.item.itemClasses.bottles;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

public class UrnItem extends EmptyBottleItem {
    public UrnItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
        if(!bottleMap.containsKey(this.asItem())) {
            EmptyBottleItem.bottleMap.put(this.asItem(), new HashMap<>());
        }
    }
}
