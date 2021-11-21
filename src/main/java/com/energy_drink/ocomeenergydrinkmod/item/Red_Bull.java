package com.energy_drink.ocomeenergydrinkmod.item;


import com.energy_drink.ocomeenergydrinkmod.main.OcomeEnergyDrinkMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.commands.SummonCommand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerEvent;

import javax.annotation.Nullable;
import java.util.List;

public class Red_Bull extends Item {
public String string;


    public Red_Bull() {
        super(new Properties().tab(OcomeEnergyDrinkMod.MOD_TAB)
                .food(new FoodProperties.Builder()
                        .alwaysEat()
                        .fast()
                        .effect(new MobEffectInstance(MobEffects.LEVITATION,200,9),1F)
                                                                                                                          // =20=1s         //1=2level      //1F =100%
                        .build())
                );
        this.setRegistryName("red_bull");
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flags){
        tooltip.add(new TranslatableComponent(this.getDescriptionId()+".desc"));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_42931_) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack p_41409_, Level p_41410_, LivingEntity p_41411_) {



     return this.isEdible() ? p_41411_.eat(p_41410_, p_41409_) : p_41409_;
    }


}
