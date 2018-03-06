package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Konsole oberflaeche = new Konsole();
        Config config = new Config(oberflaeche);
        ZeichneSpielfeld zeichneSpielfeld = new ZeichneSpielfeld();
        Spielfeld spielfeld = new Spielfeld(oberflaeche, config, zeichneSpielfeld);
        int anfänger;
        zeichneSpielfeld.zeichneSpielfeld(spielfeld);
        if(config.getBeginner() == 1);
        {
            anfänger = 1;
        }
        Spieler s1 = new Spieler(spielfeld, 'X', anfänger);
        Spieler s2 = new Spieler(spielfeld, '@', anfänger);
        spielfeld.initFarbfeld();
        s1 = new LokalerSpieler();
        s2 = config.spielerZweiAuswaehlen();

        Spieler s = s1;

        while(spielfeld.gewinn() == false) {
            s.macheZug();
            zeichneSpielfeld.zeichneSpielfeld(spielfeld);
            switch(spielfeld.getAnDerReihe()) {
                case 1: s = s1;
                case 2: s = s2;
            }
        }

        oberflaeche.gewinnText(spielfeld.getAnDerReihe());


        LokalerSpieler spielerEins = new LokalerSpieler();


    }





}
