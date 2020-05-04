package at.cc.jku.games.actors.Png;

import at.cc.jku.games.actors.Png.ObjectPngPosition;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tree extends ObjectPngPosition { // implements Actor {
    private Image slingshot;

    public Tree(float x, float y, float objectWith, float objectHeight) throws SlickException {
        super(x, y, objectWith, objectHeight, "src/at/cc/jku/games/actors/pictures/tree.png");
    }
    //float x, y, v, objectWith, objectHeight;
/*
    public Tree() throws SlickException {
        super();
                          t his.objectWith = 700;
        this.objectHeight = 700;
        Image temp = new Image("src/at/cc/jku/games/actors/pictures/tree.png");
        this.slingshot = temp.getScaledCopy((int) this.objectWith, (int) this.objectHeight);
        this.x = 400;
        this.y = 10;
        this.v = 5;

    }

 */
/*
    @Override
    public void render(Graphics graphics) {

        //this.slingshot.draw(this.x - this.objectWith / 2 , this.y);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }

 */
}
