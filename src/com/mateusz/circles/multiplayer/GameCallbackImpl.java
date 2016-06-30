package com.mateusz.circles.multiplayer;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mateusz.api.GameCallback;
import com.mateusz.circles.world.GameWorld;

public class GameCallbackImpl implements GameCallback {
	private static final Logger LOGGER = Logger.getLogger(GameCallbackImpl.class.getName());
	private GameWorld gameWorld;

	public GameCallbackImpl(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	
	@Override
	public void startGame() {
		LOGGER.log(Level.INFO, "startGame()");
		gameWorld.setGameStarted(true);
	}

	public GameWorld getGameWorld() {
		return gameWorld;
	}

	public void setGameWorld(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

}
