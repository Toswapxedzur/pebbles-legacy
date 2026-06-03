package net.minecarft.pebbles.structure;

import net.minecarft.pebbles.utility.ModMaps;
import net.minecarft.pebbles.utility.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Triple;

import java.util.HashMap;
import java.util.List;

public class StrengthData {
    public static HashMap<Block, Integer> tension = new HashMap<>();
    public static HashMap<Block, Integer> cohesion = new HashMap<>();
    public static HashMap<Block, Integer> foundation = new HashMap<>();
    /*
    first arg: limit block attachment to a certain face
    second arg: custom tcf value for horizontal placement
     */
//    public static HashMap<Block, List<Boolean>> addition = new HashMap<>();
    public static HashMap<Block, Integer> faceType = new HashMap<>();
    public static HashMap<Block, List<Block>> limitSupport = new HashMap<>();
    public static HashMap<Block, Triple<Integer, Integer, Integer>> horizontal = new HashMap<>();

    public static void registerData(int tension, int cohesion, int foundation, Block... block){
        for(Block pBlock:block) {
            StrengthData.tension.put(pBlock, tension);
            StrengthData.cohesion.put(pBlock, cohesion);
            StrengthData.foundation.put(pBlock, foundation);
            StrengthData.faceType.put(pBlock, -1);
        }
    }

    public static void registerData( int tension, int cohesion, int foundation , Block block, List<Block> limitSupport, int limitFace, Triple<Integer, Integer, Integer> horizontal){
        StrengthData.tension.put(block, tension);
        StrengthData.cohesion.put(block, cohesion);
        StrengthData.foundation.put(block, foundation);
        if(limitSupport!=null) {
            StrengthData.limitSupport.put(block, limitSupport);
        }
        StrengthData.faceType.put(block, limitFace);
        if(horizontal!=null) {
            StrengthData.horizontal.put(block, horizontal);
        }
    }

    public static void registerData(TagKey<Block> blockTag, int tension, int cohesion, int foundation){
        for (Block block : ForgeRegistries.BLOCKS.tags().getTag(blockTag)){
            registerData(tension, cohesion, foundation, block);
        }
    }

    public static void registerWood(){

    }

    static {
        //register block data here
        { //common
            registerData(BlockTags.SLABS, 100, 100, 100);

            registerData(Tags.Blocks.FENCES, 20, 80, 15);

            registerData(BlockTags.FENCE_GATES, 100, 80, 100);

            registerData(BlockTags.WALLS, 22, 75, 12);
        }

        { // wooden
            registerData(BlockTags.PLANKS, 25, 10, 16);

            for (Block pBlock : ForgeRegistries.BLOCKS.tags().getTag(BlockTags.LOGS).stream().toList()) {
                registerData(18, 70, 10, pBlock, null, 1, Triple.of(10, 15, 11));
            }

            registerData(ModTags.Blocks.WOODS, 70, 70, 12);


            for (Block pBlock : ForgeRegistries.BLOCKS.tags().getTag(BlockTags.WOODEN_STAIRS).stream().toList()) {
                registerData(25, 10, 16, pBlock, null, 2, null);
            }

            registerData(BlockTags.WOODEN_TRAPDOORS, 100, 100, 100);

            { //bamboo
                registerData(15, 75, 12, Blocks.BAMBOO_BLOCK, null, 1, Triple.of(9, 15, 12));
                registerData(15, 85, 14, Blocks.STRIPPED_BAMBOO_BLOCK);
                registerData(25,10,16, Blocks.BAMBOO_PLANKS);
                registerData(24, 12, 15, Blocks.BAMBOO_MOSAIC);
                registerData(25,10,16, Blocks.BAMBOO_STAIRS, null, 2, null);
                registerData(24,12,15, Blocks.BAMBOO_MOSAIC_STAIRS, null, 2, null);
            }
        }

        {//stoneware
            registerData(12, 4, 10, Blocks.STONE, Blocks.INFESTED_STONE, Blocks.STONE_STAIRS);
            registerData(10, 3, 8, Blocks.DEEPSLATE, Blocks.INFESTED_DEEPSLATE);
            registerData(15, 10, 12, Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS, Blocks.STONE_BRICK_STAIRS, Blocks.MOSSY_STONE_BRICK_STAIRS, Blocks.CHISELED_STONE_BRICKS);

            registerData(100,100, 8, Blocks.COBBLESTONE, Blocks.INFESTED_COBBLESTONE, Blocks.COBBLESTONE_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS, Blocks.COBBLED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE_STAIRS);
            registerData(12,4, 10, Blocks.CHISELED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_STAIRS);

            registerData(12,12,12, Blocks.SMOOTH_STONE);

            registerData(13, 5, 11, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.GRANITE_STAIRS, Blocks.DIORITE_STAIRS, Blocks.ANDESITE_STAIRS);
            registerData(11, 6, 9, Blocks.POLISHED_GRANITE, Blocks.POLISHED_DIORITE, Blocks.POLISHED_ANDESITE, Blocks.POLISHED_GRANITE_STAIRS, Blocks.POLISHED_DIORITE_STAIRS, Blocks.POLISHED_ANDESITE_STAIRS);

            registerData(12, 6, 6, Blocks.BRICKS, Blocks.BRICK_STAIRS);
            registerData(24, 12, 12, Blocks.MUD_BRICKS, Blocks.MUD_BRICK_STAIRS);

            registerData(35, 18, 12, Blocks.SANDSTONE, Blocks.SANDSTONE_STAIRS, Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE_STAIRS);
            registerData(32, 20, 11, Blocks.CHISELED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, Blocks.SMOOTH_SANDSTONE_STAIRS, Blocks.SMOOTH_RED_SANDSTONE_STAIRS);

            registerData(60, 30, 60, Blocks.SEA_LANTERN);
            registerData(10,6, 3, Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS, Blocks.DARK_PRISMARINE, Blocks.PRISMARINE_STAIRS, Blocks.PRISMARINE_BRICK_STAIRS, Blocks.DARK_PRISMARINE_STAIRS);

            registerData(10, 3, 20, Blocks.NETHERRACK);
            registerData(12, 8, 18, Blocks.NETHER_BRICKS, Blocks.NETHER_BRICK_STAIRS, Blocks.CHISELED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICK_STAIRS);

            registerData(5, 28, 5, Blocks.BASALT);
            registerData(15, 15, 15, Blocks.SMOOTH_BASALT);
            registerData(6, 32, 6, Blocks.POLISHED_BASALT);

            registerData(12, 4, 10, Blocks.BLACKSTONE, Blocks.GILDED_BLACKSTONE, Blocks.BLACKSTONE_STAIRS);
            registerData(12,12,12, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS, Blocks.POLISHED_BLACKSTONE_STAIRS);
        }

        registerData(Tags.Blocks.COBBLESTONE, 100,100,20);

        registerData(BlockTags.BASE_STONE_OVERWORLD, 10,10,10);

        registerData(15, 15, 15, Blocks.SPRUCE_STAIRS, null, 2, null);

        registerData(BlockTags.WALLS, 20,100,12);


        registerData(3, 50, 20, Blocks.CHAIN, null, 1, Triple.of(100, 50, 10));

        for(Block pBlock : ForgeRegistries.BLOCKS.tags().getTag(BlockTags.LEAVES).stream().toList()){
            registerData(25, 25, 25, pBlock, List.of(pBlock, ModMaps.get(ModMaps.LeafToTree, pBlock, Blocks.OAK_LOG)), -1, null);
        }


        registerData(ModTags.Blocks.ANTIGRAVITY, 0, 0, 0);
    }

    public static int getTension(Block pBlock){
        if(!tension.containsKey(pBlock)){
            return 3;
        }
        return tension.get(pBlock);
    }

    public static int getCohesion(Block pBlock){
        if(!cohesion.containsKey(pBlock)){
            return 3;
        }
        return cohesion.get(pBlock);
    }

    public static int getFoundation(Block pBlock){
        if(!foundation.containsKey(pBlock)){
            return 3;
        }
        return foundation.get(pBlock);
    }

    public static boolean hasLimitSupport(Block pBlock){
        return limitSupport.containsKey(pBlock);
    }

    public static List<Block> getLimitSupport(Block pBlock){
        return limitSupport.get(pBlock);
    }

    public static boolean hasHorizontal(Block pBlock){
        return horizontal.containsKey(pBlock);
    }

    public static Triple<Integer, Integer, Integer> getHorizontal(Block pBlock){
        if(!horizontal.containsKey(pBlock)){
            return Triple.of(3,3,3);
        }
        return horizontal.get(pBlock);
    }

    public static int getType(Block pBlock){
        if(!faceType.containsKey(pBlock)){
            return -1;
        }
        return faceType.get(pBlock);
    }
}
