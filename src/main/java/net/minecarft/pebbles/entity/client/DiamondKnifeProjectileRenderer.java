package net.minecarft.pebbles.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.entity.custom.knifeProjectile.DiamondKnifeProjectileEntity;
import net.minecarft.pebbles.entity.custom.knifeProjectile.FlintKnifeProjectileEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class DiamondKnifeProjectileRenderer extends EntityRenderer<DiamondKnifeProjectileEntity> {
    private DiamondKnifeProjectileModel model;

    public DiamondKnifeProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new DiamondKnifeProjectileModel(pContext.bakeLayer(DiamondKnifeProjectileModel.LAYER_LOCATION));
    }

    @Override
    public void render(DiamondKnifeProjectileEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pEntity.getRot()));
        pPoseStack.translate(0F,-1.5F,0F);
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(getTextureLocation(pEntity)), false, false);
        this.model.renderToBuffer(pPoseStack, vertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 0F,0F,0F,0F);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(DiamondKnifeProjectileEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(Pebbles.MODID, "textures/entity/diamond_knife_entity_texture.png");
    }
}
