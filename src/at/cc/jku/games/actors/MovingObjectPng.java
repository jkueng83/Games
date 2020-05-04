package at.cc.jku.games.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MovingObjectPng extends ObjectPngPosition {

    private float speed;
    //Image objectImage;
    private MOVEDIRECTION direction;

    public MovingObjectPng(float x, float y, float objectWith, float objectHeight, String imagePath,
                           MOVEDIRECTION direction , float speed) throws SlickException {
        super(x, y, objectWith, objectHeight,  imagePath);
        this.direction = direction;
        this.speed = speed;
    }


/*  // zeichne macht die Mutter Klasse
    @Override
    public void render(Graphics graphics) {

        this.objectImage.draw(this.x, this.y);

    }
 */

    @Override
    public void update(GameContainer gameContainer, int delta) {

        super.update(gameContainer, delta);

        switch (this.direction) {
            case MOVETOLEFT:
                this.x -= this.speed / 100 * delta;
                break;
            case MOVETORIGHT:
                this.x += this.speed / 100 * delta;
                break;
            case MOVEUP:
                this.y -= this.speed / 100 * delta;
                break;
            case MOVEDOWN:
                this.y += this.speed / 100 * delta;
                break;
        }

        if (this.y>2000){
            this.y = 0;
        }

    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getObjectWith() {
        return objectWith;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
