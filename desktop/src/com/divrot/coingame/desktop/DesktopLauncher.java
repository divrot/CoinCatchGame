package com.divrot.coingame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.divrot.coingame.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = MyGdxGame.TITLE;
		config.width = MyGdxGame.WIDTH;
		config.height = MyGdxGame.HEIGTH;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
