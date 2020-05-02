package at.cc.jku.games.actors;

import org.newdawn.slick.SlickException;

public class FlyingDiamond extends MovingObjectPng {
    public FlyingDiamond(float x, float y) throws SlickException {

        super(x, y, 50, 50, "src/at/cc/jku/games/actors/pictures/diamond2.png",
                MOVEDIRECTION.MOVEUP, 100);
        float objectHeightTemp = 50;
        float objectWithTemp = 50;
        this.x = x - objectWithTemp / 2;
        this.y = y + objectHeightTemp / 2;
    }

    /*
    public FlyingDiamond(float x, float y, String imagePath, MOVEDIRECTION direction, float speed) throws SlickException {
        float objectHeight = 50.0f;
        float objectWith = 50.0f;

        super(x, y, 50, 50, imagePath, direction, speed);
    }

     */

    /*
    public FlyingDiamond(float x, float y, float speed, float objectWith, float objectHeight, MOVEDIRECTION direction,
                         String imagePath) throws SlickException {
        super(x - objectWith / 2, y, 50, 50,
                "src/at/cc/jku/games/actors/pictures/diamond2.png",  MOVEDIRECTION.MOVEUP);
    }

     */
 /*
    public float getCenterpositionX() {
        return getX();
    }

  */
}
