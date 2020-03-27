package at.jku.games.firstgame;

import org.newdawn.slick.*;

/*
Aufgabe - Objects
-----------------
Erstelle ein Rechteck, einen Kreis und ein Oval.
Die Objekte sollen sich folgendermaßen bewegen:
 */

public class Objects extends BasicGame {

    private float xPosition;
    private float yPosition ;
    private float xRectangular;
    private float yRectangular;
    private float speed;
    private boolean countXPositive;
    private boolean countYPositive;

    private enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    private DIRECTION direction;


    public Objects(String title) {
        super(title);

    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.xPosition = 100.0f;
        this.yRectangular = 400.0f;
        this.speed = 50.0f;
        this.countXPositive = true;
        this.countYPositive = false;
        this.direction = DIRECTION.RIGHT;

        this.xRectangular = 100.0f;
        this.yRectangular = 100.0f;


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (this.countXPositive) {
            this.xPosition += delta / this.speed;
            if (this.xPosition >= 400) {
                this.xPosition = 400;
                this.countXPositive = false;

            }
        } else {
            this.xPosition -= delta / this.speed;
            if (this.xPosition <= 100) {
                this.xPosition = 100;
                this.countXPositive = true;
            }
        }

        if ((this.xPosition == 100) || (this.xPosition == 400)) {
            switch (this.direction) {
                case RIGHT:
                    this.direction = DIRECTION.DOWN;
                    break;
                case DOWN:
                    this.direction = DIRECTION.LEFT;
                    break;
                case LEFT:
                    this.direction = DIRECTION.UP;
                    break;
                case UP:
                    this.direction = DIRECTION.RIGHT;
                    break;
            }

        }

        if()
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawString("Hello you!", 100, 100);

        if (this.xPosition =)
            graphics.drawRect(100, 200, 100, 100);
        graphics.drawOval(500, this.xPosition, 50, 50, 100);
        graphics.drawOval(this.xPosition, 500, 100, 50, 100);

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Objects("Aufgabe - Objects"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
