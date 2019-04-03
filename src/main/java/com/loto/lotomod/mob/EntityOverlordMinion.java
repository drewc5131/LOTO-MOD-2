package com.loto.lotomod.mob;

import com.loto.lotomod.registry.MobRegistry;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class EntityOverlordMinion extends EntityMob
{
	protected EntityOverlordMinion(EntityType<?> type, World worldIn)
	{
		super(type, worldIn);
		setCustomName(new TextComponentString("Overlord Minion"));
	}

	public EntityOverlordMinion(World worldIn)
	{
		this(MobRegistry.MINION, worldIn);
		setCustomName(new TextComponentString("Overlord Minion"));
	}

	protected void initEntityAI()
	{
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.applyEntityAI();
	}

	protected void applyEntityAI()
	{
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityPigZombie.class));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
	}

	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	}

	protected void registerData()
	{
		super.registerData();
	}
	
	@Override
	public boolean getAlwaysRenderNameTagForRender(){
		return true;
	}
	

}
