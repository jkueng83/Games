package at.cc.jku.games.game3Listen;

//import at.jku.games.firstgame.Objects;

import at.cc.jku.games.actors.Rectangle;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ObjetsGame3Listen extends BasicGame {

    private List<Rectangle> rectangles;
    private List<Circle> circles;

    public ObjetsGame3Listen(String title) {
        super(title);
    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new ObjetsGame3Listen("Games 2"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        Random random = new Random();

        this.rectangles = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600),
                    random.nextInt(50));
            this.rectangles.add(rectangle);
        }

        this.circles = new LinkedList<>();// ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Circle circle = new Circle();
            this.circles.add(circle);
                    }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Rectangle rectangle : this.rectangles) { // Rechtecke updaten
            rectangle.update(gameContainer, delta);
        }

        for (Circle circle: this.circles) { // Kreise Updaten
            circle.update(gameContainer, delta);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Rectangle rectangle : this.rectangles) { // Rechtecke Zeichnen
            rectangle.render(graphics);
        }

        for (Circle circle: this.circles) { // Kreise Zeichnen
            circle.render(graphics);
        }

    }
}
