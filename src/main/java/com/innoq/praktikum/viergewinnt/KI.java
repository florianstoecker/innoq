package com.innoq.praktikum.viergewinnt;

public class KI {
    public static int difficulty ;
    public static int einfStellex;


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

    public static void setDifficulty(int dif)
    {
        difficulty = dif;
    }
    public static int getDifficulty()
    {
        return difficulty;
    }
}
