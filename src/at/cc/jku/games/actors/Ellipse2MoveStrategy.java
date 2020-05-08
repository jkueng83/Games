package at.cc.jku.games.actors;

import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.movements.LeftMoveStrategy;
import at.cc.jku.games.actors.movements.MoveStrategy;
import at.cc.jku.games.actors.movements.RightMoveStrategy;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

import java.util.List;
import java.util.Random;

public class Ellipse2MoveStrategy extends AbstractMoveableActor {


    Random random;


    public Ellipse2MoveStrategy( MoveStrategy moveStrategy) {
        super(moveStrategy);
    }

    @Override
    public void render(Graphics graphics) {

        graphics.drawOval(this.moveStrategy.getX(), this.moveStrategy.getY(), 50, 10);

    }

    @Override
    public Shape getShape() {
        return null;
    }
}
