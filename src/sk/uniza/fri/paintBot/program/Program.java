package sk.uniza.fri.paintBot.program;

import sk.uniza.fri.paintBot.hernySvet.Robot;
import sk.uniza.fri.paintBot.program.prikazy.Prikaz;

import java.util.ArrayList;
import java.util.Optional;

public class Program {
    private final ArrayList<Prikaz> prikazy;
    private int aktualnyPrikaz;

    public Program() {
        this.prikazy = new ArrayList<>();
        this.aktualnyPrikaz = 0;
    }

    /**
     * Pridá príkaz do programu
     */
    public void pridajPrikaz(Prikaz prikaz) {
        this.prikazy.add(prikaz);
    }

    /**
     * Vykona krok programu a presunie sa na ďalsi
     */
    public void vykonajKrok(Robot robot) {
        //TODO čo ak nemám platný príkaz?
        var prikaz = this.getAktualnyPrikaz();
        //Vykona prikaz
        prikaz.orElseThrow().vykonaj(robot);
        this.aktualnyPrikaz++;
        robot.zobraz();
    }

    /**
     * Vráti príkaz, ktorý ideme vykonávať
     */
    public Optional<Prikaz> getAktualnyPrikaz() {
        if (this.aktualnyPrikaz >= this.prikazy.size()) {
            return Optional.empty();
        }
        return Optional.of(this.prikazy.get(this.aktualnyPrikaz));
    }

    /**
     * Vráti textový náhľad programu
     */
    public String getProgram() {
        var sb = new StringBuilder();
        for (Prikaz prikaz : prikazy) {
            sb.append(prikaz.getPopis()).append("\n");
        }
        return sb.toString();
    }

}
