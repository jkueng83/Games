package at.cc.jku.games.snake2;

import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.snakeActors.Snake;
import at.cc.jku.games.actors.snakeActors.SnakeFood;
import at.cc.jku.games.actors.snakeActors.SnakeGameField;
import at.cc.jku.games.actors.snakeActors.SnakeStrategySnakeKeyBoard;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame2 extends BasicGame {
    // Version ???.0.5: In Arbeit Funktioniert noch nicht.


    private float xMinGameField, xMaxGameField, yMinGameField, yMaxGameField;

    private List<Actor> actors;

    private AngelCodeFont font;
    private Snake snake;

    private boolean isGameStarted, isBoarderActive, isGameOver;
    private SnakeStrategySnakeKeyBoard snakeMoveStrategy;

    public SnakeGame2(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");

        this.isGameStarted = false;
        this.isBoarderActive = false;
        this.isGameOver = false;
        this.xMinGameField = 100;
        this.xMaxGameField = 400;
        this.yMinGameField = 100;
        this.yMaxGameField = 400;


        this.actors = new ArrayList<>();

        SnakeGameField snakeGameField = new SnakeGameField(this.xMinGameField, this.xMaxGameField, this.yMinGameField,
                this.yMaxGameField);

        this.actors.add(snakeGameField);



        Snake2 snake =  new Snake2();



        this.actors.add(snake);

    }

    @Override
    public void keyPressed(int key, char c) {

        startGame(key);

        BorderActiveDeactivate(key);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (this.isGameStarted) {

            for (Actor actor: this.actors) {
                actor.update(gameContainer,delta);
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

        printTexts(graphics);

    }

    private void startGame(int key) {
        if ((key == Input.KEY_S) && !this.isGameStarted) {
            this.isGameStarted = true;

            this.snakeMoveStrategy.restart();
            if (this.isGameOver) {

                this.snake.restart();
            }
        }
    }

    private void BorderActiveDeactivate(int key) {
        if (!this.isGameStarted) {
            if (key == Input.KEY_B) {
                if (this.isBoarderActive) {
                    this.isBoarderActive = false;
                } else {
                    this.isBoarderActive = true;
                }
                this.snakeMoveStrategy.setBoarderActive(this.isBoarderActive);
            }
        }
    }

    private void printTexts(Graphics graphics) {

        if (this.isGameOver) {
            this.font.drawString(this.xMinGameField + 10, this.yMinGameField + 10, "Game Over!!!!");
        }

        graphics.drawString("Start game with pressing - s, and", this.xMinGameField, this.yMaxGameField + 50);
        graphics.drawString("then move up, down, left or right", this.xMinGameField, this.yMaxGameField + 70);

        if (this.isBoarderActive) {
            graphics.drawString("Boarder is active - GAME OVER when moving in to the boarder.",
                    this.xMinGameField, this.yMaxGameField + 90);
        } else {
            graphics.drawString("Boarder is not active - snake moves to the other side.",
                    this.xMinGameField, this.yMaxGameField + 90);
        }

        if (!this.isGameStarted) {
            if (this.isBoarderActive) {
                graphics.drawString("Deactivate boarders with pressing - b",
                        this.xMinGameField, this.yMaxGameField + 110);
            } else {
                graphics.drawString("Activate boarders with pressing - b",
                        this.xMinGameField, this.yMaxGameField + 110);
            }
        }
    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new SnakeGame2("Snake Game2"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
