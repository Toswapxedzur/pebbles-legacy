package net.minecarft.pebbles.mixin;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Item.Properties.class)
public class ItemMixin {
    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 64))
    public int Modifying(int a){
        return 8;
    }
    @ModifyVariable(method = "stacksTo", at=@At("HEAD"), ordinal = 0)
    public int inject(int pMaxStackSize){
        if(pMaxStackSize == 1){
            return 1;
        }else if(pMaxStackSize == 16){
            return 4;
        }else{
            return pMaxStackSize;
        }
    }
}
