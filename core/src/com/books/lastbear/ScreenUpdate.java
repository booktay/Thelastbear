package com.books.lastbear;

import static com.books.lastbear.Variables.*;

import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class ScreenUpdate {
	private OrthographicCamera cam;
	private CollisionDetection collisionDetection;
	private Sound sound;
	float peakY = 1000;

	public ScreenUpdate(CollisionDetection collisionDetection, OrthographicCamera cam, Sound sound) {
		this.cam = cam;
		this.collisionDetection = collisionDetection;
		this.sound = sound;
	}

	public void update(float delta) {
		float playerSpeed = SPEED * delta;
		int CheckMoveKey = 0;
		if (POINT > 500) {
			playerSpeed *= POINT / 500;
		}
		if (W_TOUCHED) {
			if (cam.position.y < V_HEIGHT) {
				cam.translate(0, playerSpeed, 0);
				peakY = cam.position.y;
				CheckMoveKey = 1;
			}
		} else if (!W_TOUCHED && !collisionDetection.isCollisionMargin(cam.position.x, cam.position.y)) {
			cam.translate(0, -playerSpeed, 0);
		}
		if (A_TOUCHED && !D_TOUCHED) {
			if (cam.position.x > 50) {
				cam.translate(-playerSpeed, 0, 0);
				CheckMoveKey = 2;
			}
		} else if (D_TOUCHED && !A_TOUCHED) {
			if (cam.position.x < VIEWPORT_WIDTH + 500) {
				cam.translate(playerSpeed, 0, 0);
				CheckMoveKey = 3;
			}
		}
		if (cam.position.y <= peakY - 2000) {
			HEALTH = 0;
		}
		if (collisionDetection.isCollisionMargin(cam.position.x, cam.position.y)) {
			CheckMargin(CheckMoveKey, playerSpeed);
		}
		CheckCollision();
		cam.update();
	}

	public void CheckMargin(int CheckMoveKey, float playerSpeed) {
		switch (CheckMoveKey) {
		case 1:
			cam.translate(0, -playerSpeed, 0);
			break;
		case 2:
			cam.translate(playerSpeed, 0, 0);
			break;
		case 3:
			cam.translate(-playerSpeed, 0, 0);
			break;
		case 0:
			cam.translate(0, playerSpeed, 0);
		default:
			break;
		}

		if (HEALTH >= 10) {
			HEALTH -= 10;
			sound.soundHpDown().play();
		}

		if (HEALTH == 0) {
			SPEED = 0;
			STATE = 2;
			sound.soundLose().play();
		}
	}

	public void CheckCollision() {
		if (collisionDetection.isCollisionEnd(cam.position.x, cam.position.y)) {
			sound.soundWin().play();
			SPEED = 0;
			STATE = 3;
		}
		for (float i = 0; i <= 100; i++) {
			for (float j = 0; j <= 10; j++) {
				float X = cam.position.x + i;
				float Y = cam.position.y + j;
				if (collisionDetection.isCollisionPoint(X, Y)) {
					POINT += 1;
					sound.soundPoint().play();
				}

				if (collisionDetection.isCollisionExtra(X, Y)) {
					Random rand = new Random();
					int math = rand.nextInt(200) - 100;
					if (HEALTH > 0 && HEALTH <= math) {
						HEALTH += math;
					}
					POINT += math;
					sound.soundExtra().play();
				}

				if (collisionDetection.isCollisionHPUp(X, Y)) {
					if (HEALTH > 0 && HEALTH <= 180) {
						HEALTH += 20;
						sound.soundHpUp().play();
					}
				}
			}
		}
		
	}
}
