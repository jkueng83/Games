package at.cc.jku.games.shootApples;

import at.cc.jku.games.actors.*;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class ShootApples extends BasicGame {

    private List<Actor> actors;
    private List<FlyingDiamond> flyingDiamonds;
    private Slingshot slingshot;
    private FlyingApple flyingApple;

    private ApplesPointsCounter applesPointsCounter;


    public ShootApples(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        this.flyingDiamonds = new ArrayList<>();

        Tree tree = new Tree();
        this.actors.add(tree);

        this.slingshot = new Slingshot();
        this.actors.add(this.slingshot);

        FlyingApple flyingApple = new FlyingApple(50, 20, DIRECTION.DOWN,
                "src/at/cc/jku/games/actors/pictures/AppleTheOriginal.png");

        this.actors.add(flyingApple);
        this.flyingApple = flyingApple;

        this.applesPointsCounter = new ApplesPointsCounter();


    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            System.out.println("shoot!");
            FlyingDiamond flyingDiamant = null;
            try {
                flyingDiamant = new FlyingDiamond(this.slingshot.getXCenter(), this.slingshot.getY(), 50,
                        50, 50, DIRECTION.UP,
                        "src/at/cc/jku/games/actors/pictures/diamond2.png");
            } catch (SlickException e) {
                e.printStackTrace();
            }
            this.actors.add(flyingDiamant);
            this.flyingDiamonds.add(flyingDiamant);

        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);

        }

        if (this.applesPointsCounter.isAppleShoot(this.flyingApple, this.flyingDiamonds)) {
            removeAllDiamonds();
            this.flyingApple.setNewStartPosition();
        }

        if (this.flyingApple.getY() > 1000) {
            this.flyingApple.setNewStartPosition();
        }

        removeDiamondsOutOfWindow();

        for (FlyingDiamond flyingDiamond: this.flyingDiamonds) {
            System.out.println("Positin Y" + flyingDiamond.getY());

        }


    }

    private void removeDiamondsOutOfWindow() {
        for (int i = 0; i < this.flyingDiamonds.size(); i++) {
            if (this.flyingDiamonds.get(i).getY() < -500) {
                this.flyingDiamonds.remove(i);
            }

        }
    }

    private void removeAllDiamonds() {
        for (int i = 0; i < this.flyingDiamonds.size(); i++) {
            this.flyingDiamonds.remove(i);
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);

        }
        System.out.println("actors: "+ this.actors.size());
    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new ShootApples("Shoot Apples"));
            container.setDisplayMode(800, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
