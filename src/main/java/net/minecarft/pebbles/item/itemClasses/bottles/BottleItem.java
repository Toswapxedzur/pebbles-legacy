package net.minecarft.pebbles.item.itemClasses.bottles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.level.NoteBlockEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class BottleItem extends BlockItem {
    public final Fluid fluid;
    public final Item bottle;
    public final int behavior;
    public BottleItem(Block pBlock, Properties pProperties, Fluid fluid, Item bottle, int behavior) {
        super(pBlock, pProperties);
        this.fluid=fluid;
        this.bottle=bottle;
        this.behavior=behavior;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level world = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        Direction face = pContext.getClickedFace();
        Player player = pContext.getPlayer();
        ItemStack stack = pContext.getItemInHand();
        if(!world.isClientSide){
            BlockEntity container = world.getBlockEntity(pos);
            if(container!=null){
                LazyOptional<IFluidHandler> cap = container.getCapability(ForgeCapabilities.FLUID_HANDLER, face);
                if(cap.isPresent()){
                    IFluidHandler capability = cap.resolve().orElse(null);
                    int testFill = capability.fill(new FluidStack(fluid, 250), IFluidHandler.FluidAction.SIMULATE);
                    if(testFill>100) {
                        capability.fill(new FluidStack(fluid, 250), IFluidHandler.FluidAction.EXECUTE);
                        stack.shrink(1);
                        if(behavior==1){
                            world.playSound(null, pos, SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1F,1F);
                        }else {
                            player.getInventory().add(new ItemStack(bottle));
                        }
                    }
                    return InteractionResult.SUCCESS;
                }
            }
            super.useOn(pContext);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if(!pLevel.isClientSide) {
            if (pPlayer.isShiftKeyDown()) {
                stack.shrink(1);
                pPlayer.getInventory().add(new ItemStack(bottle));
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
