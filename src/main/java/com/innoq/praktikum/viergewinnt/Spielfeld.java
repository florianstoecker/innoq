package com.innoq.praktikum.viergewinnt;

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
    private int anzahlZüge = 0;
    private Scanner scan = new Scanner(System.in);

    public Spielfeld() {
        initSpielfeld();
    }

    public void setAnDerReihe(int anDerReihe) {
        this.anDerReihe = anDerReihe;
    }
    public int getAnDerReihe()
    {
        return anDerReihe;
    }
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
    public int getZeichenAusFarbfeld(int i, int j)
    {
        return farbfeld[i][j];
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
    public void wirfSteinEin(Konsole oberflaeche, Spielfeld TempInstanzSpielfeld)
    {
        int insertPosy = 5;
        if(insertPos >= 0 && insertPos < 7) {

            if (anDerReihe == 1) {
                zeichenSpieler = 'X';
                farbe = oberflaeche.getAuswahlFarbeEins();
            } else if (anDerReihe == 2) {
                zeichenSpieler = '@';
                farbe = oberflaeche.getAuswahlFarbeZwei();
            }

            if (spielfeld[insertPosy][insertPos] == 'O') {
                spielfeld[insertPosy][insertPos] = zeichenSpieler;
                farbfeld[insertPosy][insertPos] = farbe;
                oberflaeche.zeichneSpielfeld(TempInstanzSpielfeld);

            } else {
                while (spielfeld[insertPosy][insertPos] == 'X' || spielfeld[insertPosy][insertPos] == '@') {
                    insertPosy--;
                }
                    spielfeld[insertPosy][insertPos] = zeichenSpieler;
                    farbfeld[insertPosy][insertPos] = farbe;
                    oberflaeche.zeichneSpielfeld(TempInstanzSpielfeld);
            }
        }
    }
    public void spiele(Konsole oberflaeche, Spieler spielerA, Spieler spielerB, Spielfeld TempInstanzSpielfeld)
    {
        Spieler Erster;
        Spieler Zweiter;
        if(oberflaeche.getBeginner() == 1)
        {
            Erster = spielerA;
            Zweiter = spielerB;
        }
        else
        {
            Erster = spielerB;
            Zweiter = spielerA;
        }
        while(spieleWeiter = true)
        {
            Erster.macheZug(oberflaeche, TempInstanzSpielfeld);
            anzahlZüge ++;
            if(gewinn()== true)
            {
                oberflaeche.gewinnText(TempInstanzSpielfeld, 1);
                spieleWeiter = false;
                return;
            }
            wechseln();
            Zweiter.macheZug(oberflaeche, TempInstanzSpielfeld);
            anzahlZüge ++;
            if(gewinn()== true)
            {
                oberflaeche.gewinnText(TempInstanzSpielfeld, 2);
                return;
            }
            wechseln();
        }
    }
    public int getAnzahlZüge()
    {
        return anzahlZüge;
    }
    public boolean legalerZug(Konsole oberflaeche)
    {
        int insertPosy = 5;

        if(insertPos >= 0 && insertPos < 7)
        {

            if (anDerReihe == 1) {
                zeichenSpieler = 'X';
                farbe = oberflaeche.getAuswahlFarbeEins();
            } else if (anDerReihe == 2) {
                zeichenSpieler = '@';
                farbe = oberflaeche.getAuswahlFarbeZwei();
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
                    if (oberflaeche.spalteVoll(insertPosy) == true)
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
    public int getInsertPos()
    {
        return insertPos;
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
    public char getZeichenAusSpielfeld(int i, int j)
    {
        return spielfeld[i][j];
    }

    public void setInsertPos(int spalte)
    {
        insertPos = spalte;

    }
    public void schreiben(String eingabe)
    {
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter("/Users/user/Documents/GitHub/innoq/src/main/java/Eingabe.txt"));
            writer.println(eingabe);
            writer.println();
            writer.print("neu");
            writer.close();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }
}