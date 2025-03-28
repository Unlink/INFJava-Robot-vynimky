package sk.uniza.fri.paintBot.program.prikazy;

import sk.uniza.fri.paintBot.hernySvet.Robot;

public interface Prikaz {
    String getPopis();

    /**
     * Vykoná príkaz, vrati true, ak je prikaz dokonceny
     *
     * @param robot
     */
    void vykonaj(Robot robot);
}
