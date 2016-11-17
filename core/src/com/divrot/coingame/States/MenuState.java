package com.divrot.coingame.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.divrot.coingame.MyGdxGame;

/**
 * Created by divrot on 16.11.16.
 */
public class MenuState extends State {

    private Texture background;
    private Texture playBtn;
    private Texture cloud1, cloud2;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background.png");
        playBtn = new Texture("hud_p1.png");
        cloud1 = new Texture("cloud1.png");
        cloud2 = new Texture("cloud2.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0,0, MyGdxGame.WIDTH, MyGdxGame.HEIGTH);
        sb.draw(playBtn, (MyGdxGame.WIDTH/2) - (playBtn.getWidth()/2), (MyGdxGame.HEIGTH/2) - playBtn.getHeight());
        //sb.draw(cloud1, MyGdxGame.WIDTH - MyGdxGame.WIDTH/3, MyGdxGame.HEIGTH - MyGdxGame.HEIGTH/4 );
        //sb.draw(cloud2, MyGdxGame.WIDTH/6, MyGdxGame.HEIGTH/5 );
        //sb.draw(cloud2, MyGdxGame.WIDTH/5, MyGdxGame.HEIGTH - MyGdxGame.HEIGTH/3 );
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        cloud1.dispose();
        cloud2.dispose();
    }
}
