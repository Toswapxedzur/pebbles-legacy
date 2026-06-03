package net.minecarft.pebbles.utility;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> ANTIGRAVITY = BlockTags.create(ResourceLocation.tryBuild("minecraft", "antigravity"));
        public static final TagKey<Block> WOODS = BlockTags.create(ResourceLocation.tryBuild("minecraft", "woods"));
        public static final TagKey<Block> CARVEDSTONE = BlockTags.create(ResourceLocation.tryBuild("minecraft", "carved_stone"));
        public static final TagKey<Block> MINEABLE_WITH_KNIFE = BlockTags.create(ResourceLocation.tryBuild("minecraft", "mineable/knife"));
    }
    public static class Items{
        public static final TagKey<Item> KNIFES = ItemTags.create(ResourceLocation.tryBuild("minecraft", "knives"));
        public static final TagKey<Item> ADVANCEKNIFE = ItemTags.create(ResourceLocation.tryBuild("minecraft", "advance_knives"));
        public static final TagKey<Item> HATCHET = ItemTags.create(ResourceLocation.tryBuild("minecraft", "hatchets"));
    }
}
