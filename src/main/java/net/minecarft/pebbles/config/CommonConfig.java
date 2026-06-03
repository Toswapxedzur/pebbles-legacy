package net.minecarft.pebbles.config;

import com.simibubi.create.AllBlocks;
import net.minecarft.pebbles.Pebbles;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Pebbles.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    public static ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec.IntValue MINEMULTIPLIER = BUILDER.defineInRange("mine_multiplier", 15, 1, 4096);

    public static ForgeConfigSpec SPEC = BUILDER.build();

    public static int mine_multiplier;

    public static void getConfig(){ mine_multiplier = MINEMULTIPLIER.get(); }

    @SubscribeEvent
    public static void initializeData(ModConfigEvent.Loading event){
        getConfig();
    }

    @SubscribeEvent
    public static void reinitializeData(ModConfigEvent.Reloading event){
        getConfig();
    }
}
