package at.cc.jku.games.FactoryMethodDesignPattern;

import at.cc.jku.games.FactoryMethodDesignPattern.SoftwareShop.*;


public class Client {
    public static void main(String[] args) {

        SoftwareShop appleShop = new AppleiWorkFactory();
        OfficeProgramm appleTextProgramm = appleShop.holeApp("Textverarbeitung");
        //appleTextProgramm.einpacken(); // eingepackt und
        //appleTextProgramm.etikettieren(); // Etikettiert wird beim Aufruf der Methode holen
        appleTextProgramm.starten(); // Starten kann es dann der Kunde

        SoftwareShop msShop = new MicrosoftOfficeFactory();
        OfficeProgramm calcProgramm = msShop.holeApp("Tabellenkalkulation");
        calcProgramm.starten();

        SoftwareShop sooShop = new SunOpenOfficeFactory();
        OfficeProgramm write =  sooShop.holeApp("Textverarbeitung");
        write.starten();


    }
}
