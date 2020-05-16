package at.cc.jku.games.observerPattern.Game;

import at.cc.jku.games.actors.Interfaces.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

@SuppressWarnings("deprecation")
public class EllipseObserver  implements Actor , Observer {

    private float x, y;
    private float speed;
    private boolean moveLeft;
    Random random;

    boolean isGameStarted ;

    public EllipseObserver(float x, float y, float speed) {
        random = new Random();
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.moveLeft = isMoveLeft();
        this.isGameStarted = true;
    }

    private boolean isMoveLeft() {
        boolean isMoveLeft;
        if (this.moveLeft) {
            isMoveLeft = false;
        } else {
            isMoveLeft = true;
        }
        return isMoveLeft;
    }

    private void setNewStartPosition() {
        this.moveLeft = isMoveLeft();
        if (this.moveLeft) {
            this.x = 600;
        } else {
            this.x = 0;
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, 50, 10);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        if ( this.isGameStarted) {

            this.y += (float) delta / 100.0 * this.speed;
            if (this.y > 600) {
                this.y = 0;
            }

            // X-Position
            if (this.moveLeft) {
                this.x -= (float) delta / 100.0 * this.speed;
                if (this.x < 0) {
                    setNewStartPosition();
                }
            } else {
                this.x += (float) delta / 100.0 * this.speed;
                if (this.x > 600) {
                    setNewStartPosition();
                }
            }
        }

    }

    @Override
    public void update(Observable o, Object arg) {

        /*
        if (this.isGameStarted){
            this.isGameStarted = false;
        } else {
            this.isGameStarted= true;
        }
         */

        if (arg == "start"){
            this.isGameStarted= true;
        } else if (arg == "stop")

        System.out.println("get string form Observable: " + arg);
    }
}
