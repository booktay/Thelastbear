package com.books.lastbear;

import static com.books.lastbear.Variables.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World extends ScreenAdapter {
	private SpriteBatch sb;
	private OrthographicCamera cam;
	private Player player;
	private Map mapPlay, mapGround;
	private HP hp;
	private Score score;
	private TotalText totalText;
	private InputHandler inputHandler;
	private Sound sound;
	private ScreenUpdate screen;
	private CollisionDetection collisionDetection;
	private int CheckMode;

	public World(TheLastBear thelastbear) {
		this.sb = thelastbear.sb;
		initWorld();
	}

	public void initWorld() {
		initCamera();
		sb.setProjectionMatrix(cam.combined);
		initMap();
		initVariable();
		initRender();
	}

	public void initCamera() {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
	}

	public void initMap() {
		mapPlay = new Map("map.tmx", new int[] { 0 }, new int[] { 1 }, new int[] { 2 }, new int[] { 3 },
				new int[] { 4 }, new int[] { 5 }, new int[] { 6 });
		mapGround = new Map("mapE.tmx", new int[] { 0 }, new int[] { 1 }, new int[] { 2 }, new int[] { 3 },
				new int[] { 4 });
		collisionDetection = new CollisionDetection(mapPlay.getAllLayer1(), mapPlay.getAllLayer4(),
				mapPlay.getAllLayer5(), mapPlay.getAllLayer6(), mapPlay.getAllLayer7());
	}

	public void initVariable() {
		STATE = 0;
		CheckMode = 0;
	}

	public void initRender() {
		inputHandler = new InputHandler();
		sound = new Sound();
		totalText = new TotalText();
		player = new Player();
		screen = new ScreenUpdate(collisionDetection, cam, sound);
		score = new Score();
		hp = new HP();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderMap(delta);
	}

	public void renderBatch() {
		sb.begin();
		player.render(sb);
		hp.render(sb);
		score.render(sb);
		sb.end();
	}

	public void renderBatch(String word, int x, int y, Color z) {
		sb.begin();
		totalText.render(sb, word, x, y, z);
		sb.end();
	}

	public void renderMap(float delta) {
		inputHandler.update();
		if (STATE == 0) {
			mapGround.getRenderer().setView(cam);
			mapGround.getRenderer().render(mapGround.getLayer1());
			CheckPlayerMode();
			if (CheckMode == 3) {
				mapGround.getRenderer().render(mapGround.getLayer3());
				renderBatch("Key", -300, 700, Color.RED);
				renderBatch("W for Up", -250, 550, Color.SALMON);
				renderBatch("A  for Left", -250, 400, Color.SALMON);
				renderBatch("D for Right", -250, 250, Color.SALMON);
				renderBatch("Enter for play", -250, 100, Color.SALMON);
				renderBatch("How to play", 220, 700, Color.BLUE);
				renderBatch("Keep Coin ", 270, 550, Color.ROYAL);
				renderBatch("Run to Win ", 270, 400, Color.ROYAL);
				sound.soundWin().play();
			} else {
				renderBatch("Enter to play", -10, 40, Color.GOLD);
				mapGround.getRenderer().render(mapGround.getLayer2());
			}
		} else {
			mapPlay.getRenderer().setView(cam);
			if (STATE == 1) {
				mapPlay.getRenderer().render(mapPlay.getLayer2());
				mapPlay.getRenderer().render(mapPlay.getLayer3());
				mapPlay.getRenderer().render(mapPlay.getLayer4());
				mapPlay.getRenderer().render(mapPlay.getLayer5());
				mapPlay.getRenderer().render(mapPlay.getLayer6());
				mapPlay.getRenderer().render(mapPlay.getLayer7());
				player.update();
				renderBatch();
				screen.update(delta);
			} else {
				mapGround.getRenderer().render(mapGround.getLayer1());
				mapGround.getRenderer().render(mapGround.getLayer3());
				if (STATE == 2) {
					mapGround.getRenderer().render(mapGround.getLayer4());
				} else if (STATE == 3) {
					mapGround.getRenderer().render(mapGround.getLayer5());
				}
				renderBatch("Enter to Main Menu", -150, 150, Color.WHITE);
				renderBatch("Score : " + POINT, -20, 0, Color.WHITE);
				if (ENTER_TOUCHED && CheckMode != 3) {
					initWorld();
					STATE = 0;
				}
			}
		}

	}

	public void CheckPlayerMode() {
		switch (CheckMode) {
		case 0:
			renderBatch("Easy Mode", 20, -60, Color.YELLOW);
			SPEED = 500;
			break;
		case 1:
			renderBatch("Normal Mode", -20, -60, Color.YELLOW);
			SPEED = 1000;
			break;
		case 2:
			renderBatch("Hard Mode", 20, -60, Color.YELLOW);
			SPEED = 2000;
			break;
		case 3:
			renderBatch("How to play", 20, -60, Color.YELLOW);
			break;
		default:
			break;
		}

		if (DOWN_TOUCHED) {
			CheckMode++;
			if (CheckMode == 4)
				CheckMode = 0;
		}
		if (ENTER_TOUCHED && CheckMode != 3) {
			cam.position.set(VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2 + 200, 0);
			STATE = 1;

		}
	}
}
