package com.innoq.praktikum.viergewinnt;

public class Konsole {

    private static final String BLACK_BOLD = "\033[1;30m";
    private static final String COLOR_RESET = "\u001B[0m";

    //Konstruktor
    public Konsole() {

    }

    //Methoden
    // Ausgabetexte
    public void gewonnen(int amZug) {
        System.out.println(BLACK_BOLD + "Der Gewinner ist Spieler " + amZug);
        System.out.println("Das Spiel ist vorbei !" + COLOR_RESET);
    }

    public void clear() {
        for (int i = 0; i < 10; i++)    // Konsole um 10 Einheiten leer ausgeben
        {
            System.out.println("\n");
        }
    }

    public void nochmalText() {
        System.out.println(BLACK_BOLD + "Möchten Sie noch einmal spielen ?");
        System.out.println("1: Ja!");
        System.out.println("2: Nein!" + COLOR_RESET);
    }

    public void gelegtText(int spaltenauswahl) {
        clear();
        System.out.println("Gewählt wurde" + BLACK_BOLD + " Spalte " + spaltenauswahl + COLOR_RESET);

    }

    public void feldVollText() {
        System.out.println(BLACK_BOLD + "Das Feld ist voll!" + COLOR_RESET);
    }

    public void spalteVollText(int spalte) {
        System.out.println(BLACK_BOLD + "Spalte " + spalte + 1 + " ist voll!" + COLOR_RESET);
    }

    public void macheZugText(char currentUser, int anzZugEinz) {
        int spieler;
        if (currentUser == '@') {
            spieler = 2;
        } else {
            spieler = 1;
        }
        System.out.println(BLACK_BOLD + "In welcher Spalte wollen Sie Ihren " + anzZugEinz + ". Stein fallen lassen ? (Spieler " + spieler + ")" + COLOR_RESET);

    }



    public void gewinnText(char currentUser, String winPosition) {
        int spieler;
        if (currentUser == '@') {
            spieler = 1;
        } else {
            spieler = 2;
        }
        Animation.an_Gewinn();
        System.out.println(BLACK_BOLD + "Der Gewinner ist Spieler " + spieler + "!");
        System.out.println("Gewonnen wurde " + winPosition);
        System.out.println("Das Spiel ist zu Ende!" + COLOR_RESET);
    }
}
