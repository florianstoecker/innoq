package com.innoq.praktikum.viergewinnt;

public class Gewinn
{



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
    public static boolean feldLegbar(char[][] Spielfeld, int Stellex, int Stelley)
    {
        boolean feldLegbar = false;
        if(Spielfeld[Stellex][Stelley] == 'O') {
            if (Stellex == 5) {
                return true;
            } else {
                for (int m = 5; m > Stellex; m --) {
                    if (Spielfeld[m][Stelley] == 'O') {
                        return false;
                    } else {
                        feldLegbar = true;
                    }
                }
                if (feldLegbar == true) {
                    return true;

                }
            }
        }
        return false;
    }
    public static int getPosxGewinn()
    {
        return posxGewinn;
    }

}
