package com.loto.lotomod.net;

import java.util.Optional;
import java.util.function.Supplier;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

public class CustomNamePacket {

	private final String name;
	private static final DataParameter<Optional<ITextComponent>> CUSTOM_PLAYER_NAME = EntityDataManager
			.createKey(Entity.class, DataSerializers.OPTIONAL_TEXT_COMPONENT);

	public CustomNamePacket(PacketBuffer buffer) {
		this.name = buffer.readString();
	}

	public void encode(PacketBuffer buffer) {
		buffer.writeString(name);
	}

	public boolean handle(Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity sender = ctx.get().getSender();
			StringTextComponent strtxvpsdvjadvjasf = new StringTextComponent(this.name);
			sender.getDataManager().set(CUSTOM_PLAYER_NAME, Optional.of(strtxvpsdvjadvjasf));

		});
		return true;

	}

}
