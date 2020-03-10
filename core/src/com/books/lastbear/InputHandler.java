package com.books.lastbear;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import static com.books.lastbear.Variables.*;

public class InputHandler {

	public void update() {

		W_TOUCHED = false;
		D_TOUCHED = false;
		A_TOUCHED = false;
		DOWN_TOUCHED = false;
		SPACE_TOUCHED = false;
		ENTER_TOUCHED = false;

		if (Gdx.input.isKeyPressed(Keys.A)) {
			A_TOUCHED = true;
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			D_TOUCHED = true;
		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			W_TOUCHED = true;
		}
		if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			DOWN_TOUCHED = true;
		}
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			SPACE_TOUCHED = true;
		}
		if (Gdx.input.isKeyPressed(Keys.ENTER)) {
			ENTER_TOUCHED = true;
		}
	}
}
