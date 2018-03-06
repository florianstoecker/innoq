package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeEins extends KIGegner {
    public void macheZug(Konsole oberflaeche, Spielfeld spielfeld)
    {
        random();
        if(spielfeld.legalerZug() == true)
        {
            int auswahlSpalte =spielfeld.getInsertPos();
            spielfeld.wirfSteinEin();
            oberflaeche.kiGelegtText(auswahlSpalte + 1);
        }
        else
        {
            macheZug(oberflaeche, spielfeld);
        }
    }
}
