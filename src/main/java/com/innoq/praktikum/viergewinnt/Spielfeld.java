package com.innoq.praktikum.viergewinnt;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import javafx.util.Pair;

import java.util.*;
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
    private int[] diagonalErgebnisse = new int[6];
    private List<Pair> coordinates = new ArrayList<>();
    private List<List<Pair>> coordinatesList = new ArrayList<>();
    private Queue<Character> userQueue = new LinkedList<>();

    //Konstruktor
    public Spielfeld() {
    }

    public Spielfeld(Konsole oberflaeche, Config config) {
        this.oberflaeche = oberflaeche;
        this.config = config;
        initFelder();
        if (config.getBeginner() == 1) {
            userQueue.add('X');
            userQueue.add('@');
        } else if (config.getBeginner() == 2) {
            userQueue.add('@');
            userQueue.add('X');
        }
    }

    private Spielfeld(char[][] spielfeld,int anzahlZüge, Konsole oberflaeche) {
        this.spielfeld = Arrays.copyOf(spielfeld, spielfeld.length);
        this.anDerReihe = anDerReihe;
        this.anzahlZüge = anzahlZüge;
        this.oberflaeche = oberflaeche;
    }

    //Methoden

    //Felder leeren
    private void initFelder() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                spielfeld[i][j] = 'O';
                farbfeld[i][j] = 0;
            }
        }
    }

    //Spielmethoden
    public void changeUser() {
        char currentUser = userQueue.poll();
        userQueue.add(currentUser);
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


    private void errechnePaare(int diagonalErgebnis)
    {
        for(int reihe = 5; reihe >=0; reihe --)
        {
            for(int spalte = 0; spalte < 7; spalte ++)
            {
                if(reihe + spalte == diagonalErgebnis)
                {
                    Pair<Integer, Integer> coordinate = new Pair<>(reihe, spalte);
                    coordinates.add(coordinate);
                }
            }
        }
    }
    private void errechnePaareZwei(int diagonalErgebnis)
    {

        for(int spalte = 6; spalte >=0; spalte --)
        {
            for(int reihe = 0; reihe < 6; reihe ++)
            {
                if(reihe + spalte == diagonalErgebnis)
                {
                    Pair<Integer, Integer> coordinate = new Pair<>(reihe, spalte);
                    coordinates.add(coordinate);
                    System.out.println(coordinate);
                }
            }
        }

    }
    private void errechnePaare()
    {
        for (int i = 3; i<9; i++)
        {
            errechnePaare(i);
            coordinatesList.add(coordinates);
            errechnePaareZwei(i);
            coordinatesList.add(coordinates);
        }
    }
    private boolean checkWinDiagonal()
    {
        errechnePaare();
        for(int i = 0; i<12; i++)
        {
            coordinates= coordinatesList.get(i);
            Counter winCounter = new Counter();
            for(int j = 0; j<coordinates.size(); j++)
            {
                Pair pair = coordinates.get(j);
                if(winCounter.checkWin(spielfeld[(int)pair.getKey()][(int)pair.getValue()]))
                {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean checkWinWagerecht()
    {
        for (int reihe = 5; reihe >= 0; reihe--)
        {
            Counter winCounter = new Counter();
            for (int spalte = 0; spalte < 7; spalte++)
            {
                if(winCounter.checkWin(spielfeld[reihe][spalte]))
                {
                    System.out.println("wagerecht reihe:" + reihe);
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkWinSenkrecht()
    {
        for(int spalte = 0; spalte<7; spalte++)
        {
            Counter winCounter = new Counter();
            for(int reihe = 5; reihe >=0; reihe--)
            {
                if(winCounter.checkWin(spielfeld[reihe][spalte]))
                {
                    System.out.println("senkrecht spalte:" + spalte);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkWin() {
        if(anzahlZüge >=8) {
                if(checkWinSenkrecht() || checkWinWagerecht() ||checkWinDiagonal() )
                {
                    return true;
                }
        }
        return false;
    }
    public void wirfSteinEin()
    {
        int insertPosy = 5;
        if(insertPos >= 0 && insertPos < 7) {
            if (getCurrentUser() == 'X') {
                farbe = config.getAuswahlFarbeEins();
                zeichenSpieler = 'X';
                UserOne ++;
            } else  {
                farbe = config.getAuswahlFarbeZwei();
                UserTwo++;
                zeichenSpieler = '@';
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

            changeUser();
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
    public Character getCurrentUser() {
        return userQueue.element();
    }
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
    public void setInsertPos(int spalte)
    {
        insertPos = spalte;
    }
    public int getInsertPos()
    {
        return insertPos;
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