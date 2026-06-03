package net.minecarft.pebbles.item;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.fluid.ModFluids;
import net.minecarft.pebbles.item.itemClasses.*;
import net.minecarft.pebbles.utility.ModTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMoreItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Pebbles.MODID);

    public static final RegistryObject<Item> STURDYROCK = ITEMS.register("sturdy_rock",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNFIREDSTURDYROCK = ITEMS.register("unfired_sturdy_rock",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAYBIT = ITEMS.register("clay_bit",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> COBBLE = ITEMS.register("cobble",()->new CobbleItem(new Item.Properties()));
    public static final RegistryObject<Item> STONEBRICK = ITEMS.register("stone_brick",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIBER = ITEMS.register("fiber",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIBERSTRING = ITEMS.register("fiber_string",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEATHERSTRING = ITEMS.register("leather_string",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> PROCELAIN = ITEMS.register("procelain",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARTZDUST = ITEMS.register("quartz_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROPE = ITEMS.register("rope",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> STRAW = ITEMS.register("straw",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> TREEBARK = ITEMS.register("tree_bark",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> WOODCHIPS = ITEMS.register("wood_chips",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> GROUTBUCKET = ITEMS.register("grout_bucket",()->new BucketItem(ModFluids.GROUT_FLUID_SOURCE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));


    public static final RegistryObject<Item> STURDYSWORD = ITEMS.register("sturdy_sword", ()->new SwordItem(ModTiers.STURDY,4,1,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> STURDYPICKAXE = ITEMS.register("sturdy_pickaxe", ()->new PickaxeItem(ModTiers.STURDY,2,(float)-2.8,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> STURDYAXE = ITEMS.register("sturdy_axe", ()->new AxeItem(ModTiers.STURDY,(float)7,(float)-3.05,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> STURDYSHOVEL = ITEMS.register("sturdy_shovel", ()->new ShovelItem(ModTiers.STURDY,2,-3,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> STURDYHOE = ITEMS.register("sturdy_hoe", ()->new HoeItem(ModTiers.STURDY,-1,-1,new Item.Properties().durability(173)));

    public static final RegistryObject<Item> STURDYHELMET = ITEMS.register("sturdy_helmet", ()->new ArmorItem(ModArmorMaterials.STURDY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STURDYCHESTPLATE = ITEMS.register("sturdy_chestplate", ()->new ArmorItem(ModArmorMaterials.STURDY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STURDYLEGGINGS = ITEMS.register("sturdy_leggings", ()->new ArmorItem(ModArmorMaterials.STURDY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STURDYBOOTS = ITEMS.register("sturdy_boots", ()->new ArmorItem(ModArmorMaterials.STURDY, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static final RegistryObject<Item> FLINTSWORD = ITEMS.register("flint_sword", ()->new SwordItem(ModTiers.FLINT,4,1,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> FLINTPICKAXE = ITEMS.register("flint_pickaxe", ()->new ItemFlintPickaxe(ModTiers.FLINT,2,(float)-2.8,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> FLINTAXE = ITEMS.register("flint_axe", ()->new AxeItem(ModTiers.FLINT,(float)7,(float)-3.05,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> FLINTSHOVEL = ITEMS.register("flint_shovel", ()->new ShovelItem(ModTiers.FLINT,2,-3,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> FLINTHOE = ITEMS.register("flint_hoe", ()->new HoeItem(ModTiers.FLINT,-1,-1,new Item.Properties().durability(173)));

    public static final RegistryObject<Item> FLINTKNIFE = ITEMS.register("flint_knife", ()->new KnifeItem(Tiers.WOOD,4,1,true,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> STURDYKNIFE = ITEMS.register("sturdy_knife", ()->new KnifeItem(Tiers.STONE,4,1,true,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> STONEKNIFE = ITEMS.register("stone_knife", ()->new KnifeItem(Tiers.STONE,4,1,true,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> IRONKNIFE = ITEMS.register("iron_knife", ()->new KnifeItem(Tiers.IRON,4,1,false,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> DIAMONDKNIFE = ITEMS.register("diamond_knife", ()->new KnifeItem(Tiers.DIAMOND,4,1,false,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> NETHERITEKNIFE = ITEMS.register("netherite_knife", ()->new KnifeItem(Tiers.NETHERITE,4,1,false,new Item.Properties().durability(173).fireResistant()));

    public static final RegistryObject<Item> FLINTHATCHET = ITEMS.register("flint_hatchet", ()->new HatchetItem(Tiers.WOOD,4,1,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> STURDYHATCHET = ITEMS.register("sturdy_hatchet", ()->new HatchetItem(Tiers.STONE,4,1,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> STONEHATCHET = ITEMS.register("stone_hatchet", ()->new HatchetItem(Tiers.STONE,4,1,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> IRONHATCHET = ITEMS.register("iron_hatchet", ()->new HatchetItem(Tiers.IRON,4,1,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> DIAMONDHATCHET = ITEMS.register("diamond_hatchet", ()->new HatchetItem(Tiers.DIAMOND,4,1,new Item.Properties().durability(173)));
    public static final RegistryObject<Item> NETHERITEHATCHET = ITEMS.register("netherite_hatchet", ()->new HatchetItem(Tiers.NETHERITE,4,1,new Item.Properties().durability(173).fireResistant()));





    public static void register(IEventBus eventb){
        ITEMS.register(eventb);
    }
}
