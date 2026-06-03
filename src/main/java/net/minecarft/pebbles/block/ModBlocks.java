package net.minecarft.pebbles.block;

import com.simibubi.create.AllFluids;
import net.minecarft.pebbles.block.blockClasses.*;
import net.minecarft.pebbles.fluid.ModFluids;
import net.minecarft.pebbles.item.ModMoreItems;
import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.item.itemClasses.SturdyTankItem;
import net.minecarft.pebbles.item.itemClasses.bottles.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Pebbles.MODID);

    public static final RegistryObject<Block> STURDYROCKBLOCK = registerBlock("sturdy_rock_block",()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STURDYBRICKS = registerBlock("sturdy_bricks", ()->new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> STURDYBRICKSTAIRS = registerBlock("sturdy_brick_stairs", ()->new StairBlock(ModBlocks.STURDYBRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS)));
    public static final RegistryObject<Block> STURDYBRICKSLAB = registerBlock("sturdy_brick_slab", ()->new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)));
    public static final RegistryObject<Block> STURDYBRICKWALL = registerBlock("sturdy_brick_wall", ()->new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)));
    public static final RegistryObject<Block> CLAYBRICKSHAPED = registerBlock("clay_brick_shaped", ()->new ClayBrickShapedBlock(BlockBehaviour.Properties.copy(Blocks.CLAY).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> BRICKBLOCK = BLOCKS.register("brick_block", ()->new BrickBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> FLUID_HOPPER_BLOCK = registerBlock("fluid_hopper", ()->new FluidHopperBlock(BlockBehaviour.Properties.copy(Blocks.HOPPER)));

    public static final RegistryObject<Block> STURDYTANKBLOCK = BLOCKS.register("sturdy_tank_block", ()-> new SturdyTankBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Item> STURDYTANK = ModMoreItems.ITEMS.register("sturdy_tank", ()->new SturdyTankItem(ModBlocks.STURDYTANKBLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Block> URNBLOCK = BLOCKS.register("urn_block", ()->new UrnTypeBlock(Fluids.EMPTY, SoundEvents.DECORATED_POT_HIT, BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));
    public static final RegistryObject<Item> URN = ModMoreItems.ITEMS.register("urn", ()->new UrnItem(ModBlocks.URNBLOCK.get(),new Item.Properties()));

    public static final RegistryObject<Block> WATERURNBLOCK = BLOCKS.register("water_urn_block", ()->new UrnTypeBlock(Fluids.WATER, SoundEvents.BOTTLE_FILL, BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));
    public static final RegistryObject<Item> WATERURN = ModMoreItems.ITEMS.register("water_urn", ()->new WaterUrnItem(ModBlocks.WATERURNBLOCK.get(),new Item.Properties()));

    public static final RegistryObject<Block> HONEYURNBLOCK = BLOCKS.register("honey_urn_block", ()->new UrnTypeBlock(AllFluids.HONEY.get().getSource(), SoundEvents.HONEY_BLOCK_SLIDE, BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));
    public static final RegistryObject<Item> HONEYURN = ModMoreItems.ITEMS.register("honey_urn", ()->new HoneyUrnItem(ModBlocks.HONEYURNBLOCK.get(),new Item.Properties()));

    public static final RegistryObject<Block> CHOCOLATEURNBLOCK = BLOCKS.register("chocolate_urn_block", ()->new UrnTypeBlock(AllFluids.CHOCOLATE.get().getSource(), SoundEvents.MUD_BREAK, BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));
    public static final RegistryObject<Item> CHOCOLATEURN = ModMoreItems.ITEMS.register("chocolate_urn", ()->new ChocolateUrnItem(ModBlocks.CHOCOLATEURNBLOCK.get(),new Item.Properties()));

    public static final RegistryObject<Block> MILKURNBLOCK = BLOCKS.register("milk_urn_block", ()->new UrnTypeBlock(ForgeMod.MILK.get(), SoundEvents.COW_MILK, BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));
    public static final RegistryObject<Item> MILKURN = ModMoreItems.ITEMS.register("milk_urn", ()->new MilkUrnItem(ModBlocks.MILKURNBLOCK.get(),new Item.Properties()));

    public static final RegistryObject<Block> LAVAURNBLOCK = BLOCKS.register("lava_urn_block", ()->new UrnTypeBlock(Fluids.LAVA.getSource(), SoundEvents.BUCKET_FILL_LAVA, BlockBehaviour.Properties.copy(Blocks.BRICKS).noOcclusion()));
    public static final RegistryObject<Item> LAVAURN = ModMoreItems.ITEMS.register("lava_urn", ()->new LavaUrnItem(ModBlocks.LAVAURNBLOCK.get(),new Item.Properties()));

    public static final RegistryObject<Block> WOODENBOTTLEBLOCK = BLOCKS.register("wooden_bottle_block", ()->new WoodenBottleTypeBlock(Fluids.EMPTY, SoundEvents.WOOD_PLACE, BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion()));
    public static final RegistryObject<Item> WOODENBOTTLE = ModMoreItems.ITEMS.register("wooden_bottle", ()->new WoodenBottleItem(WOODENBOTTLEBLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Block> WATERWOODENBOTTLEBLOCK = BLOCKS.register("water_wooden_bottle_block", ()->new WoodenBottleTypeBlock(Fluids.WATER, SoundEvents.WOOD_PLACE, BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion()));
    public static final RegistryObject<Item> WATERWOODENBOTTLE = ModMoreItems.ITEMS.register("water_wooden_bottle", ()->new WaterWoodenBottleItem(WATERWOODENBOTTLEBLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Block> CHOCOLATEWOODENBOTTLEBLOCK = BLOCKS.register("chocolate_wooden_bottle_block", ()->new WoodenBottleTypeBlock(AllFluids.CHOCOLATE.get(), SoundEvents.WOOD_PLACE, BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion()));
    public static final RegistryObject<Item> CHOCOLATEWOODENBOTTLE = ModMoreItems.ITEMS.register("chocolate_wooden_bottle", ()->new ChocolateWoodenBottleItem(CHOCOLATEWOODENBOTTLEBLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Block> HONEYWOODENBOTTLEBLOCK = BLOCKS.register("honey_wooden_bottle_block", ()->new WoodenBottleTypeBlock(AllFluids.HONEY.get(), SoundEvents.WOOD_PLACE, BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion()));
    public static final RegistryObject<Item> HONEYWOODENBOTTLE = ModMoreItems.ITEMS.register("honey_wooden_bottle", ()->new HoneyWoodenBottleItem(HONEYWOODENBOTTLEBLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Block> MILKWOODENBOTTLEBLOCK = BLOCKS.register("milk_wooden_bottle_block", ()->new WoodenBottleTypeBlock(ForgeMod.MILK.get(), SoundEvents.WOOD_PLACE, BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion()));
    public static final RegistryObject<Item> MILKWOODENBOTTLE = ModMoreItems.ITEMS.register("milk_wooden_bottle", ()->new MilkWoodenBottleItem(MILKWOODENBOTTLEBLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Block> LAVAWOODENBOTTLEBLOCK = BLOCKS.register("lava_wooden_bottle_block", ()->new WoodenBottleTypeBlock(Fluids.LAVA.getSource(), SoundEvents.WOOD_PLACE, BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion()));
    public static final RegistryObject<Item> LAVAWOODENBOTTLE = ModMoreItems.ITEMS.register("lava_wooden_bottle", ()->new LavaWoodenBottleItem(LAVAWOODENBOTTLEBLOCK.get(), new Item.Properties()));

    public static final RegistryObject<LiquidBlock> GROUT_FLUID_BLOCK = BLOCKS.register("grout_fluid_block", ()->new LiquidBlock(ModFluids.GROUT_FLUID_SOURCE, BlockBehaviour.Properties.copy(Blocks.WATER)));



    public static <T extends Block> RegistryObject<Item> registerBlockitem(String name, RegistryObject<T> block){
        return ModMoreItems.ITEMS.register(name, ()->new BlockItem(block.get(), new Item.Properties()));
    }
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> t = BLOCKS.register(name, block);
        registerBlockitem(name, t);
        return t;
    }

    public static void register(IEventBus e){
        BLOCKS.register(e);
    }
}
