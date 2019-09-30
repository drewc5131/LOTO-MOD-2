package com.loto.lotomod.registry;

import com.loto.lotomod.LOTOMod;
import com.loto.lotomod.blocks.BlockOverlordStone;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry
{

	public static Block overlordStone = new BlockOverlordStone(Block.Properties.create(Material.ROCK)).setRegistryName("overlordstone");

	public static void registerBlocks()
	{
		System.out.println("Registering Blocks");
		registerAll(overlordStone);
	}

	public static void registerAll(Block... blocks)
	{
		for (Block block : blocks)
		{
			ForgeRegistries.BLOCKS.register(block);
			// We have to create individual itemblocks for each block, so lets
			// automate it
			ForgeRegistries.ITEMS.register(new BlockItem(block, new Item.Properties().group(LOTOMod.lotoItemGroup)).setRegistryName(block.getRegistryName()));
		}
	}
}
