package io.github.masyumero.morethermalevaporationcompat.common.command.builders;

import io.github.masyumero.morethermalevaporationcompat.common.registries.MoreThermalEvaporationCompatBlocks;
import mekanism.common.command.builders.StructureBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class Builders {

    private Builders() {
    }

    public static class AbsoluteEvaporationBuilder extends StructureBuilder {

        public AbsoluteEvaporationBuilder() {
            super(4, 18, 4);
        }

        @Override
        protected void build(Level world, BlockPos start, boolean empty) {
            buildFrame(world, start);
            buildWalls(world, start);
            buildInteriorLayers(world, start, 1, 17, Blocks.AIR);
            world.setBlockAndUpdate(start.offset(1, 1, 0), MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_CONTROLLER.getBlock().defaultBlockState());
        }

        @Override
        protected Block getCasing() {
            return MoreThermalEvaporationCompatBlocks.ABSOLUTE_THERMAL_EVAPORATION_BLOCK.getBlock();
        }
    }
}
