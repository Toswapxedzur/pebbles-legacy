package net.minecarft.pebbles.structure;

import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.utility.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.*;

@Mod.EventBusSubscriber(modid = Pebbles.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TickHandler {
    public static Queue<Pair<BlockPos, Level>> checkPhysics = new LinkedList<>();
    private static int timeCount = 0, entityCount;

    private static final Direction fourDirection[] = new Direction[]{Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH};

    @SubscribeEvent
    public static void onTick(TickEvent.ServerTickEvent event){
        if(event.phase.equals(TickEvent.Phase.START) && event.side.equals(LogicalSide.SERVER)) {
            if (onCount() == 0) {
                entityCount=0;
                while (!checkPhysics.isEmpty()) {
                    Pair<BlockPos, Level> checkValue = checkPhysics.remove();
                    if (!getBlock(checkValue.getKey(), checkValue.getValue()).defaultBlockState().isAir()) {
                        if (!checkBreak(checkValue.getKey(), checkValue.getValue())) {
                            fallBlock(checkValue.getKey(), checkValue.getValue());
                            entityCount++;
                        }
                    }
                    if(entityCount>1000){
                        break;
                    }
                }
                checkPhysics.clear();
            }
        }
    }

    private static int onCount(){
        timeCount++;
        if(timeCount>=0){
            timeCount=0;
        }
        return timeCount;
    }

    public static void fallBlock(BlockPos pos, Level level){
        FallingBlockEntity newFallBlock = FallingBlockEntity.fall(level, pos, level.getBlockState(pos));
        newFallBlock.dropItem = true;
        level.addFreshEntity(newFallBlock);
    }

    public static void breakBlock(BlockPos pos, Level level){
        level.destroyBlock(pos, true);
    }

    public static boolean checkBreak(BlockPos pos, Level level){
        boolean supporter = false;
        Pair<BlockPos, Integer> nextEntry;
        BlockPos checkPos, newPos;
        BlockState checkstate, newstate;
        Block checkBlock;
        int checkSupport, newSupport, currentHeight = pos.getY();

        Queue<Pair<BlockPos, Integer>> iterationPos = new LinkedList<>();
        HashSet<Pair<BlockPos, Level>> visitedPos = new HashSet<>();
        iterationPos.add(Pair.of(pos, 100));

        while (!iterationPos.isEmpty()) {
            nextEntry = iterationPos.remove();
            checkPos = nextEntry.getLeft();
            checkSupport = nextEntry.getRight();
            checkstate = level.getBlockState(checkPos);
            checkBlock = checkstate.getBlock();

            if (visitedPos.contains(Pair.of(checkPos, level))) {
                continue;
            }
            visitedPos.add(Pair.of(checkPos, level));

            if (checkSupport < 0) {
                continue;
            }

            if (checkPos.getY() < currentHeight || getBlock(checkPos, level).defaultBlockState().is(ModTags.Blocks.ANTIGRAVITY)) {
                supporter = true;
                iterationPos.clear();
                break;
            }

            if (StrengthData.getType(getBlock(checkPos, level)) == 1 && checkstate.hasProperty(BlockStateProperties.AXIS) && checkstate.getValue(BlockStateProperties.AXIS) != Direction.Axis.Y) {
                Direction.Axis checkAxis = checkstate.getValue(BlockStateProperties.AXIS);
                Triple<Integer, Integer, Integer> horizontal = StrengthData.getHorizontal(checkBlock);
                int hConnection = horizontal.getLeft(), hSideCohesion = horizontal.getMiddle(), hFoundation = horizontal.getRight();

                newSupport = 0;
                newPos = checkAxis == Direction.Axis.X ? checkPos.east() : checkPos.north();
                newstate = level.getBlockState(newPos);
                if (isValid(newPos, level)) {
                    if (newstate.hasProperty(BlockStateProperties.AXIS) && newstate.is(checkBlock) && newstate.getValue(BlockStateProperties.AXIS) == checkAxis) {
                        if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                            newSupport = checkSupport - hConnection;
                        }
                    }
                    iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                }

                newSupport = 0;
                newPos = checkAxis == Direction.Axis.X ? checkPos.west() : checkPos.south();
                newstate = level.getBlockState(newPos);
                if (isValid(newPos, level)) {
                    if (newstate.hasProperty(BlockStateProperties.AXIS) && newstate.is(checkBlock) && newstate.getValue(BlockStateProperties.AXIS) == checkAxis) {
                        if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                            newSupport = checkSupport - hConnection;
                        }
                    }
                    iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                }


                newSupport = 0;
                newPos = checkAxis == Direction.Axis.X ? checkPos.south() : checkPos.west();
                if (isValid(newPos, level)) {
                    if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                        newSupport = checkSupport - hSideCohesion;
                    }
                    iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                }

                newSupport = 0;
                newPos = checkAxis == Direction.Axis.X ? checkPos.north() : checkPos.east();
                if (isValid(newPos, level)) {
                    if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                        newSupport = checkSupport - hSideCohesion;
                    }
                    iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                }

                newSupport = 0;
                newPos = checkPos.below();
                if (checkPos.getY() > -64) {
                    if (isValid(newPos, level)) {
                        if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                            newSupport = checkSupport - StrengthData.getFoundation(getBlock(newPos, level));
                        }
                        iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                    }
                }
            }else if(checkstate.getBlock() instanceof StairBlock){
                Direction facing = checkstate.getValue(BlockStateProperties.HORIZONTAL_FACING);
                Half half = checkstate.getValue(BlockStateProperties.HALF);

                newSupport=0;
                if (checkPos.getY() < 320) {
                    if(half.equals(Half.TOP)) {
                        newPos = checkPos.above();
                        if (isValid(newPos, level)) {
                            if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                                newSupport = checkSupport - StrengthData.getTension(getBlock(newPos, level));
                            }
                            iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                        }
                    }
                }

                newSupport=0;
                if (checkPos.getY() > -64) {
                    if(half.equals(Half.BOTTOM)) {
                        newPos = checkPos.below();
                        if (isValid(newPos, level)) {
                            if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                                newSupport = checkSupport - StrengthData.getFoundation(getBlock(newPos, level));
                            }
                            iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                        }
                    }
                }

                for(Direction direction: fourDirection) {
                    newSupport = 0;
                    newPos = checkPos.relative(direction);
                    if (isValid(newPos, level)) {
                        if(facing.equals(direction)) {
                            if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                                newSupport = checkSupport - StrengthData.getCohesion(getBlock(checkPos, level));
                            }
                            iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                        }
                    }
                }

            } else {

                newSupport=0;
                if (checkPos.getY() < 320) {
                    newPos = checkPos.above();
                    if (isValid(newPos, level)) {
                        if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                            newSupport = checkSupport - StrengthData.getTension(getBlock(newPos, level));
                        }
                        iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                    }
                }

                newSupport=0;
                newPos = checkPos.east();
                if (isValid(newPos, level)) {
                    if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                        newSupport = checkSupport - StrengthData.getCohesion(getBlock(checkPos, level));
                    }
                    iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                }
                newSupport=0;
                newPos = checkPos.west();
                if (isValid(newPos, level)) {
                    if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                        newSupport = checkSupport - StrengthData.getCohesion(getBlock(checkPos, level));
                    }
                    iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                }
                newSupport=0;
                newPos = checkPos.north();
                if (isValid(newPos, level)) {
                    if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                        newSupport = checkSupport - StrengthData.getCohesion(getBlock(checkPos, level));
                    }
                    iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                }
                newSupport=0;
                newPos = checkPos.south();
                if (isValid(newPos, level)) {
                    if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                        newSupport = checkSupport - StrengthData.getCohesion(getBlock(checkPos, level));
                    }
                    iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                }

                newSupport=0;
                if (checkPos.getY() > -64) {
                    newPos = checkPos.below();
                    if (isValid(newPos, level)) {
                        if (isLimitSupportValid(checkPos, newPos, level) && isStairSupportValid(checkPos, newPos, level)) {
                            newSupport = checkSupport - StrengthData.getFoundation(getBlock(newPos, level));
                        }
                        iterationPos.add(Pair.of(new BlockPos(newPos), newSupport));
                    }
                }
            }
        }
        return supporter;
    }

    public static Block getBlock(BlockPos pos, Level level){ return level.getBlockState(pos).getBlock(); }

    //check if the block has hitbox and are able to handle physics
    public static boolean isValid(BlockPos pos, Level level){ return level.getBlockState(pos).blocksMotion(); }

    //check the new support validity, if the block have limit support
    public static boolean isLimitSupportValid(BlockPos prevPos, BlockPos newPos, Level level){
        boolean support = true;
        BlockState prevState = level.getBlockState(prevPos), newState = level.getBlockState(newPos);
        Block prevBlock = prevState.getBlock(), newBlock = newState.getBlock();
        if(StrengthData.hasLimitSupport(prevBlock)){
            if(!StrengthData.getLimitSupport(prevBlock).contains(newBlock)){
                support=false;
            }
        }
        if(StrengthData.hasLimitSupport(newBlock)){
            if(!StrengthData.getLimitSupport(newBlock).contains(prevBlock)){
                support=false;
            }
        }
        return support;
    }

    //check the new support is not stair that couldn't connect
    public static boolean isStairSupportValid(BlockPos prevPos, BlockPos newPos, Level level){
        boolean support = true;
        BlockState prevState = level.getBlockState(prevPos), newState = level.getBlockState(newPos);
        Block prevBlock = prevState.getBlock(), newBlock = newState.getBlock();
        if (newState.getBlock() instanceof StairBlock) {
            Half half = newState.getValue(BlockStateProperties.HALF);
            Direction direction = newState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            if (newPos.getY() < prevPos.getY()) {
                if (half.equals(Half.BOTTOM)) {
                    support = false;
                }
            } else if (newPos.getY() > prevPos.getY()) {
                if (half.equals(Half.TOP)) {
                    support = false;
                }
            } else {
                if (!newPos.relative(direction).equals(prevPos)) {
                    support = false;
                }
            }
        }
        return support;
    }
}
