package at.cc.jku.games.shootApples;

import at.cc.jku.games.actors.FallingApple;
import at.cc.jku.games.actors.FlyingDiamond;

import java.util.List;

public class ApplesPointsCounter {
    private int shootApples;
    private int applesOnFloor;
    private int points;
    //private FlyingApple flyingApple;
    private float applePositionX;
    private float applePositionY;
    //private List<FlyingDiamond> flyingDiamonds;

    public ApplesPointsCounter() {
        this.shootApples = 0;
        this.applesOnFloor = 0;
        this.points = 0;
        //this.flyingDiamonds = new ArrayList<>();

    }

    public void actualPositionFlyingApple(FallingApple fallingApple) {
        //this.flyingApple = flyingApple;
        this.applePositionX = fallingApple.getAppleCenterPositionX();
        this.applePositionY = fallingApple.getY();
    }

    public boolean isAppleShoot(FallingApple fallingApple, List<FlyingDiamond> flyingDiamonds) {
        actualPositionFlyingApple(fallingApple);
        boolean isAppleShoot = false;
        for (FlyingDiamond flyingDiamond : flyingDiamonds) {
            if ((this.applePositionX - 50 < flyingDiamond.getCenterpositionX())
                    && (flyingDiamond.getCenterpositionX() < this.applePositionX + 50)) {
                if (flyingDiamond.getY() < this.applePositionY) {
                    isAppleShoot = true;
                    countApplesPoints();
                    break;
                }
            }

        }
        return isAppleShoot;
    }

    private void countApplesPoints() {
        this.shootApples++;

        this.points += 1;// bei höherer Geschwindigkeit mehrere Punkte zählen
        System.out.println("shoot Apples:\t" + this.shootApples + " Points:\t" + this.points);
    }


}
