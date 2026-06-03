package net.minecarft.pebbles.datagen;

import net.minecarft.pebbles.Pebbles;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Pebbles.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators{
    @SubscribeEvent
    public static void GatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        PackOutput packOutPut = gen.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new RecipeGenerator(packOutPut));
        gen.addProvider(event.includeServer(), LootTableGenerator.create(packOutPut));

        gen.addProvider(event.includeClient(), new BlockStateGenerator(packOutPut, fileHelper));
        gen.addProvider(event.includeClient(), new ItemModelGenerator(packOutPut, fileHelper));

        BlockTagGenerator blockTagGenerator = gen.addProvider(event.includeServer(), new BlockTagGenerator(packOutPut, lookUpProvider, fileHelper));
        gen.addProvider(event.includeServer(), new ItemTagGenerator(packOutPut, lookUpProvider, blockTagGenerator.contentsGetter(), fileHelper));
    }
}
