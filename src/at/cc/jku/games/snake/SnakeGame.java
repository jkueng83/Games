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
    // Version 2.0.0: Start with Snake Gamer

    private float xMinGameField, xMaxGameField, yMinGameField, yMaxGameField;

    private List<Actor> actors;

    private AngelCodeFont font;
    Snake snake;

    public SnakeGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");

        this.xMinGameField = 100;
        this.xMaxGameField = 300;
        this.yMinGameField = 100;
        this.yMaxGameField = 300;

        SnakeStrategySnakeKeyBoard fahren = new SnakeStrategySnakeKeyBoard(this.xMinGameField, this.xMaxGameField,
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



    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (!this.snake.isGameOver()) {
            for (Actor actor : this.actors) {

                actor.update(gameContainer, delta);

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
