package at.cc.jku.games.snake.parts;

import at.cc.jku.games.actors.Interfaces.CollisionActor;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class SnakeHead implements CollisionActor {

    private float x;
    private float y;

    private float objectWith, objectHeight;

    private Shape collisionShape;

    public SnakeHead(float xStart , float yStart) {

        this.x = xStart;
        this.y = yStart;
        this.objectHeight = 10;
        this.objectWith = this.objectHeight;
        this.collisionShape = new Rectangle(this.x, this.y,this.objectWith-5,this.objectHeight-5);

    }

    @Override
    public Shape getShape() {
        return this.collisionShape;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillRect(this.x - this.objectWith / 2, this.y - objectHeight / 2, this.objectWith, this.objectHeight);
        graphics.setColor(Color.white);

        // nur jetzt zum entwickeln
        /*
        graphics.setColor(Color.red);
        graphics.draw(this.collisionShape);
        graphics.setColor(Color.white);
         */

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        this.collisionShape.setCenterX(this.x);
        this.collisionShape.setCenterY(this.y);

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
