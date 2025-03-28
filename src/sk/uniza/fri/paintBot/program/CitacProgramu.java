package sk.uniza.fri.paintBot.program;
import sk.uniza.fri.paintBot.program.prikazy.Chod;
import sk.uniza.fri.paintBot.program.prikazy.Poloz;
import sk.uniza.fri.paintBot.program.prikazy.Prikaz;
import sk.uniza.fri.paintBot.program.prikazy.Vlavo;
import sk.uniza.fri.paintBot.program.prikazy.Vpravo;
import sk.uniza.fri.paintBot.program.prikazy.Zober;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CitacProgramu {
    private final File subor;
    private final Scanner citac;
    private final Program program;

    public CitacProgramu(File subor) throws IOException {
        this.subor = subor;
        this.citac = new Scanner(this.subor);
        this.program = new Program();
    }

    /**
     * Načíta program zo súboru
     */
    //TODO, čo ak subor nexistuje, čo ak nema dobre parametre?
    public Program nacitaj() {
        while (citac.hasNextLine()) {
            //Príkaz je na riadku
            var riadok = new Scanner(citac.nextLine());
            var prikaz = riadok.next();
            this.program.pridajPrikaz(this.parsujPrikaz(prikaz, riadok));
        }

        return program;
    }

    private Prikaz parsujPrikaz(String prikaz, Scanner parametre) {
        //TODO validacia parametrov príkazov
        return switch (prikaz) {
            case "chod" -> {
                var pocetKrokov = 1;
                if (parametre.hasNextInt()) {
                    pocetKrokov = parametre.nextInt();
                }
                yield new Chod(pocetKrokov);
            }
            case "vpravo" -> new Vpravo();
            case "vlavo" -> new Vlavo();
            case "zober" -> {
                var pocet = 1;
                if (parametre.hasNextInt()) {
                    pocet = parametre.nextInt();
                }
                yield new Zober(pocet);
            }
            case "poloz" -> {
                var pocet = 1;
                if (parametre.hasNextInt()) {
                    pocet = parametre.nextInt();
                }
                yield new Poloz(pocet);
            }
            default -> null; //TODO Mozme takto vratiť null?
        };
    }

}
