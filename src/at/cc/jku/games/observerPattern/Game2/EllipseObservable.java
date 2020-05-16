package at.cc.jku.games.observerPattern.Game2;

import at.cc.jku.games.actors.Interfaces.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

@SuppressWarnings("deprecation")
public class EllipseObservable implements Actor {

    private float x, y;
    private float speed;
    private boolean moveLeft;
    Random random;

    boolean isGameStarted;

    private List<StartStop> startStop;

    //private List<>  ;

    public EllipseObservable(float x, float y, float speed) {
        random = new Random();
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.moveLeft = isMoveLeft();
        this.isGameStarted = true;
        this.startStop = new ArrayList<>();


    }

    public void addStartStop(StartStop startStop) {
        this.startStop.add(startStop);
    }

    public void removeObserver(StartStop startStop) {
        this.startStop.remove(startStop);
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

        graphics.drawString("Press \"p\" to start and stop",100,100);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        if  (this.isGameStarted) {

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

        startStopGame(gameContainer);

    }

    private void startStopGame(GameContainer gameContainer) {

        if (gameContainer.getInput().isKeyPressed(Input.KEY_P)) {
            System.out.println("Pressed key: p");

            if (this.isGameStarted) {
                this.isGameStarted = false;
                System.out.println("Game Stop");
                stopGame();
            } else {
                this.isGameStarted = true;
                System.out.println("Game Start");
                startGame();
            }

        }

    }

    private void startGame(){
        for (StartStop startStop: this.startStop) {
            startStop.start();
        }
    }
    private void stopGame(){
        for (StartStop startStop: this.startStop) {
            startStop.stop();
        }
    }


}
