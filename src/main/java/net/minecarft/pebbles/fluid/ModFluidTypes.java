package net.minecarft.pebbles.fluid;

import net.minecarft.pebbles.Pebbles;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation GROUT_STILL_RL = ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_still");
    public static final ResourceLocation GROUT_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_flow");
    public static final ResourceLocation GROUT_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath(Pebbles.MODID, "misc/in_grout");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Pebbles.MODID);

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties){
        return FLUID_TYPES.register(name, ()->new BaseFluidType(GROUT_STILL_RL, GROUT_FLOWING_RL, GROUT_OVERLAY_RL, 0xF2282828, new Vector3f(40.5f/255f,40.5f/255f, 40.5f/255f),1F,3F, properties));
    }

    public static final RegistryObject<FluidType> GROUT_FLUID_TYPE = register("grout_fluid", FluidType.Properties.create().density(30).viscosity(5));

    public static void register(IEventBus modEventBus){
        FLUID_TYPES.register(modEventBus);
    }
}
