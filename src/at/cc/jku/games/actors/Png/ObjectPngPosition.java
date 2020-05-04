package at.cc.jku.games.actors.Png;

import at.cc.jku.games.actors.Interfaces.CollisionActor;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class ObjectPngPosition implements CollisionActor {

    protected float x, y, objectWith, objectHeight;
    protected Image objectImage;
    private Shape collisionShape;

    public ObjectPngPosition(float x, float y, float objectWith, float objectHeight,
                             String imagePath) throws SlickException {

        this.x = x;
        this.y = y;

        this.objectWith = objectWith;
        this.objectHeight = objectHeight;

        Image temp = new Image(imagePath); //"src/at/cc/jku/games/actors/pictures/diamond2.png");
        this.objectImage = temp.getScaledCopy((int) this.objectWith, (int) this.objectHeight);

        this.collisionShape = new Rectangle(x, y, objectWith, objectHeight);

        ;
    }


    @Override
    public void render(Graphics graphics) {
        this.objectImage.draw(this.x - this.objectWith / 2, this.y - this.objectHeight / 2);
        // nur jetzt zum entwickeln
        /* nur jetzt zum entwickeln
        graphics.setColor(new Color(100, 100, 100));
        graphics.draw(this.collisionShape);
        graphics.setColor(Color.white);
        */

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        /*  Es gibt auch eine Center Position
        this.collisionShape.setX(this.x - this.objectWith / 2);
        this.collisionShape.setY(this.y - this.objectHeight / 2);
        */
        this.collisionShape.setCenterX(this.x);
        this.collisionShape.setCenterY(this.y);


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

    public float getXPositionMin() {
        return this.x - this.objectWith / 2;
    }

    public float getXPositionMax() {
        return this.x + this.objectWith / 2;
    }

    public float getYPositionMin() {
        return this.y - this.objectHeight / 2;
    }

    public float getYPositionMax() {
        return this.y + this.objectHeight / 2;
    }

    /* Wird jetzt über das Intercface "CollistionShape" gemacht.
    public Shape getCollisionShape() {
        return collisionShape;
    }

     */

    @Override
    public Shape getShape() {
        return collisionShape;
    }
}
