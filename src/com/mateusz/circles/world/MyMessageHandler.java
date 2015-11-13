package com.mateusz.circles.world;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import com.mateusz.client.Message;
import com.mateusz.client.MessageHandler;
import com.mateusz.client.MessageType;
import com.mateusz.client.OnlineEntity;

public class MyMessageHandler extends MessageHandler {
	private static final Logger LOGGER = Logger.getLogger(MyMessageHandler.class.getName());
	private static final short NUMBER_OF_ENTITIES = 3;
	private static Set<OnlineEntity> entities = new HashSet<OnlineEntity>(NUMBER_OF_ENTITIES);

	@Override
	public void handleMessages(Message message) {
		if (getPlayerName().equals(message.getSenderName()))
			return;

		switch (message.getType()) {
		case POSITION_UPDATE:
			break;
		case SUBSCRIBE:
			boolean playerExists = false;
			for (OnlineEntity entity : entities) {
				if (entity.getEntityName().equals(message.getSenderName())) {
					playerExists = true;
					break;
				}
			}
			if (!playerExists) {
				entities.add(new Player(message.getSenderName()));
				System.out.println("!!!!Dodalem nowego playera i mam: !!!!");
				entities.forEach((e) -> System.out.println(e));
				if (!message.getContent().equals("introduce")) {
					System.out.println("Nowy player wiec musze mu sie przedstawic");
					sendMessage(new Message(MessageType.SUBSCRIBE, "introduce", getPlayerName()));
				}
			}

			break;
		default:
			break;

		}
	}

}
