package sk.uniza.fri.paintBot.hernySvet;

public class Pozicia {
    private final int x;
    private final int y;

    public Pozicia(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean jePlatna(HernaPlocha hernaPlocha) {
        return x >= 0 && y >= 0 && x < hernaPlocha.getRozmer() && y < hernaPlocha.getRozmer();
    }

    public Pozicia posun(Otocenie otocenie) {
        return switch (otocenie) {
            case DOLE -> new Pozicia(x, y+1);
            case HORE -> new Pozicia(x, y-1);
            case VPRAVO -> new Pozicia(x+1, y);
            case VLAVO -> new Pozicia(x-1, y);
        };
    }
}
