package com.innoq.praktikum.viergewinnt;

public class Main {

    //Main-Methode
    public static void main(String[] args) {
        Konsole oberflaeche = new Konsole();
        GUI gui = new GUI();
        Config config = new Config(gui);
        ZeichneSpielfeld zeichneSpielfeld = new ZeichneSpielfeld();
        Spielfeld spielfeld = new Spielfeld(oberflaeche, config);
        gui.setSpielfeld(spielfeld);
        gui.setConfig(config);
        boolean weiter = true;
        Spieler s1 = new LokalerSpieler(spielfeld, 'X', config.getAuswahlFarbeEins(), gui);
        Spieler s2 = config.spielerZweiAuswaehlen(spielfeld, '@', config.getAuswahlFarbeZwei(), gui);

        Spieler s = s1;
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
            gui.repaint(spielfeld);
            zeichneSpielfeld.zeichneSpielfeld(spielfeld);
            s.macheZug();
            spielfeld.anzahlZügeHoch();
            if (spielfeld.checkWin()) {
                gui.gewinn(spielfeld.getCurrentUser(), spielfeld.getWinPosition());
                zeichneSpielfeld.zeichneSpielfeld(spielfeld);
                weiter = false;
            } else if (spielfeld.voll()) {
                gui.repaint(spielfeld);
                weiter = false;
            }
        }
    }
}
