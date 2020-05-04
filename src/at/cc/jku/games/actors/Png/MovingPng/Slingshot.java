package at.cc.jku.games.actors.Png.MovingPng;

import at.cc.jku.games.actors.Png.ObjectPngPosition;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Slingshot extends ObjectPngPosition {

    private float speed;

    public Slingshot() throws SlickException {
        super(300, 750, 100, 100,
                "src/at/cc/jku/games/actors/pictures/steinschleuder3.png");

        this.speed = 75;
    }


    /*  Zeichnen macht die Mutterklasse
    @Override
    public void render(Graphics graphics) {

        //this.slingshot.draw(this.x, this.y);

    }

     */




    @Override
    public void update(GameContainer gameContainer, int delta) {
        super.update(gameContainer,delta);

        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x += this.speed / 100 * delta;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x -= this.speed / 100 * delta;
        }

        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x > 800) {
            this.x = 800;
        }




    }
}
