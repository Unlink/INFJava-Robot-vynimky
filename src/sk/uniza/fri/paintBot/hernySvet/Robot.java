package sk.uniza.fri.paintBot.hernySvet;

import fri.shapesge.Obrazok;

public class Robot {

    private Pozicia pozicia;
    private final HernaPlocha hernaPlocha;
    private Otocenie otocenie;
    private final Obrazok obrazok;
    private int pocetZnaciek;

    public Robot(Pozicia pozicia, HernaPlocha hernaPlocha) {
        this.pozicia = pozicia;
        this.hernaPlocha = hernaPlocha;
        this.otocenie = Otocenie.VPRAVO;
        this.pocetZnaciek = 0;

        this.obrazok = new Obrazok("robot.png");
        this.zobraz();
        this.obrazok.zobraz();
    }

    public void otocDolava() {
        this.otocenie = this.otocenie.dolava();
    }

    public void otocVpravo() {
        this.otocenie = this.otocenie.doprava();
    }

    public boolean chod() {
        var novaPozicia = pozicia.posun(this.otocenie);
        if (novaPozicia.jePlatna(this.hernaPlocha) && this.hernaPlocha.mozemVstupit(novaPozicia, this)) {
            this.pozicia = novaPozicia;
            return true;
        }
        return false;
    }

    public boolean zober(int pocet) {
        if (this.hernaPlocha.skusZobrat(this.pozicia, pocet)) {
            //TODO pridat limit na pocet znaciek
            this.pocetZnaciek += pocet;
            return true;
        }
        return false;
    }

    public boolean poloz(int pocet) {
        if (this.hernaPlocha.skusPolozit(this.pozicia, pocet)) {
            this.pocetZnaciek -= pocet;
            return true;
        }
        return true;
    }

    public Pozicia getPozicia() {
        return pozicia;
    }

    public Otocenie getOtocenie() {
        return otocenie;
    }

    public void zobraz() {
        this.obrazok.zmenPolohu(pozicia.getX() * Policko.ROZMER, pozicia.getY() * Policko.ROZMER + HernaPlocha.Odsadenie);
        this.obrazok.zmenUhol(otocenie.getUhol());
    }

    public String getInfo() {
        return String.format("Aktualna pozicia %d, %d\npocet znaciek: %d", this.pozicia.getX(), this.pozicia.getY(), this.pocetZnaciek);
    }
}
