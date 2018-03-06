package com.innoq.praktikum.viergewinnt;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Spielfeld {


    private int farbe;
    public int insertPos;
    public int posxGewinn;
    public boolean spieleWeiter = true;
    private char[][] spielfeld = new char[6][7];
    private int[][] farbfeld = new int[6][7];
    private char zeichenSpieler;
    private int anDerReihe;
    private Konsole oberflaeche;
    private int anzahlZüge = 0;
    public ZeichneSpielfeld zeichneSpielfeld = new ZeichneSpielfeld();
    private Config config;
    private Scanner scan = new Scanner(System.in);

    public Spielfeld( Konsole oberflaeche, Config config, ZeichneSpielfeld zeichneSpielfeld) {
    this.oberflaeche = oberflaeche;
    this.config = config;
    }

    private Spielfeld(char[][] spielfeld, int anDerReihe, int anzahlZüge, Konsole oberflaeche) {
        this.spielfeld = Arrays.copyOf(spielfeld, spielfeld.length);
        this.anDerReihe = anDerReihe;
        this.anzahlZüge = anzahlZüge;
        this.oberflaeche = oberflaeche;
        initSpielfeld();
    }
    public int getAuswahlAnfänger()
    {
        return config.getAuswAnfänger();
    }
    public Spielfeld getCopy() {
        return new Spielfeld(spielfeld, anDerReihe, anzahlZüge, oberflaeche);
    }

    //Felder leeren
    private void initSpielfeld()
    {
        for(int i = 0; i<6; i++)
        {
            for(int j = 0; j<7; j++)
            {
                spielfeld[i][j] = 'O';
            }
        }
    }
    public void initFarbfeld()
    {

        for(int i = 0; i<6; i++)
        {
            for(int j = 0; j<7; j++)
            {
                farbfeld[i][j] = 0;
            }
        }
    }

    //Spielmethoden
    public boolean gewinn()
    {
        char zeichenSpieler = 'D';
        if (anDerReihe == 1)
        {
            zeichenSpieler = 'X';
        }
        else if (anDerReihe == 2)
        {
            zeichenSpieler = '@';
        }

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (spielfeld[i][j] == zeichenSpieler)
                {
                    if (j < 4) // wagerecht
                    {
                        if (spielfeld[i][j + 1] == zeichenSpieler && spielfeld[i][j + 2] == zeichenSpieler && spielfeld[i][j + 3] == zeichenSpieler)
                        {
                            return true;
                        }
                    }
                    else if (j > 3) // wagerecht
                    {
                        if (spielfeld[i][j - 1] == zeichenSpieler && spielfeld[i][j - 2] == zeichenSpieler && spielfeld[i][j - 3] == zeichenSpieler)
                        {
                            return true;
                        }
                    }
                    if (i < 3)
                    {
                        // senkrecht
                        if (spielfeld[i + 1][j] == zeichenSpieler && spielfeld[i + 2][j] == zeichenSpieler && spielfeld[i + 3][j] == zeichenSpieler)
                        {
                            return true;
                        }
                        else if (j < 3) //diagonal
                        {
                            if (spielfeld[i + 1][j + 1] == zeichenSpieler && spielfeld[i + 2][j + 2] == zeichenSpieler && spielfeld[i + 3][j + 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                        else if (j == 3) //diagonal
                        {
                            if (spielfeld[i + 1][j + 1] == zeichenSpieler && spielfeld[i + 2][j + 2] == zeichenSpieler && spielfeld[i + 3][j + 3] == zeichenSpieler)
                            {
                                return true;
                            }
                            else if (spielfeld[i + 1][j - 1] == zeichenSpieler && spielfeld[i + 2][j - 2] == zeichenSpieler && spielfeld[i + 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                        else if (j > 3)  //diagonal
                        {
                            if (spielfeld[i + 1][j - 1] == zeichenSpieler && spielfeld[i + 2][j - 2] == zeichenSpieler && spielfeld[i + 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                    }

                    else if (i > 2)
                    {
                        // senkrecht
                        if (spielfeld[i - 1][j] == zeichenSpieler && spielfeld[i - 2][j] == zeichenSpieler && spielfeld[i - 3][j] == zeichenSpieler)
                        {
                            return true;
                        }
                        if (j < 3) //diagonal
                        {
                            if (spielfeld[i - 1][j + 1] == zeichenSpieler && spielfeld[i - 2][j + 2] == zeichenSpieler && spielfeld[i - 3][j + 3] == zeichenSpieler)
                            {

                            }
                        }
                        else if (j == 3) //diagonal
                        {
                            if (spielfeld[i - 1][j + 1] == zeichenSpieler && spielfeld[i - 2][j + 2] == zeichenSpieler && spielfeld[i - 3][j + 3] == zeichenSpieler)
                            {
                                return true;
                            }
                            else if (spielfeld[i - 1][j - 1] == zeichenSpieler && spielfeld[i - 2][j - 2] == zeichenSpieler && spielfeld[i - 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                        else if (j > 3) //diagonal
                        {
                            if (spielfeld[i - 1][j - 1] == zeichenSpieler && spielfeld[i - 2][j - 2] == zeichenSpieler && spielfeld[i - 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public  void wechseln()
    {


        if(anDerReihe == 1)
        {
            anDerReihe = 2;
        }
        else if(anDerReihe == 2)
        {
            anDerReihe = 1;
        }
    }
    public void wirfSteinEin()
    {
        int insertPosy = 5;
        if(insertPos >= 0 && insertPos < 7) {

            if (anDerReihe == 1) {
                zeichenSpieler = 'X';
                farbe = config.getAuswahlFarbeEins();
            } else if (anDerReihe == 2) {
                zeichenSpieler = '@';
                farbe = config.getAuswahlFarbeZwei();
            }

            if (spielfeld[insertPosy][insertPos] == 'O') {
                spielfeld[insertPosy][insertPos] = zeichenSpieler;
                farbfeld[insertPosy][insertPos] = farbe;

            } else {
                while (spielfeld[insertPosy][insertPos] == 'X' || spielfeld[insertPosy][insertPos] == '@') {
                    insertPosy--;
                }
                    spielfeld[insertPosy][insertPos] = zeichenSpieler;
                    farbfeld[insertPosy][insertPos] = farbe;
            }
        }
        anzahlZüge++;
        wechseln();
    }


    // Darf das Feld belegt werden?
    public boolean legalerZug()
    {
        int insertPosy = 5;

        if(insertPos >= 0 && insertPos < 7)
        {

            if (anDerReihe == 1) {
                zeichenSpieler = 'X';
                farbe = config.getAuswahlFarbeEins();
            } else if (anDerReihe == 2) {
                zeichenSpieler = '@';
                farbe = config.getAuswahlFarbeZwei();
            }
            if (spielfeld[insertPosy][insertPos] == 'O')
            {
                return true;

            }

            else
            {
                while (spielfeld[insertPosy][insertPos] == 'X' || spielfeld[insertPosy][insertPos] == '@')
                {
                    insertPosy--;
                    if (spalteVoll(insertPosy) == true)
                    {
                        oberflaeche.spalteVollText(insertPos + 1);
                        return false;
                    }

                }
                    return true;
            }
        }
        else
        {
            oberflaeche.falscheEingabeText();
            return false;
        }
    }

    public boolean feldLegbar(int Stellex, int Stelley)
    {
        boolean feldBelegbar = false;
        if(spielfeld[Stellex][Stelley] == 'O') {
            if (Stellex == 5) {
                return true;
            } else {
                for (int m = 5; m > Stellex; m --) {
                    if (spielfeld[m][Stelley] == 'O') {
                        return false;
                    } else {
                        feldBelegbar = true;
                    }
                }
                if (feldBelegbar == true) {
                    return true;

                }
            }
        }
        return false;
    }
    public static boolean spalteVoll(int reihe)
    {
        if(reihe == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Get- & Set-Methoden
    public void setInsertPos(int spalte)
    {
        insertPos = spalte;
    }
    public int getInsertPos()
    {
        return insertPos;
    }
    public void setAnDerReihe(int anDerReihe) {
        this.anDerReihe = anDerReihe;
    }
    public int getAnDerReihe()
    {
        return anDerReihe;
    }
    public int getAnzahlZüge()
    {
        return anzahlZüge;
    }
    public void setZeichenAnSpielfeld(int i, int j, char zeichen)
    {
        spielfeld[i][j] = zeichen;
    }
    public char getZeichenAusSpielfeld(int i, int j)
    {
        return spielfeld[i][j];
    }
    public int getZeichenAusFarbfeld(int i, int j)
    {
        return farbfeld[i][j];
    }

}