package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeVier extends KIGegner {

    //Konstruktor
    public KIGegnerStaerkeVier(Spielfeld spielfeld, char sign, int farbe) {
        super(spielfeld, sign, farbe);
    }

    //Methoden
<<<<<<< HEAD
    public void macheZug()
    {
        spielfeld.setInsertPos(findeBestenZug(spielfeld, 3));
        spielfeld.wirfSteinEin();
        return;
=======
    public void macheZug() {
        betrachteterSpieler = 2;
        if (kannGewinnen()) {
            spielfeld.wirfSteinEin();
            return;
        }
        betrachteterSpieler = 1;

        if (kannGewinnen()) {
            spielfeld.wirfSteinEin();
        } else {
            char sign = spielfeld.getCurrentUser();
            spielfeld.setInsertPos(findeBestenZug(spielfeld, 5));
            char signTwo = spielfeld.getCurrentUser();
            if (sign != signTwo) {
                spielfeld.changeUser();
            }
            spielfeld.wirfSteinEin();
        }
>>>>>>> dda3cbf197d366996a21544b08024453f15b7206
    }
}
