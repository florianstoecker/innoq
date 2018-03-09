package com.innoq.praktikum.viergewinnt;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Spielfeld {


    private int farbe;
    public int insertPos;
    private char[][] spielfeld = new char[6][7];
    private int[][] farbfeld = new int[6][7];
    private char zeichenSpieler;
    private int anDerReihe;
    private int UserOne = 1;
    private int UserTwo = 1;
    private Konsole oberflaeche;
    private int anzahlZüge = 0;
    private Config config;

    private Queue<Character> userQueue = new LinkedList<>();

    //Konstruktor
    public Spielfeld() {
    }

    public Spielfeld(Konsole oberflaeche, Config config, ZeichneSpielfeld zeichneSpielfeld) {
        this.oberflaeche = oberflaeche;
        this.config = config;
        initSpielfeld();
        initFarbfeld();
        if (config.getBeginner() == 1) {
            userQueue.add('X');
            userQueue.add('@');
        } else if (config.getBeginner() == 2) {
            userQueue.add('@');
            userQueue.add('X');
        }
    }

    private Spielfeld(char[][] spielfeld, int anDerReihe, int anzahlZüge, Konsole oberflaeche) {
        this.spielfeld = Arrays.copyOf(spielfeld, spielfeld.length);
        this.anDerReihe = anDerReihe;
        this.anzahlZüge = anzahlZüge;
        this.oberflaeche = oberflaeche;
    }

    //Methoden

    //Felder leeren
    private void initSpielfeld() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                spielfeld[i][j] = 'O';
            }
        }
    }

    public void initFarbfeld() {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                farbfeld[i][j] = 0;
            }
        }
    }

    public void changeUser() {
        Character currentUser = userQueue.poll();
        userQueue.add(currentUser);
    }

    public Character getCurrentUser() {
        return userQueue.peek();
    }

    private boolean checkWin() {
        int counter = 0;
        char checkSign = 'X';
        //wagerecht
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                if (spielfeld[i][j] == checkSign) {
                    counter++;
                } else {
                    counter = 0;
                    if (spielfeld[i][j] != 'O') {
                        checkSign = spielfeld[i][j];
                    }
                }
                if (counter == 4) {
                    return true;
                }
            }
            counter = 0;
        }
        //senkrecht
        for (int j = 0; j < 7; j++) {
            for (int i = 5; i >= 0; i--) {
                if (spielfeld[i][j] == checkSign) {
                    counter++;
                } else {
                    counter = 0;
                    if (spielfeld[i][j] != 'O') {
                        checkSign = spielfeld[i][j];
                    }
                }
                if (counter == 4) {
                    return true;
                }
            }
            counter = 0;
        }
        return false;
    }

    private int countSign(char sign) {
        int counter = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (spielfeld[j][i] == sign) {
                    counter++;
                }
            }
        }
        return counter;
    }

    //Spielmethoden
    private int gewinnHelp(char zeichenSpieler, int vorfaktorX, int vorfaktorY, int x, int y)
    {
        int ergebnisReihe = 0;
        if ((spielfeld[x][y] == zeichenSpieler)
                && (spielfeld[x + 1 * vorfaktorX][y + 1 * vorfaktorY] == zeichenSpieler)
                && (spielfeld[x + 2 * vorfaktorX][y + 2 * vorfaktorY] == zeichenSpieler)
                && (spielfeld[x + 3 * vorfaktorX][y + 3 * vorfaktorY] == zeichenSpieler))
        {
            for (int i = 0; i < 4; i++)
            {
                if (spielfeld[x + i * vorfaktorX][y + i * vorfaktorY] == zeichenSpieler)
                {
                    ergebnisReihe++;
                }
            }
        }
        return ergebnisReihe;
    }
    public boolean gewinn()
    {
        anzahlZüge++;
        if(anzahlZüge>=8) {
            char zeichenSpieler;
            if (anDerReihe == 2) {
                zeichenSpieler = 'X';
            } else {
                zeichenSpieler = '@';
            }
            int ergebnisReihe;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    if (j < 4) {
                        ergebnisReihe = gewinnHelp(zeichenSpieler, 0, 1, i, j);
                        //gewonnen wagerecht rechts
                        if (ergebnisReihe == 4) {
                            return true;
                        }
                    }
                    if (i > 2) {

                        ergebnisReihe = gewinnHelp(zeichenSpieler, -1, 0, i, j);
                        //gewonnen senkrecht
                        if (ergebnisReihe == 4) {
                            return true;
                        }
                    }
                    if (j < 4 && i < 3) {
                        ergebnisReihe = gewinnHelp(zeichenSpieler, 1, 1, i, j);
                        //gewonnen diagonal rechts unten
                        if (ergebnisReihe == 4) {
                            return true;
                        }
                        if (j < 4 && i > 2) {
                            ergebnisReihe = gewinnHelp(zeichenSpieler, -1, 1, i, j);
                            //gewonnen diagonal rechts oben
                            if (ergebnisReihe == 4) {
                                return true;
                            }

                        }
                    }
                }
            }
            return false;
        }
        else{
            return false;
        }
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
            if (getAnDerReihe() == 1) {
                farbe = config.getAuswahlFarbeEins();
                zeichenSpieler = 'X';
                UserOne ++;
            } else  {
                farbe = config.getAuswahlFarbeZwei();
                zeichenSpieler = '@';
                UserTwo++;
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
        /*int signs = countSign(getCurrentUser());
        changeUser();
        if(signs > countSign(getCurrentUser()))
        {
            changeUser();
        }*/
      //  changeUser();
        wechseln();
    }

    // Darf das Feld belegt werden?
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
    public boolean probeEinfügen(int insertPos) {
        int insertPosy = 5;
        if (spielfeld[insertPosy][insertPos] == 'O') {
            return true;

        } else {
            while (spielfeld[insertPosy][insertPos]!= 'O') {
                insertPosy--;
                if (insertPosy <= - 1) {
                    return false;
                }
            }
            return true;

        }
    }

    // Get- & Set-Methoden
    public Queue getUserQueue()
    {
        return userQueue;
    }
    public void setUserQueue(Queue userQueue)
    {
        this.userQueue = userQueue;
    }
    public int getUserOne()
    {
        return UserOne;
    }
    public int getUserTwo()
    {
        return UserTwo;
    }
    public int getAuswahlAnfänger()
    {
        return config.getBeginner();
    }
    public Spielfeld getCopy() {
        return new Spielfeld(spielfeld, anDerReihe, anzahlZüge, oberflaeche);
    }
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