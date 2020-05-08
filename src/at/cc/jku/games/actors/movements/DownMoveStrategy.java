package at.cc.jku.games.actors.movements;

public class DownMoveStrategy implements MoveStrategy {
    private float x, y;
    private float speed;

    public DownMoveStrategy(float x, float speed) {
        this.x = x;
        setYStartPosition();
        this.speed = speed;
    }

    private void setYStartPosition (){
        this.y = 0;
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public void update(int delta) {
        this.y += (float) delta / 100.0 * this.speed;

        if (this.y > 800) {
           setYStartPosition();
        }

    }
}
