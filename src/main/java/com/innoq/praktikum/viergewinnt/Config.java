package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class Config {

    private int auswahlGegner = 0;
    private int beginner;
    private int auswahlFarbeZwei;
    private int auswahlFarbeEins;
    private GUI gui;
    public static Scanner scan = new Scanner(System.in);

    //Konstruktor
    public Config(GUI gui ) {
        this.gui = gui;
        auswahlGegner = this.gui.gegnerAuswahl();
        andereAbfragen();

    }

    //Methoden

    private KIGegner kiErstellen(int kiStaerke, Spielfeld spielfeld, char sign, int anfänger) {

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

    public Spieler spielerZweiAuswaehlen(Spielfeld spielfeld, char sign, int anfänger, GUI gui) {
        if (auswahlGegner == 2) {
            return kiErstellen(gui.staerkeAuswahl(), spielfeld, sign, anfänger);
        }
        if (auswahlGegner == 1) {
            return new LokalerSpieler(spielfeld, sign, anfänger, gui);
        }
        return null;
    }

    public void andereAbfragen() {
        int zahlSpieler = 1;
        beginner = gui.beginnerAuswahl();
        auswahlFarbeEins = gui.farbAuswahl(zahlSpieler);
        zahlSpieler ++;
        auswahlFarbeZwei = gui.farbAuswahl(zahlSpieler);
    }

    //Get und Set Methoden
    public int getBeginner() {
        return beginner;
    }

    public int getAuswahlGegner() {
        return auswahlGegner;
    }

    public int getAuswahlFarbeZwei() {
        return auswahlFarbeZwei;
    }

    public int getAuswahlFarbeEins() {
        return auswahlFarbeEins;
    }

}
