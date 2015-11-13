package com.mateusz.circles.world;

import java.io.Serializable;

import com.badlogic.gdx.math.Vector2;
import com.mateusz.client.Message;
import com.mateusz.client.MessageType;

public class MyMessage extends Message implements Serializable {

	private static final long serialVersionUID = 8587188729074776736L;
	private Vector2 position;

	public MyMessage() {
		super();
	}

	public MyMessage(MessageType type, Object content, String senderName, Vector2 position) {
		super(type, content, senderName);
		this.position = position;
	}

	public MyMessage(MyMessageBuilder messageBuilder) {
		super(messageBuilder);
		this.position = messageBuilder.getPosition();
	}

	public Vector2 getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "MyMessage [position=" + position + ", getType()=" + getType() + ", getContent()=" + getContent() + ", getSenderName()=" + getSenderName() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
