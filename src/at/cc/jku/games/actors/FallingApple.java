package at.cc.jku.games.actors;

import org.newdawn.slick.SlickException;

import java.util.Random;

public class FallingApple extends MovingObjectPng {


    public FallingApple(float y, float speed, MOVEDIRECTION direction, String imagePath) throws SlickException {
        super(0, y, speed, 100, 100, direction, imagePath);//

        setNewStartPosition();

    }

    public void setNewStartPosition() {
        Random random = new Random();
        float x = (float) (random.nextInt(600) + 50);
        this.setX(x);
        this.setY(-100);

    }

    public float getAppleCenterPositionX() {
        return getX() + getObjectWith() / 2;
    }

}
