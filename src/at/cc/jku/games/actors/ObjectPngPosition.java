package at.cc.jku.games.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ObjectPngPosition implements Actor {

    protected float x, y, objectWith, objectHeight;
    protected Image objectImage;

    public ObjectPngPosition(float x, float y, float objectWith, float objectHeight,
                             String imagePath) throws SlickException {

        this.x = x;
        this.y = y;

        this.objectWith = objectWith;
        this.objectHeight = objectHeight;

        Image temp = new Image(imagePath); //"src/at/cc/jku/games/actors/pictures/diamond2.png");
        this.objectImage = temp.getScaledCopy((int) this.objectWith, (int) this.objectHeight);

        ;
    }


    @Override
    public void render(Graphics graphics) {
        this.objectImage.draw(this.x - this.objectWith / 2, this.y - this.objectHeight / 2);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {


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
