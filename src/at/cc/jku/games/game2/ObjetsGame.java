package at.cc.jku.games.game2;

//import at.jku.games.firstgame.Objects;
import at.cc.jku.games.actors.Rectangle;
import org.newdawn.slick.*;

public class ObjetsGame extends BasicGame {

    Rectangle rectangle;
    Rectangle rectangle1;
    Rectangle rectangle2;
    Rectangle rectangle3;
    Rectangle rectangle4;
    Rectangle rectangle5;
    Rectangle rectangle6;
    Rectangle rectangle7;
    Rectangle rectangle8;
    Rectangle rectangle9;

    public ObjetsGame(String title) {
        super(title);
    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new ObjetsGame ("Games 2"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.rectangle = new Rectangle(100,100,5);
        this.rectangle1 = new Rectangle(100 , 200 , 10);
        this.rectangle2 = new Rectangle(100 , 300 , 20);
        this.rectangle3 = new Rectangle(100 , 400 , 30);
        this.rectangle4 = new Rectangle(100 , 500 , 40);
        this.rectangle5 = new Rectangle(300 , 150 , 5);
        this.rectangle6 = new Rectangle(300 , 250 , 10);
        this.rectangle7 = new Rectangle(300 , 350 , 20);
        this.rectangle8 = new Rectangle(300 , 450 , 30);
        this.rectangle9 = new Rectangle(300 , 550 , 40);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.rectangle.update(gameContainer, delta);
        this.rectangle1.update(gameContainer, delta);
        this.rectangle2.update(gameContainer,delta);
        this.rectangle3.update(gameContainer, delta);
        this.rectangle4.update(gameContainer, delta);
        this.rectangle5.update(gameContainer, delta);
        this.rectangle6.update(gameContainer, delta);
        this.rectangle7.update(gameContainer, delta);
        this.rectangle8.update(gameContainer, delta);
        this.rectangle9.update(gameContainer, delta);

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        this.rectangle.render(graphics);
        this.rectangle1.render(graphics);
        this.rectangle2.render(graphics);
        this.rectangle3.render(graphics);
        this.rectangle4.render(graphics);
        this.rectangle5.render(graphics);
        this.rectangle6.render(graphics);
        this.rectangle7.render(graphics);
        this.rectangle8.render(graphics);
        this.rectangle9.render(graphics);

    }
}
