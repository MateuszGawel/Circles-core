package com.mateusz.circles.world;

import com.badlogic.gdx.math.Vector2;

public interface OnlineEntity {
	void init();

	boolean isControlledByPlayer();

	String getName();

	Vector2 getPosition();

	void setPosition(Vector2 position);
}
