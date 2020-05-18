package at.cc.jku.games.FactoryMethodDesignPattern.SoftwareShop;

import at.cc.jku.games.FactoryMethodDesignPattern.SoftwareShop.OfficeProgramm;

public class Word extends OfficeProgramm {

    @Override
    public void starten() {
        System.out.println("Word startet.");
    }
}
