package at.cc.jku.games.actors;

import at.cc.jku.games.actors.Interfaces.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class CannonBall implements Actor {

    float x, y, speed, diameter;

    public CannonBall(float x, float y) {
        this.diameter = 10;
        this.x = x - this.diameter / 2;
        this.y = y;
        this.speed = 20;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.diameter, this.diameter);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        this.y -= this.speed / 100 * delta;

    }
}
