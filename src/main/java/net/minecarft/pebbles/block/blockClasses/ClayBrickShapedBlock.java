package net.minecarft.pebbles.block.blockClasses;

import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ClayBrickShapedBlock extends Block {

    public ClayBrickShapedBlock(Properties pProperties) {
        super(pProperties.randomTicks());
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom){
        if( pLevel.isDay() && pLevel.canSeeSky(pPos) ){
            if(pRandom.nextInt(5) == 1){
                pLevel.setBlock(pPos, ModBlocks.BRICKBLOCK.get().defaultBlockState(), 0);
            }
        }
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos){
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos world, CollisionContext context){
        return box(0,0,5,16,6,11);
    }
}
