package com.mateusz.circles.multiplayer;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.math.Vector2;
import com.mateusz.api.GameCallback;
import com.mateusz.api.MessageBuilder;
import com.mateusz.api.MessageType;
import com.mateusz.circles.world.OnlineEntity;
import com.mateusz.circles.world.Player;
import com.mateusz.local.LocalMessageHandler;
import com.mateusz.utils.JSONConverter;

public class MyMessageHandler extends LocalMessageHandler {

	private static final short NUMBER_OF_ENTITIES = 3;
	private static Map<String, OnlineEntity> entities = new HashMap<String, OnlineEntity>(NUMBER_OF_ENTITIES);

	public MyMessageHandler(MessageBuilder<?> synchronousMessageBuilder, GameCallback gameCallback) {
		super(synchronousMessageBuilder, gameCallback);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void handleMessages(String inputMessage) {
		MyMessage message = JSONConverter.JSONtoObject(inputMessage, MyMessage.class);

		if (getPlayerName().equals(message.getSenderName()))
			return;

		switch (message.getType()) {
		case UPDATE_STATE:
			OnlineEntity entity = entities.get(message.getSenderName());
			if(entity == null)
				break;
			entity.setPosition(new Vector2(message.getPosX(), message.getPosY()));
			break;
		case SUBSCRIBE:
			if (!entities.containsKey(message.getSenderName())) {
				OnlineEntity player = new Player(message.getSenderName());
				player.init();
				entities.put(message.getSenderName(), player);
				if (message.getContent() != null && !message.getContent().equals("introduce")) {
					sendMessage(new MessageBuilder(MessageType.SUBSCRIBE, getPlayerName()).content("introduce").build());
				}
			}
			break;
		default:
			break;

		}
	}

}
