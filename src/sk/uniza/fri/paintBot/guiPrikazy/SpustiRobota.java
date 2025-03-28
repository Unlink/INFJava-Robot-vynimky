package sk.uniza.fri.paintBot.guiPrikazy;

import sk.uniza.fri.paintBot.Game;

public class SpustiRobota implements Runnable {
    private final Game game;

    public SpustiRobota(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        this.game.spustiRobota();
    }
}
