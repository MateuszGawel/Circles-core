package com.mateusz.circles.world;

import static com.mateusz.circles.vars.Box2DVars.PPM;
import static com.mateusz.circles.vars.Box2DVars.SCREEN_HEIGHT;
import static com.mateusz.circles.vars.Box2DVars.SCREEN_WIDTH;

import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mateusz.circles.handlers.MyContactListener;

public class GameWorld {

	private static GameWorld gameWorld = new GameWorld();
	private World world;
	private Box2DDebugRenderer debugRenderer;
	private Stage gameWorldStage;
	private Player player;

	private boolean gameStarted;
	
	public GameWorld() {
		world = new World(new Vector2(0, 0), true);
		debugRenderer = new Box2DDebugRenderer();
		createGameWorldStage();

		world.setContactListener(new MyContactListener(this));
	}

	private void createGameWorldStage() {
		gameWorldStage = new Stage();
		gameWorldStage.setViewport(new FillViewport(SCREEN_WIDTH / PPM, SCREEN_HEIGHT / PPM));
		((OrthographicCamera) gameWorldStage.getCamera()).setToOrtho(false, SCREEN_WIDTH / PPM, SCREEN_HEIGHT / PPM);

	}

	public void init() {
		player = new Player("GRACZ " + String.valueOf(new Random().nextInt(100) + 1));
		player.connectToServer();
		gameWorldStage.addActor(player);
	}

	public void act(float delta) {
		world.step(delta, 3, 3);
		gameWorldStage.act();
	}

	public void draw() {
		gameWorldStage.draw();
		debugRenderer.render(world, gameWorldStage.getCamera().combined);
	}

	public Stage getGameWorldStage() {
		return gameWorldStage;
	}

	public World getWorld() {
		return world;
	}

	public Box2DDebugRenderer getDebugRenderer() {
		return debugRenderer;
	}

	public Player getPlayer() {
		return player;
	}

	public static GameWorld getInstance() {
		return gameWorld;
	}

	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}
}
