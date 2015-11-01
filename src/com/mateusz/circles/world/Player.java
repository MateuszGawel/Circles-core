package com.mateusz.circles.world;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mateusz.circles.handlers.InputHandler;

public class Player extends Actor {

	private Body body;
	private GameWorld gameWorld;
	private InputHandler inputHandler;
	
	public Player(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		createBody();
		inputHandler = new InputHandler(gameWorld);
	}

	private void createBody() {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;

		CircleShape shape = new CircleShape();
		shape.setRadius(0.5f);
		FixtureDef fixDef = new FixtureDef();
		fixDef.shape = shape;

		body = gameWorld.getWorld().createBody(bodyDef);
		body.createFixture(fixDef);
	}

	public void move(Vector2 force) {
		body.applyForceToCenter(force, true);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		inputHandler.handleInput();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
	}

}
