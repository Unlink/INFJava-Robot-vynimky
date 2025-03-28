package sk.uniza.fri.paintBot.program.prikazy;

import sk.uniza.fri.paintBot.hernySvet.Robot;

public class Vlavo implements Prikaz {
    @Override
    public String getPopis() {
        return "vlavo";
    }

    @Override
    public void vykonaj(Robot robot) {
        robot.otocDolava();
    }
}
