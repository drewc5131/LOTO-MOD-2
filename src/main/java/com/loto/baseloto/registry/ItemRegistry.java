package com.loto.baseloto.registry;
import com.loto.baseloto.LOTOMod;
import com.loto.baseloto.items.ItemOverlordSword;
import com.loto.baseloto.items.LOTOItemTier;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;


public class ItemRegistry {
	public static Item overlordSword = new ItemOverlordSword(LOTOItemTier.OVERLORD, 8, 5f, (new Item.Properties()).group(LOTOMod.lotoItemGroup)).setRegistryName("overlordsword");
	
	public static void registerItems(){
		System.out.println("Registering Items");
		ForgeRegistries.ITEMS.registerAll(overlordSword);
	}	
}
