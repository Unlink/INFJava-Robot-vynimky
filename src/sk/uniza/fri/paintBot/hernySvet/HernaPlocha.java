package sk.uniza.fri.paintBot.hernySvet;

import sk.uniza.fri.paintBot.mapa.PolickoMapy;

public class HernaPlocha {

    //Odsadenie herneho pola od zaciatku platna
    public static final int Odsadenie = 50;

    private final Policko[][] hernePole;

    public HernaPlocha(PolickoMapy[][] hernePole) {
        this.hernePole = new Policko[hernePole.length][hernePole[0].length];
        for (int i = 0; i < hernePole.length; i++) {
            for (int j = 0; j < hernePole[0].length; j++) {
                this.hernePole[i][j] = new Policko(j, i, hernePole[i][j]);
            }
        }
    }

    public int getRozmer() {
        return this.hernePole.length;
    }

    public boolean mozemVstupit(Pozicia pozicia, Robot robot) {
        return this.hernePole[pozicia.getY()][pozicia.getX()].mozemVstupit(robot);
    }

    public boolean skusZobrat(Pozicia pozicia, int pocet) {
        return this.hernePole[pozicia.getY()][pozicia.getX()].skusZobrat(pocet);
    }

    public boolean skusPolozit(Pozicia pozicia, int pocet) {
        return this.hernePole[pozicia.getY()][pozicia.getX()].skusPolozit(pocet);
    }
}
