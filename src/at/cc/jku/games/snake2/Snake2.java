package at.cc.jku.games.snake2;

import at.cc.jku.games.actors.Enums.MOVEDIRECTION;
import at.cc.jku.games.actors.Interfaces.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.ArrayList;
import java.util.List;

public class Snake2 implements Actor {

    List<Integer> xPosition;
    List<Integer> yPosition;

    public int scalingFactor;
    private int counterTime;

    private MOVEDIRECTION movedirection;
    private MOVEDIRECTION movedirectionRequested;


    private int xMinGameField, xMaxGameField, yMinGameField, yMaxGameField, GameFieldWith, GameFieldHeight;

    private boolean isBoarderActive;

    public Snake2() {
        this.xPosition = new ArrayList<>();
        this.yPosition = new ArrayList<>();

        this.scalingFactor = 10;

        this.xMinGameField = 100;
        this.xMaxGameField = 500;
        this.GameFieldWith = (this.xMaxGameField - this.xMinGameField) / this.scalingFactor;

        this.yMinGameField = 100;
        this.yMaxGameField = 500;
        this.GameFieldHeight = (this.yMaxGameField - this.yMinGameField) / this.scalingFactor;

        this.isBoarderActive = false;

        restart();

    }

    public void restart() {

        this.movedirection = MOVEDIRECTION.MOVETORIGHT;
        this.movedirectionRequested = this.movedirection;
        this.xPosition.add(15);
        this.yPosition.add(15);

    }

    @Override
    public void render(Graphics graphics) {

        graphics.fillRect(this.xMinGameField + this.xPosition.get(0) * this.scalingFactor, this.yMinGameField +
                this.yPosition.get(0) * this.scalingFactor, this.scalingFactor, this.scalingFactor);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        System.out.println("update");
        this.counterTime += delta;
        changeMoveDirection(gameContainer);
        int iTemp = 100; // Zeit bis die Position vergrößert wird.

        if (this.counterTime > iTemp) {
            this.counterTime -= iTemp;
            updatePosition();
            System.out.println("Ppdate");

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
    }

    private void updatePosition() {


        if (!isGameOver()) {
            switch (this.movedirection) {
                case MOVETORIGHT:
                    this.xPosition.add(this.xPosition.get(this.xPosition.size()) + 1);

                    break;

            }
        }


    }


    public boolean isGameOver() {

        boolean isGameOver = false;


        return isGameOver;
    }

}
