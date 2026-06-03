package net.minecarft.pebbles.item.itemClasses;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecarft.pebbles.enchantment.ModEnchantments;
import net.minecarft.pebbles.entity.custom.KnifeProjectileEntity;
import net.minecarft.pebbles.entity.custom.knifeProjectile.*;
import net.minecarft.pebbles.item.ModMoreItems;
import net.minecarft.pebbles.utility.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KnifeItem extends DiggerItem implements Vanishable{
    public boolean damageOnUse;
    private Item knifeKey = Items.AIR;

    public static final int THROW_THRESHOLD_TIME = 10;
    public static final float BASE_DAMAGE = 8.0F;
    public static final float SHOOT_POWER = 2.5F;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public KnifeItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, boolean pDamageOnUse, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.MINEABLE_WITH_KNIFE, pProperties);
        this.damageOnUse = pDamageOnUse;

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 8.0D, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)-2.9F, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public boolean hasCraftingRemainingItem(){ return true; }
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack pItemStack){
        ItemStack itemStack = new ItemStack(this);
        int pDamage = pItemStack.getDamageValue()+1;
        if(pDamage >= itemStack.getMaxDamage()){
            return ItemStack.EMPTY;
        }else{
            itemStack.setDamageValue(pDamage);
            return itemStack;
        }
    }
    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return super.isCorrectToolForDrops(stack, state) || ( (EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.STONEBREAK.get(), stack) > 0)
        && (state.is(ModTags.Blocks.MINEABLE_WITH_KNIFE) || state.is(BlockTags.MINEABLE_WITH_PICKAXE)) && net.minecraftforge.common.TierSortingRegistry.isCorrectTierForDrops(Tiers.IRON, state) );
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext){
        if(!pContext.getLevel().isClientSide) {
            Random r = new Random();

            ArrayList<ItemStack> itemPool = new ArrayList<>();
            ArrayList<Block> blockPool = new ArrayList<>();

            boolean applyKey = false;
            Level world = pContext.getLevel();
            BlockPos clickedPos = pContext.getClickedPos();
            Block pBlockIngredient = world.getBlockState(clickedPos).getBlock();
            ItemStack pItemIngredient = new ItemStack(pBlockIngredient.asItem());
            ItemStack iterStack = new ItemStack(Items.AIR);
            Block pResult = pBlockIngredient;

            if (pContext.getPlayer().isShiftKeyDown()) {
                applyKey = true;
            }

            List<StonecutterRecipe> recipeResult = world.getRecipeManager().getRecipesFor(RecipeType.STONECUTTING, new SimpleContainer(pItemIngredient), world);
            for (StonecutterRecipe recipe : recipeResult) {
                iterStack = recipe.getResultItem(world.registryAccess());
//                pContext.getPlayer().displayClientMessage(Component.literal(iterStack.toString()),false);
                if ((!applyKey) || iterStack.is(knifeKey)) {
                    itemPool.add(iterStack);
                }
            }

            if (!itemPool.isEmpty()) {
                for (ItemStack pStack : itemPool) {
                    if (pStack.getItem() instanceof BlockItem blockItem) {
                        blockPool.add(blockItem.getBlock());
                    }
                }
            }

            if (!blockPool.isEmpty()) {
                if(blockPool.size()==1) {
                    pResult = blockPool.get(0);
                }else{
                    pResult = blockPool.get(r.nextInt(blockPool.size() - 1));
                }
                world.setBlock(clickedPos, pResult.defaultBlockState(), 0);
                if (damageOnUse) {
                    pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));
                }
            }

//            pContext.getPlayer().displayClientMessage(Component.literal(this.knifeKey.toString()),false);
            this.knifeKey = pResult.asItem();
        }
        pContext.getLevel().playSound(pContext.getPlayer(), pContext.getClickedPos(), SoundEvents.DEEPSLATE_BREAK, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    //Throwable

    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            int i = this.getUseDuration(pStack) - pTimeLeft;
            if (i >= 10) {
                if (!pLevel.isClientSide) {
                    pStack.hurtAndBreak(1, player, (pPlayer) -> {
                        pPlayer.broadcastBreakEvent(pEntityLiving.getUsedItemHand());
                    });
                    KnifeProjectileEntity knifeProjectile;
                    if(pStack.is(ModMoreItems.FLINTKNIFE.get())){
                        knifeProjectile = new FlintKnifeProjectileEntity(player, pLevel, pStack);
                    } else if (pStack.is(ModMoreItems.STURDYKNIFE.get())) {
                        knifeProjectile = new SturdyKnifeProjectileEntity(player, pLevel, pStack);
                    } else if (pStack.is(ModMoreItems.STONEKNIFE.get())) {
                        knifeProjectile = new StoneKnifeProjectileEntity(player, pLevel, pStack);
                    } else if (pStack.is(ModMoreItems.IRONKNIFE.get())) {
                        knifeProjectile = new IronKnifeProjectileEntity(player, pLevel, pStack);
                    } else if (pStack.is(ModMoreItems.DIAMONDKNIFE.get())) {
                        knifeProjectile = new DiamondKnifeProjectileEntity(player, pLevel, pStack);
                    } else {
                        knifeProjectile = new NetheriteKnifeProjectileEntity(player, pLevel, pStack);
                    }
                    knifeProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F , 1.0F);
                    if (player.getAbilities().instabuild) {
                        knifeProjectile.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                    }

                    pLevel.addFreshEntity(knifeProjectile);
                    pLevel.playSound((Player) null, knifeProjectile, SoundEvents.METAL_HIT, SoundSource.PLAYERS, 1.0F, 1.0F);
                    if (!player.getAbilities().instabuild) {
                        player.getInventory().removeItem(pStack);
                    }
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
            return InteractionResultHolder.fail(itemstack);
        } else if (EnchantmentHelper.getRiptide(itemstack) > 0 && !pPlayer.isInWaterOrRain()) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            pPlayer.startUsingItem(pHand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }

}
