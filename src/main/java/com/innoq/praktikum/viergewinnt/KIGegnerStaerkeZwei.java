package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeZwei extends KIGegner {
    public KIGegnerStaerkeZwei(Spielfeld spielfeld, char sign, int farbe) {
        super(spielfeld, sign, farbe);
    }

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

        if (eigenerStein()) {
            spielfeld.wirfSteinEin();
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
