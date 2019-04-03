package com.loto.lotomod.registry;

import com.loto.lotomod.LOTOMod;
import com.loto.lotomod.items.ItemMythicalDiamond;
import com.loto.lotomod.items.ItemMythicalPickaxe;
import com.loto.lotomod.items.ItemOverlordSword;
import com.loto.lotomod.items.LOTOItemTier;
import com.loto.lotomod.items.ItemRightPassengerSideMirrorForToyotaCamry2007200820092010UnpaintedNonHeatedNonFoldingDoorUSABuiltOutsideRearViewReplacementMirror;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry
{

	public static Item mythicalDiamond = new ItemMythicalDiamond((new Item.Properties()).group(LOTOMod.lotoItemGroup)).setRegistryName("mythicaldiamond");

	public static Item overlordSword = new ItemOverlordSword(LOTOItemTier.OVERLORD, 8, 20f, (new Item.Properties()).group(LOTOMod.lotoItemGroup)).setRegistryName("overlordsword");

	public static Item mythicalPickaxe = new ItemMythicalPickaxe(LOTOItemTier.MYTHICAL, 2, 4f, (new Item.Properties()).group(LOTOMod.lotoItemGroup)).setRegistryName("mythicalpickaxe");

	public static Item rightPassengerSideMirrorForToyotaCamry2007200820092010UnpaintedNonHeatedNonFoldingDoorUSABuiltOutsideRearViewReplacementMirror = new ItemRightPassengerSideMirrorForToyotaCamry2007200820092010UnpaintedNonHeatedNonFoldingDoorUSABuiltOutsideRearViewReplacementMirror((new Item.Properties()).group(LOTOMod.lotoItemGroup)).setRegistryName("rightpassengersidemirrorforyoyotacamry2007200820092010unpaintednonheatednonfoldingdoorusabuiltoutsiderearviewreplacementmirror");
	public static void registerItems()
	{
		System.out.println("Registering Items");
		ForgeRegistries.ITEMS.registerAll(mythicalDiamond, overlordSword, mythicalPickaxe, rightPassengerSideMirrorForToyotaCamry2007200820092010UnpaintedNonHeatedNonFoldingDoorUSABuiltOutsideRearViewReplacementMirror);
	}
}
