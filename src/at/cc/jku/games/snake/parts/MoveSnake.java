package at.cc.jku.games.snake.parts;

import at.cc.jku.games.actors.Enums.MOVEDIRECTION;
import at.cc.jku.games.actors.Interfaces.CollisionActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class MoveSnake implements CollisionActor {
    private MOVEDIRECTION movedirection;
    private float x;
    private float y;

    private int counterTime;

    public MoveSnake() {
        this.movedirection = MOVEDIRECTION.STANDSTILL;
        this.x = 300;
        this.y = 300;
    }

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public void render(Graphics graphics) {

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }
}
