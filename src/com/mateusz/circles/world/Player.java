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
import com.mateusz.client.MessageType;
import com.mateusz.client.OnlineEntity;

public class Player extends Actor implements OnlineEntity {

	private Body body;
	private final GameWorld gameWorld;
	private InputHandler inputHandler;
	private MessageHandler messageHandler;
	private MyMessageBuilder synchronousMessageBuilder;
	private boolean controlledByPlayer;
	private String playerName;

	public Player(String playerName) {
		this.gameWorld = GameWorld.getInstance();
		this.playerName = playerName;
		this.inputHandler = new InputHandler(gameWorld);
		setName(playerName);
		createBody();
	}

	public void connectToServer() {
		synchronousMessageBuilder = new MyMessageBuilder(MessageType.UPDATE, playerName);
		messageHandler = new MyMessageHandler(synchronousMessageBuilder);
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
		body.setTransform(new Vector2(10, 5), 0);
		body.setLinearDamping(1);
	}

	public void move(Vector2 force) {
		body.applyForceToCenter(force, true);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		inputHandler.handleInput();
		messageHandler.sendBufferedMessage(delta);
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

	public void setControlledByPlayer(boolean controlledByPlayer) {
		this.controlledByPlayer = controlledByPlayer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [controlledByPlayer=" + controlledByPlayer + ", playerName=" + playerName + "]";
	}
}
