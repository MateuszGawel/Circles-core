package com.mateusz.circles.world;

import com.badlogic.gdx.math.Vector2;
import com.mateusz.client.MessageBuilder;
import com.mateusz.client.MessageType;

public class MyMessageBuilder extends MessageBuilder<MyMessageBuilder> {

	private Vector2 position;

	public MyMessageBuilder position(Vector2 position) {
		this.position = position;
		return this;
	}

	public MyMessageBuilder(MessageType type, String senderName) {
		super(type, senderName);
	}

	public MyMessage build() {
		return new MyMessage(this);
	}

	public Vector2 getPosition() {
		return position;
	}
}
