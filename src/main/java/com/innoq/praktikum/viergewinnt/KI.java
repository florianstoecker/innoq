package com.innoq.praktikum.viergewinnt;

public class KI {
    public static int difficulty ;
    public static int einfStellex;
    public static int steinEinfügen(char[][] kiFeld, int amZug)
    {
        boolean feldLegbar = false;
        switch(difficulty)
        {
            case 1:
                for(int i = 5; i>= 1; i--)//senkrecht auf eigenen Stein
                {

                    for(int j = 0; j<7; j++)
                    {
                        if(i >2) {
                            if (kiFeld[i][j] == '@' && kiFeld[i - 1][j] == 'O') {
                                einfStellex = j;
                                return einfStellex;
                            }
                        }
                    }
                }
                for(int i = 5; i>= 0; i--) //wagerecht neben eigenen Stein
                {

                    for(int j = 0; j<7; j++)
                    {
                            if(kiFeld[i][j] == '@' && j>0 && kiFeld[i][j-1] == 'O' ) // links neben eigenen Stein
                            {

                                int help_i = i;

                                if(i == 5)
                                {
                                    einfStellex = j-1;
                                    return einfStellex;
                                }

                                else  if(help_i < 5)
                                {
                                    for (int m = 5; m > i; m--) {
                                        if (kiFeld[m][j - 1] == 'O') {
                                            feldLegbar = false;
                                        }
                                        else {
                                            feldLegbar = true;
                                        }

                                    }
                                    if (feldLegbar == true)
                                    {
                                        einfStellex = j - 1;
                                        return einfStellex;
                                    }
                                }

                            }
                            else if(kiFeld[i][j] == '@' && j<6&& kiFeld[i][j+1] == 'O') // rechts neben eigenen Stein
                            {

                                int help_i_ = i;
                                if(i == 5)
                                {
                                    einfStellex = j+1;
                                    return einfStellex;
                                }
                                else  if(help_i_ < 5)
                                {
                                        for (int m = 5; m > i; m--) {
                                            if (kiFeld[m][j + 1] == 'O') {
                                                feldLegbar = false;
                                            }
                                            else {
                                                feldLegbar = true;
                                            }

                                        }
                                        if (feldLegbar == true)
                                        {
                                            einfStellex = j + 1;
                                            return einfStellex;
                                        }
                                }
                            }
                    }
                }

                difficulty = 4;
                break;
            case 2:


                if(Gewinn.kannGewinnen(kiFeld, 2) == true) { // Kann KI gewinnen ?
                    einfStellex = Gewinn.getPosxGewinn();
                    return einfStellex;
                }
                else if(Gewinn.kannGewinnen(kiFeld,1) == true) // Kann Spieler gewinnen ?
                {
                    einfStellex = Gewinn.getPosxGewinn();
                    return einfStellex;
                }

                difficulty = 1;
                break;
            case 3:
                if(Gewinn.kannGewinnen(kiFeld, 2) == true) { // Kann KI gewinnen ?
                    einfStellex = Gewinn.getPosxGewinn();
                    return einfStellex;
                }
                else if(Gewinn.kannGewinnen(kiFeld,1) == true) // Kann Spieler gewinnen ?
                {
                    einfStellex = Gewinn.getPosxGewinn();
                    return einfStellex;
                }

                break;

            case 4:
                einfStellex = (int)((Math.random()) * 7 + 1)-1;
              break;

        }
        return einfStellex;
    }

    public static void setDifficulty(int dif)
    {
        difficulty = dif;
    }
}
