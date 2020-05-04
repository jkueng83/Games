package at.cc.jku.games.actors.Png.MovingPng;

import at.cc.jku.games.actors.Enums.MOVETYPE;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class MoveAppleToShootApples extends MoveAppleToPosition {
    Random random;
    //private float xDestination, yDestination;


    public MoveAppleToShootApples(float xStart, float xDestination, float yStart, float yDestination) throws SlickException {
        super(xStart, xDestination, yStart, yDestination, 50, 20, 20, MOVETYPE.LINEAR);
        randomPosition();
    }

    private void randomPosition() {

        random = new Random();
        float yRandom = random.nextInt(50);
        this.yDestination = 700 - yRandom;
        int xBound = (int) (3 *  (55-yRandom)); //(int)(100.0/(yRandom*yRandom));
        float xRandom = random.nextInt(xBound);
        this.xDestination = 100 + xRandom - xBound / 2   ;


        //this.xDestination = 50;
        //this.yDestination = 600;

    }
}
