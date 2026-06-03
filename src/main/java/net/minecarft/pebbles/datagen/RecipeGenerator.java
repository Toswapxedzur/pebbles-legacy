package net.minecarft.pebbles.datagen;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecarft.pebbles.item.ModMoreItems;
import net.minecarft.pebbles.utility.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider implements IConditionBuilder {
    public RecipeGenerator(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModMoreItems.UNFIREDSTURDYROCK.get()).requires(Items.IRON_NUGGET, 2).requires(Items.ANDESITE, 2).requires(Items.CLAY_BALL).requires(Items.KELP).unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModMoreItems.STONEBRICK.get()).requires(ModMoreItems.COBBLE.get(), 1).requires(ModMoreItems.CLAYBIT.get(), 2).requires(ModMoreItems.FIBER.get()).unlockedBy(getHasName(ModMoreItems.FIBER.get()), has(ModMoreItems.FIBER.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModMoreItems.FIBERSTRING.get(), 3).requires(ModMoreItems.FIBER.get()).requires(ModTags.Items.KNIFES).unlockedBy(getHasName(ModMoreItems.FIBER.get()), has(ModMoreItems.FIBER.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModMoreItems.LEATHERSTRING.get(), 4).requires(Items.LEATHER).requires(ModTags.Items.KNIFES).unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER)).save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModMoreItems.CLAYBIT.get(), 3).requires(Items.CLAY_BALL).unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CLAY_BALL).requires(ModMoreItems.CLAYBIT.get(), 4).unlockedBy(getHasName(ModMoreItems.CLAYBIT.get()), has(ModMoreItems.CLAYBIT.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModMoreItems.COBBLE.get(), 4).requires(Items.COBBLESTONE).unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COBBLESTONE).requires(ModMoreItems.COBBLE.get(), 4).unlockedBy(getHasName(ModMoreItems.CLAYBIT.get()), has(ModMoreItems.CLAYBIT.get())).save(consumer);

        oreBlasting(consumer, List.of(ModMoreItems.UNFIREDSTURDYROCK.get()), RecipeCategory.MISC, ModMoreItems.STURDYROCK.get(), 0.2f, 200, "smelt");

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModMoreItems.STURDYPICKAXE.get()).define('I', Items.STICK).define('#',ModMoreItems.STURDYROCK.get())
//                .pattern("###").pattern(" I ").pattern(" I ").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);
        pickaxeRecipe(ModMoreItems.STURDYPICKAXE.get(), ModMoreItems.STURDYROCK.get(), consumer);
        axeRecipe(ModMoreItems.STURDYAXE.get(), ModMoreItems.STURDYROCK.get(), consumer);
        shovelRecipe(ModMoreItems.STURDYSHOVEL.get(), ModMoreItems.STURDYROCK.get(), consumer);
        swordRecipe(ModMoreItems.STURDYSWORD.get(), ModMoreItems.STURDYROCK.get(), consumer);
        hoeRecipe(ModMoreItems.STURDYHOE.get(), ModMoreItems.STURDYROCK.get(), consumer);

        pickaxeRecipe(ModMoreItems.FLINTPICKAXE.get(), Items.FLINT, consumer);
        axeRecipe(ModMoreItems.FLINTAXE.get(), Items.FLINT, consumer);
        shovelRecipe(ModMoreItems.FLINTSHOVEL.get(), Items.FLINT, consumer);
        swordRecipe(ModMoreItems.FLINTSWORD.get(), Items.FLINT, consumer);
        hoeRecipe(ModMoreItems.FLINTHOE.get(), Items.FLINT, consumer);

        pickaxeRecipe(Items.STONE_PICKAXE, ModMoreItems.STONEBRICK.get(), consumer);
        axeRecipe(Items.STONE_AXE, ModMoreItems.STONEBRICK.get(), consumer);
        shovelRecipe(Items.STONE_SHOVEL, ModMoreItems.STONEBRICK.get(), consumer);
        swordRecipe(Items.STONE_SWORD, ModMoreItems.STONEBRICK.get(), consumer);
        hoeRecipe(Items.STONE_HOE, ModMoreItems.STONEBRICK.get(), consumer);

        knifeRecipe(ModMoreItems.FLINTKNIFE.get(), Items.FLINT, consumer);
        knifeRecipe(ModMoreItems.STURDYKNIFE.get(), ModMoreItems.STURDYROCK.get(), consumer);
        knifeRecipe(ModMoreItems.STONEKNIFE.get(), ModMoreItems.STONEBRICK.get(), consumer);
        knifeRecipe(ModMoreItems.IRONKNIFE.get(), Items.IRON_INGOT, consumer);
        knifeRecipe(ModMoreItems.DIAMONDKNIFE.get(), Items.DIAMOND, consumer);

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ModMoreItems.DIAMONDKNIFE.get()), Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.TOOLS, ModMoreItems.NETHERITEKNIFE.get());
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModMoreItems.STURDYAXE.get()).define('I', Items.STICK).define('#',ModMoreItems.STURDYROCK.get())
//                .pattern("## ").pattern("#I ").pattern(" I ").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModMoreItems.STURDYHOE.get()).define('I', Items.STICK).define('#',ModMoreItems.STURDYROCK.get())
//                .pattern("## ").pattern(" I ").pattern(" I ").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModMoreItems.STURDYSHOVEL.get()).define('I', Items.STICK).define('#',ModMoreItems.STURDYROCK.get())
//                .pattern(" # ").pattern(" I ").pattern(" I ").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModMoreItems.STURDYSWORD.get()).define('I', Items.STICK).define('#',ModMoreItems.STURDYROCK.get())
//                .pattern(" # ").pattern(" # ").pattern(" I ").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModMoreItems.FLINTPICKAXE.get()).define('I', Items.STICK).define('#',Items.FLINT)
//                .pattern("###").pattern(" I ").pattern(" I ").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModMoreItems.FLINTAXE.get()).define('I', Items.STICK).define('#',Items.FLINT)
//                .pattern("## ").pattern("#I ").pattern(" I ").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModMoreItems.FLINTHOE.get()).define('I', Items.STICK).define('#',Items.FLINT)
//                .pattern("## ").pattern(" I ").pattern(" I ").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModMoreItems.FLINTSHOVEL.get()).define('I', Items.STICK).define('#',Items.FLINT)
//                .pattern(" # ").pattern(" I ").pattern(" I ").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModMoreItems.FLINTSWORD.get()).define('I', Items.STICK).define('#',Items.FLINT)
//                .pattern(" # ").pattern(" # ").pattern(" I ").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);

        //ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.STURDYROCKBLOCK.get().asItem()).define('#',ModMoreItems.STURDYROCK.get())
        //        .pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);
        //ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModMoreItems.STURDYROCK.get(),9).requires(ModBlocks.STURDYROCKBLOCK.get().asItem());

        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModMoreItems.STURDYROCK.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.STURDYROCKBLOCK.get().asItem());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STURDYBRICKS.get()).define('#', ModMoreItems.STURDYROCK.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()), has(ModMoreItems.STURDYROCK.get())).save(consumer);

        stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, ModBlocks.STURDYBRICKSTAIRS.get().asItem(), ModBlocks.STURDYBRICKS.get().asItem());
        stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, ModBlocks.STURDYBRICKSLAB.get().asItem(), ModBlocks.STURDYBRICKS.get().asItem(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.DECORATIONS, ModBlocks.STURDYBRICKWALL.get().asItem(), ModBlocks.STURDYBRICKS.get().asItem());

        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STURDYBRICKSLAB.get().asItem(), ModBlocks.STURDYBRICKS.get().asItem());
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STURDYBRICKWALL.get().asItem(), ModBlocks.STURDYBRICKS.get().asItem());
        stairBuilder(ModBlocks.STURDYBRICKSTAIRS.get().asItem(), Ingredient.of(ModBlocks.STURDYBRICKS.get().asItem())).unlockedBy(getHasName(ModBlocks.STURDYBRICKS.get().asItem()), has(ModBlocks.STURDYBRICKS.get().asItem())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModMoreItems.STURDYHELMET.get()).define('#', ModMoreItems.STURDYROCK.get()).pattern("###").pattern("# #").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()),has(ModMoreItems.STURDYROCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModMoreItems.STURDYBOOTS.get()).define('#', ModMoreItems.STURDYROCK.get()).pattern("# #").pattern("# #").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()),has(ModMoreItems.STURDYROCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModMoreItems.STURDYCHESTPLATE.get()).define('#', ModMoreItems.STURDYROCK.get()).pattern("# #").pattern("###").pattern("###").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()),has(ModMoreItems.STURDYROCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModMoreItems.STURDYLEGGINGS.get()).define('#', ModMoreItems.STURDYROCK.get()).pattern("###").pattern("# #").pattern("# #").unlockedBy(getHasName(ModMoreItems.STURDYROCK.get()),has(ModMoreItems.STURDYROCK.get())).save(consumer);
    }
    public static void pickaxeRecipe(Item pFinal, Item pMaterial, Consumer<FinishedRecipe> pConsumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pFinal).define('#', pMaterial).define('I', Items.STICK).define('S', Tags.Items.STRING).pattern("###").pattern(" IS").pattern(" I ").unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pConsumer);
    }
    public static void axeRecipe(Item pFinal, Item pMaterial, Consumer<FinishedRecipe> pConsumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pFinal).define('#', pMaterial).define('I', Items.STICK).define('S', Tags.Items.STRING).pattern("##S").pattern("#I ").pattern(" I ").unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pConsumer);
    }
    public static void shovelRecipe(Item pFinal, Item pMaterial, Consumer<FinishedRecipe> pConsumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pFinal).define('#', pMaterial).define('I', Items.STICK).define('S', Tags.Items.STRING).pattern(" #S").pattern(" I ").pattern(" I ").unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pConsumer);
    }
    public static void swordRecipe(Item pFinal, Item pMaterial, Consumer<FinishedRecipe> pConsumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pFinal).define('#', pMaterial).define('I', Items.STICK).define('S', Tags.Items.STRING).pattern(" # ").pattern(" # ").pattern(" IS").unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pConsumer);
    }
    public static void hoeRecipe(Item pFinal, Item pMaterial, Consumer<FinishedRecipe> pConsumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pFinal).define('#', pMaterial).define('I', Items.STICK).define('S', Tags.Items.STRING).pattern("##S").pattern(" I ").pattern(" I ").unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pConsumer);
    }
    public static void knifeRecipe(Item pFinal, Item pMaterial, Consumer<FinishedRecipe> pConsumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pFinal).define('#', pMaterial).define('I', Items.STICK).pattern(" # ").pattern(" I ").unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pConsumer);
    }

    //copied from minecraft source code
    public static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    public static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    public static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, Pebbles.MODID + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
