package at.cc.jku.games.AufgabeRectanglesAndCo;

import at.cc.jku.games.actors.Actor;
import at.cc.jku.games.actors.Enums.MOVEDIRECTION;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class RectangleDirection implements Actor {

    private float x;
    private float y;
    private float speed;
    private MOVEDIRECTION direction;
    Random random;

    public RectangleDirection(float x, float y, float speed, MOVEDIRECTION direction) {
        this.random = new Random();
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;

    }

    public void render(Graphics graphics) {

        graphics.drawRect(this.x, this.y, 10, 10);

    }

    public void update(GameContainer gameContainer, int delta) {

        switch (this.direction) {
            case MOVETORIGHT:
                this.x += (float) delta / 100.0 * this.speed;
                if (this.x > 600) {
                    this.x = 0;
                }
                break;
            case MOVETOLEFT:
                this.x -= (float) delta / 100.0 * this.speed;
                if (this.x < 0) {
                    this.x = 600;
                }
                break;
        }


    }
}
