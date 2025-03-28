package sk.uniza.fri.paintBot.mapa;

import sk.uniza.fri.paintBot.hernySvet.Robot;

public class ZakladnePolicko implements PolickoMapy {

    private int pocetZnaciek;

    public ZakladnePolicko() {
        this(0);
    }

    public ZakladnePolicko(int pocetZnaciek) {
        this.pocetZnaciek = pocetZnaciek;
    }

    @Override
    public boolean mozemVstupit(Robot robot) {
        return true; //Na toto policko sa da vzdy
    }

    @Override
    public int getPocetZnaciek() {
        return this.pocetZnaciek;
    }

    @Override
    public String getTextura() {
        return null;
    }

    @Override
    public boolean skusZobrat(int pocet) {
        //TODO nemali by sme nejako osetrit, že ak zadam zaporny pocet
        if (pocet <= this.pocetZnaciek) {
            this.pocetZnaciek -= pocet;
            return true;
        }
        return false;
    }

    @Override
    public boolean skusPolozit(int pocet) {
        //TODO co ak by som chcel limitovat pocet znaciek na policku?
        this.pocetZnaciek += pocet;
        return true;
    }
}
