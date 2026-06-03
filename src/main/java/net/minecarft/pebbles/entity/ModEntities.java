package net.minecarft.pebbles.entity;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.entity.custom.Cobble;
import net.minecarft.pebbles.entity.custom.KnifeProjectileEntity;
import net.minecarft.pebbles.entity.custom.knifeProjectile.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Pebbles.MODID);

    public static final RegistryObject<EntityType<Cobble>> COBBLE = ENTITY_TYPES.register("cobble", ()->EntityType.Builder.<Cobble>of(Cobble::new, MobCategory.MISC).sized(0.8F,0.8F).build("cobble"));

    public static final RegistryObject<EntityType<FlintKnifeProjectileEntity>> FLINTKNIFEPROJECTILE = ENTITY_TYPES.register("flint_knife_projectile", ()->EntityType.Builder.<FlintKnifeProjectileEntity>of(FlintKnifeProjectileEntity::new, MobCategory.MISC).sized(0.4F,0.4F).build("flint_knife_projectile"));
    public static final RegistryObject<EntityType<NetheriteKnifeProjectileEntity>> NETHERITEKNIFEPROJECTILE = ENTITY_TYPES.register("netherite_knife_projectile", ()->EntityType.Builder.<NetheriteKnifeProjectileEntity>of(NetheriteKnifeProjectileEntity::new, MobCategory.MISC).sized(0.4F,0.4F).build("netherite_knife_projectile"));
    public static final RegistryObject<EntityType<DiamondKnifeProjectileEntity>> DIAMONDKNIFEPROJECTILE = ENTITY_TYPES.register("diamond_knife_projectile", ()->EntityType.Builder.<DiamondKnifeProjectileEntity>of(DiamondKnifeProjectileEntity::new, MobCategory.MISC).sized(0.4F,0.4F).build("diamond_knife_projectile"));
    public static final RegistryObject<EntityType<IronKnifeProjectileEntity>> IRONKNIFEPROJECTILE = ENTITY_TYPES.register("iron_knife_projectile", ()->EntityType.Builder.<IronKnifeProjectileEntity>of(IronKnifeProjectileEntity::new, MobCategory.MISC).sized(0.4F,0.4F).build("iron_knife_projectile"));
    public static final RegistryObject<EntityType<StoneKnifeProjectileEntity>> STONEKNIFEPROJECTILE = ENTITY_TYPES.register("stone_knife_projectile", ()->EntityType.Builder.<StoneKnifeProjectileEntity>of(StoneKnifeProjectileEntity::new, MobCategory.MISC).sized(0.4F,0.4F).build("stone_knife_projectile"));
    public static final RegistryObject<EntityType<SturdyKnifeProjectileEntity>> STURDYKNIFEPROJECTILE = ENTITY_TYPES.register("sturdy_knife_projectile", ()->EntityType.Builder.<SturdyKnifeProjectileEntity>of(SturdyKnifeProjectileEntity::new, MobCategory.MISC).sized(0.4F,0.4F).build("sturdy_knife_projectile"));

    public static void register(IEventBus modEventBus){
        ENTITY_TYPES.register(modEventBus);
    }
}
