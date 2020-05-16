package at.cc.jku.games.observerPattern.Joke;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class JokeListener implements Observer {
    final private String name;

    public JokeListener(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.name + " lacht über: \"" + arg + "\"");

    }
}
