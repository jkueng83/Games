package at.cc.jku.games.actors;

import org.newdawn.slick.SlickException;

import java.util.Random;

public class FallingApple extends MovingObjectPng {


    public FallingApple(float speed) throws SlickException {
        super(0, 0, 100, 100,
                "src/at/cc/jku/games/actors/pictures/AppleTheOriginal.png", MOVEDIRECTION.MOVEDOWN, speed);
        setNewStartPosition();
    }

    public void setNewStartPosition() {

        float x = setXPositionRandom();
        this.setX(x);
        this.setY(-100);

    }

    private float setXPositionRandom() {
        Random random = new Random();
        float x = (float) (random.nextInt(600) + 50);
        return x;
    }

}
