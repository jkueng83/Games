package at.cc.jku.games.snake.parts;

import at.cc.jku.games.actors.AbstractMoveableActor;
import at.cc.jku.games.actors.Enums.MOVEDIRECTION;
import at.cc.jku.games.actors.Interfaces.CollisionActor;
import at.cc.jku.games.actors.movements.MoveStrategy;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Shape;

import java.util.List;

public class SnakeStrategySnakeKeyBoard implements MoveStrategySnake {

    private MOVEDIRECTION movedirection;
    private float x;
    private float y;

    private int counterTime;

    private List<CollisionActor> collisionActorList;


    public SnakeStrategySnakeKeyBoard () {

        this.movedirection = MOVEDIRECTION.STANDSTILL;
        this.x = 300;
        this.y = 300;
    }


    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.counterTime += delta;
        changeMoveDirection(gameContainer);
        int iTemp = 100;
        if (this.counterTime > iTemp) {
            this.counterTime -= iTemp;
            updatePosition();

        }


    }

    private void updatePosition() {
        float deltaMove = 5;
        switch (this.movedirection) {
            case MOVETORIGHT:
                this.x += deltaMove;
                break;
            case MOVETOLEFT:
                this.x -= deltaMove;
                break;
            case MOVEUP:
                this.y -= deltaMove;
                break;
            case MOVEDOWN:
                this.y += deltaMove;
                break;
        }

        jumpToTheOtherSide();


    }

    private void jumpToTheOtherSide() {

        float xMin = 100;
        float xMax = 600;
        float yMin = xMin;
        float yMax = xMax;

        if (this.x < xMin) {
            this.x = xMax;
        }
        if (this.x > xMax) {
            this.x = xMin;
        }
        if (this.y < yMin) {
            this.y = yMax;
        }
        if (this.y > yMax) {
            this.y = yMin;
        }
    }

    private void changeMoveDirection(GameContainer gameContainer) {
        switch (this.movedirection) {
            case STANDSTILL:
                if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
                    this.movedirection = MOVEDIRECTION.MOVETOLEFT;
                }
                if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
                    this.movedirection = MOVEDIRECTION.MOVEUP;
                }
                if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
                    this.movedirection = MOVEDIRECTION.MOVETORIGHT;
                }
                if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
                    this.movedirection = MOVEDIRECTION.MOVEDOWN;
                }
                break;

            case MOVEUP:
            case MOVEDOWN:
                if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
                    this.movedirection = MOVEDIRECTION.MOVETOLEFT;
                }
                if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
                    this.movedirection = MOVEDIRECTION.MOVETORIGHT;
                }
                break;

            case MOVETOLEFT:
            case MOVETORIGHT:
                if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
                    this.movedirection = MOVEDIRECTION.MOVEDOWN;
                }
                if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
                    this.movedirection = MOVEDIRECTION.MOVEUP;
                }
                break;
        }
    }




    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }


}





