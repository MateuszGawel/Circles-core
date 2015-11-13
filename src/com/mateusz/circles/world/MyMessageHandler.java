package com.mateusz.circles.world;

import java.util.HashMap;
import java.util.Map;
import static com.mateusz.circles.world.MyMessage.MessageBuilder;
import com.mateusz.client.Message;
import com.mateusz.client.MessageHandler;
import com.mateusz.client.MessageType;
import com.mateusz.client.OnlineEntity;

public class MyMessageHandler extends MessageHandler {

	private static final short NUMBER_OF_ENTITIES = 3;
	private static Map<String, OnlineEntity> entities = new HashMap<String, OnlineEntity>(NUMBER_OF_ENTITIES);
	
	public MyMessageHandler(MessageBuilder synchronousMessageBuilder) {
		super(synchronousMessageBuilder);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void handleMessages(Message message) {
		if (getPlayerName().equals(message.getSenderName()))
			return;

		switch (message.getType()) {
		case UPDATE:
			break;
		case SUBSCRIBE:
			if (!entities.containsKey(message.getSenderName())) {
				entities.put(message.getSenderName(), new Player(message.getSenderName()));
				System.out.println("!!!!Dodalem nowego playera i mam: !!!!");
				entities.values().forEach((e) -> System.out.println(e));
				if (!message.getContent().equals("introduce")) {
					System.out.println("Nowy player wiec musze mu sie przedstawic");
					sendMessage(new Message.MessageBuilder().type(MessageType.SUBSCRIBE).senderName(getPlayerName()).content("introduce").build());
				}
			}

			break;
		default:
			break;

		}
	}

}
