package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeDrei extends KIGegner {

    //Konstruktor
    public KIGegnerStaerkeDrei(Spielfeld spielfeld, char sign, int farbe) {
        super(spielfeld, sign, farbe);
    }

    //Methoden
    public void macheZug() {

        betrachteterSpieler = 2;
        if (kannGewinnen()) {
            spielfeld.wirfSteinEin();
            return;
        }
        betrachteterSpieler = 1;

        if (kannGewinnen()) {
            spielfeld.wirfSteinEin();
            return;
        }
        betrachteterSpieler = 1;
        if (zweiGleicheGewinnMöglich(0)) {
            spielfeld.wirfSteinEin();
            return;
        }
        betrachteterSpieler = 2;
        if (zweiGleicheGewinnMöglich(0)) {
            spielfeld.wirfSteinEin();
            return;
        }
        if (eigenerStein()) {
            spielfeld.wirfSteinEin();
            return;
        } else {
            random();
            while (!spielfeld.probeEinfügen(spielfeld.getInsertPos())) {
                random();
            }
            spielfeld.wirfSteinEin();
            return;
        }


    }
}
