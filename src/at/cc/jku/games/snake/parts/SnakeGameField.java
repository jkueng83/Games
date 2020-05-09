package at.cc.jku.games.snake.parts;

import at.cc.jku.games.actors.Interfaces.Actor;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class SnakeGameField implements Actor {

    private float xMinGameField, xMaxGameField, yMinGameField, yMaxGameField;


    private float objectThickness;

    public SnakeGameField(float xMinGameField, float xMaxGameField, float yMinGameField, float yMaxGameField) {
        this.xMinGameField = xMinGameField;
        this.xMaxGameField = xMaxGameField;
        this.yMinGameField = yMinGameField;
        this.yMaxGameField = yMaxGameField;
        this.objectThickness = 10;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.yellow);

        // Spielrand oben
        graphics.fillRect(this.xMinGameField - this.objectThickness, this.yMinGameField - this.objectThickness,
                this.xMaxGameField - this.xMinGameField + this.objectThickness * 2, this.objectThickness);
        // Spielrand unten
        graphics.fillRect(this.xMinGameField - this.objectThickness, this.yMaxGameField,
                this.xMaxGameField - this.xMinGameField + this.objectThickness * 2, this.objectThickness);
        // Spielrand links
        graphics.fillRect(this.xMinGameField - this.objectThickness, this.yMinGameField - this.objectThickness,
                this.objectThickness, this.yMaxGameField - this.yMinGameField + this.objectThickness * 2);
        // Spielrand rechts
        graphics.fillRect(this.xMaxGameField , this.yMinGameField - this.objectThickness,
                this.objectThickness, this.yMaxGameField - this.yMinGameField + this.objectThickness * 2);


        graphics.setColor(Color.white);


    }

    @Override
    public void update(GameContainer gameContainer, int delta) {


    }

}
