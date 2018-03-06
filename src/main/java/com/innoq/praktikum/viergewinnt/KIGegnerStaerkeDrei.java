package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeDrei extends KIGegner {
    public KIGegnerStaerkeDrei(Spielfeld spielfeld, char sign, int anfänger)
    {
        super(spielfeld, sign, anfänger);
    }
    public void macheZug(Konsole oberflaeche, Spielfeld spielfeld) {

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
        betrachteterSpieler = 1;
        if (zweiGleicheGewinnMöglich(0 )== true) {
            steinWurdeAusgewaehlt();
            return;
        }
        betrachteterSpieler = 2;
        if (zweiGleicheGewinnMöglich(0) == true) {
            steinWurdeAusgewaehlt();
            return;
        }
        if (eigenerStein() == true) {
            steinWurdeAusgewaehlt();
            return;
        } else {
            random();
            while (spielfeld.legalerZug() == false) {
                random();
            }
            int auswahlSpalte = spielfeld.getInsertPos();
            spielfeld.wirfSteinEin();
            oberflaeche.kiGelegtText(auswahlSpalte + 1);
        }


    }
}
