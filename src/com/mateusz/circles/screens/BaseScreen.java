package com.mateusz.circles.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mateusz.circles.Circles;
import com.mateusz.circles.enums.ScreenType;


public abstract class BaseScreen implements Screen
{	
	protected Circles runner;
	protected int currentWindowWidth, currentWindowHeight;

	public abstract ScreenType getSceneType();
	
	protected BaseScreen(Circles runner) 
	{
		this.runner = runner;
	}
	
	@Override
	public void show() {

	}
	
	@Override
	public void render(float delta){		
		Gdx.graphics.getGL20().glClearColor( 0, 0, 0, 1 );
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); 
		handleInput();
	}
	
	protected void handleInput()
	{	
		if( Gdx.input.isKeyJustPressed(Keys.ESCAPE) || Gdx.input.isKeyJustPressed(Keys.BACK) )
		{
			Gdx.app.exit();
		}
	}
	
	@Override
	public void resize(int width, int height) {
		currentWindowWidth = width;
		currentWindowHeight = height;
	}
	
	@Override
	public void dispose() 
	{		
		
	}
}
