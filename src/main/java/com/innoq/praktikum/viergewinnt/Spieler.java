package com.innoq.praktikum.viergewinnt;

public class Spieler {
    public int fEins;
    public int fZwei;
    public Spielfeld spielfeld;
    public char spielerZeichen;
    public int farbe;

    //Konstruktor
    public Spieler() {

    }

    public Spieler(Spielfeld spielfeld, char spielerZeichen, int farbe) {
        this.spielfeld = spielfeld;
        this.spielerZeichen = spielerZeichen;
        this.farbe = farbe;
    }

    //Methoden
    public void macheZug() {

    }
}
