package at.cc.jku.games.actors.movements;

import org.newdawn.slick.GameContainer;

public interface MoveStrategy {
    public float getX();
    public float getY();
    public void update(int delta);

}
