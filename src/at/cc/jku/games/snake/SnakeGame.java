package at.cc.jku.games.snake;

import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.snake.parts.Snake;
import at.cc.jku.games.snake.parts.SnakeFood;
import at.cc.jku.games.snake.parts.SnakeGameField;
import at.cc.jku.games.snake.parts.SnakeStrategySnakeKeyBoard;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame extends BasicGame {
    // Version 2.0.2: Start mit "s" ergänzt
    // Version 2.0.1: Working Version
    // Version 2.0.0: Start with Snake Gamer

    private float xMinGameField, xMaxGameField, yMinGameField, yMaxGameField;

    private List<Actor> actors;

    private AngelCodeFont font;
    private Snake snake;

    private boolean isGameStarted;
    private SnakeStrategySnakeKeyBoard fahren;

    public SnakeGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");

        this.isGameStarted = false;
        this.xMinGameField = 100;
        this.xMaxGameField = 300;
        this.yMinGameField = 100;
        this.yMaxGameField = 300;

        this.fahren = new SnakeStrategySnakeKeyBoard(this.xMinGameField, this.xMaxGameField,
                this.yMinGameField, this.yMaxGameField);

        this.actors = new ArrayList<>();

        SnakeGameField snakeGameField = new SnakeGameField(this.xMinGameField, this.xMaxGameField, this.yMinGameField,
                this.yMaxGameField);

        this.actors.add(snakeGameField);


        SnakeFood snakeFood = new SnakeFood(this.xMinGameField, this.xMaxGameField, this.yMinGameField,
                this.yMaxGameField);

        this.actors.add(snakeFood);

        this.snake = new Snake(fahren, snakeFood);

        this.actors.add(snake);


    }

    @Override
    public void keyPressed(int key, char c) {

        if ((key == Input.KEY_S) && !this.isGameStarted) {
            this.isGameStarted = true;

            this.fahren.restart();
            if (this.snake.isGameOver()) {

                this.snake.restart();
            }
        }


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (this.isGameStarted) {

            if (!this.snake.isGameOver()) {
                for (Actor actor : this.actors) {

                    actor.update(gameContainer, delta);

                }
            } else {
                this.isGameStarted = false;
            }
        }

    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

        if (this.snake.isGameOver()) {
            this.font.drawString(this.xMinGameField + 10, this.yMinGameField + 10, "Game Over!!!!");
        }


        graphics.drawString("Start game with pressing - s", this.xMinGameField, this.yMaxGameField + 50);
        graphics.drawString("Then move up, down, left or right", this.xMinGameField, this.yMaxGameField + 70);


    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new SnakeGame("Snake Game"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
