package net.minecarft.pebbles.mixin;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DiggerItem.class)
public class DiggerItemMixin extends TieredItem {
    @Shadow
    private final TagKey<Block> blocks;
    @Shadow
    protected final float speed;
    public DiggerItemMixin(Tier pTier, Properties pProperties, TagKey<Block> blocks, float speed) {
        super(pTier, pProperties);
        this.blocks = blocks;
        this.speed = speed;
    }
    /**
     * @author
     * @reason
     */
    @Overwrite
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        return pState.is(this.blocks) ? this.speed / 3 : 1.0F;
    }
}
