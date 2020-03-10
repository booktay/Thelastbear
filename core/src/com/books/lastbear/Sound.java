package com.books.lastbear;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Sound {
	private Music musicBG, musicHpDown, musicHpUp, musicExtra, musicPoint, musicWin, musicLose;

	public Sound() {
		initBackgroundSound();
		initSound();
	}

	public Music soundPoint() {
		return musicPoint;
	}

	public Music soundHpUp() {
		return musicHpUp;
	}

	public Music soundWin() {
		return musicWin;
	}

	public Music soundHpDown() {
		return musicHpDown;
	}

	public Music soundLose() {
		return musicLose;
	}

	public Music soundExtra() {
		return musicExtra;
	}

	public void initSound() {
		musicHpDown = Gdx.audio.newMusic(Gdx.files.internal("sound/hpOut.wav"));
		musicHpDown.setLooping(false);
		musicHpUp = Gdx.audio.newMusic(Gdx.files.internal("sound/hpIn.wav"));
		musicHpUp.setLooping(false);
		musicExtra = Gdx.audio.newMusic(Gdx.files.internal("sound/extra.wav"));
		musicExtra.setLooping(false);
		musicPoint = Gdx.audio.newMusic(Gdx.files.internal("sound/point.wav"));
		musicPoint.setLooping(false);
		musicWin = Gdx.audio.newMusic(Gdx.files.internal("sound/win.wav"));
		musicWin.setLooping(false);
		musicLose = Gdx.audio.newMusic(Gdx.files.internal("sound/lose.wav"));
		musicLose.setLooping(false);
	}

	public void initBackgroundSound() {
		musicBG = Gdx.audio.newMusic(Gdx.files.internal("sound/title.mp3"));
		musicBG.setLooping(true);
		musicBG.play();
	}

	/*
	 * ------- Sound Credit --------- Harvest Moon : Back to Nature Kirby & the
	 * Amazing Mirror Kirby Adventure ------------------------------
	 */
}
