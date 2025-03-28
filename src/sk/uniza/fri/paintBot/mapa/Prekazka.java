package sk.uniza.fri.paintBot.mapa;

import sk.uniza.fri.paintBot.hernySvet.Robot;

public class Prekazka implements PolickoMapy {

    @Override
    public boolean mozemVstupit(Robot robot) {
        //Na prekazku sa nikdy neda vstupit
        return false;
    }

    @Override
    public int getPocetZnaciek() {
        return 0;
    }

    @Override
    public String getTextura() {
        return "crate.png";
    }

    @Override
    public boolean skusZobrat(int pocet) {
        //TODO prečo je tato metoda prazdna? nieje to problém?
        return false;
    }

    @Override
    public boolean skusPolozit(int pocet) {
        //TODO prečo je tato metoda prazdna? nieje to problém?
        return false;
    }
}
