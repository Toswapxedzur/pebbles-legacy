package net.minecarft.pebbles.fluid;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecarft.pebbles.item.ModMoreItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Pebbles.MODID);

    public static final RegistryObject<FlowingFluid> GROUT_FLUID_SOURCE = FLUIDS.register("grout_fluid_source", ()->new ForgeFlowingFluid.Source(ModFluids.GROUT_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> GROUT_FLUID_FLOWING = FLUIDS.register("grout_fluid_flowing", ()->new ForgeFlowingFluid.Flowing(ModFluids.GROUT_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties GROUT_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.GROUT_FLUID_TYPE,
            GROUT_FLUID_SOURCE,
            GROUT_FLUID_FLOWING
    ).slopeFindDistance(1).levelDecreasePerBlock(4).block(ModBlocks.GROUT_FLUID_BLOCK).bucket(ModMoreItems.GROUTBUCKET);

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}
