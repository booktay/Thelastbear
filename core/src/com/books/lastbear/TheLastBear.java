package com.books.lastbear;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TheLastBear extends Game {
	public SpriteBatch sb;

	@Override
	public void create() {
		sb = new SpriteBatch();
		setScreen(new World(this));
	}

	@Override
	public void render() {
		super.render();
	}

}
