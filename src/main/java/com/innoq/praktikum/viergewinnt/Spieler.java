package com.innoq.praktikum.viergewinnt;

public class Spieler {
    public static int fEins;
    public static int fZwei;
    public Spielfeld spielfeld;
    public char spielerZeichen;
    public int anfänger;

    public Spieler()
    {}

    public Spieler(Spielfeld spielfeld, char spielerZeichen, int anfänger)
    {
        this.spielfeld = spielfeld;
        this.spielerZeichen = spielerZeichen;
        this.anfänger = anfänger;
    }
    public void macheZug()
    {

    }
}
