package at.cc.jku.games.actors;

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


    /*

    private Image slingshot;
    float x, y, v, objectWith, objectHeight;

    public Slingshot() throws SlickException {
        this.objectWith = 100;
        this.objectHeight = 100;
        Image temp = new Image("src/at/cc/jku/games/actors/pictures/steinschleuder3.png");
        this.slingshot = temp.getScaledCopy((int) this.objectWith, (int) this.objectHeight);
        this.x = 300;
        this.y = 700;
        this.v = 5;

    }


     */

    /*
    @Override
    public void render(Graphics graphics) {

        //this.slingshot.draw(this.x, this.y);

    }

     */

    /*
    public float getXCenter() {
        return x + this.objectWith/2;
    }

     */

    /*
    public float getY() {
        return y;
    }

     */

    @Override
    public void update(GameContainer gameContainer, int delta) {
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
