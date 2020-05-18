package at.cc.jku.games.FactoryMethodDesignPattern.SoftwareShop;

public abstract class OfficeProgramm {
    public void einpacken() {
        System.out.println("Methode Einpacken");
    }
    public void etikettieren() {
        System.out.println("Methode Etikettieren");
    }
    public abstract void starten();
}
