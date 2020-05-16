package at.cc.jku.games.observerPattern.Joke;

import at.cc.jku.games.actors.Png.ObjectPngPosition;
import at.cc.jku.games.observerPattern.Joke.ANIMALS;
import at.cc.jku.games.observerPattern.Joke.AnimalListener;
import at.cc.jku.games.observerPattern.Joke.JokeListener;
import at.cc.jku.games.observerPattern.Joke.JokeTeller;

import java.util.Observer;

public class MainObserverPattern {
    public static void main(String[] args) {

        printTitle();

        Observer achim = new JokeListener("Achmi");
        Observer michael = new JokeListener("Michael");
        JokeTeller chris = new JokeTeller();

        chris.addObserver(achim);
        chris.tellJoke();
        chris.tellJoke();

        chris.addObserver(michael);
        chris.tellJoke();


        System.out.println(ANIMALS.DOG.toString());
        System.out.println(ANIMALS.CAT.toString());
        System.out.println(ANIMALS.DUCK.toString());
        System.out.println(ANIMALS.COW.toString());

        Observer klaus = new AnimalListener("Klaus" , ANIMALS.COW);
        chris.addObserver(klaus);

        AnimalListener franz = new AnimalListener("Franz", ANIMALS.CAT);
        chris.addObserver(franz);



        chris.tellJoke();



    }

    private static void printTitle() {
        String string = "#### observer pattern ####";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < string.length(); j++) {
                if (i % 2 == 0) {
                    System.out.print("#");
                } else {
                    System.out.print(string);
                    break;
                }
            }
            System.out.println();
        }
    }
}
