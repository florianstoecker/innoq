package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeZwei extends KIGegner {
    public void macheZug(Konsole oberflaeche, Spielfeld spielfeld)
    {
        if(eigenerStein(spielfeld) == true)
        {
         steinWurdeAusgewaehlt(spielfeld,oberflaeche);
        }

            else
            {
                random(spielfeld);
                while(spielfeld.legalerZug(oberflaeche) == false)
                {
                    random(spielfeld);
                }
                int auswahlSpalte = spielfeld.getInsertPos();
                spielfeld.wirfSteinEin(oberflaeche,spielfeld);
                oberflaeche.kiGelegtText(auswahlSpalte + 1);
            }


        }

}
