package at.cc.jku.games.shootApples;

import at.cc.jku.games.actors.*;
import at.cc.jku.games.actors.Png.*;
import at.cc.jku.games.actors.Png.MovingPng.FallingApple;
import at.cc.jku.games.actors.Png.MovingPng.FlyingDiamond;
import at.cc.jku.games.actors.Png.MovingPng.MoveAppleToShootApples;
import at.cc.jku.games.actors.Png.MovingPng.Slingshot;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class ShootApples extends BasicGame {
    // Version 1.5.0: Neue Package erstellen
    // Version 1.4.0: Texte überarbeitet
    // Version 1.3.0: Interface CollisionActor erbt von Actor
    // Version 1.2.0: Add Interface CollisionShape
    // Version 1.1.0: Add Collision Shape
    // Version 1: ohne Collision Shape

    private List<Actor> actors;
    private List<FlyingDiamond> flyingDiamonds;
    private Slingshot slingshot;
    private FallingApple fallingApple;

    private ApplesPointsCounter applesPointsCounter;


    public ShootApples(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        this.flyingDiamonds = new ArrayList<>();

        Tree tree = new Tree(400, 350, 700, 700);
        this.actors.add(tree);

        ObjectPngPositionHelloKitty helloKitty = new ObjectPngPositionHelloKitty(600, 600, 300,
                200);

        this.actors.add(helloKitty);

        this.slingshot = new Slingshot();
        this.actors.add(this.slingshot);

        FallingApple fallingApple = new FallingApple(10);

        this.actors.add(fallingApple);
        this.fallingApple = fallingApple;

        this.applesPointsCounter = new ApplesPointsCounter(fallingApple);
        this.actors.add(applesPointsCounter);




    }

    @Override
    public void keyPressed(int key, char c) {

        if (key == Input.KEY_SPACE) {
            System.out.println("shoot!");
            FlyingDiamond flyingDiamont = null;
            try {
                flyingDiamont = new FlyingDiamond(this.slingshot.getX(), this.slingshot.getY());
            } catch (SlickException e) {
                e.printStackTrace();
            }
            this.flyingDiamonds.add(flyingDiamont);
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        if (!this.applesPointsCounter.isGameOver()) {


            for (Actor actor : this.actors) {
                actor.update(gameContainer, delta);

            }

            if (this.applesPointsCounter.isAppleShoot(this.flyingDiamonds)) {
                removeAllDiamonds();


                MoveAppleToShootApples shootApple2 = new MoveAppleToShootApples(this.fallingApple.getX(), 100,
                        this.fallingApple.getY(), 500);

                this.actors.add(shootApple2);

                this.fallingApple.setNewStartPosition();

            }

            for (FlyingDiamond flyingDiamond : this.flyingDiamonds) {
                flyingDiamond.update(gameContainer, delta);
            }

            if (this.fallingApple.getY() > 1000) {
                this.fallingApple.setNewStartPosition();
            }

            removeDiamondsOutOfWindow();

            for (FlyingDiamond flyingDiamond : this.flyingDiamonds) {
                System.out.println("Positin Y" + flyingDiamond.getY());

            }

        }


    }

    private void removeDiamondsOutOfWindow() {
        for (int i = 0; i < this.flyingDiamonds.size(); i++) {
            if (this.flyingDiamonds.get(i).getY() < -500) {
                this.flyingDiamonds.remove(i);
            }

        }
    }

    private void removeAllDiamonds() {
        for (int i = 0; i < this.flyingDiamonds.size(); i++) {
            this.flyingDiamonds.remove(i);
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);

        }

        for (FlyingDiamond flyingDiamond : this.flyingDiamonds) {
            flyingDiamond.render(graphics);
        }

    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new ShootApples("Shoot Apples"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
