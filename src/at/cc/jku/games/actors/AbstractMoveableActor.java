package at.cc.jku.games.actors;

import at.cc.jku.games.actors.Interfaces.CollisionActor;
import at.cc.jku.games.actors.movements.MoveStrategy;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public abstract class AbstractMoveableActor implements CollisionActor {

    protected MoveStrategy moveStrategy;

    public AbstractMoveableActor(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.moveStrategy.update(delta);
    }
}
