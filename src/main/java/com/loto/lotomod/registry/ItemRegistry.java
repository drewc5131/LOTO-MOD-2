package com.loto.lotomod.registry;

import com.loto.lotomod.LOTOMod;
import com.loto.lotomod.items.ItemMythicalDiamond;
import com.loto.lotomod.items.ItemMythicalPickaxe;
import com.loto.lotomod.items.ItemOverlordSword;
import com.loto.lotomod.items.LOTOItemTier;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry
{

	public static Item mythicalDiamond = new ItemMythicalDiamond((new Item.Properties()).group(LOTOMod.lotoItemGroup)).setRegistryName("mythicaldiamond");

	public static Item overlordSword = new ItemOverlordSword(LOTOItemTier.OVERLORD, 8, 20f, (new Item.Properties()).group(LOTOMod.lotoItemGroup)).setRegistryName("overlordsword");

	public static Item mythicalPickaxe = new ItemMythicalPickaxe(LOTOItemTier.MYTHICAL, 2, 4f, (new Item.Properties()).group(LOTOMod.lotoItemGroup)).setRegistryName("mythicalpickaxe");

	public static void registerItems()
	{
		System.out.println("Registering Items");
		ForgeRegistries.ITEMS.registerAll(mythicalDiamond, overlordSword, mythicalPickaxe);
	}
}
