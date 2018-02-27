package com.innoq.praktikum.viergewinnt;

public class KI {
    public static int difficulty ;
    public static int einfStellex;
    public void kiSteinEinfügen(int amZug)
    {
        switch(difficulty)
        {
            case 1:
                Spielfeld.eigenerStein();
                einfStellex = Spielfeld.getPosxGewinn();
                difficulty = 4;
                break;
            case 2:


                if(Spielfeld.kannGewinnen( 2) == true) { // Kann KI gewinnen ?
                    einfStellex = Spielfeld.getPosxGewinn();
                }
                else if(Spielfeld.kannGewinnen(1) == true) // Kann Spieler gewinnen ?
                {
                    einfStellex = Spielfeld.getPosxGewinn();
                }

                difficulty = 1;
                break;
            case 3:
                if(Spielfeld.kannGewinnen( 2) == true) { // Kann KI gewinnen ?
                    einfStellex = Spielfeld.getPosxGewinn();
                }
                else if(Spielfeld.kannGewinnen(1) == true) // Kann Spieler gewinnen ?
                {
                    einfStellex = Spielfeld.getPosxGewinn();
                }

                break;

            case 4:
                einfStellex = (int)((Math.random()) * 7 + 1)-1;
                break;

        }
    }

    public int getEinfStellex() {
        return einfStellex;
    }

    public static void setDifficulty(int dif)
    {
        difficulty = dif;
    }
}
