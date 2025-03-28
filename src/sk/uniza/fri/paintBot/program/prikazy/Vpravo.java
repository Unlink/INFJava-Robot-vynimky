package sk.uniza.fri.paintBot.program.prikazy;

import sk.uniza.fri.paintBot.hernySvet.Robot;

public class Vpravo implements Prikaz {
    @Override
    public String getPopis() {
        return "vpravo";
    }

    @Override
    public void vykonaj(Robot robot) {
        robot.otocVpravo();
    }
}
