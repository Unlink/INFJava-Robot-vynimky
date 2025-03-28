package sk.uniza.fri.paintBot;

import fri.shapesge.BlokTextu;
import fri.shapesge.Manazer;
import fri.shapesge.StylFontu;
import sk.uniza.fri.paintBot.guiPrikazy.NacitajProgram;
import sk.uniza.fri.paintBot.guiPrikazy.PozastavProgram;
import sk.uniza.fri.paintBot.guiPrikazy.SpustiRobota;
import sk.uniza.fri.paintBot.program.CitacProgramu;
import sk.uniza.fri.paintBot.hernySvet.Pozicia;
import sk.uniza.fri.paintBot.program.Program;
import sk.uniza.fri.paintBot.hernySvet.Robot;
import sk.uniza.fri.paintBot.hernySvet.HernaPlocha;
import sk.uniza.fri.paintBot.mapa.NacitavacMapy;
import sk.uniza.fri.paintBot.gui.Tlacidlo;

import javax.swing.JOptionPane;
import java.nio.file.Paths;

public class Game {

    private final Robot robot;
    private final HernaPlocha hernaPlocha;
    private Tlacidlo tlacidlo;
    private BlokTextu blokTextu;
    private Program program;
    private final Manazer manazer;
    private final BlokTextu robotInfo;

    public Game() {
        var nacitavacMapy = new NacitavacMapy("hernaPlocha.txt");
        var mapa = nacitavacMapy.nacitajPolicka();
        this.hernaPlocha = new HernaPlocha(mapa);
        this.robot = new Robot(new Pozicia(2, 1), this.hernaPlocha);
        this.program = null;
        this.manazer = new Manazer();
        this.blokTextu = new BlokTextu("", 50, 20);
        this.blokTextu.zmenFont("Serif", StylFontu.PLAIN,16);
        this.blokTextu.zobraz();
        this.robotInfo = new BlokTextu("", 400, 20);
        this.robotInfo.zobraz();
    }

    /**
     * Spustí program
     */
    public void run() {
        this.tlacidlo = new Tlacidlo(2, 2, "nacitaj.png", new NacitajProgram(this));
    }

    /**
     * Vykona sa po stlaceni tlacidla "nacitaj program"
     */
    public void nacitajProgram() {
        try {
            var programFile = JOptionPane.showInputDialog("Zadaj nazov programu", "program1.txt");
            var citacProgramu = new CitacProgramu(Paths.get("programy", programFile).toFile());

            this.program = citacProgramu.nacitaj();
            this.tlacidlo.skry();
            this.tlacidlo = new Tlacidlo(2, 2, "spusti.png", new SpustiRobota(this));

            JOptionPane.showMessageDialog(null,
                    program.getProgram(),
                    "Program",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex) {
            //TODO čo s týmto? aby mi to išlo skompilovať tak sme tu dali try catch, ale je to spravne?
            ex.printStackTrace();
        }
    }

    /**
     * Spusti nacitany program
     */
    public void spustiRobota() {
        this.tlacidlo.skry();
        this.tlacidlo = new Tlacidlo(5, 5, "pause.png", new PozastavProgram(this));
        this.manazer.spravujObjekt(this);
    }

    /**
     * Metóda, ktorú volá manazer na simuláciu spustania robota
     */
    public void krokProgramu() {
        //Vykoname krok
        this.program.vykonajKrok(this.robot);

        //Skontrolujeme ci mame dalsi prikaz
        var dalsiPrikaz = this.program.getAktualnyPrikaz();

        //Ak uz nemame prikaz, tak sme skoncili
        if (dalsiPrikaz.isEmpty()) {
            this.blokTextu.zmenText("");
            this.manazer.prestanSpravovatObjekt(this);
            this.tlacidlo.skry();
            this.run(); //inicializuje tlacidlo na nacitanie programu
        }
        else {
            //Vykonacame jeden krok robota
            this.blokTextu.zmenText("Dalsi prikaz prikaz: " + dalsiPrikaz.get().getPopis());
            this.robot.zobraz();
        }
        this.robotInfo.zmenText(this.robot.getInfo());
    }

    public void pozastavProgram() {
        this.tlacidlo.skry();
        this.tlacidlo = new Tlacidlo(5, 5, "run.png", new SpustiRobota(this));
        this.manazer.prestanSpravovatObjekt(this);
    }

}
