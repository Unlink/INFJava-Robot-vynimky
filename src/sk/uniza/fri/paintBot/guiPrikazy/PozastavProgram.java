package sk.uniza.fri.paintBot.guiPrikazy;

import sk.uniza.fri.paintBot.Game;

public class PozastavProgram implements Runnable {
    private final Game game;

    public PozastavProgram(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        this.game.pozastavProgram();
    }
}
