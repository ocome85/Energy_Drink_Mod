package com.energy_drink.ocomeenergydrinkmod.main;

import com.energy_drink.ocomeenergydrinkmod.CustomPlayerRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@net.minecraftforge.fml.common.Mod("ocomeenergydrinkmod")
public class OcomeEnergyDrinkMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static  final CreativeModeTab MOD_TAB = new CreativeTab("ocomeenergydrinkmod");
    public static final String MOD_ID = "ocomeenergydrinkmod";

    public OcomeEnergyDrinkMod() {



        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
   }

    private void processIMC(final InterModProcessEvent event)
    {
   }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @net.minecraftforge.fml.common.Mod.EventBusSubscriber(bus= net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

    @SubscribeEvent
    public void onItemPickup(PlayerEvent.ItemPickupEvent event) {
        ItemStack itemStack = event.getStack();
        String itemNamespace = "";
        String itemPath = "";
        Item item = itemStack.getItem(); //Somehow translates to the item name (minecraft:sand is "sand" here)
        try {
            itemNamespace = Objects.requireNonNull(item.getRegistryName()).getNamespace();
            itemPath = Objects.requireNonNull(item.getRegistryName()).getPath();
        } catch (Exception e) {
            LOGGER.info("Unable to get item namespace or path.");
        }
        String itemId = itemNamespace + ":" + itemPath;
        ServerPlayer player = (ServerPlayer) event.getPlayer();
        String playerName = player.getName().getContents();  //Just player name.

        Minecraft mc = Minecraft.getInstance();
        if(mc.player != null) {
            //mc.player.sendChatMessage("[" + playerName + "][" + player.getPlayerIP() + "] picked up [" + itemId + "][" + itemStack.getCount() + "]");
            LOGGER.info("[" + playerName + "] picked up [" + itemId + "]");
        }
    }



}




