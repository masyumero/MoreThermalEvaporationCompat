package io.github.masyumero.morethermalevaporationcompat.extras.client.tileentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.masyumero.morethermalevaporationcompat.extras.common.content.evaporation.SupremeThermalEvaporationMultiblockData;
import io.github.masyumero.morethermalevaporationcompat.extras.common.tile.multiblock.TileEntitySupremeThermalEvaporationController;
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
public class RenderSupremeThermalEvaporationPlant extends MultiblockTileEntityRenderer<SupremeThermalEvaporationMultiblockData, TileEntitySupremeThermalEvaporationController> {

    public RenderSupremeThermalEvaporationPlant(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void render(TileEntitySupremeThermalEvaporationController tile, SupremeThermalEvaporationMultiblockData multiblock, float partialTick, PoseStack matrix, MultiBufferSource renderer,
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
        return "SupremeThermalEvaporationController";
    }

    @Override
    protected boolean shouldRender(TileEntitySupremeThermalEvaporationController tile, SupremeThermalEvaporationMultiblockData multiblock, Vec3 camera) {
        return super.shouldRender(tile, multiblock, camera) && !multiblock.inputTank.isEmpty();
    }
}