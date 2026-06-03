package net.minecarft.pebbles.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecarft.pebbles.Pebbles;
import net.minecarft.pebbles.entity.custom.knifeProjectile.FlintKnifeProjectileEntity;
import net.minecarft.pebbles.entity.custom.knifeProjectile.IronKnifeProjectileEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class IronKnifeProjectileRenderer extends EntityRenderer<IronKnifeProjectileEntity> {
    private IronKnifeProjectileModel model;

    public IronKnifeProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new IronKnifeProjectileModel(pContext.bakeLayer(IronKnifeProjectileModel.LAYER_LOCATION));
    }

    @Override
    public void render(IronKnifeProjectileEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pEntity.getRot()));
        pPoseStack.translate(0F,-1.5F,0F);
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(getTextureLocation(pEntity)), false, false);
        this.model.renderToBuffer(pPoseStack, vertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 0F,0F,0F,0F);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(IronKnifeProjectileEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(Pebbles.MODID, "textures/entity/iron_knife_entity_texture.png");
    }
}
