package at.cc.jku.games.snake.parts;

import at.cc.jku.games.actors.Enums.MOVEDIRECTION;
import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.Interfaces.CollisionActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Snake implements CollisionActor {

    private MOVEDIRECTION movedirection;
    private float x;
    private float y;

    private int counterTime;

    private List<SnakeBody> snakeBodies;

    MoveStrategySnake moveStrategySnake;


    public Snake( MoveStrategySnake moveStrategySnake) {
        this.movedirection = MOVEDIRECTION.STANDSTILL;
        this.x = 300;
        this.y = 300;

        this.moveStrategySnake = moveStrategySnake;

        this.snakeBodies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SnakeBody snakeBody = new SnakeBody();
            this.snakeBodies.add(snakeBody);
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.moveStrategySnake.getX(), this.moveStrategySnake.getY(),10,10);
        for (SnakeBody snakeBody: this.snakeBodies) {
            snakeBody.render(graphics);

        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        this.moveStrategySnake.update(gameContainer,delta);

        this.snakeBodies.get(0).updateSnakeBody(this.moveStrategySnake.getX(),this.moveStrategySnake.getY());

        for (int i = 1; i < this.snakeBodies.size();  i++) {
            this.snakeBodies.get(i).updateSnakeBody(this.snakeBodies.get(i-1).getX(),this.snakeBodies.get(i-1).getY());

        }








    }


    @Override
    public Shape getShape() {
        return null;
    }
}





