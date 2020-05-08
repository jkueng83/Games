package at.cc.jku.games.actors;

import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.movements.MoveStrategy;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Rectangle2MoveStrategy implements Actor {

    //private float x;
    //private float y;
    //private float speed;
    private MoveStrategy moveStrategy ;

    public Rectangle2MoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void render(Graphics graphics) {

        graphics.drawRect(this.moveStrategy.getX(), this.moveStrategy.getY(), 10, 10);

    }

    public void update(GameContainer gameContainer, int delta) {

        this.moveStrategy.update(delta);



    }
}
