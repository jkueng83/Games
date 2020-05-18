package at.cc.jku.games.FactoryMethodDesignPattern.SoftwareShop;

public class MicrosoftOfficeFactory extends SoftwareShop {
    @Override
    protected OfficeProgramm createOfficeProgram(String zuHolendesProg) {
        OfficeProgramm programm = null;

        if (zuHolendesProg== "Textverarbeitung"){

            programm = new Word();

        }else if (zuHolendesProg == "Tabellenkalkulation"){
            programm = new Excel();
        }else {
            System.out.println("ungültige Eingabe: " + zuHolendesProg);
        }
        return programm;
    }
}
