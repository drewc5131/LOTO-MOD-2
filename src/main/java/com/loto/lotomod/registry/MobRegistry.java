package com.loto.lotomod.registry;

import com.loto.lotomod.mob.EntityOverlordMinion;

import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.ForgeRegistries;

public class MobRegistry
{
	public static EntityType<EntityOverlordMinion> MINION = EntityType.Builder.create(EntityOverlordMinion.class, EntityOverlordMinion::new).build("overlordminion");
			
			
	public static void registerEntities()
	{
		System.out.println("Registering Entities");
		ForgeRegistries.ENTITIES.registerAll(MINION.setRegistryName("overlordminion"));
	}
}
