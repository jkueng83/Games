package at.cc.jku.games.snake.parts;

import at.cc.jku.games.actors.Interfaces.CollisionActor;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class SnakeBody implements CollisionActor {

    private float x, xLastCycle, y, yLastCycle, objectWith, objectHeight;

    private Shape collisionShape;

    boolean isMoving;

    public SnakeBody(float x, float y) {

        this.x = x;
        this.y = y;
        this.xLastCycle = this.x;
        this.yLastCycle = this.y;

        this.objectHeight = 10;
        this.objectWith = this.objectHeight;

        this.isMoving = false;

        this.collisionShape = new Rectangle(this.x, this.y, this.objectWith-8, this.objectHeight-8);

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillRect(this.x-this.objectWith/2, this.y-this.objectHeight/2,
                this.objectWith, this.objectHeight);
        graphics.setColor(Color.white);

        // nur jetzt zum entwickeln
        /*
        graphics.setColor(Color.red);
        graphics.draw(this.collisionShape);
        graphics.setColor(Color.white);

         */
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        this.collisionShape.setCenterX(this.x);
        this.collisionShape.setCenterY(this.y);

    }

    public void updateSnakeBody(float x, float y) {

        if (x != this.xLastCycle || y != this.yLastCycle) {
            this.x = this.xLastCycle;
            this.y = this.yLastCycle;
            this.isMoving = true;
        }

        this.xLastCycle = x;
        this.yLastCycle = y;

    }

    @Override
    public Shape getShape() {
        return this.collisionShape;
    }

    public boolean isMoving() {
        return isMoving;
    }
}





