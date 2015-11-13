package com.mateusz.circles.world;

import com.badlogic.gdx.math.Vector2;
import com.mateusz.client.Message;
import com.mateusz.client.MessageType;

public class MyMessage extends Message {

	private static final long serialVersionUID = 7996609214439888638L;
	private final Vector2 position;

	public static class MessageBuilder extends Message.MessageBuilder<MessageBuilder> {
		private Vector2 position;

		public MessageBuilder() {
			super();
		}

		public MessageBuilder(MessageType type, String content, String senderName, Vector2 position) {
			super(type, content, senderName);
		}

		public MessageBuilder position(Vector2 position) {
			this.position = position;
			return this;
		}

		// tutaj bedzie masa setterow, a metoda build bedzie to konwertowac to
		// byte[] i zapisywa jako content albo tego typu pole
		public MyMessage build() {
			return new MyMessage(this);
		}
	}

	protected MyMessage(MessageBuilder messageBuilder) {
		super(messageBuilder);
		position = messageBuilder.position;
	}

	public Vector2 getPosition() {
		return position;
	}
}
