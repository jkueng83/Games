package at.cc.jku.games.Strategy;

//import at.jku.games.firstgame.Objects;

import at.cc.jku.games.actors.Ellipse2MoveStrategy;
import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.Rectangle;
import at.cc.jku.games.actors.Rectangle2MoveStrategy;
import at.cc.jku.games.actors.RectangleFilled;
import at.cc.jku.games.actors.movements.*;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjetsGameStrategy extends BasicGame {

    Rectangle rectangle;
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


        RightMoveStrategy rms1 = new RightMoveStrategy(50, 50, 5);
        RightMoveStrategy rms2 = new RightMoveStrategy(50, 400, 50);
        LeftMoveStrategy lms = new LeftMoveStrategy(550, 200, 10);


        Ellipse2MoveStrategy e1 = new Ellipse2MoveStrategy(rms1);
        this.actors.add(e1);
        Ellipse2MoveStrategy e2 = new Ellipse2MoveStrategy(rms2);
        this.actors.add(e2);
        Ellipse2MoveStrategy e3 = new Ellipse2MoveStrategy(lms);
        this.actors.add(e3);

        RightMoveStrategy rms3 = new RightMoveStrategy(50,500,100);
        Rectangle2MoveStrategy r1 = new Rectangle2MoveStrategy(rms3);
        this.actors.add(r1);

        LeftMoveStrategy lms2 = new LeftMoveStrategy( 300, 200,10);
        RectangleFilled r2 = new RectangleFilled(lms2);
        this.actors.add(r2);

        FallingWithGravity fg = new FallingWithGravity(500);
        RectangleFilled r3 = new RectangleFilled(fg);
        this.actors.add(r3);

        UpMoveStrategy ums = new UpMoveStrategy(40,20);
        Ellipse2MoveStrategy e4 = new Ellipse2MoveStrategy(ums);
        this.actors.add(e4);

        DownMoveStrategy dms = new DownMoveStrategy(40,20);
        RectangleFilled rf1 = new RectangleFilled(dms);
        this.actors.add(rf1);



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
