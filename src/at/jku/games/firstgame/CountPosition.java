package at.jku.games.firstgame;

public class CountPosition {
    private float position;
    private float maxPosition;
    private float minPosition;
    private float speed;
    private float deltaTime;
    private boolean isCountingPositive;

    public CountPosition(float startPosition,  float minPosition,float maxPosition, float speed,
                         boolean startCountingPositive) {

        this.position = startPosition;
        this.maxPosition = maxPosition;
        this.minPosition = minPosition;
        this.speed = speed;
        this.isCountingPositive = startCountingPositive;
    }


    public void setPosition(float position) {
        this.position = position;
    }

    public void setMaxPosition(float maxPosition) {
        this.maxPosition = maxPosition;
    }

    public void setMinPosition(float minPosition) {
        this.minPosition = minPosition;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getPosition(int deltaTime) {
        this.deltaTime = (float) deltaTime;
        calcPosition();
        return position;
    }

    private void calcPosition() {
        if (this.isCountingPositive) {

            this.position += this.deltaTime / this.speed;

            if (this.position >= this.maxPosition) {
                this.position = this.maxPosition;
                this.isCountingPositive = false;
            }

        } else {

            this.position -= this.deltaTime / this.speed;

            if (this.position <= this.minPosition) {
                this.position = this.minPosition;
                this.isCountingPositive = true;
            }
        }

    }
}
