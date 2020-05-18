package at.cc.jku.games.FactoryMethodDesignPattern.SoftwareShop;

public class SunOpenOfficeFactory extends SoftwareShop {
    @Override
    protected OfficeProgramm createOfficeProgram(String zuHolendesProg) {
        OfficeProgramm programm = null;
        if (zuHolendesProg == "Textverarbeitung"){
            programm = new Write();
        }else if (zuHolendesProg == "Tabellenkalkulation"){
            programm = new Calc();
        }else {
            System.out.println("Kein Programm gefunden");
        }
        return programm;
    }
}
