package at.jku.games.firstgame;

public class CounterXYRectangles {

    private enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    private DIRECTION direction;

    private float xPosition;
    private float xPositionMax;
    private float xPositionMin;

    private float yPosition;
    private float yPositionMax;
    private float yPositionMin;

    private float speed;

    private int deltaTime;

    boolean directionIsClockwise;

    CountPosition counterPositionX = new CountPosition(this.xPositionMin, this.xPositionMin, this.xPositionMax, this.speed,
            true);

    CountPosition counterPositionY = new CountPosition(this.yPositionMin, this.yPositionMin, this.yPositionMax, this.speed,
            true);

    public CounterXYRectangles(float xPositionMin, float xPositionMax,
                               float yPositionMin, float yPositionMax,
                               float speed, boolean directionIsClockwise) {

        this.xPositionMax = xPositionMax;
        this.xPositionMin = xPositionMin;
        this.xPosition = xPositionMin;

        this.yPositionMax = yPositionMax;
        this.yPositionMin = yPositionMin;
        this.yPosition = yPositionMin;

        this.speed = speed;
        this.direction = DIRECTION.RIGHT;
        this.directionIsClockwise = directionIsClockwise;

        this.counterPositionX.setPosition(this.xPosition);
        this.counterPositionX.setMaxPosition(xPositionMax);
        this.counterPositionX.setMinPosition(xPositionMin);
        this.counterPositionX.setSpeed(speed);

        this.counterPositionY.setPosition(this.yPosition);
        this.counterPositionY.setMaxPosition(yPositionMax);
        this.counterPositionY.setMinPosition(yPositionMin);
        this.counterPositionY.setSpeed(speed);

    }

    public float getXPosition(int deltaTime) {
        this.deltaTime = deltaTime ;
        countX();
        return xPosition;
    }

    public float getYPosition(int deltaTime) {
        this.deltaTime=deltaTime;
        countY();
        return yPosition;
    }

    private void countX() {
        // hier wird die X-Richtung gezählt, nach links/rechts

        if ((this.direction == DIRECTION.RIGHT) || (this.direction == DIRECTION.LEFT)) {
            this.xPosition = counterPositionX.getPosition(deltaTime);
        }

        checkChangeDirection();
    }
    private void countY() {
        // hier wird rauf und runter gezählt.
        if ((this.direction == DIRECTION.UP) || (this.direction == DIRECTION.DOWN)) {
            this.yPosition = counterPositionY.getPosition(deltaTime);
        }

        checkChangeDirection();
    }

    private void checkChangeDirection (){
        // Hier wird überprüft ob der Zähler in einer Ecke steht. Wenn ja, dann wird die Richtung geändert.
        if ((this.xPosition<=this.xPositionMin)||(this.xPosition>=xPositionMax)){
            if((this.yPosition<=this.yPositionMin)||(this.yPosition>=yPositionMax)){
                changeDirection(true);
            }
        }

    }

    private void changeDirection(boolean clockwise) {

        // Hier wird die Zählrichtung geändert.
        if (clockwise) {
            switch (this.direction) {

                case RIGHT:
                    this.direction = DIRECTION.DOWN;
                    break;
                case DOWN:
                    this.direction = DIRECTION.LEFT;
                    break;
                case LEFT:
                    this.direction = DIRECTION.UP;
                    break;
                case UP:
                    this.direction = DIRECTION.RIGHT;
                    break;
            }

        } else {

            switch (this.direction) {
                case LEFT:
                    this.direction = DIRECTION.DOWN;
                    break;
                case DOWN:
                    this.direction = DIRECTION.RIGHT;
                    break;
                case RIGHT:
                    this.direction = DIRECTION.UP;
                    break;
                case UP:
                    this.direction = DIRECTION.LEFT;
                    break;
            }

        }

    }


}
