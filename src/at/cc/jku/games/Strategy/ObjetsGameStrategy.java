package at.cc.jku.games.Strategy;

//import at.jku.games.firstgame.Objects;

import at.cc.jku.games.actors.Ellipse2MoveStrategy;
import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.Rectangle;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjetsGameStrategy extends BasicGame {

    Rectangle rectangle;
    Ellipse2MoveStrategy ellipse2MoveStrategy;
    private List<Actor> actors;
    Random random;


    public ObjetsGameStrategy(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.random = new Random();
        this.actors = new ArrayList<>();

        this.rectangle = new Rectangle(100, 100, 5);
        this.actors.add(this.rectangle);

        for (int i = 0; i < 5; i++) {
            this.ellipse2MoveStrategy = new Ellipse2MoveStrategy(this.random.nextInt(600),
                    this.random.nextInt(600), 20);
            this.actors.add(this.ellipse2MoveStrategy);
        }


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new ObjetsGameStrategy("Games 2"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
