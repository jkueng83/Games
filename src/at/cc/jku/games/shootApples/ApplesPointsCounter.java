package at.cc.jku.games.shootApples;

import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.Png.MovingPng.FallingApple;
import at.cc.jku.games.actors.Png.MovingPng.FlyingDiamond;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.List;

public class ApplesPointsCounter implements Actor {
    private int shootApples;
    private int applesOnFloor;
    private int points;
    private int pointsPerApple;
    private FallingApple fallingApple;
    private boolean isGameOver;
    private AngelCodeFont font;
    //private FlyingApple flyingApple;
    //private float applePositionX;
    //private float applePositionY;
    //private List<FlyingDiamond> flyingDiamonds;


    public ApplesPointsCounter(FallingApple fallingApple) throws SlickException {
        this.fallingApple = fallingApple;
        this.shootApples = 0;
        this.applesOnFloor = 0;
        this.points = 0;
        this.pointsPerApple = 1;
        this.font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");
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
            /* Kollision selbst überwacht
            if ((this.fallingApple.getXPositionMin() < flyingDiamond.getXPositionMax())
                    && (this.fallingApple.getXPositionMax() > flyingDiamond.getXPositionMin())) {

                if (flyingDiamond.getY() < this.fallingApple.getY()) {

                    isAppleShoot = true;
                    countApplesPoints();
                    break;
                }
            }

             */
            /*// Neu mit collition Shapes
            if (this.fallingApple.getCollisionShape().intersects(flyingDiamond.getCollisionShape())){
                System.out.println("hit with intersection of Collision Shape");
                isAppleShoot = true;
                countApplesPoints();
                break;
            }

             */

            // mit Interface CollisionActor erkennen ob getroffen wurde:
            // CollisionActor erbt von Actor
            if (this.fallingApple.getShape().intersects(flyingDiamond.getShape())){
                System.out.println("hit with intersection of CollisionActor from Interface");
                isAppleShoot = true;
                countApplesPoints();
                break;
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
        float yStart = 30;
        this.font.drawString(20, yStart, "Points: " + this.points);
        this.font.drawString(20, yStart + 50, "Hits: " + this.shootApples);
        this.font.drawString(20, yStart + 100, "Fail: " + this.applesOnFloor);
        if (this.isGameOver) {
                this.font.drawString(20, yStart + 150, "Game Over!!!!");
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }
}
