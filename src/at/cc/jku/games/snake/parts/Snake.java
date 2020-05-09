package at.cc.jku.games.snake.parts;

import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.Interfaces.CollisionActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Snake implements CollisionActor {


    private int counterTime, points, eats;
    boolean isGameOver;

    private SnakeHead snakeHead;
    private List<SnakeBody> snakeBodies;

    private MoveStrategySnake moveStrategySnake;
    private SnakeFood snakeFood;

    private List<Actor> actors;




    public Snake(MoveStrategySnake moveStrategySnake, SnakeFood snakeFood) throws SlickException {
        //this.movedirection = MOVEDIRECTION.STANDSTILL;
        // this.x = 300;
        // this.y = 300;

        this.isGameOver = false;


        this.moveStrategySnake = moveStrategySnake;
        this.actors = new ArrayList<>();
        this.snakeBodies = new ArrayList<>();
        eat(); // Body erzeugen (Schwanz)


        this.snakeFood = snakeFood;

        this.snakeHead = new SnakeHead();
        this.actors.add(this.snakeHead);



    }

    @Override
    public void render(Graphics graphics) {

        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

        renderCounter(graphics);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        if (!this.isGameOver) {
            this.moveStrategySnake.update(gameContainer, delta);

            this.snakeHead.setX(this.moveStrategySnake.getX());
            this.snakeHead.setY(this.moveStrategySnake.getY());

            this.snakeBodies.get(0).updateSnakeBody(this.moveStrategySnake.getX(), this.moveStrategySnake.getY());

            for (int i = 1; i < this.snakeBodies.size(); i++) {
                this.snakeBodies.get(i).updateSnakeBody(this.snakeBodies.get(i - 1).getX(), this.snakeBodies.get(i - 1).getY());
            }

            for (Actor actor : this.actors) {
                actor.update(gameContainer, delta);
            }


            if (hasEatFood()) {

                eat();
                pointsCounter();
            }

            this.isGameOver = isGameOver();
        }



    }

    public void eat() {
        for (int i = 0; i < 5; i++) {
            float x, y;

            if (this.snakeBodies.size() == 0) {
                x = this.moveStrategySnake.getX();
                y = this.moveStrategySnake.getY();
            } else {
                x = this.snakeBodies.get(this.snakeBodies.size()-1).getX();
                y = this.snakeBodies.get(this.snakeBodies.size()-1).getY();
            }

            SnakeBody snakeBody = new SnakeBody(x, y);
            this.snakeBodies.add(snakeBody);
            this.actors.add(snakeBody);
        }
    }


    @Override
    public Shape getShape() {
        return null;
    }

    private boolean hasEatFood() {
        boolean hasEatFood = false;
        if (this.snakeFood.getShape().intersects(this.snakeHead.getShape())) {
            hasEatFood = true;
            System.out.println("The snake eat something");
            this.eats++;
            this.snakeFood.newPosition();


        }

        return hasEatFood;
    }

    private void pointsCounter() {
        this.points++;

    }

    private void renderCounter(Graphics graphics) {
        graphics.drawString("Eats: " + this.eats, 200, 50);
        graphics.drawString("Points: " + this.points, 400, 50);
    }

    public boolean isGameOver() {
        boolean isGameOver = false;

        for (SnakeBody snakeBody : this.snakeBodies) {
            if (snakeBody.isMoving()) {

                if (snakeBody.getShape().intersects(this.snakeHead.getShape())) {
                    isGameOver = true;
                    System.out.println("The snake eat snake");
                    System.out.println("GAME OVER");
                }

            }

        }

        return isGameOver;
    }

    public void restart() {
        this.isGameOver = false;


        this.moveStrategySnake = moveStrategySnake;
        this.actors.clear();
        this.snakeBodies.clear();
        eat(); // Body erzeugen (Schwanz)


        this.actors.add(this.snakeHead);

        this.points = 0;
        this.eats = 0;


    }

}





