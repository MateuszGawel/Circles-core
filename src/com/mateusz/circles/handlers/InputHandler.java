package com.mateusz.circles.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mateusz.circles.world.GameWorld;

public class InputHandler {

	private static final Vector2 right = new Vector2(5f, 0);
	private static final Vector2 left = new Vector2(-5f, 0);
	private static final Vector2 down = new Vector2(0, -5f);
	private static final Vector2 up = new Vector2(0, 5f);

	private GameWorld gameWorld;

	public InputHandler(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

	public void handleInput() {

		if (Gdx.input.isKeyPressed(Keys.UP)) {
			gameWorld.getPlayer().move(up);
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			gameWorld.getPlayer().move(down);
		}

		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			gameWorld.getPlayer().move(left);
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			gameWorld.getPlayer().move(right);
		}
	}
}
