package com.innoq.praktikum.viergewinnt;

public class Main {

    //Main-Methode
    public static void main(String[] args) {
        Konsole oberflaeche = new Konsole();
        GUI gui = new GUI();
        Config config = new Config(oberflaeche);
        ZeichneSpielfeld zeichneSpielfeld = new ZeichneSpielfeld();
        Spielfeld spielfeld = new Spielfeld(oberflaeche, config);
        boolean weiter = true;
        Spieler s1 = new LokalerSpieler(spielfeld, 'X', config.getAuswahlFarbeEins());
        Spieler s2 = config.spielerZweiAuswaehlen(spielfeld, '@', config.getAuswahlFarbeZwei());

        Spieler s = s1;

        oberflaeche.spielBeginnText();
        gui.fillField(spielfeld);
        zeichneSpielfeld.zeichneSpielfeld(spielfeld);
        while (weiter) {
            switch (spielfeld.getCurrentUser()) {
                case 'X':
                    s = s1;
                    oberflaeche.macheZugText(spielfeld.getCurrentUser(), spielfeld.getUserOne());
                    break;
                case '@':
                    s = s2;
                    if (config.getAuswahlGegner() == 1) {
                        oberflaeche.macheZugText(spielfeld.getCurrentUser(), spielfeld.getUserTwo());
                    }
                    break;
            }
            s.macheZug();
            oberflaeche.gelegtText(spielfeld.getInsertPos() + 1);
            gui.repaint(spielfeld);
            zeichneSpielfeld.zeichneSpielfeld(spielfeld);
            spielfeld.anzahlZügeHoch();
            if (spielfeld.checkWin()) {
                oberflaeche.gewinnText(spielfeld.getCurrentUser(), spielfeld.getWinPosition());
                zeichneSpielfeld.zeichneSpielfeld(spielfeld);
                weiter = false;
            } else if (spielfeld.voll()) {
                zeichneSpielfeld.zeichneSpielfeld(spielfeld);
                oberflaeche.feldVollText();
                weiter = false;
            }
        }
    }
}
