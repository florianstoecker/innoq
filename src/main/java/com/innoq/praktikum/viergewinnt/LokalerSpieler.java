package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class LokalerSpieler extends Spieler {
    Scanner scan = new Scanner(System.in);
    private int anzZugEinz;
    public LokalerSpieler(Spielfeld spielfeld, char sign, int anfänger)
    {
      super(spielfeld, sign, anfänger);
      anzZugEinz = 0;
    }
    public void macheZug()
    {
        int anDerReihe = spielfeld.getAnDerReihe();
        int spaltenAuswahl;
        spaltenAuswahl = scan.nextInt() - 1;
        spielfeld.setInsertPos(spaltenAuswahl);
        if(spielfeld.legalerZug() == true)
        {
            spielfeld.setInsertPos(spaltenAuswahl);
            spielfeld.wirfSteinEin();
        }
            else
            {
                macheZug();
            }
            anzZugEinz ++;
    }
    public int getAnzZugEinz()
    {return anzZugEinz;}
}
