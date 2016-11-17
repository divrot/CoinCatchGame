package com.divrot.coingame.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by divrot on 16.11.16.
 */
public class Hero {
    //public static final int MOVE_SPEED = 15;
    private Vector3 position;
    private Vector3 velocity;

    private Texture hero;

    public Hero(int x, int y) {
        position = new Vector3(x, 0, 0);
        velocity = new Vector3(0, 0 ,0);
        hero = new Texture("p1_walk01.png");
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getHero() {
        return hero;
    }

    public void update(float delta) {
        velocity.add(0, 0, 0);
        velocity.scl(delta);
        position.add(velocity.x, 0,0);

        velocity.scl(1/delta);
    }

    public void turn() {


    }
}
