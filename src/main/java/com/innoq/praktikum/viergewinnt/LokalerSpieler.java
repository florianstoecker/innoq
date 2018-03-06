package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class LokalerSpieler extends Spieler {
    Scanner scan = new Scanner(System.in);
    public LokalerSpieler(Spielfeld spielfeld, char sign, int anfänger)
    {
      super(spielfeld, sign, anfänger);
    }
    public void macheZug()
    {
        int spaltenAuswahl;
        spaltenAuswahl = scan.nextInt()-1;

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
    }
}
