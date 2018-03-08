package com.innoq.praktikum.viergewinnt;

public class Main {

    //Main-Methode
    public static void main(String[] args) {
        Konsole oberflaeche = new Konsole();
        Config config = new Config(oberflaeche);
        ZeichneSpielfeld zeichneSpielfeld = new ZeichneSpielfeld();
        Spielfeld spielfeld = new Spielfeld(oberflaeche, config, zeichneSpielfeld);
        int anfänger;

        if(config.getBeginner() == 1);
        {
            anfänger = 1;
        }
        spielfeld.setAnDerReihe(config.getBeginner());
        Spieler s1 =  new LokalerSpieler(spielfeld, 'X', anfänger);
        Spieler s2 = config.spielerZweiAuswaehlen(spielfeld, '@', anfänger);

        Spieler s = s1;
        oberflaeche.clear();

        oberflaeche.spielBeginnText();
        zeichneSpielfeld.zeichneSpielfeld(spielfeld);
        do{
            switch(spielfeld.getAnDerReihe()) {
                case 1: s = s1;oberflaeche.macheZugText(spielfeld.getAnDerReihe(),2);break;
                case 2: s = s2; if(config.getAuswahlGegner() == 1){oberflaeche.macheZugText(spielfeld.getAnDerReihe(), 2);}break;
            }
            s.macheZug();
            oberflaeche.gelegtText(spielfeld.getInsertPos() + 1);
            zeichneSpielfeld.zeichneSpielfeld(spielfeld);
        }while(spielfeld.gewinn() == false);

        oberflaeche.gewinnText(spielfeld.getAnDerReihe());
    }
}
