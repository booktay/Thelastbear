package com.books.lastbear;

import static com.books.lastbear.Variables.*;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HP {
	private int width = 1, height = 1;
	private Texture barLayer1, barLayer2;
	private float HpBarX, HpBarY;

	public HP() {
		HPCreate();
	}

	public void render(SpriteBatch sb) {
		HpBarX = VIEWPORT_WIDTH - 220;
		HpBarY = VIEWPORT_HEIGHT - 100;
		sb.draw(barLayer2, HpBarX, HpBarY, 200, 80);
		sb.draw(barLayer1, HpBarX, HpBarY, HEALTH, 80);
	}

	private void HPCreate() {
		Pixmap pixmap = createHPPixmap(width, height, 0, 1, 0);
		Pixmap pixmap2 = createHPPixmap(width, height, 1, 0, 0);
		barLayer1 = new Texture(pixmap);
		barLayer2 = new Texture(pixmap2);
	}

	private Pixmap createHPPixmap(int width, int height, int r, int g, int b) {
		Pixmap pixmap = new Pixmap(width, height, Format.RGBA8888);
		pixmap.setColor(r, g, b, 1);
		pixmap.fill();
		return pixmap;
	}

}
