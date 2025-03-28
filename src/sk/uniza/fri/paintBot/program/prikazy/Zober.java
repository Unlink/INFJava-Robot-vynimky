package sk.uniza.fri.paintBot.program.prikazy;

import sk.uniza.fri.paintBot.hernySvet.Robot;

public class Zober implements Prikaz {
    private final int pocet;

    public Zober(int pocet) {
        this.pocet = pocet;
    }

    @Override
    public String getPopis() {
        return "zober " + this.pocet;
    }

    @Override
    public void vykonaj(Robot robot) {
        robot.zober(this.pocet);
    }
}
