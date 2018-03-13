package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeVier extends KIGegner {

    //Konstruktor
    public KIGegnerStaerkeVier(Spielfeld spielfeld, char sign, int farbe)
    {
        super(spielfeld, sign, farbe);
    }

    //Methoden
    public void macheZug() {
        betrachteterSpieler = 2;
        if (kannGewinnen()) {
            spielfeld.wirfSteinEin();
        }
        betrachteterSpieler = 1;

        if (kannGewinnen()) {
            spielfeld.wirfSteinEin();
        }

        else {
            char sign = spielfeld.getCurrentUser();
            spielfeld.setInsertPos(findeBestenZug(spielfeld, 3));
            char signTwo = spielfeld.getCurrentUser();
            if (sign != signTwo) {
                spielfeld.changeUser();
            }
            spielfeld.wirfSteinEin();
        }
    }
}
