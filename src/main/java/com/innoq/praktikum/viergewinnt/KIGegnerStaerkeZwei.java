package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeZwei extends KIGegner {
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

        if(eigenerStein() == true)
        {
         steinWurdeAusgewaehlt();
        }

            else
            {
                random();
                while(spielfeld.legalerZug() == false)
                {
                    random();
                }
                int auswahlSpalte = spielfeld.getInsertPos();
                spielfeld.wirfSteinEin();
            }


        }

}
