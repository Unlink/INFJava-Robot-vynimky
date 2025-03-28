package sk.uniza.fri.paintBot.program.prikazy;

import sk.uniza.fri.paintBot.hernySvet.Robot;

public class Chod implements Prikaz {

    private final int pocetKrokov;

    public Chod(int pocetKrokov) {
        this.pocetKrokov = pocetKrokov;
    }

    @Override
    public String getPopis() {
        return "chod " + pocetKrokov;
    }

    @Override
    public void vykonaj(Robot robot) {
        for (int i = 0; i < pocetKrokov; i++) {
            robot.chod(); //TODO, co ak sa neda ist? Zatial len cakam asi by som nemal
        }
    }
}
