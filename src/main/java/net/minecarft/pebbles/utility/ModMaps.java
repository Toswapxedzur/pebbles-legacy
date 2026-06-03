package net.minecarft.pebbles.utility;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModMaps {
    public static final Map<Block, Block> LeafToTree = Map.ofEntries(
            Map.entry(Blocks.OAK_LEAVES, Blocks.OAK_LOG),
            Map.entry(Blocks.BIRCH_LEAVES, Blocks.BIRCH_LOG),
            Map.entry(Blocks.SPRUCE_LEAVES, Blocks.SPRUCE_LOG),
            Map.entry(Blocks.ACACIA_LEAVES, Blocks.ACACIA_LOG),
            Map.entry(Blocks.DARK_OAK_LEAVES, Blocks.DARK_OAK_LOG),
            Map.entry(Blocks.JUNGLE_LEAVES, Blocks.JUNGLE_LOG),
            Map.entry(Blocks.MANGROVE_LEAVES, Blocks.MANGROVE_LOG),
            Map.entry(Blocks.CHERRY_LEAVES, Blocks.CHERRY_LOG),
            Map.entry(Blocks.WARPED_STEM, Blocks.WARPED_WART_BLOCK),
            Map.entry(Blocks.CRIMSON_STEM, Blocks.NETHER_WART_BLOCK)
            );

    public static <T, V> V get(Map<T, V> map, T input, V fallBack){
        if(!map.containsKey(input)){
            return fallBack;
        }
        return map.get(input);
    }

}
