package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeVier extends KIGegner {
    public KIGegnerStaerkeVier(Spielfeld spielfeld, char sign, int anfänger)
    {
        super(spielfeld, sign, anfänger);
    }
    public void macheZug()
    {
        spielfeld.setInsertPos(findeBestenZug());
        spielfeld.wirfSteinEin();
        return;
    }
}
