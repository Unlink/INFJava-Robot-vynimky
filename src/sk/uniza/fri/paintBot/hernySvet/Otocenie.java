package sk.uniza.fri.paintBot.hernySvet;

public enum Otocenie {
    HORE,
    VPRAVO,
    DOLE,
    VLAVO;

    public Otocenie doprava() {
        return Otocenie.values()[((this.ordinal()+1) % Otocenie.values().length)];
    }

    public Otocenie dolava() {
        return this.doprava().doprava().doprava(); // :D
    }

    public int getUhol() {
        return switch (this) {
            case DOLE -> 0;
            case HORE -> 180;
            case VLAVO -> 90;
            case VPRAVO -> 270;
        };
    }
}
