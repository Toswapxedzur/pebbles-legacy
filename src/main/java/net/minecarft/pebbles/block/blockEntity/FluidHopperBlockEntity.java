package net.minecarft.pebbles.block.blockEntity;

import com.simibubi.create.AllBlocks;
import net.minecarft.pebbles.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FluidHopperBlockEntity extends BlockEntity {
    public static final int CAPACITY = 1500;
    public static final int inputRate = 25;
    public static final int outputRate = 25;
    private final FluidTank fluidHandler = new FluidTank(CAPACITY);

    public FluidHopperBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FLUID_HOPPER.get(), pPos, pBlockState);
    }

    private LazyOptional<IFluidHandler> fluidCap = LazyOptional.empty();

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if(cap == ForgeCapabilities.FLUID_HANDLER){
            return fluidCap.cast();
        }
        return super.getCapability(cap);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        fluidCap=LazyOptional.of(()->fluidHandler);
    }

    @Override
    public void invalidateCaps() {
        fluidCap.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        fluidHandler.writeToNBT(pTag);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        fluidHandler.readFromNBT(pTag);
    }

    public void drop(){
        if(getFluidHandler().getFluidAmount() >=1000 && !getFluidHandler().getFluid().isFluidEqual(FluidStack.EMPTY))
            getLevel().setBlock(getBlockPos(), fluidHandler.getFluid().getFluid().defaultFluidState().createLegacyBlock(), 3);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        transferInFluid(pLevel, pPos, pState);
        transferOutFluid(pLevel, pPos, pState);
    }

    public FluidTank getFluidHandler(){
        return this.fluidHandler;
    }

    public void suckFluid() {
        Level level = getLevel();
        BlockPos pos = getBlockPos();
        BlockPos fluidPos = pos.relative(Direction.UP);
        FluidState fluid = level.getFluidState(fluidPos);
        FluidStack fluidStack = new FluidStack(fluid.getType(), 1000);

        if(fluid.isSource()) {
            if (getFluidHandler().fill(fluidStack, IFluidHandler.FluidAction.SIMULATE) >= 900) {
                getFluidHandler().fill(fluidStack, IFluidHandler.FluidAction.EXECUTE);
                getLevel().setBlock(fluidPos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
    }

    public void transferInFluid(Level pLevel, BlockPos pPos, BlockState pState){
        BlockPos inputPos = pPos.above();
        if(pLevel.getBlockEntity(inputPos) == null)
            return;
        IFluidHandler FluidCapability = pLevel.getBlockEntity(inputPos).getCapability(ForgeCapabilities.FLUID_HANDLER, Direction.DOWN).orElse(null);
        if(FluidCapability == null)
            return;
        FluidStack testdrain = FluidCapability.drain(inputRate, IFluidHandler.FluidAction.SIMULATE);
        int testfill = getFluidHandler().fill(testdrain, IFluidHandler.FluidAction.SIMULATE);
        FluidStack actualDrain = FluidCapability.drain(testfill, IFluidHandler.FluidAction.EXECUTE);
        getFluidHandler().fill(actualDrain, IFluidHandler.FluidAction.EXECUTE);
    }

    public void transferOutFluid(Level pLevel, BlockPos pPos, BlockState pState){
        Direction outputDir = pState.getValue(BlockStateProperties.FACING_HOPPER);
        BlockPos outputPos = pPos.relative(outputDir);
        String block1 = pLevel.getBlockState(outputPos).getBlock().getName().toString();
        if(pLevel.getBlockEntity(outputPos) == null)
            return;
        IFluidHandler FluidCapability = pLevel.getBlockEntity(outputPos).getCapability(ForgeCapabilities.FLUID_HANDLER, outputDir.getOpposite()).orElse(null);
        if(FluidCapability == null)
            return;
        FluidStack testdrain = getFluidHandler().drain(outputRate, IFluidHandler.FluidAction.SIMULATE);
        Fluid fluid2 = testdrain.getFluid();
        int testfill = FluidCapability.fill(testdrain, IFluidHandler.FluidAction.SIMULATE);
        FluidStack actualDrain = getFluidHandler().drain(testfill, IFluidHandler.FluidAction.EXECUTE);
        FluidCapability.fill(actualDrain, IFluidHandler.FluidAction.EXECUTE);
    }

    public void updateRedstone() {
    }
}
