package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class LokalerSpieler extends Spieler {
    Scanner scan = new Scanner(System.in);
    private int anzZugEinz;

    //Konstruktor
    public LokalerSpieler(Spielfeld spielfeld, char sign, int farbe)
    {
      super(spielfeld, sign, farbe);
      anzZugEinz = 0;
    }
    //Methoden
    public void macheZug() {
        int spaltenAuswahl;
        spaltenAuswahl = scan.nextInt() - 1;
        if (spaltenAuswahl >= 0 && spaltenAuswahl < 7) {
            spielfeld.setInsertPos(spaltenAuswahl);
            if (spielfeld.probeEinfügen(spaltenAuswahl) == true) {
                spielfeld.setInsertPos(spaltenAuswahl);
                spielfeld.wirfSteinEin();
            } else {
                macheZug();
            }
            anzZugEinz++;
        }
        else
        {
            macheZug();
        }
    }

}
