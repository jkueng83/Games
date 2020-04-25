package at.cc.jku.games.game4Interfacees;

import org.newdawn.slick.Graphics;

import java.awt.*;

public interface Actor {
    public void render(Graphics graphics);
    public void update(int delta);
}
