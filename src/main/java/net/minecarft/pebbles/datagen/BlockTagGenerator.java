package net.minecarft.pebbles.datagen;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.trains.station.StationMarker;
import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecarft.pebbles.utility.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Pebbles.MODID, existingFileHelper);
    }

    public static final List<Block> AntiGravity = List.of(Blocks.END_STONE, Blocks.BEDROCK, Blocks.STONE, Blocks.DEEPSLATE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.TUFF);

    public static final List<Block> Woods = List.of(Blocks.ACACIA_WOOD, Blocks.CHERRY_WOOD,Blocks.BIRCH_WOOD,Blocks.JUNGLE_WOOD,Blocks.MANGROVE_WOOD,Blocks.DARK_OAK_WOOD,Blocks.OAK_WOOD,Blocks.SPRUCE_WOOD,Blocks.WARPED_HYPHAE, Blocks.CRIMSON_HYPHAE);
    public static final List<Block> carves_stone = List.of(Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS, Blocks.DEEPSLATE_BRICKS, Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_MOSSY_STONE_BRICKS, Blocks.INFESTED_MOSSY_STONE_BRICKS);

    public static final List<Block> MineableKnife = List.of(Blocks.GRASS, Blocks.TALL_GRASS, Blocks.COBWEB, Blocks.CHAIN, Blocks.POINTED_DRIPSTONE,
            Blocks.SMALL_AMETHYST_BUD, Blocks.MEDIUM_AMETHYST_BUD, Blocks.LARGE_AMETHYST_BUD, Blocks.AMETHYST_CLUSTER, Blocks.SCULK_VEIN, Blocks.TORCH, Blocks.SOUL_TORCH,
            Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WIRE, Blocks.LEVER, Blocks.TRIPWIRE_HOOK, Blocks.TRIPWIRE);

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for(Block IBlock : MineableKnife){
            this.tag(ModTags.Blocks.MINEABLE_WITH_KNIFE).add(IBlock);
        }
        this.tag(ModTags.Blocks.MINEABLE_WITH_KNIFE).addTag(BlockTags.SWORD_EFFICIENT);
        this.tag(ModTags.Blocks.MINEABLE_WITH_KNIFE).addTag(BlockTags.UNDERWATER_BONEMEALS);
        this.tag(ModTags.Blocks.MINEABLE_WITH_KNIFE).addTag(BlockTags.RAILS);

        for(Block IBlock : AntiGravity){ this.tag(ModTags.Blocks.ANTIGRAVITY).add(IBlock); }
        for(Block IBlock : Woods){ this.tag(ModTags.Blocks.WOODS).add(IBlock); }

        this.tag(BlockTags.WALLS).add(ModBlocks.STURDYBRICKWALL.get());
    }
}
