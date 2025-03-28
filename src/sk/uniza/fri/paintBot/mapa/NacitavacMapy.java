package sk.uniza.fri.paintBot.mapa;

import java.util.Scanner;

public class NacitavacMapy {
    private final String nazovMapy;

    public NacitavacMapy(String nazovMapy) {
        this.nazovMapy = nazovMapy;
    }

    //TODO, treba nejako validovať či je format mapy OK
    public PolickoMapy[][] nacitajPolicka() {
        var subor = ClassLoader.getSystemResourceAsStream("hernaPlocha.txt");

        var scanner = new Scanner(subor);
        var rozmer = scanner.nextInt();
        var mapa = new PolickoMapy[rozmer][rozmer];

        for (int i = 0; i < rozmer; i++) {
            for (int j = 0; j < rozmer; j++) {
                mapa[i][j] = nacitajPolicko(scanner);
            }
        }
        scanner.close();
        return mapa;
    }

    private PolickoMapy nacitajPolicko(Scanner scanner) {
        //Policko s cislom je zakladne policko
        if (scanner.hasNextInt()) {
            return new ZakladnePolicko(scanner.nextInt());
        }

        var znak = scanner.next();
        return switch (znak) { //TODO viac typov policok (Srotovnik, Nekonecne znacky)
            case "X" -> new Prekazka();
            case "." -> new ZakladnePolicko();
            default -> null; //TODO môzme vratit null?
        };
    }
}
