package sk.uniza.fri.paintBot.program.prikazy;

import sk.uniza.fri.paintBot.hernySvet.Robot;

public class Poloz implements Prikaz {
    private final int pocet;

    public Poloz(int pocet) {
        this.pocet = pocet;
    }

    @Override
    public String getPopis() {
        return "poloz " + this.pocet;
    }

    @Override
    public void vykonaj(Robot robot) {
        robot.poloz(this.pocet);
    }
}
