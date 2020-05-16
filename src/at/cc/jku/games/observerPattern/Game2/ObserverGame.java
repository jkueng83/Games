package at.cc.jku.games.observerPattern.Game2;


import at.cc.jku.games.actors.Interfaces.Actor;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class ObserverGame extends BasicGame {

    /*
    50 Kleine Schneeflocken
    50 mittlere Schneeflocken
    50 große Schneeflocken
     */

    private List<Actor> actors;

    public ObserverGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        EllipseObservable e0 = new EllipseObservable(100, 100, 5);
        this.actors.add(e0);

        EllipseObserver e1 = new EllipseObserver(200, 200, 50);
        EllipseObserver e2 = new EllipseObserver(400, 200, 50);
        this.actors.add(e1);
        this.actors.add(e2);

        e0.addStartStop(e1);// zum Observable ergänzen, hier ist es das Interface "StartStop"
        e0.addStartStop(e2);

        for (int i = 0; i < 30; i++) {
            EllipseObserver ei = new EllipseObserver(i * 5, i * 10, i + 3);
            this.actors.add(ei);

            e0.addStartStop(ei);// zum Observable ergänzen, hier ist es das Interface "StartStop"

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
            AppGameContainer container = new AppGameContainer(new ObserverGame("* * * Observer * * *"));
            container.setDisplayMode(600, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
