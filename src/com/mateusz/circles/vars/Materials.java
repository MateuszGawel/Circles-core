package com.mateusz.circles.vars;

import com.badlogic.gdx.physics.box2d.FixtureDef;
public class Materials {
	
	public static FixtureDef playerBody;
	public static FixtureDef enemyBody;
	public static FixtureDef bullet;
	public static FixtureDef playerLaser;
	public static FixtureDef boundings;
	public static FixtureDef powerup;
	
	static
	{

	}
	
	private static FixtureDef createFixtureDef(float density, float friction, float restitution, short categoryBits, short maskBits, boolean sensor)
	{
		FixtureDef f = new FixtureDef();
		
		f.density = density;
		f.friction = friction;
		f.restitution = restitution;
		f.filter.categoryBits = categoryBits;
		f.filter.maskBits = maskBits;
		f.isSensor = sensor;
		
		return f;
	}

}
