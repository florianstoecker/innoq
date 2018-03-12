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
        return userQueue.element();
    }
    public boolean voll()
    {
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if(spielfeld[i][j] == 'O')
                {
                    return false;
                }
            }

        }
        return true;
    }
    private boolean checkWinDiagonal()
    {
        Counter winCounter = new Counter();

        for(int i = 0; i<7; i ++)
        {
            int iHelp = i;
            for(int j = 0; j<6; j++)
            {
                while(i < 7)
                {
                if(winCounter.checkWin(spielfeld[j][i]))
                {
                    return true;
                }
                i++;
                }
            }
            i = iHelp;
        }

        for(int i = 6; i>= 0; i --)
        {
            int iHelp = i;
            for(int j = 0; j<6; j++)
            {
                while(i >= 0) {
                    if (winCounter.checkWin(spielfeld[j][i])) {
                        return true;
                    }
                    i--;
                }
            }
            i = iHelp;
        }
        return false;
    }
    private boolean checkWinWagerecht()
    {
        Counter winCounter = new Counter();
        for (int i = 5; i >= 0; i--)
        {
            for (int j = 0; j < 7; j++)
            {
                if(winCounter.checkWin(spielfeld[i][j]) == true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkWinSenkrecht()
    {
        Counter winCounter = new Counter();
        for(int i = 0; i<7; i++)
        {
            for(int j = 5; j >=0; j--)
            {
                if(winCounter.checkWin(spielfeld[j][i]))
                {return true;}
            }
        }
        return false;
    }
    public boolean checkWin() {
        if(anzahlZüge >=16) {
            if (checkWinDiagonal() || checkWinSenkrecht() || checkWinWagerecht()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private int countSign(char sign) {
        Counter counter = new Counter();
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                counter.countSign(sign, spielfeld[i][j]);
            }
        }
        return counter.getCounter();
    }

    //Spielmethoden
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
            if (getCurrentUser() == 'X') {
                farbe = config.getAuswahlFarbeEins();
                UserOne ++;
            } else  {
                farbe = config.getAuswahlFarbeZwei();
                UserTwo++;
            }

            if (spielfeld[insertPosy][insertPos] == 'O') {
                spielfeld[insertPosy][insertPos] = getCurrentUser();
                farbfeld[insertPosy][insertPos] = farbe;

            } else {
                while (spielfeld[insertPosy][insertPos] == 'X' || spielfeld[insertPosy][insertPos] == '@') {
                    insertPosy--;
                }
                spielfeld[insertPosy][insertPos] = getCurrentUser();
                farbfeld[insertPosy][insertPos] = farbe;
            }
        }

            changeUser();

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
    public boolean probeEinfügen(int insertPos) {
        int insertPosy = 5;
        if (spielfeld[insertPosy][insertPos] == 'O') {
            return true;

        } else {
            while (spielfeld[insertPosy][insertPos]!= 'O') {
                insertPosy--;
                if (insertPosy <= - 1) {
                    oberflaeche.spalteVollText(insertPos);
                    return false;
                }
            }
            return true;

        }
    }

    // Get- & Set-Methoden
    public void anzZügeHoch()
    {
        anzahlZüge ++;
    }
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