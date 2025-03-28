package sk.uniza.fri.paintBot.guiPrikazy;

import sk.uniza.fri.paintBot.Game;

public class NacitajProgram implements Runnable {
    private final Game game;

    public NacitajProgram(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        this.game.nacitajProgram();
    }
}
