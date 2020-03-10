package com.books.lastbear;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map {

	public TiledMap tileMap;
	public OrthogonalTiledMapRenderer tileMapRenderer;

	int[] LAYER1;
	int[] LAYER2;
	int[] LAYER3;
	int[] LAYER4;
	int[] LAYER5;
	int[] LAYER6;
	int[] LAYER7;

	public Map(String tilemapPath, int[] Layer1, int[] Layer2, int[] Layer3, int[] Layer4, int[] Layer5, int[] Layer6,
			int[] Layer7) {

		LAYER1 = Layer1;
		LAYER2 = Layer2;
		LAYER3 = Layer3;
		LAYER4 = Layer4;
		LAYER5 = Layer5;
		LAYER6 = Layer6;
		LAYER7 = Layer7;

		tileMap = new TmxMapLoader().load(tilemapPath);
		tileMapRenderer = new OrthogonalTiledMapRenderer(tileMap);

	}

	public Map(String tilemapPath, int[] Layer1, int[] Layer2, int[] Layer3, int[] Layer4, int[] Layer5) {

		LAYER1 = Layer1;
		LAYER2 = Layer2;
		LAYER3 = Layer3;
		LAYER4 = Layer4;
		LAYER5 = Layer5;

		tileMap = new TmxMapLoader().load(tilemapPath);
		tileMapRenderer = new OrthogonalTiledMapRenderer(tileMap);

	}

	public TiledMapRenderer getRenderer() {
		return tileMapRenderer;
	}

	public int[] getLayer1() {
		return LAYER1;
	}

	public int[] getLayer2() {
		return LAYER2;
	}

	public int[] getLayer3() {
		return LAYER3;
	}

	public int[] getLayer4() {
		return LAYER4;
	}

	public int[] getLayer5() {
		return LAYER5;
	}

	public int[] getLayer6() {
		return LAYER6;
	}

	public int[] getLayer7() {
		return LAYER7;
	}

	public TiledMapTileLayer getAllLayer1() {
		return (TiledMapTileLayer) tileMap.getLayers().get(LAYER1[0]);
	}

	public TiledMapTileLayer getAllLayer2() {
		return (TiledMapTileLayer) tileMap.getLayers().get(LAYER2[0]);
	}

	public TiledMapTileLayer getAllLayer3() {
		return (TiledMapTileLayer) tileMap.getLayers().get(LAYER3[0]);
	}

	public TiledMapTileLayer getAllLayer4() {
		return (TiledMapTileLayer) tileMap.getLayers().get(LAYER4[0]);
	}

	public TiledMapTileLayer getAllLayer5() {
		return (TiledMapTileLayer) tileMap.getLayers().get(LAYER5[0]);
	}

	public TiledMapTileLayer getAllLayer6() {
		return (TiledMapTileLayer) tileMap.getLayers().get(LAYER6[0]);
	}

	public TiledMapTileLayer getAllLayer7() {
		return (TiledMapTileLayer) tileMap.getLayers().get(LAYER7[0]);
	}

	/*
	 * --- Tile Map Credit --- Gameart2d.com -----------------------
	 */
}
