package at.cc.jku.games.actors;

import at.cc.jku.games.actors.movements.MoveStrategy;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class RectangleFilled extends AbstractMoveableActor {

    public RectangleFilled(MoveStrategy moveStrategy) {
        super(moveStrategy);
    }

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.moveStrategy.getX(),this.moveStrategy.getY(),50,50);

    }
}
