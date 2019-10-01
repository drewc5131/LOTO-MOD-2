package com.loto.lotomod.mob;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OverlordMinionRenderer<T extends MobEntity, M extends OverlordMinionModel<T>> extends MobRenderer<EntityOverlordMinion, OverlordMinionModel<EntityOverlordMinion>> {
   private static final ResourceLocation DEFAULT_RES_LOC = new ResourceLocation("lotomod:textures/entity/overlordminion.png");

   public OverlordMinionRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new OverlordMinionModel<>(), 1.0f);
      this.addLayer(new HeadLayer<>(this));
   }

   protected ResourceLocation getEntityTexture(EntityOverlordMinion entity) {
      return DEFAULT_RES_LOC;
   }

}