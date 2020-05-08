package at.cc.jku.games.actors.movements;

public class MoveParable implements MoveStrategy {

    // noch nicht fertig, Formelumwandlung muss noch gemacht werden.

    private float x, y;

    protected float xStart, yStart, yHeight, xDestination, deltaT, speedXParable;

    private float a, b, c, x1, y1, x2, y2, x3, y3;



    public MoveParable(float xStart, float yStart, float yHeight, float xDestination,
                       float speedXParable, float x1, float y1, float x2, float y2,
                       float x3, float y3, boolean calculationDone) {
        this.x = xStart;
        this.y = yStart;
        this.xStart = xStart;
        this.yStart = yStart;
        this.yHeight = yHeight;
        this.xDestination = xDestination;
        if (xStart < xDestination) {
            this.speedXParable = Math.abs(speedXParable);
        } else {
            this.speedXParable = -Math.abs(speedXParable);
        }


        this.x1 = xStart;
        this.y1 = yStart;
        this.x2 = (xStart + xDestination) / 2;
        this.y2 = yHeight;
        this.x3 = xDestination;
        this.y3 = yStart;

        //calculateConstants();

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
        this.deltaT = (float) delta;
        //moveParableToDestination();

    }

    /*
    private void calculateConstants (){
        // Konstanten berechnern

        // Formeln umwandlen

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
        // a =

        float a, b, c;
        float x1 = this.x1;
        float y1 = this.y1;
        float x2 = this.x2;
        float y2 = this.y2;
        float x3 = this.x3;
        float y3 = this.y3;

            a = (y3 - ((y2 - a * x2 * x2 - (y1 - a * x1 * x1 - b * x1)) / x2) * x3 - (y1 - a * x1 * x1 - b * x1)) / (x3 * x3);

            b = (y2 - a * x2 * x2 - (y1 - a * x1 * x1 - b * x1)) / x2;
            c = y1 - a * x1 * x1 - b * x1;//c = y1 - a * x1 * x1 - b * x1; //c = y1 - a * x1 * x1 - b * x1;



            this.a = a;
            this.b = b;
            this.c = c;




    }

    private void moveParableToDestination() {
        // funktioniert nich so gut da die Punkte der Parabel für die Berechnung der Konstanten nicht stimmt.
        float a, b, c;

        a = this.a;
        b = this.b;
        c = this.c;

        float deltaX = Math.abs(this.xDestination - this.x);

        if (deltaX < 0.01) {
            this.x = this.xStart;

        } else {
            if (this.xDestination - this.x > 0) {
                this.x += this.deltaT * this.speedXParable;

            } else {
                this.x -= this.deltaT * this.speedXParable;
            }
            this.y = a * this.x * this.x + b * this.x + c;

            System.out.println("x pos: " + this.x + "y pos: " + this.y);
        }


    }

     */

}
