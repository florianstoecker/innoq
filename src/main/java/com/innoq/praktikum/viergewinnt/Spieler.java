package com.innoq.praktikum.viergewinnt;

public class Spieler {
    public int fEins;
    public int fZwei;
    public Spielfeld spielfeld;
    public char spielerZeichen;
    public int anfänger;

    //Konstruktor
    public Spieler()
    {

    }
    public Spieler(Spielfeld spielfeld, char spielerZeichen, int anfänger)
    {
        this.spielfeld = spielfeld;
        this.spielerZeichen = spielerZeichen;
        this.anfänger = anfänger;
    }

    //Methoden
    public void macheZug()
    {

    }
}
