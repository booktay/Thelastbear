package com.books.lastbear;

import static com.books.lastbear.Variables.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	private Texture bear, bear_left, bear_right, bear_up, bear_down;
	private float PLAYER_X, PLAYER_Y;

	public Player() {
		PLAYER_X = VIEWPORT_WIDTH / 2;
		PLAYER_Y = VIEWPORT_HEIGHT / 2;
		HEALTH = 200;
		SPEED = 500;
		loadPlayerTextures();
	}

	public void update() {
		if (A_TOUCHED && !D_TOUCHED && !SPACE_TOUCHED) {
			bear = bear_left;
		} else if (D_TOUCHED && !A_TOUCHED && !SPACE_TOUCHED) {
			bear = bear_right;
		} else if (W_TOUCHED && !A_TOUCHED && !D_TOUCHED) {
			bear = bear_up;
		} else {
			bear = bear_down;
		}
	}

	public void render(SpriteBatch sb) {
		sb.draw(bear, PLAYER_X, PLAYER_Y, (float) (bear.getWidth() / 1.5), (float) (bear.getHeight() / 1.5));
	}

	public void loadPlayerTextures() {
		bear_left = new Texture("bear/bearL.png");
		bear_right = new Texture("bear/bearR.png");
		bear_up = new Texture("bear/bearU.png");
		bear_down = new Texture("bear/bearD.png");
		bear = bear_down;
	}
}
