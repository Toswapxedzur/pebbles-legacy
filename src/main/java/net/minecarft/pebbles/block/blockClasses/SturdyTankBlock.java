package net.minecarft.pebbles.block.blockClasses;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SturdyTankBlock extends Block {
    public SturdyTankBlock(Properties pProperties) {
        super(pProperties.noOcclusion());
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos){
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos world, CollisionContext context){
        return box(3,0,3,13,12,13);
    }
}
