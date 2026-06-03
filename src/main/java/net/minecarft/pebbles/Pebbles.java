package net.minecarft.pebbles;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.createmod.catnip.lang.FontHelper;
import net.minecarft.pebbles.block.ModBlockEntities;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecarft.pebbles.creativeTab.addToExistingCreativeTab;
import net.minecarft.pebbles.enchantment.ModEnchantments;
import net.minecarft.pebbles.entity.ModEntities;
import net.minecarft.pebbles.entity.client.*;
import net.minecarft.pebbles.fluid.ModFluidTypes;
import net.minecarft.pebbles.fluid.ModFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Pebbles.MODID)
public class Pebbles
{
    public static final String MODID = "pebbles";
    public static final CreateRegistrate registrate = CreateRegistrate.create(MODID).setTooltipModifierFactory(item ->
            new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE).andThen(TooltipModifier.mapNull(KineticStats.create(item))));

    public Pebbles(FMLJavaModLoadingContext context)
    {

        IEventBus modEventBus = context.getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        ModItems.register();


//
//        ModMoreItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModEntities.register(modEventBus);
        ModEnchantments.register(modEventBus);
//
//
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(addToExistingCreativeTab::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.COBBLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.FLINTKNIFEPROJECTILE.get(), FlintKnifeProjectileRenderer::new);
            EntityRenderers.register(ModEntities.NETHERITEKNIFEPROJECTILE.get(), NetheriteKnifeProjectileRenderer::new);
            EntityRenderers.register(ModEntities.DIAMONDKNIFEPROJECTILE.get(), DiamondKnifeProjectileRenderer::new);
            EntityRenderers.register(ModEntities.IRONKNIFEPROJECTILE.get(), IronKnifeProjectileRenderer::new);
            EntityRenderers.register(ModEntities.STONEKNIFEPROJECTILE.get(), StoneKnifeProjectileRenderer::new);
            EntityRenderers.register(ModEntities.STURDYKNIFEPROJECTILE.get(), SturdyKnifeProjectileRenderer::new);

            ItemBlockRenderTypes.setRenderLayer(ModFluids.GROUT_FLUID_SOURCE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.GROUT_FLUID_FLOWING.get(), RenderType.translucent());
        }
    }
}
