package net.minecarft.pebbles;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecarft.pebbles.item.itemClasses.CobbleItem;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final CreateRegistrate registrate = Pebbles.registrate;

    public static final ItemEntry<Item> rar  = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_ROCK = registrate.item("sturdy_rock", Item::new).register();

    public static final ItemEntry<Item> UNFIRED_STURDY_ROCK = registrate.item("unfired_sturdy_rock", Item::new).register();

    public static final ItemEntry<Item> CLAY_BIT = registrate.item("clay_bit", Item::new).register();

    public static final ItemEntry<CobbleItem> COBBLE = registrate.item("cobble", CobbleItem::new).register();

    public static final ItemEntry<Item> STONE_BRICK = registrate.item("stone_brick", Item::new).register();

    public static final ItemEntry<Item> FIBER = registrate.item("fiber", Item::new).register();

    public static final ItemEntry<Item> FIBER_STRING = registrate.item("fiber_string", Item::new).register();

    public static final ItemEntry<Item> LEATHER_STRING = registrate.item("leather_string", Item::new).register();

    public static final ItemEntry<Item> PROCELAIN = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> QUARTZ_DUST = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> ROPE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STRAW = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> TREE_BARK = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> WOOD_CHIPS = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> GROUT_BUCKET = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_SWORD = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_PICKAXE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_AXE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_SHOVEL = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_HOE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_HELMET = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_CHESTPLATE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_LEGGINGS = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_BOOTS = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> FLINT_SWORD = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> FLINT_PICKAXE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> FLINT_AXE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> FLINT_SHOVEL = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> FLINT_HOE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> FLINT_KNIFE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_KNIFE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STONE_KNIFE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> IRON_KNIFE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> DIAMOND_KNIFE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> NETHERITE_KNIFE = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> FLINT_HATCHET = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STURDY_HATCHET = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> STONE_HATCHET = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> IRON_HATCHET = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> DIAMOND_HATCHET = registrate.item("", Item::new).register();

    public static final ItemEntry<Item> NETHERITE_HATCHET = registrate.item("", Item::new).register();


    public static void register(){}
}
