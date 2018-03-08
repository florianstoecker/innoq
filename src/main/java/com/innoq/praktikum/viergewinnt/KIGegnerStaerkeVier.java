package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeVier extends KIGegner {

    //Konstruktor
    public KIGegnerStaerkeVier(Spielfeld spielfeld, char sign, int anfänger)
    {
        super(spielfeld, sign, anfänger);
    }

    //Methoden
    public void macheZug()
    {
        spielfeld.setInsertPos(findeBestenZug(spielfeld, 5));
        spielfeld.wirfSteinEin();
        return;
    }
}
