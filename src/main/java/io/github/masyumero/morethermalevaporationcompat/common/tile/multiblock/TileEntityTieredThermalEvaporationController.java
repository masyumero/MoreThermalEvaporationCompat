package io.github.masyumero.morethermalevaporationcompat.common.tile.multiblock;

import astral_mekanism.enums.AMEUpgrade;
import io.github.masyumero.morethermalevaporationcompat.common.content.evaporation.TieredThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.util.UpgradeUtils;
import mekanism.api.Action;
import mekanism.api.AutomationType;
import mekanism.api.Upgrade;
import mekanism.common.lib.chunkloading.IChunkLoader;
import mekanism.common.tile.component.TileComponentChunkLoader;
import mekanism.common.tile.interfaces.IHasDumpButton;
import morethermalevaporation.MoreThermalEvaporation;
import morethermalevaporation.common.tile.multiblock.MoreThermalEvaporationPipezHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Set;

public class TileEntityTieredThermalEvaporationController extends TileEntityTieredThermalEvaporationBlock implements IChunkLoader, IHasDumpButton {

    private static final Capability<?>[] CAPS = {ForgeCapabilities.ITEM_HANDLER};
    private final TileComponentChunkLoader<TileEntityTieredThermalEvaporationController> chunkLoaderComponent = new TileComponentChunkLoader<>(this);

    public TileEntityTieredThermalEvaporationController(BlockPos pos, BlockState state, TETier tier) {
        super(tier.getControllerBlock(), pos, state);
        delaySupplier = NO_DELAY;
    }

    @Override
    protected boolean onUpdateServer(TieredThermalEvaporationMultiblockData multiblock) {
        boolean needsPacket = super.onUpdateServer(multiblock);
        if (upgradeComponent.isUpgradeInstalled(AMEUpgrade.WATER_SUPPLY.getValue())) {
            getMultiblock().inputTank.insert(new FluidStack(Fluids.WATER, Integer.MAX_VALUE), Action.EXECUTE, AutomationType.EXTERNAL);
        }
        setActive(multiblock.isFormed());
        return needsPacket;
    }

    @Override
    public void recalculateUpgrades(Upgrade upgrade) {
        super.recalculateUpgrades(upgrade);
        if (UpgradeUtils.isSolarUpgrade(upgrade)) {
            int upgradeCount = upgradeComponent.getUpgrades(upgrade);
            getMultiblock().mteCompat$setUpgradeCount(upgradeCount);
        }
    }

    @Override
    public boolean canBeMaster() {
        return true;
    }

    @Override
    public TileComponentChunkLoader<TileEntityTieredThermalEvaporationController> getChunkLoader() {
        return chunkLoaderComponent;
    }

    @Override
    public Set<ChunkPos> getChunkSet() {
        return Collections.singleton(new ChunkPos(getBlockPos()));
    }


    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction side) {
        var cap = super.getCapability(capability, side);
        if (MoreThermalEvaporation.PipezLoaded && !cap.isPresent() && ArrayUtils.contains(CAPS, capability)) {
            return LazyOptional.of(() -> (T) MoreThermalEvaporationPipezHelper.MAP.get(capability));
        }
        return cap;
    }

    @Override
    public void dump() {
        TieredThermalEvaporationMultiblockData multiblock = getMultiblock();
        multiblock.inputTank.setEmpty();
        multiblock.outputTank.setEmpty();
    }
}