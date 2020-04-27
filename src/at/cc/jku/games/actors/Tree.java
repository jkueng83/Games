package at.cc.jku.games.actors;

import org.newdawn.slick.*;

public class Tree implements Actor {
    private Image slingshot;
    float x, y, v, objectWith, objectHeight;

    public Tree() throws SlickException {
        this.objectWith = 700;
        this.objectHeight = 700;
        Image temp = new Image("src/at/cc/jku/games/actors/pictures/tree.png");
        this.slingshot = temp.getScaledCopy((int) this.objectWith, (int) this.objectHeight);
        this.x = 400;
        this.y = 10;
        this.v = 5;

    }

    @Override
    public void render(Graphics graphics) {

        this.slingshot.draw(this.x - this.objectWith / 2 , this.y);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }
}
