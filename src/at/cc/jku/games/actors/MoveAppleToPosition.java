package at.cc.jku.games.actors;

import org.newdawn.slick.SlickException;

public class MoveAppleToPosition extends MoveObjectToPosition {

    public MoveAppleToPosition(float xStart, float xDestination, float yStart, float yDestination, float speedMax,
                               float objectWith, float objectHeight , MOVETYPE moveType) throws SlickException {
        super(xStart, xDestination, yStart, yDestination, speedMax, objectWith, objectHeight,
                "src/at/cc/jku/games/actors/pictures/AppleTheOriginal.png", moveType);
    }
}
