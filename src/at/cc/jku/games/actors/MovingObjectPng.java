package at.cc.jku.games.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MovingObjectPng implements Actor {

    float x, y, speed, objectWith, objectHeight;
    Image objectImage;
    MOVEDIRECTION direction;

    public MovingObjectPng(float x, float y, float speed, float objectWith, float objectHeight, MOVEDIRECTION direction,
                           String imagePath) throws SlickException {

        this.x = x;
        this.y = y;
        this.speed = speed;
        this.objectWith = objectWith;
        this.objectHeight = objectHeight;

        Image temp = new Image(imagePath); //"src/at/cc/jku/games/actors/pictures/diamond2.png");
        this.objectImage = temp.getScaledCopy((int) this.objectWith, (int) this.objectHeight);
        this.direction = direction;
        ;
    }


    @Override
    public void render(Graphics graphics) {
        this.objectImage.draw(this.x, this.y);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

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
}
