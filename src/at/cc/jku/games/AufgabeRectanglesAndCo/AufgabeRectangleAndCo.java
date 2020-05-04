package at.cc.jku.games.AufgabeRectanglesAndCo;

//import at.jku.games.firstgame.Objects;

import at.cc.jku.games.actors.Interfaces.Actor;
import at.cc.jku.games.actors.CircleExpand;
import at.cc.jku.games.actors.Enums.MOVEDIRECTION;
import at.cc.jku.games.actors.Ellipse;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Aufgabe - Rectangles & Co
Programmiere das Beispiel aus den Videos nach!

Mache folgende Adaptierungen

Es gibt 10 Rectangles
Es gibt 10 Circles
Es gibt 10 Eclipsen (müssen wieder herinfliegen)
Baue folgende Objekte dazu:

Baue die Rectangles so um, damit man im Konstruktor angeben kann ob sie von links nach rechts oder umgekehrt fliegen.
Die Circles sollen im laufe des Fluges wachsen - immer größer werden (der Durchmesser wächst)
 */
public class AufgabeRectangleAndCo extends BasicGame {

    private List<Actor> actors;


    public AufgabeRectangleAndCo(String title) {
        super(title);
    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new AufgabeRectangleAndCo("Games 2"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        System.out.println("###################################");
        System.out.println("#### Aufgabe - Rectangles & Co ####");
        System.out.println("###################################");

        Random random = new Random();

        this.actors = new ArrayList<>();

        MOVEDIRECTION direction ;

        for (int i = 0; i < 10; i++) {

            if (random.nextInt(2)>0){
                direction = MOVEDIRECTION.MOVETORIGHT;
            }else {
                direction = MOVEDIRECTION.MOVETOLEFT;
            }

            RectangleDirection rectangle = new RectangleDirection(random.nextInt(600),
                    random.nextInt(600), random.nextInt(40)+10,direction);

            this.actors.add(rectangle);
        }

       for (int i = 0; i < 10; i++) {
            CircleExpand circle = new CircleExpand();
            this.actors.add(circle);
                    }

        for (int i = 0; i < 10 ; i++) {
            Ellipse ellipse = new Ellipse(random.nextInt(600),random.nextInt(600),
                    random.nextInt(34)+10);
            this.actors.add(ellipse);

        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor actor : this.actors) { // Actors updaten
            actor.update(gameContainer, delta);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Actor actor : this.actors) { // Actors Zeichnen
            actor.render(graphics);
        }

    }
}
