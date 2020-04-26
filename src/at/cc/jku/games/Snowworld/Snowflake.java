package at.cc.jku.games.Snowworld;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Actor {

    private SIZE size;
    private float x, deltaX, xConstant, y;
    private float speed;
    private float diameter;


    public Snowflake(SIZE size) {

        this.size = size;

        this.y = yStartPosition();

        this.xConstant = xStartPosition();

        switch (size) {
            case XL:
                this.speed = 20;
                this.diameter = 13;
                break;
            case LARGE: // fast speed
                this.speed = 15;
                this.diameter = 10;
                break;
            case MEDIUM: // medium speed
                this.speed = 10;
                this.diameter = 7;
                break;
            case SMALL: // slow speed
                this.speed = 5;
                this.diameter = 4;
                break;
            case XS:
                this.speed = 3;
                this.diameter = 2;
                break;
        }


    }

    private float xStartPosition() {
        Random random = new Random();
        float value = random.nextInt(600);
        return value;
    }

    private float yStartPosition() {
        Random random = new Random();
        return random.nextFloat() * (-600.0f);
    }

    @Override
    public void render(Graphics graphics) {

        graphics.fillOval(this.x, this.y, this.diameter, this.diameter);

    }

    @Override
    public void update(int delta) {

        this.y += (float) delta / 100.0 * this.speed;

        if (this.y > 600) {

            this.y = yStartPosition();

            this.xConstant = xStartPosition();
        }

        this.deltaX = this.diameter / 2.0f;
        this.x = this.xConstant - this.deltaX;

    }
}
