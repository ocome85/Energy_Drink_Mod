package com.energy_drink.ocomeenergydrinkmod;

import com.energy_drink.ocomeenergydrinkmod.item.CustomElytraLayer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.energy_drink.ocomeenergydrinkmod.main.OcomeEnergyDrinkMod.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
public final class LayerRenderSubscriber {

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void renderPlayer(final EntityRenderersEvent.AddLayers event) {
        LivingEntityRenderer<Player, PlayerModel<Player>> renderer = event.getRenderer(EntityType.PLAYER);
        CustomElytraLayer<Player, PlayerModel<Player>> layer = new CustomElytraLayer<>(renderer, event.getEntityModels());
        renderer.addLayer(layer);
    }


}
