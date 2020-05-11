package at.cc.jku.games.actors.snakeActors;

import at.cc.jku.games.actors.Interfaces.CollisionActor;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class SnakeFood implements CollisionActor {

    private float x, y;
    private float objectWith, objectHeight;

    private float xMinGameField, xMaxGameField, yMinGameField, yMaxGameField;

    private Shape collisionShape;

    public SnakeFood(float xMinGameField, float xMaxGameField, float yMinGameField, float yMaxGameField) {

        this.objectHeight = 10;
        this.objectWith = this.objectHeight;

        this.xMinGameField = xMinGameField ;
        this.xMaxGameField = xMaxGameField;
        this.yMinGameField = yMinGameField;;
        this.yMaxGameField = yMaxGameField;
        newPosition();


        this.collisionShape = new Rectangle(this.x, this.y, this.objectWith-2, this.objectHeight-2);
    }

    @Override
    public Shape getShape() {
        return this.collisionShape;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillOval(this.x - this.objectWith / 2, this.y - this.objectHeight / 2,
                this.objectWith, this.objectHeight);
        graphics.setColor(Color.white);

        // nur jetzt zum entwickeln

        graphics.setColor(Color.red);
        graphics.draw(this.collisionShape);
        graphics.setColor(Color.white);


    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.collisionShape.setCenterX(this.x);
        this.collisionShape.setCenterY(this.y);
    }

    public void newPosition() {
        Random random = new Random();

        this.x = random.nextInt(((int) (this.xMaxGameField - this.xMinGameField-this.objectWith)/10 ) )*10 +
                this.xMinGameField + this.objectWith/2;
        this.y = random.nextInt(((int) (this.yMaxGameField - this.yMinGameField - this.objectHeight)/10 ))*10 +
                this.yMinGameField + this.objectHeight/2;

        System.out.println("x: " + this.x + "y: " + this.y);

    }
}
