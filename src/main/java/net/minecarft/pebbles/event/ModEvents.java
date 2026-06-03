package net.minecarft.pebbles.event;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.entity.client.*;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Pebbles.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(FlintKnifeProjectileModel.LAYER_LOCATION, FlintKnifeProjectileModel::createBodyLayer);
        event.registerLayerDefinition(NetheriteKnifeProjectileModel.LAYER_LOCATION, NetheriteKnifeProjectileModel::createBodyLayer);
        event.registerLayerDefinition(DiamondKnifeProjectileModel.LAYER_LOCATION, DiamondKnifeProjectileModel::createBodyLayer);
        event.registerLayerDefinition(IronKnifeProjectileModel.LAYER_LOCATION, IronKnifeProjectileModel::createBodyLayer);
        event.registerLayerDefinition(StoneKnifeProjectileModel.LAYER_LOCATION, StoneKnifeProjectileModel::createBodyLayer);
        event.registerLayerDefinition(SturdyKnifeProjectileModel.LAYER_LOCATION, SturdyKnifeProjectileModel::createBodyLayer);
    }
}
