package at.cc.jku.games.actors.snakeActors;

import at.cc.jku.games.actors.Enums.MOVEDIRECTION;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class SnakeStrategySnakeKeyBoard implements MoveStrategySnake {

    private MOVEDIRECTION movedirection;
    private MOVEDIRECTION movedirectionRequested;
    private float x, y, xMinGameField, xMaxGameField, yMinGameField, yMaxGameField;

    private int counterTime;
    private boolean isBoarderActive;


    public SnakeStrategySnakeKeyBoard(boolean isBoarderActive, float xMinGameField, float xMaxGameField,
                                      float yMinGameField, float yMaxGameField) {

        this.xMinGameField = xMinGameField;
        this.xMaxGameField = xMaxGameField;
        this.yMinGameField = yMinGameField;
        this.yMaxGameField = yMaxGameField;
        this.isBoarderActive = isBoarderActive;

        restart();

    }
     public void restart (){

         this.movedirection = MOVEDIRECTION.STANDSTILL;
         this.movedirectionRequested = this.movedirection;
         this.x = ((int) ((xMinGameField + xMaxGameField) / 2 / 10)) * 10.0f + 5;
         this.y = ((int) ((yMinGameField + yMaxGameField) / 2 / 10)) * 10.0f + 5;

     }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        this.counterTime += delta;
        changeMoveDirection(gameContainer);
        int iTemp = 100; // Zeit bis die Position vergrößert wird.

        if (this.counterTime > iTemp) {
            this.counterTime -= iTemp;
            updatePosition();

        }

    }

    private void updatePosition() {

        float deltaMove = 5;

        if (!isGameOver())
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

        float xMin = this.xMinGameField + 5; // 5 ist die halbe Größe der Schlange
        float xMax = this.xMaxGameField - 5;
        float yMin = this.yMinGameField + 5;
        float yMax = this.yMaxGameField - 5;

        if (!this.isBoarderActive) {

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
    }

    private void changeMoveDirection(GameContainer gameContainer) {

        switch (this.movedirection) {
            case STANDSTILL:
                if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
                    this.movedirectionRequested = MOVEDIRECTION.MOVETOLEFT;
                }
                if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
                    this.movedirectionRequested = MOVEDIRECTION.MOVEUP;
                }
                if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
                    this.movedirectionRequested = MOVEDIRECTION.MOVETORIGHT;
                }
                if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
                    this.movedirectionRequested = MOVEDIRECTION.MOVEDOWN;
                }
                break;

            case MOVEUP:
            case MOVEDOWN:
                if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
                    this.movedirectionRequested = MOVEDIRECTION.MOVETOLEFT;
                }
                if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
                    this.movedirectionRequested = MOVEDIRECTION.MOVETORIGHT;
                }
                break;

            case MOVETOLEFT:
            case MOVETORIGHT:
                if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
                    this.movedirectionRequested = MOVEDIRECTION.MOVEDOWN;
                }
                if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
                    this.movedirectionRequested = MOVEDIRECTION.MOVEUP;
                }
                break;
        }

        if (this.movedirection == MOVEDIRECTION.STANDSTILL || (
                (((int) this.x) % 5 == 0) && !(((int) this.x) % 10 == 0) &&
                        (((int) this.y) % 5 == 0) && !(((int) this.y) % 10 == 0))
        ) {
            this.movedirection = this.movedirectionRequested;
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

    public boolean isBoarderActive() {
        return isBoarderActive;
    }

    public void setBoarderActive(boolean boarderActive) {
        isBoarderActive = boarderActive;
    }

    public boolean isGameOver() {

        boolean isGameOver = false;

        if ((this.x < this.xMinGameField) || (this.x > this.xMaxGameField) ||
                (this.y < this.yMinGameField) || (this.y > this.yMaxGameField)) {
            isGameOver = true;
        }

        return isGameOver;
    }

    public MOVEDIRECTION getMovedirection() {
        return movedirection;
    }
}





