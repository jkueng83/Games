package at.cc.jku.games.observerPattern.Joke;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class AnimalListener implements Observer {
    private String name;
    private ANIMALS animal;

    public AnimalListener(String name, ANIMALS animal) {
        this.name = name;
        this.animal = animal;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.name + " is a " + animal.toString() + " and listnes to the joke: \"" + arg +"\"");

    }
}
