package net.minecarft.pebbles.creativeTab;

import net.minecarft.pebbles.block.ModBlocks;
import net.minecarft.pebbles.item.ModMoreItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class addToExistingCreativeTab {
    public static void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModMoreItems.STURDYROCK);
            event.accept(ModMoreItems.UNFIREDSTURDYROCK);
            event.accept(ModMoreItems.CLAYBIT);
            event.accept(ModMoreItems.COBBLE);
            event.accept(ModMoreItems.FIBER);
            event.accept(ModMoreItems.FIBERSTRING);
            event.accept(ModMoreItems.STONEBRICK);
            event.accept(ModMoreItems.LEATHERSTRING);
            event.accept(ModBlocks.URN);
            event.accept(ModBlocks.WATERURN);
            event.accept(ModBlocks.HONEYURN);
            event.accept(ModBlocks.CHOCOLATEURN);
            event.accept(ModBlocks.MILKURN);
            event.accept(ModBlocks.LAVAURN);
            event.accept(ModBlocks.WOODENBOTTLE);
            event.accept(ModBlocks.WATERWOODENBOTTLE);
            event.accept(ModBlocks.CHOCOLATEWOODENBOTTLE);
            event.accept(ModBlocks.HONEYWOODENBOTTLE);
            event.accept(ModBlocks.MILKWOODENBOTTLE);
            event.accept(ModBlocks.LAVAWOODENBOTTLE);
            event.accept(ModMoreItems.GROUTBUCKET);
            event.accept(ModBlocks.STURDYTANK);
            event.accept(ModMoreItems.PROCELAIN);
            event.accept(ModMoreItems.QUARTZDUST);
            event.accept(ModMoreItems.ROPE);
            event.accept(ModMoreItems.STRAW);
            event.accept(ModMoreItems.TREEBARK);
            event.accept(ModMoreItems.WOODCHIPS);
            event.accept(ModBlocks.CLAYBRICKSHAPED);
        }else if(event.getTabKey() == CreativeModeTabs.COMBAT){
            event.accept(ModMoreItems.STURDYSWORD);
            event.accept(ModMoreItems.STURDYHELMET);
            event.accept(ModMoreItems.STURDYCHESTPLATE);
            event.accept(ModMoreItems.STURDYLEGGINGS);
            event.accept(ModMoreItems.STURDYBOOTS);
            event.accept(ModMoreItems.FLINTSWORD);
        }else if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModMoreItems.STURDYPICKAXE);
            event.accept(ModMoreItems.STURDYAXE);
            event.accept(ModMoreItems.STURDYSHOVEL);
            event.accept(ModMoreItems.STURDYHOE);
            event.accept(ModMoreItems.FLINTPICKAXE);
            event.accept(ModMoreItems.FLINTAXE);
            event.accept(ModMoreItems.FLINTSHOVEL);
            event.accept(ModMoreItems.FLINTHOE);

            event.accept(ModMoreItems.FLINTKNIFE);
            event.accept(ModMoreItems.STURDYKNIFE);
            event.accept(ModMoreItems.STONEKNIFE);
            event.accept(ModMoreItems.IRONKNIFE);
            event.accept(ModMoreItems.DIAMONDKNIFE);
            event.accept(ModMoreItems.NETHERITEKNIFE);

            event.accept(ModMoreItems.FLINTHATCHET);
            event.accept(ModMoreItems.STURDYHATCHET);
            event.accept(ModMoreItems.STONEHATCHET);
            event.accept(ModMoreItems.IRONHATCHET);
            event.accept(ModMoreItems.DIAMONDHATCHET);
            event.accept(ModMoreItems.NETHERITEHATCHET);
        }else if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.STURDYROCKBLOCK.get());
            event.accept(ModBlocks.STURDYBRICKSTAIRS);
            event.accept(ModBlocks.STURDYBRICKSLAB);
            event.accept(ModBlocks.STURDYBRICKWALL);
            event.accept(ModBlocks.STURDYBRICKS);
        }else if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
            event.accept(ModBlocks.FLUID_HOPPER_BLOCK);
        }
    }
}
