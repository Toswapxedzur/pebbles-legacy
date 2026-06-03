package net.minecarft.pebbles.datagen;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Pebbles.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //simpleBlockItem(pass in block object)
        SimpleBlockItem(ModBlocks.STURDYROCKBLOCK);
        SimpleBlockItem(ModBlocks.STURDYBRICKS);
        stairsBlock((StairBlock) ModBlocks.STURDYBRICKSTAIRS.get(), blockTexture(ModBlocks.STURDYBRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.STURDYBRICKSLAB.get(), blockTexture(ModBlocks.STURDYBRICKS.get()), blockTexture(ModBlocks.STURDYBRICKS.get()));
        wallBlock((WallBlock) ModBlocks.STURDYBRICKWALL.get(), blockTexture(ModBlocks.STURDYBRICKS.get()));


        ModelFile modelFile = models().getExistingFile(modLoc("block/urn_block"));
        simpleBlock(ModBlocks.URNBLOCK.get(), modelFile);
        simpleBlock(ModBlocks.WATERURNBLOCK.get(), modelFile);
        simpleBlock(ModBlocks.HONEYURNBLOCK.get(), modelFile);
        simpleBlock(ModBlocks.CHOCOLATEURNBLOCK.get(), modelFile);
        simpleBlock(ModBlocks.MILKURNBLOCK.get(), modelFile);
        simpleBlock(ModBlocks.LAVAURNBLOCK.get(), modelFile);

        modelFile = models().getExistingFile(modLoc("block/wooden_bottle"));
        simpleBlock(ModBlocks.WOODENBOTTLEBLOCK.get(), modelFile);
        simpleBlock(ModBlocks.WATERWOODENBOTTLEBLOCK.get(), modelFile);
        simpleBlock(ModBlocks.CHOCOLATEWOODENBOTTLEBLOCK.get(), modelFile);
        simpleBlock(ModBlocks.HONEYWOODENBOTTLEBLOCK.get(), modelFile);
        simpleBlock(ModBlocks.MILKWOODENBOTTLEBLOCK.get(), modelFile);
        simpleBlock(ModBlocks.LAVAWOODENBOTTLEBLOCK.get(), modelFile);

        modelFile = models().getExistingFile(modLoc("block/tank_model"));
        simpleBlock(ModBlocks.STURDYTANKBLOCK.get(), modelFile);

    }

    private void SimpleBlockItem(RegistryObject<Block> b){
        simpleBlockWithItem(b.get(), cubeAll(b.get()));
    }
}
