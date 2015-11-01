package com.mateusz.circles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mateusz.circles.enums.ScreenType;
import com.mateusz.circles.handlers.ScreensManager;

public class Circles extends Game {

	@Override
	public void create() {
		ScreensManager.create();
		ScreensManager.prepareManager(this);
		ScreensManager.getInstance().createScreen(ScreenType.SIMULATION);
	}

	@Override
	public void render() {
		try {
			super.render();
		} catch (Exception e) {
			e.printStackTrace();
			Gdx.app.exit();
		}
	}
}
