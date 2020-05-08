package at.cc.jku.games.snake;

import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.snake.parts.Snake;
import at.cc.jku.games.snake.parts.SnakeStrategySnakeKeyBoard;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame extends BasicGame {
    // Version 2.0.0: Start with Snake Gamer


    private List<Actor> actors;





    public SnakeGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        SnakeStrategySnakeKeyBoard fahren = new SnakeStrategySnakeKeyBoard();

        Snake snake = new Snake(fahren);

        this.actors.add(snake);



    }

    @Override
    public void keyPressed(int key, char c) {



    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

            for (Actor actor : this.actors) {
                actor.update(gameContainer, delta);

            }

    }





    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);

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
