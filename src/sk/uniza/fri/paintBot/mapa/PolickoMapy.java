package sk.uniza.fri.paintBot.mapa;

import sk.uniza.fri.paintBot.hernySvet.Robot;

public interface PolickoMapy {
    boolean mozemVstupit(Robot robot);

    /**
     * Vráti počet značiek na danim poličku
     * @return
     */
    int getPocetZnaciek();

    String getTextura();

    boolean skusZobrat(int pocet);

    boolean skusPolozit(int pocet);
}
