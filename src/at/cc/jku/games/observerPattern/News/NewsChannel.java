package at.cc.jku.games.observerPattern.News;


public class NewsChannel implements Channel {
    private String chanalName;
    private String news;

    public NewsChannel(String chanalName) {
        this.chanalName = chanalName;
    }

    @Override
    public void update(Object news) {
        this.setNews((String) news);

        System.out.println(this.chanalName + " tells news: \"" + this.news + "\"");

    }

    private void setNews(String news) {
        this.news = news;
    }
}
