package at.cc.jku.games.snake.parts;

import at.cc.jku.games.actors.Interfaces.CollisionActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class SnakeBody implements CollisionActor {

    //private MOVEDIRECTION movedirection;
    private float x;
    private float y;

    // private int counterTime;

    ///private List<CollisionActor> collisionActorList;

    //MoveStrategySnake moveStrategySnake;


    public SnakeBody() {
        //this.movedirection = MOVEDIRECTION.STANDSTILL;
        this.x = 300;
        this.y = 300;

        //this.moveStrategySnake = moveStrategySnake;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.x, this.y, 10, 10);

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {


    }

    public void updateSnakeBody(float x, float y) {
        this.x = x + 100;
        this.y = y + 100;
        System.out.println("x: " + this.x + "y: " + this.y);
    }


    @Override
    public Shape getShape() {
        return null;
    }
}





