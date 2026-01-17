package io.github.masyumero.morethermalevaporationcompat.common.upgrade;

import mekanism.common.capabilities.fluid.BasicFluidTank;
import mekanism.common.capabilities.heat.VariableHeatCapacitor;
import mekanism.common.inventory.slot.FluidInventorySlot;
import mekanism.common.inventory.slot.OutputInventorySlot;
import mekanism.common.tile.component.ITileComponent;
import mekanism.common.tile.interfaces.IRedstoneControl;
import mekanism.common.upgrade.IUpgradeData;
import net.minecraft.nbt.CompoundTag;

import java.util.List;

public class TieredCompactThermalEvaporationUpgradeData implements IUpgradeData {

    public final boolean redstone;
    public final IRedstoneControl.RedstoneControl controlType;
    public final BasicFluidTank inputTank;
    public final BasicFluidTank outputTank;
    public final FluidInventorySlot inputInputSlot;
    public final OutputInventorySlot outputInputSlot;
    public final FluidInventorySlot inputOutputSlot;
    public final OutputInventorySlot outputOutputSlot;
    public final VariableHeatCapacitor heatCapacitor;
    public final CompoundTag components;

    public TieredCompactThermalEvaporationUpgradeData(boolean redstone, IRedstoneControl.RedstoneControl controlType, BasicFluidTank inputTank, BasicFluidTank outputTank, FluidInventorySlot inputInputSlot, OutputInventorySlot outputInputSlot, FluidInventorySlot inputOutputSlot, OutputInventorySlot outputOutputSlot, VariableHeatCapacitor heatCapacitor, List<ITileComponent> components) {
        this.redstone = redstone;
        this.controlType = controlType;
        this.inputTank = inputTank;
        this.outputTank = outputTank;
        this.inputInputSlot = inputInputSlot;
        this.outputInputSlot = outputInputSlot;
        this.inputOutputSlot = inputOutputSlot;
        this.outputOutputSlot = outputOutputSlot;
        this.heatCapacitor = heatCapacitor;
        this.components = new CompoundTag();
        for (ITileComponent component : components) {
            component.write(this.components);
        }
    }
}
