package at.cc.jku.games.actors.Interfaces;

import at.cc.jku.games.actors.Interfaces.Actor;
import org.newdawn.slick.geom.Shape;

public interface CollisionActor extends Actor {
    public Shape getShape();
}
