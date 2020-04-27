package at.cc.jku.games.actors;

import org.newdawn.slick.*;

public class Slingshot implements Actor {
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

    @Override
    public void render(Graphics graphics) {

        this.slingshot.draw(this.x, this.y);

    }

    public float getXCenter() {
        return x + this.objectWith/2;
    }

    public float getY() {
        return y;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x++;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x--;
        }

        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x > 700) {
            this.x = 700;
        }




    }
}
