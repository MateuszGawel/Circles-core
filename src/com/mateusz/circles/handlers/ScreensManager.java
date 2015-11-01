 package com.mateusz.circles.handlers;

import com.mateusz.circles.Circles;
import com.mateusz.circles.enums.ScreenType;
import com.mateusz.circles.screens.BaseScreen;
import com.mateusz.circles.screens.SimulationScreen;

public class ScreensManager {
	
	private static ScreensManager INSTANCE;
	private Circles planets;
	
	public static void create()
	{
		INSTANCE = new ScreensManager();
	}
	public static void destroy()
	{
		INSTANCE = null;
	}
	public static ScreensManager getInstance(){ return INSTANCE; }
	public static void prepareManager(Circles planets)
	{ 
		getInstance().planets = planets; 
	}

	private BaseScreen currentScreen;
	private ScreenType currentScreenType;
			
	public void createScreen(ScreenType screenType, Object... parameters)
	{
		BaseScreen screen = getScreen(screenType, parameters);
		setScreen(screen);
	}

	private BaseScreen getScreen(ScreenType screenType, Object... parameters)
	{
		BaseScreen screen;
		
		if(screenType == ScreenType.SIMULATION)
			screen = new SimulationScreen(planets);
		else
			screen = null;
		
		return screen;
	}
	
	public void setScreen(BaseScreen screen)
	{
		if( currentScreen != null ) currentScreen.dispose();
		
		currentScreen = screen;
		currentScreenType = screen.getSceneType();
	
		planets.setScreen(screen);
	}
	
    public ScreenType getCurrentScreenType(){ return currentScreenType; }
    public BaseScreen getCurrentScreen(){ return currentScreen; }
}