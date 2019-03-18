package com.loto.lotomod;

import com.loto.lotomod.registry.BlockRegistry;
import com.loto.lotomod.registry.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("lotomod")
public class LOTOMod
{
	public static LOTOItems lotoItemGroup;

	public LOTOMod()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);

		MinecraftForge.EVENT_BUS.register(this);

		lotoItemGroup = new LOTOItems("loto");
	}

	private void setup(final FMLCommonSetupEvent event)
	{
	}

	private void setupClient(final FMLClientSetupEvent event)
	{

	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
		{
			BlockRegistry.registerBlocks();
		}

		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent)
		{

			ItemRegistry.registerItems();
		}
	}

	public class LOTOItems extends ItemGroup
	{

		public LOTOItems(String label)
		{
			super(label);
		}

		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(ItemRegistry.overlordSword);
		}
	}
}
