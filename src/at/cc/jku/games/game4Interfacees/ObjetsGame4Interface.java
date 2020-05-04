package at.cc.jku.games.game4Interfacees;

//import at.jku.games.firstgame.Objects;

import at.cc.jku.games.actors.Actor;
import at.cc.jku.games.actors.Ellipse;
import at.cc.jku.games.actors.Rectangle;
import at.cc.jku.games.actors.Circle;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjetsGame4Interface extends BasicGame {

    private List<Actor> actors;


    public ObjetsGame4Interface(String title) {
        super(title);
    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new ObjetsGame4Interface("Game 4 - Interface"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        Random random = new Random();

        this.actors = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600),
                    random.nextInt(50));
            this.actors.add(rectangle);
        }

       for (int i = 0; i < 30; i++) {
            Circle circle = new Circle();
            this.actors.add(circle);
                    }

        for (int i = 0; i < 70 ; i++) {
            Ellipse ellipse = new Ellipse(random.nextInt(600),random.nextInt(600),
                    random.nextInt(34)+10);
            this.actors.add(ellipse);

        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor actor : this.actors) { // Actors updaten
            actor.update(gameContainer, delta);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Actor actor : this.actors) { // Actors Zeichnen
            actor.render(graphics);
        }



    }
}
