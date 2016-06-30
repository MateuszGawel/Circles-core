package com.mateusz.circles.multiplayer;

import com.badlogic.gdx.math.Vector2;
import com.mateusz.api.MessageBuilder;
import com.mateusz.api.MessageType;

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
