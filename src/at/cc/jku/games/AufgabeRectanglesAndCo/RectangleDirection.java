package at.cc.jku.games.AufgabeRectanglesAndCo;

import at.cc.jku.games.game4Interfacees.Actor;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class RectangleDirection implements Actor {

    private float x;
    private float y;
    private float speed;
    private DIRECTION direction;
    Random random;

    public RectangleDirection(float x, float y, float speed, DIRECTION direction) {
        this.random = new Random();
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;

    }

    public void render(Graphics graphics) {

        graphics.drawRect(this.x, this.y, 10, 10);

    }

    public void update(int delta) {

        switch (this.direction) {
            case FROMLEFTTORIGHT:
                this.x += (float) delta / 100.0 * this.speed;
                if (this.x > 600) {
                    this.x = 0;
                }
                break;
            case FROMRIGHTTOLEFT:
                this.x -= (float) delta / 100.0 * this.speed;
                if (this.x < 0) {
                    this.x = 600;
                }
                break;
        }


    }
}
