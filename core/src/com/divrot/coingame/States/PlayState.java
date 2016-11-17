package com.divrot.coingame.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.divrot.coingame.MyGdxGame;
import com.divrot.coingame.Sprites.Hero;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by divrot on 16.11.16.
 */
public class PlayState extends State {

    private Hero hero;
    private Texture background;

    Vector3 touchPos;

    private Music backMusic;
    private Sound coinSound;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        hero = new Hero(50, 70);
        background = new Texture("background.png");

        touchPos = new Vector3();

        backMusic = Gdx.audio.newMusic(Gdx.files.internal("polkamusic.mp3"));
        coinSound = Gdx.audio.newSound(Gdx.files.internal("Coin.ogg"));

        backMusic.setLooping(true);
        backMusic.play();

        camera.setToOrtho(false, MyGdxGame.WIDTH, MyGdxGame.HEIGTH);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            hero.getPosition();
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
        hero.update(delta);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGTH);
        sb.draw(hero.getHero(), hero.getPosition().x, hero.getPosition().y);
        sb.end();

        if (Gdx.input.justTouched()) {
            touchPos.set(Gdx.input.getX(), 0, 0);
            camera.unproject(touchPos);
            hero.getPosition().x = touchPos.x;

        }
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
