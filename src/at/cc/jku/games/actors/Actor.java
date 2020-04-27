package at.cc.jku.games.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.awt.*;

public interface Actor {
    public void render(Graphics graphics);
    public void update(GameContainer gameContainer, int delta);
}
