package sk.uniza.fri.paintBot.gui;

import fri.shapesge.DataObrazku;
import fri.shapesge.Manazer;
import fri.shapesge.Obdlznik;
import fri.shapesge.Obrazok;

public class Tlacidlo {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Obrazok obrazok;
    private final Obdlznik obdlznik;
    private final Runnable action;
    private final Manazer manazer;
    private boolean jeHover;

    public Tlacidlo(int x, int y, String obrazok, Runnable action) {
        this.x = x;
        this.y = y;
        this.action = action;
        var dataObrazku = new DataObrazku(obrazok);
        this.width = dataObrazku.getSirka();
        this.height = dataObrazku.getVyska();

        this.obdlznik = new Obdlznik(x - 1, y - 1);
        this.obdlznik.zmenStrany(this.width+2, this.height+2);
        this.obdlznik.zmenFarbu("#f1c40f");
        this.obrazok = new Obrazok(dataObrazku, x, y);
        this.obrazok.zobraz();

        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);

        this.jeHover = false;
    }

    public void mouseMove(int x, int y) {
        if (jeVRozsahu(x, y) && !this.jeHover) {
            this.obdlznik.zobraz();
            this.obrazok.skry();
            this.obrazok.zobraz();
            this.jeHover = true;
        }
        else if (!jeVRozsahu(x, y) && this.jeHover) {
            this.obdlznik.skry();
            this.jeHover = false;
        }
    }

    private boolean jeVRozsahu(int x, int y) {
        return (x >= this.x && x < this.x + this.width && y >= this.y && y < this.y + this.height);
    }

    /**
     * Posiela manazer
     */
    public void vyberSuradnice(int x, int y) {
        if (jeVRozsahu(x, y)) {
            this.action.run();
        }
    }

    public void skry() {
        this.obrazok.skry();
        this.obdlznik.skry();
        this.manazer.prestanSpravovatObjekt(this);
    }
}
