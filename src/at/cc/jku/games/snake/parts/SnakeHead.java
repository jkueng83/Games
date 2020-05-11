package at.cc.jku.games.snake.parts;

import at.cc.jku.games.actors.Enums.MOVEDIRECTION;
import at.cc.jku.games.actors.Interfaces.CollisionActor;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class SnakeHead implements CollisionActor {

    private float x;
    private float y;

    private float objectWith, objectHeight;

    private Shape collisionShape;

    private Image objectImage;
    MOVEDIRECTION movedirection;

    public SnakeHead(float xStart, float yStart) throws SlickException {

        this.x = xStart;
        this.y = yStart;
        this.objectHeight = 10;
        this.objectWith = this.objectHeight;
        this.movedirection = MOVEDIRECTION.STANDSTILL;
        this.collisionShape = new Rectangle(this.x, this.y, this.objectWith - 5, this.objectHeight - 5);

        Image temp = new Image("src/at/cc/jku/games/actors/pictures/snakeHead.png");
        this.objectImage = temp.getScaledCopy((int) this.objectWith * 2, (int) this.objectHeight * 2);


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


        this.objectImage.draw(this.x - this.objectWith, this.y - this.objectHeight);

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

    private void rotateSnakeHead() {

        switch (this.movedirection) {
            case MOVEUP:
                this.objectImage.setRotation(180);
                break;

            case MOVEDOWN:
                this.objectImage.setRotation(0);
                break;

            case MOVETOLEFT:
                this.objectImage.setRotation(90);
                break;

            case MOVETORIGHT:
                this.objectImage.setRotation(270);
                break;
        }


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

    public void setMoveDirection(MOVEDIRECTION movedirection) {
        this.movedirection = movedirection;
        rotateSnakeHead();
    }


}
