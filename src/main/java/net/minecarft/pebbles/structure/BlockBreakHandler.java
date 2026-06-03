package net.minecarft.pebbles.structure;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.block.ModBlocks;
import net.minecarft.pebbles.utility.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = Pebbles.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockBreakHandler {
    @SubscribeEvent
    public static void blockUpdate(BlockEvent.NeighborNotifyEvent event){
        Level world = (Level) event.getLevel();
        BlockPos pos = event.getPos();
        if(!world.isClientSide){
            if (world.dimension() != Level.END && world.getBlockState(pos).isAir()){
                for(BlockPos adjacent : BlockPos.betweenClosed(pos.offset(-1,-1,-1), pos.offset(1,1,1))){
                    if(pos.getY()>=-64 && pos.getY()<=320) {
                        if (adjacent.distManhattan(pos) >= 1) {
                            TickHandler.checkPhysics.add(Pair.of(new BlockPos(adjacent), world));
                        }
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public static void entityPlace(BlockEvent.EntityPlaceEvent event){
        Level world = (Level) event.getLevel();
        if(!world.isClientSide){
            if (world.dimension() != Level.END){
                TickHandler.checkPhysics.add(Pair.of(new BlockPos(event.getPos()), world));
            }
        }
    }
}
