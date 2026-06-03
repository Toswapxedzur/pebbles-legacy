package net.minecarft.pebbles.enchantment;

import net.minecarft.pebbles.Pebbles;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Pebbles.MODID);

    public static final RegistryObject<Enchantment> VENOMOUSBLADE = ENCHANTMENTS.register("venomous_blade", ()->new Venomousblade(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> STONEBREAK = ENCHANTMENTS.register("stone_break", ()->new StoneBreak(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));

    public static void register(IEventBus modEventBus){
        ENCHANTMENTS.register(modEventBus);
    }
}
