package com.innoq.praktikum.viergewinnt;

public class LokalerSpieler extends Spieler {
    public void macheZug(Konsole oberflaeche, Spielfeld spielfeld)
    {
        int spaltenAuswahl;
        spaltenAuswahl= oberflaeche.macheZugText(spielfeld);
        spielfeld.setInsertPos(spaltenAuswahl);
        if(spielfeld.legalerZug(oberflaeche) == true)
        {
            spielfeld.setInsertPos(spaltenAuswahl);
            spielfeld.wirfSteinEin(oberflaeche, spielfeld);
        }
            else
            {
                macheZug(oberflaeche, spielfeld);
            }
    }
}
