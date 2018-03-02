package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeDrei extends KIGegner {
    public void macheZug(Konsole oberflaeche, Spielfeld spielfeld)
    {
        int anDerReihe = spielfeld.getAnDerReihe();
        spielfeld.setAnDerReihe(1);
        if(kannGewinnen(spielfeld) == true)
        {
            spielfeld.wechseln();
            steinWurdeAusgewaehlt(spielfeld, oberflaeche);
            return;
        }
        spielfeld.setAnDerReihe(2);
        if(kannGewinnen(spielfeld) == true)
        {
            steinWurdeAusgewaehlt(spielfeld, oberflaeche);
            return;
        }
        spielfeld.wechseln();
        if(zweiGleicheGewinnMöglich(0, spielfeld) == true)
        {
            spielfeld.wechseln();
            steinWurdeAusgewaehlt(spielfeld, oberflaeche);
            return;
        }
        spielfeld.setAnDerReihe(2);
        if(zweiGleicheGewinnMöglich(0, spielfeld) == true)
        {
            steinWurdeAusgewaehlt(spielfeld, oberflaeche);
            return;
        }
        spielfeld.setAnDerReihe(anDerReihe);
            if(eigenerStein(spielfeld) == true)
            {
                steinWurdeAusgewaehlt(spielfeld, oberflaeche);
                return;
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
