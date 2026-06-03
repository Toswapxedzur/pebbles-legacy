package net.minecarft.pebbles.datagen;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecarft.pebbles.item.ModMoreItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Pebbles.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simplemodel(ModMoreItems.UNFIREDSTURDYROCK);
        simplemodel(ModMoreItems.STURDYROCK);
        simplemodel(ModMoreItems.CLAYBIT);
        simplemodel(ModMoreItems.COBBLE);
        simplemodel(ModMoreItems.FIBER);
        simplemodel(ModMoreItems.FIBERSTRING);
        simplemodel(ModMoreItems.LEATHERSTRING);
        simplemodel(ModMoreItems.STONEBRICK);

        handheldmodel(ModMoreItems.STURDYSWORD);
        handheldmodel(ModMoreItems.STURDYAXE);
        handheldmodel(ModMoreItems.STURDYPICKAXE);
        handheldmodel(ModMoreItems.STURDYSHOVEL);
        handheldmodel(ModMoreItems.STURDYHOE);

        handheldmodel(ModMoreItems.FLINTSWORD);
        handheldmodel(ModMoreItems.FLINTAXE);
        handheldmodel(ModMoreItems.FLINTPICKAXE);
        handheldmodel(ModMoreItems.FLINTSHOVEL);
        handheldmodel(ModMoreItems.FLINTHOE);

        handheldmodel(ModMoreItems.FLINTKNIFE);
        handheldmodel(ModMoreItems.STURDYKNIFE);
        handheldmodel(ModMoreItems.STONEKNIFE);
        handheldmodel(ModMoreItems.IRONKNIFE);
        handheldmodel(ModMoreItems.DIAMONDKNIFE);
        handheldmodel(ModMoreItems.NETHERITEKNIFE);

        handheldmodel(ModMoreItems.FLINTHATCHET);
        handheldmodel(ModMoreItems.STURDYHATCHET);
        handheldmodel(ModMoreItems.STONEHATCHET);
        handheldmodel(ModMoreItems.IRONHATCHET);
        handheldmodel(ModMoreItems.DIAMONDHATCHET);
        handheldmodel(ModMoreItems.NETHERITEHATCHET);

        simplemodel(ModMoreItems.STURDYHELMET);
        simplemodel(ModMoreItems.STURDYCHESTPLATE);
        simplemodel(ModMoreItems.STURDYLEGGINGS);
        simplemodel(ModMoreItems.STURDYBOOTS);

        simplemodel(ModMoreItems.PROCELAIN);
        simplemodel(ModMoreItems.QUARTZDUST);
        simplemodel(ModMoreItems.ROPE);
        simplemodel(ModMoreItems.STRAW);
        simplemodel(ModMoreItems.TREEBARK);
        simplemodel(ModMoreItems.WOODCHIPS);

        simplemodel(ModMoreItems.GROUTBUCKET);


        simplermodel(ModBlocks.STURDYBRICKSTAIRS);
        simplermodel(ModBlocks.STURDYBRICKSLAB);
        wallInventory("sturdy_brick_wall", modLoc("block/sturdy_bricks"));

        simplermodel(ModBlocks.BRICKBLOCK);

        singleTexture("urn", mcLoc("item/generated"), "layer0", modLoc("item/urn"));
        singleTexture("water_urn", mcLoc("item/generated"), "layer0", modLoc("item/urn"));
        singleTexture("honey_urn", mcLoc("item/generated"), "layer0", modLoc("item/urn"));
        singleTexture("chocolate_urn", mcLoc("item/generated"), "layer0", modLoc("item/urn"));
        singleTexture("milk_urn", mcLoc("item/generated"), "layer0", modLoc("item/urn"));
        singleTexture("lava_urn", mcLoc("item/generated"), "layer0", modLoc("item/urn"));
        singleTexture("wooden_bottle", mcLoc("item/generated"), "layer0", modLoc("item/wooden_bottle"));
        singleTexture("water_wooden_bottle", mcLoc("item/generated"), "layer0", modLoc("item/wooden_bottle"));
        singleTexture("chocolate_wooden_bottle", mcLoc("item/generated"), "layer0", modLoc("item/wooden_bottle"));
        singleTexture("honey_wooden_bottle", mcLoc("item/generated"), "layer0", modLoc("item/wooden_bottle"));
        singleTexture("milk_wooden_bottle", mcLoc("item/generated"), "layer0", modLoc("item/wooden_bottle"));
        singleTexture("lava_wooden_bottle", mcLoc("item/generated"), "layer0", modLoc("item/wooden_bottle"));

        singleTexture("sturdy_tank", mcLoc("item/generated"), "layer0", modLoc("item/sturdy_tank"));

        singleTexture("clay_brick_shaped", mcLoc("item/generated"), "layer0", modLoc("item/clay_brick"));

        singleTexture("fluid_hopper", mcLoc("item/generated"), "layer0", modLoc("item/fluid_hopper"));
    }

    private ItemModelBuilder simplemodel(RegistryObject<Item> i){
        return withExistingParent(i.getId().getPath(), ResourceLocation.tryParse("item/generated"))
                .texture("layer0", ResourceLocation.tryBuild(Pebbles.MODID,"item/"+i.getId().getPath()));
    }

    public ItemModelBuilder simplermodel(RegistryObject<Block> i){
        return withExistingParent((Pebbles.MODID+":"+ ForgeRegistries.BLOCKS.getKey(i.get()).getPath()),
                modLoc(("block/"+ForgeRegistries.BLOCKS.getKey(i.get()).getPath())));
    }

    private ItemModelBuilder handheldmodel(RegistryObject<Item> i){
        return withExistingParent(i.getId().getPath(), ResourceLocation.tryParse("item/handheld"))
                .texture("layer0", ResourceLocation.tryBuild(Pebbles.MODID,"item/"+i.getId().getPath()));
    }
}
