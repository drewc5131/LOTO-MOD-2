package com.loto.lotomod.items;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.FireworkRocketEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemOverlordSword extends SwordItem {

	private float attackSpeed;
	private float attackDamage;

	public ItemOverlordSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		this.attackSpeed = attackSpeedIn;
		this.attackDamage = attackDamageIn;
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> lores,
			ITooltipFlag flagIn) {
		lores.add(new StringTextComponent(
				"�o�3�lThe Oversword\n�r�oShoots fireballs.\nLaunches the holder when they are using an elytra."));
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER,
					"Weapon modifier", (double) this.attackDamage, AttributeModifier.Operation.MULTIPLY_BASE));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER,
					"Weapon modifier", (double) this.attackSpeed, AttributeModifier.Operation.MULTIPLY_BASE));
		}

		return multimap;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		// If the player is using an elytra, do the firework launch thing
		if (playerIn.isElytraFlying()) {
			if (!worldIn.isRemote) {
				FireworkRocketEntity entityfireworkrocket = new FireworkRocketEntity(worldIn, itemstack, playerIn);
				worldIn.addEntity(entityfireworkrocket);

			}

			return new ActionResult<ItemStack>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
		}
		// Otherwise, just shoot a fireball
		else {
			double d1 = 4.0D;
			Vec3d looking = playerIn.getLookVec();
			if (looking != null) {
				Vec3d vec3d = playerIn.getLook(1.0F);
				FireballEntity fireball = new FireballEntity(worldIn, playerIn, looking.x, looking.y, looking.z);
				fireball.setPositionAndUpdate(playerIn.posX + vec3d.x * d1, playerIn.posY,
						playerIn.posZ + vec3d.z * d1);
				fireball.setVelocity(looking.x, looking.y, looking.z);
//				fireball.motionX = looking.x;
//				fireball.motionY = looking.y;
//				fireball.motionZ = looking.z;
//				fireball.accelerationX = fireball.motionX * 0.2D;
//				fireball.accelerationY = fireball.motionY * 0.2D;
//				fireball.accelerationZ = fireball.motionZ * 0.2D;
				fireball.explosionPower = 4;
				worldIn.addEntity(fireball);
				playerIn.getCooldownTracker().setCooldown(this, 3);
				return new ActionResult<ItemStack>(ActionResultType.SUCCESS, itemstack);
			}
		}

		return new ActionResult<ItemStack>(ActionResultType.FAIL, itemstack);

	}

}
