package sk.uniza.fri.paintBot.hernySvet;

import fri.shapesge.BlokTextu;
import fri.shapesge.Obrazok;
import fri.shapesge.Stvorec;
import fri.shapesge.StylFontu;
import sk.uniza.fri.paintBot.mapa.PolickoMapy;

public class Policko {
    public static final int ROZMER = 25;

    private final PolickoMapy polickoMapy;
    private final Stvorec stvorec;
    private final Stvorec oramovanie;
    private final BlokTextu text;
    private Obrazok obrazok;

    private static final String[] FARBY_POLICOK = {
            "#00FF00",
            "#00DD55",
            "#00BB99",
            "#0099DD",
            "#0077FF",
            "#4455FF",
            "#8822FF",
            "#BB00CC",
            "#DD0033"
    };


    public Policko(int x, int y, PolickoMapy polickoMapy) {
        this.polickoMapy = polickoMapy;

        this.oramovanie = new Stvorec(x*ROZMER, y*ROZMER + HernaPlocha.Odsadenie);
        this.oramovanie.zmenFarbu("#bdc3c7");
        this.oramovanie.zmenStranu(ROZMER);
        this.oramovanie.zobraz();

        this.stvorec = new Stvorec(x*ROZMER + 1, y*ROZMER + 1 + HernaPlocha.Odsadenie);
        this.stvorec.zmenFarbu("white");
        this.stvorec.zmenStranu(ROZMER -1);
        this.stvorec.zobraz();

        //Vykreslenie roznych typov policok
        if (this.polickoMapy.getTextura() != null) {
            this.obrazok = new Obrazok(this.polickoMapy.getTextura());
            this.obrazok.zmenPolohu(x*ROZMER, y*ROZMER + HernaPlocha.Odsadenie);
            this.obrazok.zobraz();
        }

        this.text = new BlokTextu("", x*ROZMER + 9, y*ROZMER + 18 + HernaPlocha.Odsadenie);
        this.text.zmenFont("Serif", StylFontu.BOLD, 15);
        this.text.zobraz();
        this.aktualizujZobrazenie();
    }

    public boolean mozemVstupit(Robot robot) {
        return this.polickoMapy.mozemVstupit(robot);
    }

    public boolean skusZobrat(int pocet) {
        if (this.polickoMapy.skusZobrat(pocet)) {
            this.aktualizujZobrazenie();
            return true;
        }
        return false;
    }

    public boolean skusPolozit(int pocet) {
        if (this.polickoMapy.skusPolozit(pocet)) {
            this.aktualizujZobrazenie();
            return true;
        }
        return false;
    }

    private void aktualizujZobrazenie() {
        int pocetZnaciek = this.polickoMapy.getPocetZnaciek();
        if (pocetZnaciek > 0) {
            this.text.zmenText(pocetZnaciek + "");
            if (pocetZnaciek < 10) {
                this.stvorec.zmenFarbu(FARBY_POLICOK[pocetZnaciek -1]);
            }
            else {
                this.stvorec.zmenFarbu("red");
            }
        }
        else {
            this.text.zmenText("");
            this.stvorec.zmenFarbu("white");
        }
    }
}
