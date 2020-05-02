package at.cc.jku.games.shootApples;

import at.cc.jku.games.actors.Actor;
import at.cc.jku.games.actors.FallingApple;
import at.cc.jku.games.actors.FlyingDiamond;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.List;

public class ApplesPointsCounter implements Actor {
    private int shootApples;
    private int applesOnFloor;
    private int points;
    private int pointsPerApple;
    private FallingApple fallingApple;
    private boolean isGameOver;
    //private FlyingApple flyingApple;
    //private float applePositionX;
    //private float applePositionY;
    //private List<FlyingDiamond> flyingDiamonds;


    public ApplesPointsCounter(FallingApple fallingApple) {
        this.fallingApple = fallingApple;
        this.shootApples = 0;
        this.applesOnFloor = 0;
        this.points = 0;
        this.pointsPerApple = 1;
    }

    public boolean isGameOver() {
        if (this.applesOnFloor >= 10) {
            this.isGameOver = true;
        }

        return this.isGameOver;
    }

    public boolean isAppleShoot(List<FlyingDiamond> flyingDiamonds) {
        //actualPositionFlyingApple(fallingApple);

        boolean isAppleShoot = false;
        for (FlyingDiamond flyingDiamond : flyingDiamonds) {
            if ((this.fallingApple.getXPositionMin() < flyingDiamond.getXPositionMax())
                    && (this.fallingApple.getXPositionMax() > flyingDiamond.getXPositionMin())) {

                if (flyingDiamond.getY() < this.fallingApple.getY()) {

                    isAppleShoot = true;
                    countApplesPoints();
                    break;
                }
            }

        }
        isAppleOnFloor();
        return isAppleShoot;
    }

    private boolean isAppleOnFloor() {
        boolean isAppleOnFloor = false;
        if (this.fallingApple.getY() > 800) {
            isAppleOnFloor = true;
            this.applesOnFloor++;
            this.fallingApple.setNewStartPosition();
        }
        return isAppleOnFloor;
    }

    private void updateAppleSpeedAndPointsPerApple() {

        float factor = this.shootApples * 0.1f + 1;
        this.fallingApple.setSpeed(10 * (int) factor);
        this.pointsPerApple = 1 * (int) factor;

    }

    private void countApplesPoints() {
        this.shootApples++;
        this.points += this.pointsPerApple;// bei höherer Geschwindigkeit mehrere Punkte zählen
        updateAppleSpeedAndPointsPerApple();

        System.out.println("shoot Apples:\t" + this.shootApples + " Points:\t" + this.points);

    }


    @Override
    public void render(Graphics graphics) {

        graphics.drawString("Points:\t" + this.points, 20, 50);
        graphics.drawString("Shoot apples:\t" + this.shootApples, 20, 70);
        graphics.drawString("Apples on Floor:\t" + this.applesOnFloor, 20, 90);
        graphics.drawString("Apple speed:\t" + this.fallingApple.getSpeed(), 20, 110);
        if (this.isGameOver) {

            graphics.drawString("Game Over!!!!", 20, 150);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }
}
