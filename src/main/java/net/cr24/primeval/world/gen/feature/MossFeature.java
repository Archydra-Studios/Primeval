package net.cr24.primeval.world.gen.feature;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.cr24.primeval.block.PrimevalBlocks;
import net.cr24.primeval.block.SpreadingMossBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GlowLichenFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MossFeature extends Feature<GlowLichenFeatureConfig> {
    public MossFeature(Codec<GlowLichenFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<GlowLichenFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        GlowLichenFeatureConfig glowLichenFeatureConfig = context.getConfig();
        if (!isAirOrWater(structureWorldAccess.getBlockState(blockPos))) {
            return false;
        }
        List<Direction> list = shuffleDirections(glowLichenFeatureConfig, random);
        if (generate(structureWorldAccess, blockPos, structureWorldAccess.getBlockState(blockPos), glowLichenFeatureConfig, random, list)) {
            return true;
        }
        BlockPos.Mutable mutable = blockPos.mutableCopy();
        block0: for (Direction direction : list) {
            mutable.set(blockPos);
            List<Direction> list2 = shuffleDirections(glowLichenFeatureConfig, random, direction.getOpposite());
            for (int i = 0; i < glowLichenFeatureConfig.searchRange; ++i) {
                mutable.set(blockPos, direction);
                BlockState blockState = structureWorldAccess.getBlockState(mutable);
                if (!isAirOrWater(blockState) && !blockState.isOf(PrimevalBlocks.MOSS)) continue block0;
                if (!generate(structureWorldAccess, mutable, blockState, glowLichenFeatureConfig, random, list2)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean generate(StructureWorldAccess world, BlockPos pos, BlockState state, GlowLichenFeatureConfig config, Random random, List<Direction> directions) {
        BlockPos.Mutable mutable = pos.mutableCopy();
        for (Direction direction : directions) {
            BlockState blockState = world.getBlockState(mutable.set(pos, direction));
            if (!blockState.isIn(config.canPlaceOn)) continue;
            SpreadingMossBlock mossBlock = (SpreadingMossBlock)PrimevalBlocks.MOSS;
            BlockState blockState2 = mossBlock.withDirection(state, world, pos, direction);
            if (blockState2 == null) {
                return false;
            }
            world.setBlockState(pos, blockState2, Block.NOTIFY_ALL);
            world.getChunk(pos).markBlockForPostProcessing(pos);
            if (random.nextFloat() < config.spreadChance) {
                mossBlock.trySpreadRandomly(blockState2, world, pos, direction, random, true);
            }
            return true;
        }
        return false;
    }

    public static List<Direction> shuffleDirections(GlowLichenFeatureConfig config, Random random) {
        ArrayList<Direction> list = Lists.newArrayList(config.directions);
        Collections.shuffle(list, random);
        return list;
    }

    public static List<Direction> shuffleDirections(GlowLichenFeatureConfig config, Random random, Direction excluded) {
        List<Direction> list = config.directions.stream().filter(direction -> direction != excluded).collect(Collectors.toList());
        Collections.shuffle(list, random);
        return list;
    }

    private static boolean isAirOrWater(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER);
    }
}