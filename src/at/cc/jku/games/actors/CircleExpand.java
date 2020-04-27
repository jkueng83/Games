package at.cc.jku.games.actors;

import at.cc.jku.games.actors.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class CircleExpand implements Actor {

    private float x, y,deltaX ,xConstant;
    private float speed;
    private float diameter;
    Random random;

    public CircleExpand() {
        random = new Random();
        this.xConstant = this.random.nextInt(600);
        this.y = 0;
        this.speed = this.random.nextInt(40) + 10;
        this.diameter = 5;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
    }

    public void update(GameContainer gameContainer, int delta) {

        this.y += (float) delta / 100.0 * this.speed;

        if (this.y > 600) {
            this.y = 0;
            this.diameter = 5;
            this.xConstant = this.random.nextInt(600);
        }

        this.diameter += delta / 10.0f;

        this.deltaX = this.diameter / 2.0f;
        this.x = this.xConstant - this.deltaX;
    }
}
