package net.minecarft.pebbles.datagen;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.item.ModMoreItems;
import net.minecarft.pebbles.utility.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ItemTagsProvider {

    public ItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Pebbles.MODID, existingFileHelper);
    }

    public static final List<Item> knifeItems = List.of(ModMoreItems.FLINTKNIFE.get(), ModMoreItems.STURDYKNIFE.get(), ModMoreItems.STONEKNIFE.get(), ModMoreItems.IRONKNIFE.get(), ModMoreItems.DIAMONDKNIFE.get(), ModMoreItems.NETHERITEKNIFE.get());
    public static final List<Item> hatchetItem = List.of(ModMoreItems.FLINTHATCHET.get(), ModMoreItems.STURDYHATCHET.get(), ModMoreItems.STONEHATCHET.get(), ModMoreItems.IRONHATCHET.get(), ModMoreItems.DIAMONDHATCHET.get(), ModMoreItems.NETHERITEHATCHET.get());

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for(Item pItem : knifeItems){
            this.tag(ModTags.Items.KNIFES).add(pItem);
        }
        this.tag(ModTags.Items.ADVANCEKNIFE).add(ModMoreItems.DIAMONDKNIFE.get(), ModMoreItems.NETHERITEKNIFE.get());
        for(Item pItem : hatchetItem){
            this.tag(ModTags.Items.HATCHET).add(pItem);
        }
        this.tag(ItemTags.SWORDS).add(ModMoreItems.FLINTSWORD.get(), ModMoreItems.STURDYSWORD.get());
        this.tag(ItemTags.PICKAXES).add(ModMoreItems.FLINTPICKAXE.get(), ModMoreItems.STURDYPICKAXE.get());
        this.tag(ItemTags.AXES).add(ModMoreItems.FLINTAXE.get(), ModMoreItems.STURDYAXE.get());
        this.tag(ItemTags.SHOVELS).add(ModMoreItems.FLINTSHOVEL.get(), ModMoreItems.STURDYSHOVEL.get());
        this.tag(ItemTags.HOES).add(ModMoreItems.FLINTHOE.get(), ModMoreItems.STURDYHOE.get());

        this.tag(Tags.Items.ARMORS_HELMETS).add(ModMoreItems.STURDYHELMET.get());
        this.tag(Tags.Items.ARMORS_CHESTPLATES).add(ModMoreItems.STURDYCHESTPLATE.get());
        this.tag(Tags.Items.ARMORS_LEGGINGS).add(ModMoreItems.STURDYLEGGINGS.get());
        this.tag(Tags.Items.ARMORS_BOOTS).add(ModMoreItems.STURDYBOOTS.get());

        this.tag(Tags.Items.STRING).add(ModMoreItems.FIBERSTRING.get(), ModMoreItems.LEATHERSTRING.get());
    }
}
