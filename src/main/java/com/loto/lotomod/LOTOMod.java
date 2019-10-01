package com.loto.lotomod;

import com.loto.lotomod.mob.EntityOverlordMinion;
import com.loto.lotomod.mob.OverlordMinionRenderer;
import com.loto.lotomod.net.CustomNamePacket;
import com.loto.lotomod.registry.BlockRegistry;
import com.loto.lotomod.registry.MobRegistry;
import com.loto.lotomod.registry.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("lotomod")
public class LOTOMod
{
	public static LOTOItems lotoItemGroup;
	private static final String NetworkProtocolVersion = "093019";
	public static final SimpleChannel NetworkInstance = NetworkRegistry.newSimpleChannel(
			new ResourceLocation("lotomod", "main"),
			() -> NetworkProtocolVersion,
			NetworkProtocolVersion::equals,
			NetworkProtocolVersion::equals
			);

	public LOTOMod()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);

		MinecraftForge.EVENT_BUS.register(this);

		lotoItemGroup = new LOTOItems("loto");
		
		NetworkInstance.<CustomNamePacket>registerMessage(0, CustomNamePacket.class, CustomNamePacket::encode, CustomNamePacket::new, CustomNamePacket::handle);
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> RenderingRegistry.registerEntityRenderingHandler(EntityOverlordMinion.class, OverlordMinionRenderer::new));
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
		
		@SubscribeEvent
		public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> entityRegistryEvent){
			MobRegistry.registerEntities();
			
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
