package at.cc.jku.games.actors.movements;

public interface MoveStrategy {
    public float getX();
    public float getY();
    public void update(int delta);

}
