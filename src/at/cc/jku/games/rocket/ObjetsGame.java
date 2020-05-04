package at.cc.jku.games.rocket;

//import at.jku.games.firstgame.Objects;

import at.cc.jku.games.Snowworld.SIZE;
import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.Snowflake;
import at.cc.jku.games.actors.*;
import at.cc.jku.games.actors.Circle;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjetsGame extends BasicGame {

    private List<Actor> actors;

    private Rocket rocket;


    public ObjetsGame(String title) {
        super(title);
    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new ObjetsGame("Rocket Game"));
            container.setDisplayMode(700, 700, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        Random random = new Random();

        this.actors = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600),
                    random.nextInt(50));
            this.actors.add(rectangle);

            Circle circle = new Circle();
            this.actors.add(circle);

            Ellipse ellipse = new Ellipse(random.nextInt(600), random.nextInt(600),
                    random.nextInt(34) + 10);
            this.actors.add(ellipse);

            for (SIZE size : SIZE.values()) {
                Snowflake snowflake = new Snowflake(size);
                this.actors.add(snowflake);

            }

        }

        Rocket rocket = new Rocket();
        this.actors.add(rocket);
        this.rocket = rocket;

    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            System.out.println("shoot!");
            CannonBall cannonBall = new CannonBall(this.rocket.getXCenter(), this.rocket.getY());
            this.actors.add(cannonBall);

        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor actor : this.actors) { // Actors updaten
            actor.update(gameContainer, delta);
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {

        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Actor actor : this.actors) { // Actors Zeichnen
            actor.render(graphics);
        }


    }
}
