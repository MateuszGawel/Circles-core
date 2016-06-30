package com.mateusz.circles.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mateusz.circles.Circles;
import com.mateusz.circles.enums.ScreenType;
import com.mateusz.circles.world.GameWorld;

public class SimulationScreen extends BaseScreen {
	GameWorld gameWorld;

	public SimulationScreen(Circles planets) {
		super(planets);
		this.gameWorld = GameWorld.getInstance();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		if (gameWorld.isGameStarted()) {
			gameWorld.act(delta);
			gameWorld.draw();
		}
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void show() {
		gameWorld.init();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void handleInput() {
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE) || Gdx.input.isKeyJustPressed(Keys.BACK)) {

		}
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public ScreenType getSceneType() {
		return ScreenType.SIMULATION;
	}

}
