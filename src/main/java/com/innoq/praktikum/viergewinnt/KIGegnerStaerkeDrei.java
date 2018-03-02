package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeDrei extends KIGegner {
    public void macheZug(Konsole oberflaeche, Spielfeld spielfeld)
    {
        if(kannGewinnen(spielfeld) == true)
        {
            steinWurdeAusgewaehlt(spielfeld, oberflaeche);
            return;
        }

        if(kannGewinnen(spielfeld) == true)
        {

            steinWurdeAusgewaehlt(spielfeld, oberflaeche);
            return;
        }
        spielfeld.wechseln();
        if(zweiGleicheGewinnMöglich(0, spielfeld) == true)
        {
            steinWurdeAusgewaehlt(spielfeld, oberflaeche);
            return;
        }
        if(zweiGleicheGewinnMöglich(0, spielfeld) == true)
        {
            steinWurdeAusgewaehlt(spielfeld, oberflaeche);
            return;
        }

                if(eigenerStein(spielfeld) == true)
                {
                    steinWurdeAusgewaehlt(spielfeld, oberflaeche);
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
