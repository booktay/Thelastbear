package com.books.lastbear;

import static com.books.lastbear.Variables.VIEWPORT_HEIGHT;
import static com.books.lastbear.Variables.VIEWPORT_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TotalText {
	private BitmapFont font;
	private float BarX, BarY;

	public TotalText() {
		font = new BitmapFont();
	}

	public void render(SpriteBatch sb, String Word, int X, int Y, Color word) {
		BarX = VIEWPORT_WIDTH / 2 - 220;
		BarY = VIEWPORT_HEIGHT / 2 - 200;
		font.getData().setScale(6, 6);
		font.setColor(word);
		font.draw(sb, Word, BarX + X, BarY + Y);

	}
}
