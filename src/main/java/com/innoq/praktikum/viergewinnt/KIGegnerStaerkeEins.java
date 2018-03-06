package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeEins extends KIGegner {
    public KIGegnerStaerkeEins(Spielfeld spielfeld, char sign, int anfänger)
    {
        super(spielfeld, sign, anfänger);
    }
    public void macheZug()
    {
        random();
        if(spielfeld.legalerZug() == true)
        {
            int auswahlSpalte =spielfeld.getInsertPos();
            spielfeld.wirfSteinEin();
        }
        else
        {
            macheZug();
        }
    }
}
