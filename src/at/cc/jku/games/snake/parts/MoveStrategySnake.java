package at.cc.jku.games.snake.parts;

import at.cc.jku.games.actors.Enums.MOVEDIRECTION;
import org.newdawn.slick.GameContainer;

public interface MoveStrategySnake {
    public float getX();
    public float getY();
    public void update(GameContainer gameContainer, int delta);
    public MOVEDIRECTION getMovedirection();
}
