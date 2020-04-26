package at.cc.jku.games.Snowworld;


import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SnowWorld extends BasicGame {

    /*
    50 Kleine Schneeflocken
    50 mittlere Schneeflocken
    50 große Schneeflocken
     */

    private List<Actor> actors;

    public SnowWorld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            //Snowflake snowflakeSmall = new Snowflake(SIZE.SMALL);
            //Snowflake snowflakeMedium = new Snowflake(SIZE.MEDIUM);
            //Snowflake snowflakeLarge = new Snowflake(SIZE.LARGE);

            //this.actors.add(snowflakeSmall);
            //this.actors.add(snowflakeMedium);
            //this.actors.add(snowflakeLarge);

            for (SIZE size: SIZE.values()) {
                Snowflake snowflake = new Snowflake(size);
                this.actors.add(snowflake);

            }

        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(delta);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {

        try {
            AppGameContainer container = new AppGameContainer(new SnowWorld("* * * Snow World * * *"));
            container.setDisplayMode(600, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
