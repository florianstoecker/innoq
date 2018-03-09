package com.innoq.praktikum.viergewinnt;

public class Main {

    //Main-Methode
    public static void main(String[] args) {
        Konsole oberflaeche = new Konsole();
        Config config = new Config(oberflaeche);
        ZeichneSpielfeld zeichneSpielfeld = new ZeichneSpielfeld();
        boolean weiter = true;
        Spielfeld spielfeld = new Spielfeld(oberflaeche, config, zeichneSpielfeld);
        int anfänger = 1;

        spielfeld.setAnDerReihe(config.getBeginner());
        Spieler s1 =  new LokalerSpieler(spielfeld, 'X', config.getAuswahlFarbeEins());
        Spieler s2 = config.spielerZweiAuswaehlen(spielfeld, '@', config.getAuswahlFarbeZwei());

        Spieler s = s1;
        oberflaeche.clear();

        oberflaeche.spielBeginnText();
        zeichneSpielfeld.zeichneSpielfeld(spielfeld);
        while(weiter = true && spielfeld.getAnzahlZüge()<=42){
            switch(spielfeld.getAnDerReihe()) {
                case 1: s = s1;oberflaeche.macheZugText(spielfeld.getCurrentUser(),spielfeld.getUserOne());break;
                case 2: s = s2; if(config.getAuswahlGegner() == 1){oberflaeche.macheZugText(spielfeld.getCurrentUser(), spielfeld.getUserTwo());}break;
            }
            s.macheZug();
            oberflaeche.gelegtText(spielfeld.getInsertPos() + 1);
            zeichneSpielfeld.zeichneSpielfeld(spielfeld);
            if(spielfeld.gewinn())
            {
                weiter = false;
            }
        }

        oberflaeche.gewinnText(spielfeld.getAnDerReihe());
        zeichneSpielfeld.zeichneSpielfeld(spielfeld);
    }
}
