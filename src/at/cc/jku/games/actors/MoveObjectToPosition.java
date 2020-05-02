package at.cc.jku.games.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class MoveObjectToPosition extends ObjectPngPosition {

    protected float xDestination, yDestination, speedMax, deltaT, speedXParabel, speedXBogen;
    MOVETYPE moveType;
    private float a, b, c, x1, y1, x2, y2, x3, y3;

    public MoveObjectToPosition(float xStart, float xDestination, float yStart, float yDestination, float speedMax,
                                float objectWith, float objectHeight, String imagePath, MOVETYPE moveType) throws SlickException {

        super(xStart, yStart, objectWith, objectHeight, imagePath);

        this.xDestination = xDestination;
        this.yDestination = yDestination;
        this.speedMax = speedMax;
        this.moveType = moveType;
        this.x1 = xStart;
        this.y1 = yStart;
        this.x2= (xStart + xDestination) /2;
        this.y2 = yStart/2;
        this.x3 = xDestination;
        this.y3 = yDestination;


    }

    private void calculateActualPosition() {
        switch (this.moveType) {
            case LINEAR:
                moveDirectToDestination();
                break;
            case PARABEL:
                moveParableToDestination();
                break;
            case BOGEN:
                moveBogenToDestination();
                break;
        }

    }

    private void moveBogenToDestination() {
        // funktioniert auch nicht gut
        this.speedXBogen = (this.x3 - this.x1) / 2000;
        float deltaX = Math.abs(this.xDestination - this.x);
        if (deltaX < 1) {
            this.x = this.xDestination;
            this.y = this.yDestination;
        } else {
            this.x += this.speedXBogen * this.deltaT;
            if (deltaX > 200){
                this.y +=2 ;
            }else{
                this.y = this.y - (this.y-this.yDestination)/2;
            }

        }



    }

    private void moveParableToDestination() {
        // funktioniert nich so gut da die Punkte der Parabel für die Berechnung der Konstanten nicht stimmt.
        float a, b, c;
        float x1 = this.x1;
        float y1 = this.y1;
        float x2 = this.x2;
        float y2 = this.y2;
        float x3 = this.x3;
        float y3 = this.y3;


        //y = ax2 + bx + c
        // c = y - ax^2 - bx =
        // c = y1 - a*x1 ^ 2 - b * x1
        // c = y1 - a * x1 * x1 - b * x1;

        // b = (y - ax^2 - c)/x
        // b = (y2 - a * x2^2 - c)/x2
        // b  = (y2 - a * x2^2 - (c))/x2
        // b = (y2- a*x2*x2 - (y1 - a * x1 * x1 - b * x1))/x2

        // a = (y - bx - c)/(x^2) =
        // a= (y3 - (b) * x3 - (c) /(x3^2)
        // a= (y3 - ((y2- a*x2*x2 - (y1 - a * x1 * x1 - b * x1))/x2) * x3 - (y1 - a * x1 * x1 - b * x1)) /(x3*x3)
        //

        a = this.a;
        b = this.b;
        c = this.c;

        float deltaX = Math.abs(this.xDestination - this.x);

        if (a == 0) { // Konstanten berechnern

            a = (y3 - ((y2 - a * x2 * x2 - (y1 - a * x1 * x1 - b * x1)) / x2) * x3 - (y1 - a * x1 * x1 - b * x1)) / (x3 * x3);

            b = (y2 - a * x2 * x2 - (y1 - a * x1 * x1 - b * x1)) / x2;
            c = y1 - a * x1 * x1 - b * x1;//c = y1 - a * x1 * x1 - b * x1; //c = y1 - a * x1 * x1 - b * x1;
            //a = 1;
            //b = 1;
            //c = 1;


            this.a = a;
            this.b = b;
            this.c = c;
            this.speedXParabel = deltaX / 2000; //s/t soll in 2 Sekunden am Ziel sein
        }

        if (deltaX < 0.01) {
            this.x = this.xDestination;
            this.y = this.yDestination;
        } else {
            if (this.xDestination - this.x > 0) {
                this.x += this.deltaT * this.speedXParabel;

            } else {
                this.x -= this.deltaT * this.speedXParabel;
            }
            this.y = a * this.x * this.x + b * this.x + c;

            System.out.println("x pos: " + this.x + "y pos: " + this.y);
        }


    }

    private void moveDirectToDestination() {
        float deltaX = Math.abs(this.xDestination - this.x);
        float deltaY = Math.abs(this.yDestination - this.y);
        float speedX, speedY;

        if (deltaX < deltaY) {
            // Delta Y ist größer als Delta X
            speedX = this.speedMax * deltaX / deltaY;
            speedY = this.speedMax;

        } else {
            speedX = this.speedMax;
            speedY = this.speedMax * deltaY / deltaX;
        }

        if (deltaY < 2) {
            this.y = this.yDestination;
        } else if (this.yDestination < this.y) {
            this.y -= speedY / 100 * deltaT;
        } else {
            this.y += speedY / 100 * deltaT;
        }

        if (deltaX < 2) {
            this.x = this.xDestination;
        } else if (this.xDestination < this.x) {
            this.x -= speedX / 100 * deltaT;
        } else {
            this.x += speedX / 100 * deltaT;
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        //super.update(gameContainer, delta);
        this.deltaT = (float) delta;
        calculateActualPosition();
    }
}
