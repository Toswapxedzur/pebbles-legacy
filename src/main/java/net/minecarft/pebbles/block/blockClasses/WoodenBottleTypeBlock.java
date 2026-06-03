package net.minecarft.pebbles.block.blockClasses;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WoodenBottleTypeBlock extends Block {
    Fluid fluid;
    SoundEvent soundEvent;
    public WoodenBottleTypeBlock(Properties pProperties) {
        super(pProperties);
    }
    public WoodenBottleTypeBlock(Fluid pFluid, SoundEvent pSoundDvent, Properties pProperties) {
        super(pProperties);
        this.fluid=pFluid;
        this.soundEvent=pSoundDvent;
    }
    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos){
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos world, CollisionContext context){
        return box(4,0,4,12,8,12);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
//        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        if(!pLevel.isClientSide){
            pLevel.playSound(null, pPos, soundEvent, SoundSource.BLOCKS, 1F, 1F);
            pLevel.sendBlockUpdated(pPos, pState, pState, 3);
        }
        return InteractionResult.SUCCESS;
    }
}
