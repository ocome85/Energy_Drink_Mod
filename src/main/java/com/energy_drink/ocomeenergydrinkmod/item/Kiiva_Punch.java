package com.energy_drink.ocomeenergydrinkmod.item;


import com.energy_drink.ocomeenergydrinkmod.main.OcomeEnergyDrinkMod;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.List;

public class Kiiva_Punch extends Item {
    public Kiiva_Punch() {
        super(new Properties().tab(OcomeEnergyDrinkMod.MOD_TAB)
                .food(new FoodProperties.Builder()
                        .alwaysEat()
                        .fast()
                        .effect(new MobEffectInstance(MobEffects.REGENERATION,200,1),1F)
                                                                                                                          // =20=1s         //1=2level      //1F =100%
                        .build())
                );
        this.setRegistryName("kiiva_punch");
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flags){
        tooltip.add(new TranslatableComponent(this.getDescriptionId()+".desc"));
    }

@Override
    public UseAnim getUseAnimation(ItemStack p_42931_) {
        return UseAnim.DRINK;
    }


}
