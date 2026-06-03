package net.minecarft.pebbles.event;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.block.blockEntity.FluidHopperBlockEntity;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Pebbles.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    @SubscribeEvent
    public static void rightClickEvent(PlayerInteractEvent.RightClickBlock pContext){
        if(!pContext.getLevel().isClientSide) {
            if(pContext.getLevel().getBlockEntity(pContext.getPos()) != null){
                if(pContext.getLevel().getBlockEntity(pContext.getPos()) instanceof FluidHopperBlockEntity aaa){
                    pContext.getEntity().displayClientMessage(Component.literal("yee"), false);
                    pContext.getEntity().displayClientMessage(Component.literal(aaa.getFluidHandler().getFluid().getTranslationKey()), false);
                }
            }
        }
    }
}
