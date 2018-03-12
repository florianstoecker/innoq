package com.innoq.praktikum.viergewinnt;

public class Main {

    //Main-Methode
    public static void main(String[] args) {
        Konsole oberflaeche = new Konsole();
        Config config = new Config(oberflaeche);
        ZeichneSpielfeld zeichneSpielfeld = new ZeichneSpielfeld();
        boolean weiter = true;
        Spielfeld spielfeld = new Spielfeld(oberflaeche, config, zeichneSpielfeld);

        spielfeld.setAnDerReihe(config.getBeginner());
        Spieler s1 =  new LokalerSpieler(spielfeld, 'X', config.getAuswahlFarbeEins());
        Spieler s2 = config.spielerZweiAuswaehlen(spielfeld, '@', config.getAuswahlFarbeZwei());

        Spieler s = s1;

        oberflaeche.spielBeginnText();
        zeichneSpielfeld.zeichneSpielfeld(spielfeld);
        while(weiter == true){
            switch(spielfeld.getCurrentUser()) {
                case 'X': s = s1;oberflaeche.macheZugText(spielfeld.getCurrentUser(),spielfeld.getUserOne());break;
                case '@': s = s2; if(config.getAuswahlGegner() == 1){oberflaeche.macheZugText(spielfeld.getCurrentUser(), spielfeld.getUserTwo());}break;
            }
            s.macheZug();
            oberflaeche.gelegtText(spielfeld.getInsertPos() + 1);
            zeichneSpielfeld.zeichneSpielfeld(spielfeld);
            spielfeld.anzZügeHoch();
            if(spielfeld.checkWin())
            {
               oberflaeche.gewinnText(spielfeld.getAnDerReihe());
               zeichneSpielfeld.zeichneSpielfeld(spielfeld);
               weiter = false;
            }
            else if(spielfeld.voll() == true)
            {
                zeichneSpielfeld.zeichneSpielfeld(spielfeld);
                oberflaeche.feldVollText();
                weiter = false;
            }
        }
    }
}
