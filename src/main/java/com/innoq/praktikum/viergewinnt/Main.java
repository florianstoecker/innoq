package com.innoq.praktikum.viergewinnt;

public class Main {

    public static void main(String[] args) {
        Konsole oberflaeche = new Konsole();
        Config config = new Config(oberflaeche);
        ZeichneSpielfeld zeichneSpielfeld = new ZeichneSpielfeld();
        Spielfeld spielfeld = new Spielfeld(oberflaeche, config, zeichneSpielfeld);
        int anfänger;
        zeichneSpielfeld.zeichneSpielfeld(spielfeld);
        if(config.getBeginner() == 1);
        {
            anfänger = 1;
        }
        spielfeld.initFarbfeld();
        spielfeld.setAnDerReihe(config.getBeginner());
        Spieler s1 =  new LokalerSpieler(spielfeld, 'X', anfänger);
        Spieler s2 = config.spielerZweiAuswaehlen(spielfeld, '@', anfänger);

        Spieler s = s1;

         do{
            switch(spielfeld.getAnDerReihe()) {
                case 1: s = s1;break;
                case 2: s = s2;break;
            }
            s.macheZug();
            zeichneSpielfeld.zeichneSpielfeld(spielfeld);
        }while(spielfeld.gewinn() == false);

        oberflaeche.gewinnText(spielfeld.getAnDerReihe());
    }





}
