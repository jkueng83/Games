package at.cc.jku.games.actors;

import at.cc.jku.games.actors.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Rectangle implements Actor {

    private float x;
    private float y;
    private float speed;

    public Rectangle(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(Graphics graphics) {

        graphics.drawRect(this.x, this.y, 10, 10);

    }

    public void update(GameContainer gameContainer, int delta) {

        this.x += (float) delta /100.0 * this.speed;
        if (this.x > 600) {
            this.x = 100;
        }

    }
}
