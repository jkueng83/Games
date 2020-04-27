package at.cc.jku.games.actors;

import org.newdawn.slick.*;

public class Rocket implements Actor {

    private Image rocketImage;
    float x, y, v, objectWith, objectHeight;

    public Rocket() throws SlickException {
        this.objectWith = 100;
        this.objectHeight = 100;
        Image tmp = new Image("testdata/rocket2.png");
        this.rocketImage = tmp.getScaledCopy((int) this.objectWith, (int) this.objectHeight);
        this.x = 300;
        this.y = 500;
        this.v = 10;

    }

    @Override
    public void render(Graphics graphics) {

        this.rocketImage.draw(this.x, this.y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.y--;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.y++;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x--;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x++;
        }

        if (this.x < 0){
            this.x = 0;
        }

        if (this.x > 600){
            this.x = 600;
        }

        if (this.y < 0){
            this.y = 0;
        }

        if (this.y > 600){
            this.y = 600;
        }



    }

    public float getX() {
        return x;
    }

    public float getXCenter() {
        return this.x + this.objectWith / 2;
    }

    public float getY() {
        return y;
    }
}
