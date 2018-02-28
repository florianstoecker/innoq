package com.innoq.praktikum.viergewinnt;

public class KI {
    public static int difficulty;
    public static int entscheidung;

    public static int dreiGleich(char xEins,char xZwei, char xDrei, char xVier, char zeichenSpieler)
    {

        if(xVier == xZwei && xZwei== xDrei && xDrei == zeichenSpieler)
        {
            return 1;
        }
        else if(xVier == xEins && xEins== xDrei && xDrei == zeichenSpieler)
        {
            return 2;
        }
        else if(xVier == xZwei && xZwei == xEins && xEins == zeichenSpieler)
        {
            return 3;
        }
        else if(xEins == xZwei && xZwei == xDrei && xDrei == zeichenSpieler)
        {
            return 4;
        }
        return 0;
    }

    public static void zweiGleichGewinnMoeglich(char xEins,char xZwei, char xDrei, char xVier, char zeichenSpieler, int schonGecheckt)
    {
        if(schonGecheckt < 1)
        {
        if(xEins== xZwei && xZwei == zeichenSpieler && xDrei == 'O' && xDrei == xVier)
        {
            setEntscheidung(1);
            return;
        }
        }
        if(schonGecheckt <2) {
        if (xEins == xDrei && xDrei == zeichenSpieler && xZwei == 'O' && xZwei == xVier) {
                setEntscheidung(2);
                return;
            }
        }
        if(schonGecheckt <3) {
            if (xEins == xVier && xVier == zeichenSpieler && xZwei == 'O' && xZwei == xDrei) {
                setEntscheidung(3);
                return;
            }
        }
        if(schonGecheckt <4) {
            if (xZwei == xDrei && xDrei == zeichenSpieler && xEins == 'O' && xEins == xVier) {
                setEntscheidung(4);
                return;
            }
        }
        if(schonGecheckt <5) {
            if (xZwei == xVier && xVier == zeichenSpieler && xEins == 'O' && xEins == xDrei) {
                setEntscheidung(5);
                return;
            }
        }
        if(schonGecheckt <6) {
            if (xDrei == xVier && xVier == zeichenSpieler && xEins == 'O' && xEins == xZwei) {
                setEntscheidung(6);
                return;
            }
        }
        setEntscheidung(0);
    }

    public static void setEntscheidung(int ent)
    {
        entscheidung = ent;
    }

    public static int getEntscheidung() {
        return entscheidung;
    }

    public static void setDifficulty(int dif)
    {
        difficulty = dif;
    }
    public static int getDifficulty()
    {
        return difficulty;
    }
}
