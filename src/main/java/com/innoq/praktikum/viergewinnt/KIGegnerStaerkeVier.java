package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeVier extends KIGegner {
    public KIGegnerStaerkeVier(Spielfeld spielfeld, char sign, int anfänger)
    {
        super(spielfeld, sign, anfänger);
    }
    public void macheZug()
    {
        betrachteterSpieler = 2;
        if (kannGewinnen() == true) {
            steinWurdeAusgewaehlt();
            return;
        }
        betrachteterSpieler = 1;

        if (kannGewinnen() == true) {
            steinWurdeAusgewaehlt();
            return;
        }
        spielfeld.setInsertPos(findeBestenZug());
        spielfeld.wirfSteinEin();
        return;
    }
}
