package at.cc.jku.games.observerPattern.News;

public class News {
    public static void main(String[] args) {

        NewsAgency newsAgency = new NewsAgency();

        NewsChannel newsChannel1 = new NewsChannel("O3");

        NewsChannel newsChannel2 = new NewsChannel("der Standard");

        newsAgency.addObserver(newsChannel1);
        newsAgency.addObserver(newsChannel2);

        newsAgency.setNews("Hello world!");

        newsAgency.setNews("Zum heutigen Stand (16.5.2020-13:20) sind in Vorarlberg 12 Personen positiv auf das " +
                "Corona Vieruns getestet.");

    }
}
