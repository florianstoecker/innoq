package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeZwei extends KIGegner {
    public KIGegnerStaerkeZwei(Spielfeld spielfeld, char sign, int farbe)
    {
        super(spielfeld, sign, farbe);
    }
    public void macheZug()
    {
        betrachteterSpieler = 2;

        if (kannGewinnen()) {
            steinWurdeAusgewaehlt();
            return;
        }
        betrachteterSpieler = 1;

        if (kannGewinnen()) {
            steinWurdeAusgewaehlt();
            return;
        }

        if(eigenerStein())
        {
         steinWurdeAusgewaehlt();
        }
            else
            {
                random();
                while(!spielfeld.probeEinfügen(spielfeld.getInsertPos()))
                {
                    random();
                }
                spielfeld.wirfSteinEin();
            }
        }
}
