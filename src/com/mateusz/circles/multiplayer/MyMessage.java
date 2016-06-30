package com.mateusz.circles.multiplayer;

import java.io.Serializable;

import com.mateusz.api.Message;

public class MyMessage extends Message implements Serializable {

	private static final long serialVersionUID = 8587188729074776736L;
	private float posX, posY;

	public MyMessage() {
		super();
	}

	public MyMessage(MyMessageBuilder messageBuilder) {
		super(messageBuilder);
		this.posX = messageBuilder.getPosition().x;
		this.posY = messageBuilder.getPosition().y;
	}

	public float getPosX() {
		return posX;
	}

	public float getPosY() {
		return posY;
	}

	@Override
	public String toString() {
		return "MyMessage [posX=" + posX + ", posY=" + posY + ", getType()=" + getType() + ", getContent()=" + getContent() + ", getSenderName()=" + getSenderName() + "]";
	}

}
