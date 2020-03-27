package at.jku.games.firstgame;

import org.newdawn.slick.*;

/*
Aufgabe - Objects
-----------------
Erstelle ein Rechteck, einen Kreis und ein Oval.
Die Objekte sollen sich folgendermaßen bewegen:
 */

public class Objects extends BasicGame {

    CountPosition countPositionX;
    CountPosition countPositionY;

    CounterXYRectangles counterXYRectangles;

    private float xMax;
    private float xMin;
    private float yMax;
    private float yMin;
    private float xPosition;
    private float yPosition;
    private float xRectangular;
    private float yRectangular;
    private float speed;
    private boolean countXPositive;
    private boolean countYPositive;

    public Objects(String title) {
        super(title);

    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.speed = 2.0f;
        this.xMin = 100;
        this.xMax = 500;
        this.yMin = this.xMin;
        this.yMax = this.xMax;

        this.countPositionX = new CountPosition(this.xMin, this.xMin, this.xMax, this.speed,
                true);

        this.countPositionY = new CountPosition(this.yMin, this.yMin, this.yMax, this.speed,
                false);

        counterXYRectangles = new CounterXYRectangles(this.xMin, this.xMax, this.yMin, this.yMax,
                this.speed, true);


        this.yRectangular = 400.0f;

        this.countXPositive = true;
        this.countYPositive = false;

        this.xRectangular = 100.0f;
        this.yRectangular = 100.0f;


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.xPosition = this.countPositionX.getPosition(delta);
        this.yPosition = this.countPositionY.getPosition(delta);

        this.xRectangular = counterXYRectangles.getXPosition(delta);
        this.yRectangular = counterXYRectangles.getYPosition(delta);

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawString("Hello you!", 100, 100);

        graphics.drawRect(this.xRectangular, this.yRectangular, 100, 100);
        graphics.drawOval(10, this.yPosition, 50, 50, 100);
        graphics.drawOval(this.xPosition, 10, 100, 50, 100);

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
