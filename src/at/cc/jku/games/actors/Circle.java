package at.cc.jku.games.actors;

import at.cc.jku.games.actors.Interfaces.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor{

    private float x, y;
    private float speed;
    private int diameter;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(600);
        this.y = 0;
        this.speed = random.nextInt(40)+10;
        this.diameter = random.nextInt(80) + 10;
    }

    public void render(Graphics graphics) {

        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);

    }

    public void update(GameContainer gameContainer, int delta) {

        this.y += (float) delta / 100.0 * this.speed;
        if (this.y > 600) {
            this.y = 0;
        }

    }
}
