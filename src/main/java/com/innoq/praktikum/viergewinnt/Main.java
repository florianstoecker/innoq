package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Spielfeld spielfeld = new Spielfeld();
        Konsole oberflaeche = new Konsole();

        LokalerSpieler spielerEins = new LokalerSpieler();
        oberflaeche.gegnerAuswahl();
        spielfeld.initFarbfeld();
        Spieler spielerZwei = oberflaeche.spielerZweiAuswaehlen();//Gegner soll ausgewählt werden
        oberflaeche.clear(); // Konsole wird um 10 Einheiten nach oben leer ausgegeben
        oberflaeche.andereAbfragen(spielfeld);
        spielfeld.spiele(oberflaeche, spielerEins, spielerZwei, spielfeld);// Spielfeld wird gezeichnet
    }





}
