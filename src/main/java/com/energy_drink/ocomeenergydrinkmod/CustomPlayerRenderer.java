package com.energy_drink.ocomeenergydrinkmod;

import com.energy_drink.ocomeenergydrinkmod.item.CustomElytraLayer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CustomPlayerRenderer extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    public CustomPlayerRenderer(EntityRendererProvider.Context p_174557_, boolean p_174558_) {
        super(p_174557_, new PlayerModel<>(p_174557_.bakeLayer(p_174558_ ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), p_174558_), 0.5F);
        this.addLayer(new CustomElytraLayer<>(this, p_174557_.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractClientPlayer p_117783_) {
        return p_117783_.getSkinTextureLocation();
    }
}