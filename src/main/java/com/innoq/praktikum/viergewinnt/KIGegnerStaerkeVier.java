package com.innoq.praktikum.viergewinnt;

public class KIGegnerStaerkeVier extends KIGegner {
    public void macheZug(Konsole oberflaeche, Spielfeld spielfeld)
    {
        spielfeld.setInsertPos(findeBestenZug());
        steinWurdeAusgewaehlt();
        return;
    }
}
