package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class LokalerSpieler extends Spieler {
    private int anzZugEinz;
    private GUI gui;

    //Konstruktor
    public LokalerSpieler(Spielfeld spielfeld, char sign, int farbe, GUI gui) {
        super(spielfeld, sign, farbe);
        this.gui = gui;
        anzZugEinz = 0;
    }

    //Methoden
    public void macheZug() {
        int spaltenAuswahl;
        while(!gui.getClicked())
        {
            try
            {
                Thread.sleep(5);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        spaltenAuswahl = spielfeld.getInsertPos();
            if (spielfeld.probeEinfügen(spaltenAuswahl)) {
                spielfeld.setInsertPos(spaltenAuswahl);
                spielfeld.wirfSteinEin();
                anzZugEinz++;
            }
            else {
                macheZug();
            }
        gui.setClicked(false);
    }
}

