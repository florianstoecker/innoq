package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeEins extends KIGegner {
    public void macheZug(Konsole oberflaeche, Spielfeld spielfeld)
    {
        random(spielfeld);
        if(spielfeld.legalerZug(oberflaeche) == true)
        {
            int auswahlSpalte =spielfeld.getInsertPos();
            spielfeld.wirfSteinEin(oberflaeche, spielfeld);
            oberflaeche.kiGelegtText(auswahlSpalte + 1);
        }
        else
        {
            macheZug(oberflaeche, spielfeld);
        }
    }
}
