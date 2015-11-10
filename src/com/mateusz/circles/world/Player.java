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
import com.mateusz.client.MessageHandler;
import com.mateusz.client.OnlineEntity;

public class Player extends Actor implements OnlineEntity{

	private Body body;
	private final GameWorld gameWorld;
	private InputHandler inputHandler;
	private MessageHandler messageHandler;
	private boolean controlledByPlayer;

	public Player(String playerName, GameWorld myGameWorld) {
		this.gameWorld = myGameWorld;
		setName(playerName);
		createBody();
		inputHandler = new InputHandler(gameWorld);
		
		//entities handler to po prostu kolekcja wszystkich playerow, trzeba to jakos ladnie polaczyc z API
//		entitiesHandler = new EntitiesHandler();
		messageHandler = new MessageHandler();
		messageHandler.connect(playerName);
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
		messageHandler.send(delta);
		messageHandler.listen();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
	}

	@Override
	public void init() {

	}

	@Override
	public String getEntityName() {
		return getName();
	}

	@Override
	public float getEntityX() {
		return body.getPosition().x;
	}

	@Override
	public float getEntityY() {
		return body.getPosition().y;
	}

	@Override
	public boolean isControlledByPlayer() {
		return controlledByPlayer;
	}
	
	public void setControlledByPlayer(boolean controlledByPlayer){
		this.controlledByPlayer = controlledByPlayer;
	}
}
