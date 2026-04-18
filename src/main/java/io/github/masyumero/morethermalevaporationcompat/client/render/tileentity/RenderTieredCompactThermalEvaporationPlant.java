package io.github.masyumero.morethermalevaporationcompat.client.render.tileentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.masyumero.morethermalevaporationcompat.common.tier.TETier;
import io.github.masyumero.morethermalevaporationcompat.common.tile.TileEntityTieredCompactThermalEvaporation;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.client.render.MekanismRenderer;
import mekanism.client.render.ModelRenderer;
import mekanism.client.render.RenderResizableCuboid;
import mekanism.client.render.tileentity.MekanismTileEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@NothingNullByDefault
public class RenderTieredCompactThermalEvaporationPlant extends MekanismTileEntityRenderer<TileEntityTieredCompactThermalEvaporation> {

    private final TETier tier;
    private static final Map<FluidStack, Int2ObjectMap<MekanismRenderer.Model3D>> cachedCenterFluids = new HashMap<>();
    private static final Map<FluidStack, Int2ObjectMap<MekanismRenderer.Model3D>> cachedValveFluids = new HashMap<>();

    private static final int stages = 1_400;

    public RenderTieredCompactThermalEvaporationPlant(TETier tier, BlockEntityRendererProvider.Context context) {
        super(context);
        this.tier = tier;
    }

    public static void resetCachedModels() {
        cachedCenterFluids.clear();
        cachedValveFluids.clear();
    }

    @Override
    protected void render(TileEntityTieredCompactThermalEvaporation tile, float partialTick, PoseStack matrix, MultiBufferSource renderer, int light, int overlayLight, ProfilerFiller profiler) {
        FluidStack fluid = tile.inputTank.getFluid();
        float fluidScale = tile.prevScale;

        Lazy<VertexConsumer> buffer = Lazy.of(() -> renderer.getBuffer(Sheets.translucentCullBlockSheet()));

        if (!fluid.isEmpty() && fluidScale > 0) {
            MekanismRenderer.renderObject(getFluidModel(fluid, fluidScale), matrix, buffer.get(), MekanismRenderer.getColorARGB(fluid, fluidScale),
                    MekanismRenderer.calculateGlowLight(light, fluid), overlayLight, RenderResizableCuboid.FaceDisplay.FRONT, getCamera(), tile.getBlockPos());
        }
    }

    @Override
    protected String getProfilerSection() {
        return this.tier.getLowerName() + "ThermalEvaporationCompact";
    }

    public static MekanismRenderer.Model3D getFluidModel(@NotNull FluidStack fluid, float fluidScale) {
        return cachedCenterFluids.computeIfAbsent(fluid, f -> new Int2ObjectOpenHashMap<>())
                .computeIfAbsent(ModelRenderer.getStage(fluid, stages, fluidScale), stage -> new MekanismRenderer.Model3D()
                        .setTexture(MekanismRenderer.getFluidTexture(fluid, MekanismRenderer.FluidTextureType.STILL))
                        .setSideRender(Direction.DOWN, false)
                        .setSideRender(Direction.UP, stage < stages)
                        .xBounds(0.016F, 0.984F)
                        .yBounds(0.125F, 0.125F + 0.75F * (stage / (float) stages))
                        .zBounds(0.016F, 0.984F)
                );
    }

}