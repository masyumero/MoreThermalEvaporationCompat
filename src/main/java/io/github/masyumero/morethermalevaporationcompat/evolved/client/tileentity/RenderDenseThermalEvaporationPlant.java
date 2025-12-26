package io.github.masyumero.morethermalevaporationcompat.evolved.client.tileentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.content.evaporation.DenseThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.evolved.common.tile.multiblock.TileEntityDenseThermalEvaporationController;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.client.render.data.FluidRenderData;
import mekanism.client.render.data.RenderData;
import mekanism.client.render.tileentity.MultiblockTileEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.phys.Vec3;

@NothingNullByDefault
public class RenderDenseThermalEvaporationPlant extends MultiblockTileEntityRenderer<DenseThermalEvaporationMultiblockData, TileEntityDenseThermalEvaporationController> {

    public RenderDenseThermalEvaporationPlant(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void render(TileEntityDenseThermalEvaporationController tile, DenseThermalEvaporationMultiblockData multiblock, float partialTick, PoseStack matrix, MultiBufferSource renderer,
                          int light, int overlayLight, ProfilerFiller profiler) {
        VertexConsumer buffer = renderer.getBuffer(Sheets.translucentCullBlockSheet());
        FluidRenderData data = RenderData.Builder.create(multiblock.inputTank.getFluid())
                .of(multiblock)
                .height(multiblock.height() - 2)    // TODO なぜか液体の描画が1ブロック分多い
                .build();
        renderObject(data, multiblock.valves, tile.getBlockPos(), matrix, buffer, overlayLight, Math.min(1, multiblock.prevScale));
    }

    @Override
    protected String getProfilerSection() {
        return "DenseThermalEvaporationController";
    }

    @Override
    protected boolean shouldRender(TileEntityDenseThermalEvaporationController tile, DenseThermalEvaporationMultiblockData multiblock, Vec3 camera) {
        return super.shouldRender(tile, multiblock, camera) && !multiblock.inputTank.isEmpty();
//        && MoreThermalEvaporationConfig.RenderFluid.get();
    }
}