package com.books.lastbear;

import static com.books.lastbear.Variables.POINT;
import static com.books.lastbear.Variables.VIEWPORT_HEIGHT;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Score {

	private float PointBarX, PointBarY;
	private BitmapFont font;

	public Score() {
		font = new BitmapFont();
		POINT = 0;
	}

	public void render(SpriteBatch sb) {
		PointBarX = 100;
		PointBarY = VIEWPORT_HEIGHT - 100;
		font.getData().setScale(5, 5);
		font.draw(sb, " " + POINT, PointBarX, PointBarY);
	}
}
