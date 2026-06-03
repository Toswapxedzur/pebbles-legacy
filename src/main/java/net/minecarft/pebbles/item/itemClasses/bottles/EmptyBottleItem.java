package net.minecarft.pebbles.item.itemClasses.bottles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
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
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;

import java.util.HashMap;
import java.util.Map;

public class EmptyBottleItem extends BlockItem {
    public static HashMap<Item, HashMap<Fluid, Item>> bottleMap = new HashMap<>();
    public EmptyBottleItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level world = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        Direction face = pContext.getClickedFace();
        Player player = pContext.getPlayer();
        ItemStack stack = pContext.getItemInHand();
        HashMap<Fluid, Item> itemHashMap = bottleMap.get(this.asItem());
        if(!world.isClientSide){
            BlockEntity container = world.getBlockEntity(pos);
            if(container!=null){
                LazyOptional<IFluidHandler> cap = container.getCapability(ForgeCapabilities.FLUID_HANDLER, face);
                if(cap.isPresent()){
                    IFluidHandler capability = cap.resolve().orElse(null);
                    FluidStack testDrain = capability.drain(250, IFluidHandler.FluidAction.SIMULATE);
                    if(itemHashMap.containsKey(testDrain.getFluid())){
                        stack.shrink(1);
                        player.getInventory().add(new ItemStack(itemHashMap.get(testDrain.getFluid())));
                        capability.drain(250,IFluidHandler.FluidAction.EXECUTE);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
            super.useOn(pContext);
        }
        return InteractionResult.SUCCESS;
    }
}
