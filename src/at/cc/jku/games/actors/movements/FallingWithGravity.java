package at.cc.jku.games.actors.movements;

public class FallingWithGravity implements MoveStrategy {

    private float x, y;
    private float v, a;

    public FallingWithGravity(float x) {
        this.x = x;
        this.v = 0;
        this.a = 9.81f;
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

        this.v += this.a * delta;
        this.y += this.v * delta / 10000;

        if (this.y > 1000) {
            this.y = 0;
            this.v = 0;
        }
        // System.out.println("v: " + this.v + " - t [ms]: " + delta);

    }
}
