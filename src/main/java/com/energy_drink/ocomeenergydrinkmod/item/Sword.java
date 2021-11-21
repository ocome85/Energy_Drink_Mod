package com.energy_drink.ocomeenergydrinkmod.item;

import com.energy_drink.ocomeenergydrinkmod.main.OcomeEnergyDrinkMod;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;
import java.util.Objects;

public class Sword extends SwordItem {

    public Sword() {
        //damage Tier+p_43270_+1 speed 4+p_43271_
        super(Tiers.GOLD, 3, -2.4F, new Properties().tab(OcomeEnergyDrinkMod.MOD_TAB).rarity(Rarity.EPIC).fireResistant());

        this.setRegistryName("sword");
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //攻撃時　微回復
        attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1, 5));

        Vec3 vec3 = attacker.getViewVector(1.0F);

        //攻撃時　上へ飛ばす                                                   上
        target.setDeltaMovement(target.getDeltaMovement().add(vec3.x, (double) 0.2F, vec3.z));
        stack.hurtAndBreak(1, attacker, (entity) -> {
            entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;

    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // Right Click
        ItemStack itemStack = player.getItemInHand(hand);
        player.startUsingItem(hand);

        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 50, 10));
        // Ghast ball shot
        Vec3 vec3 = player.getViewVector(1.0F);
        LargeFireball largefireball = new LargeFireball(level, player, vec3.x, vec3.y - 3, vec3.z, 10);
        largefireball.setPos(player.getX() + vec3.x, player.getOnPos().getY() + 3, player.getZ() + vec3.z);
        largefireball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
        level.addFreshEntity(largefireball);

        //
        itemStack.hurtAndBreak(2, player, (entity) -> {
            entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });

        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add(new TranslatableComponent(this.getDescriptionId() + ".desc"));
    }

}

