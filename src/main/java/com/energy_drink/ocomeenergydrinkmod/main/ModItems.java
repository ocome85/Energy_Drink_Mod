package com.energy_drink.ocomeenergydrinkmod.main;

import com.energy_drink.ocomeenergydrinkmod.item.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;


@ObjectHolder(OcomeEnergyDrinkMod.MOD_ID)
@Mod.EventBusSubscriber(modid= OcomeEnergyDrinkMod.MOD_ID,bus =Mod.EventBusSubscriber.Bus.MOD)

public class ModItems {
   public static final Item TUTORIAL_T = new Item((new Item.Properties()).tab(OcomeEnergyDrinkMod.MOD_TAB));

    @SubscribeEvent
    public static void  registerItem(RegistryEvent.Register<Item> event){
        //event.getRegistry().register(TUTORIAL_T.setRegistryName("tutorial_t"));
        event.getRegistry().register(new Kiiva_Punch());
        event.getRegistry().register(new Monster_Energy());
        event.getRegistry().register(new Red_Bull());
        event.getRegistry().register(new Red_Bull_SugarFree());
        event.getRegistry().register(new Survivar_Energy_Drink());
        event.getRegistry().register(new Zone_Ver2());
        event.getRegistry().register(new Sword());
        event.getRegistry().register(new Red_Bull_Elytra());
    }
}

