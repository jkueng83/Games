package at.cc.jku.games.actors;

import org.newdawn.slick.SlickException;

public class FlyingDiamond extends FlyingObject {

    public FlyingDiamond(float x, float y, float speed, float objectWith, float objectHeight, DIRECTION direction,
                         String imagePath) throws SlickException {
        super(x - objectWith / 2, y, speed, objectWith, objectHeight, direction, imagePath);
    }

    public float getCenterpositionX(){
        return getX() + getObjectWith()/2;
    }
}
