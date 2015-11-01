package com.mateusz.circles.handlers;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mateusz.circles.world.GameWorld;

public class MyContactListener implements ContactListener {
	private GameWorld gameWorld;

	public MyContactListener(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

	@Override
	public void beginContact(Contact contact) {

	}

	@Override
	public void endContact(Contact contact) {

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {

	}

	// HELP METHODS
	private boolean checkFixturesTypes(Fixture fixtureA, Fixture fixtureB, String typeA, String typeB) {
		if (fixtureA.getUserData() != null && fixtureB.getUserData() != null) {
			if ((fixtureA.getUserData().equals(typeA) && fixtureB.getUserData().equals(typeB)) || (fixtureA.getUserData().equals(typeB) && fixtureB.getUserData().equals(typeA))) {
				return true;
			}
		}

		return false;
	}

	private boolean checkFixturesTypesContains(Fixture fixtureA, Fixture fixtureB, String typeA, String typeB) {
		if (fixtureA.getUserData() != null && fixtureB.getUserData() != null) {
			if ((fixtureA.getUserData().toString().contains(typeA) && fixtureB.getUserData().toString().contains(typeB))
					|| (fixtureA.getUserData().toString().contains(typeB) && fixtureB.getUserData().toString().contains(typeA))) {
				return true;
			}
		}

		return false;
	}

	private boolean checkIsOneOfType(Fixture fixtureA, Fixture fixtureB, String type) {
		if (fixtureA.getUserData() != null && fixtureB.getUserData() != null) {
			if (fixtureA.getUserData().equals(type) || fixtureB.getUserData().equals(type)) {
				return true;
			}
		}

		return false;
	}

	private Fixture getFixtureByType(Fixture fixtureA, Fixture fixtureB, String type) {
		return fixtureA.getUserData().equals(type) ? fixtureA : fixtureB;
	}

	private Fixture getFixtureByTypeContains(Fixture fixtureA, Fixture fixtureB, String type) {
		return fixtureA.getUserData().toString().contains(type) ? fixtureA : fixtureB;
	}
}
