package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeEins extends KIGegner {
    public KIGegnerStaerkeEins(Spielfeld spielfeld, char sign, int farbe) {
        super(spielfeld, sign, farbe);
    }

    public void macheZug() {
        random();
        if (spielfeld.probeEinfügen(spielfeld.getInsertPos())) {
            spielfeld.wirfSteinEin();
        } else {
            macheZug();
        }
    }
}
