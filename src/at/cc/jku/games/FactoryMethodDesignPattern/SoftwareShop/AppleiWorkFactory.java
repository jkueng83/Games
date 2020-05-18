package at.cc.jku.games.FactoryMethodDesignPattern.SoftwareShop;

import at.cc.jku.games.FactoryMethodDesignPattern.SoftwareShop.OfficeProgramm;
import at.cc.jku.games.FactoryMethodDesignPattern.SoftwareShop.SoftwareShop;

public class AppleiWorkFactory extends SoftwareShop {
    @Override
    protected OfficeProgramm createOfficeProgram(String zuHolendesProg) {
        OfficeProgramm programm = null;

        if(zuHolendesProg == "Textverarbeitung"){
            programm = new Pages();
        }else if (zuHolendesProg == "Tabellenkalkulation"){
            programm = new Numbers();
        }else {
            System.out.println("Programm gibt es nicht.");
        }
        return programm;
    }
}
