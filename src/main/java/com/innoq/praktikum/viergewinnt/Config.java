package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class Config {

    private static int auswahlGegner;
    private static int beginner;
    private static int auswahlFarbeZwei;
    private static int auswahlFarbeEins;
    private Konsole oberflaeche;
    private GUI gui;
    public static Scanner scan = new Scanner(System.in);

    //Konstruktor
    public Config(Konsole oberflaeche) {
        this.oberflaeche = oberflaeche;
        // gui.gegnerAuswahlText();
        auswahlGegner = gegnerAuswahl();
        andereAbfragen();

    }

    //Methoden
    public int gegnerAuswahl() { // Menü - Gegnerauswahl

        oberflaeche.gegnerAuswahlText();
        auswahlGegner = scan.nextInt();
        if (auswahlGegner != 2 && auswahlGegner != 1) {
            oberflaeche.clear();
            oberflaeche.falscheEingabeText();
            return gegnerAuswahl();
        }
        oberflaeche.clear();
        return auswahlGegner;
    }

    public void auswahlBeginn() {
        oberflaeche.clear();
        oberflaeche.auswahlBeginnText();
        beginner = scan.nextInt();
        if (beginner != 2 && beginner != 1) {
            oberflaeche.clear();
            oberflaeche.falscheEingabeText();
            auswahlBeginn();
            oberflaeche.clear();
            return;
        }
        oberflaeche.clear();
    }

    public void farbeAuswaehlen() {
        int zahlSpieler = 1;
        auswahlFarbeEins = auswahlFarbe(zahlSpieler); // Farben für Spieler werden in Zwischenspeichervariabeln gespeichert
        zahlSpieler++;
        oberflaeche.clear();
        auswahlFarbeZwei = auswahlFarbe(zahlSpieler);
        oberflaeche.clear();//Übergabe von Farbe und Auswahl des Gegners
    }

    public int auswahlFarbe(int zahlSpieler) {
        int auswahlFarbe = 0;
        oberflaeche.auswahlFarbeText(zahlSpieler);
        auswahlFarbe = scan.nextInt();
        if (auswahlFarbe > 6 || auswahlFarbe < 1) {
            oberflaeche.falscheEingabeText();
            return auswahlFarbe(zahlSpieler);
        }
        return auswahlFarbe;
    }

    private KIGegner kiErstellen(int kiStaerke, Spielfeld spielfeld, char sign, int anfänger) {
        oberflaeche.clear();

        switch (kiStaerke) {
            case 1:
                return new KIGegnerStaerkeEins(spielfeld, '@', anfänger);

            case 2:
                return new KIGegnerStaerkeZwei(spielfeld, '@', anfänger);

            case 3:
                return new KIGegnerStaerkeDrei(spielfeld, '@', anfänger);

            case 4:
                return new KIGegnerStaerkeVier(spielfeld, '@', anfänger);

        }
        return null;
    }

    public Spieler spielerZweiAuswaehlen(Spielfeld spielfeld, char sign, int anfänger) {
        if (auswahlGegner == 2) {
            return kiErstellen(staerkeAuswahl(), spielfeld, sign, anfänger);
        }
        if (auswahlGegner == 1) {
            oberflaeche.clear();
            return new LokalerSpieler(spielfeld, sign, anfänger);
        }
        return null;
    }

    public int staerkeAuswahl() {
        oberflaeche.staerkeAuswahlText();
        int dif = scan.nextInt();
        if (dif > 0 && dif < 5) {
            return dif;
        }
        return staerkeAuswahl();
    }

    public void andereAbfragen() {
        auswahlBeginn();
        farbeAuswaehlen();
        oberflaeche.clear();
    }

    //Get und Set Methoden
    public int getBeginner() {
        return beginner;
    }

    public int getAuswahlGegner() {
        return auswahlGegner;
    }

    public static int getAuswahlFarbeZwei() {
        return auswahlFarbeZwei;
    }

    public static int getAuswahlFarbeEins() {
        return auswahlFarbeEins;
    }

}
