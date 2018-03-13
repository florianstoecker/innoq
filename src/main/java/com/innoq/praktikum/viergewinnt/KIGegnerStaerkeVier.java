package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeVier extends KIGegner {

    //Konstruktor
    public KIGegnerStaerkeVier(Spielfeld spielfeld, char sign, int farbe)
    {
        super(spielfeld, sign, farbe);
    }

    //Methoden
    public void macheZug() {
        char sign = spielfeld.getCurrentUser();
        spielfeld.setInsertPos(findeBestenZug(spielfeld, 3));
        char signTwo = spielfeld.getCurrentUser();
        if(sign != signTwo)
        {
            spielfeld.changeUser();
        }
        spielfeld.wirfSteinEin();
    }
}
