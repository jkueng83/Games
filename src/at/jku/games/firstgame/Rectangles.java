package at.jku.games.firstgame;

import org.newdawn.slick.*;

public class Rectangles extends BasicGame {

    private float x;
    private float y;
    private float speed;

    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 50;
        this.y = 50;
        this.speed = 50.0f; // "f" für Float - wird anscheindend benötigt.


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        //System.out.println("Delta Variable: " + delta);
        this.x += (float) delta / this.speed;
        this.y += (float) delta / this.speed;

        if (this.x > 800) {
            this.x = 0;
            this.y = 0;
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.x, this.y, 100, 100);
        graphics.drawString("Hello you!", 300, 300);

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
