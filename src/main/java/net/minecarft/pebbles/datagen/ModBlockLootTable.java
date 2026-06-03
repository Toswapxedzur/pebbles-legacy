package net.minecarft.pebbles.datagen;

import net.minecarft.pebbles.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTable extends BlockLootSubProvider {
    public ModBlockLootTable() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.STURDYROCKBLOCK.get());
        // (LootTable.Builder)r = createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pBlock, LootItem.lootTableItem(Items.RAW_COPPER).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
        // this.add(Block copper_ore, block -> r)
        this.dropSelf(ModBlocks.STURDYBRICKS.get());
        this.dropSelf(ModBlocks.STURDYBRICKSTAIRS.get());
        this.dropSelf(ModBlocks.STURDYBRICKWALL.get());

        this.dropSelf(ModBlocks.URNBLOCK.get());
        this.dropSelf(ModBlocks.WATERURNBLOCK.get());
        this.dropSelf(ModBlocks.HONEYURNBLOCK.get());
        this.dropSelf(ModBlocks.CHOCOLATEURNBLOCK.get());
        this.dropSelf(ModBlocks.MILKURNBLOCK.get());
        this.dropSelf(ModBlocks.LAVAURNBLOCK.get());
        this.dropSelf(ModBlocks.WOODENBOTTLEBLOCK.get());
        this.dropSelf(ModBlocks.WATERWOODENBOTTLEBLOCK.get());
        this.dropSelf(ModBlocks.CHOCOLATEWOODENBOTTLEBLOCK.get());
        this.dropSelf(ModBlocks.HONEYWOODENBOTTLEBLOCK.get());
        this.dropSelf(ModBlocks.MILKWOODENBOTTLEBLOCK.get());
        this.dropSelf(ModBlocks.LAVAWOODENBOTTLEBLOCK.get());
        this.dropSelf(ModBlocks.GROUT_FLUID_BLOCK.get());

        this.dropSelf(ModBlocks.STURDYTANKBLOCK.get());
        this.dropSelf(ModBlocks.FLUID_HOPPER_BLOCK.get());

        this.dropSelf(ModBlocks.CLAYBRICKSHAPED.get());
        this.dropSelf(ModBlocks.BRICKBLOCK.get());
        this.add(ModBlocks.STURDYBRICKSLAB.get(), block -> createSlabItemTable(ModBlocks.STURDYBRICKSLAB.get()));

    }

//    public LootTable.Builder StoneLootTable(Block pBlock, Block cBlock, Item item){
//        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2f))
//                .add( this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)) )  );
//    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
