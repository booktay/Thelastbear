package com.books.lastbear;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import static com.books.lastbear.Variables.*;

public class CollisionDetection {
	public TiledMapTileLayer CollisionMargin, CollisionPoint, CollisionExtraEvent, CollisionHPUp, CollisionWin;

	public CollisionDetection(TiledMapTileLayer Layer1, TiledMapTileLayer Layer4, TiledMapTileLayer Layer5,
			TiledMapTileLayer Layer6, TiledMapTileLayer Layer7) {
		this.CollisionMargin = Layer1;
		this.CollisionPoint = Layer4;
		this.CollisionExtraEvent = Layer5;
		this.CollisionHPUp = Layer6;
		this.CollisionWin = Layer7;
	}

	public boolean isCellBlock(float x, float y, TiledMapTileLayer CollisionLayer, boolean CheckLayer) {
		if (SPACE_TOUCHED) { // God Mode
			return false;
		}
		Cell cell = CollisionLayer.getCell((int) (x / CollisionLayer.getTileWidth()),
				(int) (y / CollisionLayer.getTileHeight()));
		boolean block = cell != null && cell.getTile() != null;
		if (CheckLayer && cell != null && cell.getTile() != null)
			cell.setTile(null);
		return block;
	}

	public boolean isCollisionMargin(float x, float y) {
		return isCellBlock(x, y, CollisionMargin, false);
	}

	public boolean isCollisionPoint(float x, float y) {
		return isCellBlock(x, y, CollisionPoint, true);
	}

	public boolean isCollisionExtra(float x, float y) {
		return isCellBlock(x, y, CollisionExtraEvent, true);
	}

	public boolean isCollisionHPUp(float x, float y) {
		return isCellBlock(x, y, CollisionHPUp, true);
	}

	public boolean isCollisionEnd(float x, float y) {
		return isCellBlock(x, y, CollisionWin, true);
	}

}
