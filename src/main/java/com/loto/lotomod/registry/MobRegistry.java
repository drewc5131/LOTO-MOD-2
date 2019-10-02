package com.loto.lotomod.registry;

import com.loto.lotomod.mob.EntityOverlordMinion;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.registries.ForgeRegistries;

public class MobRegistry {
	public static EntityType<EntityOverlordMinion> MINION = EntityType.Builder
			.<EntityOverlordMinion>create(EntityOverlordMinion::new, EntityClassification.MONSTER)
			.build("overlordminion");

	public static void registerEntities() {
		ForgeRegistries.ENTITIES.registerAll(MINION.setRegistryName("overlordminion"));

		EntitySpawnPlacementRegistry.register(MINION, PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::func_223325_c);
	}

	public static void registerEntitySpawn(EntityType<? extends LivingEntity> entityType, int weight, int minGroupCount,
			int maxGroupCount, Biome... biomes) {
		for (Biome biome : biomes) {
			biome.getSpawns(EntityClassification.MONSTER)
					.add(new Biome.SpawnListEntry(entityType, weight, minGroupCount, maxGroupCount));
		}
	}
}
