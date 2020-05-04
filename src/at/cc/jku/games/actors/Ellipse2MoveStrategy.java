package at.cc.jku.games.actors;

import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.movements.LeftMoveStrategy;
import at.cc.jku.games.actors.movements.MoveStrategy;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.List;
import java.util.Random;

public class Ellipse2MoveStrategy implements Actor {

    private MoveStrategy moveStrategy;
    Random random;


    public Ellipse2MoveStrategy(float x, float y, float speed) {

        this.moveStrategy = new LeftMoveStrategy(x,y,speed);
    }

    @Override
    public void render(Graphics graphics) {

        graphics.drawOval(this.moveStrategy.getX(), this.moveStrategy.getY(), 50, 10);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        this.moveStrategy.update(delta);

    }
}
