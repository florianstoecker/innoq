public class Gewinn {
    public static boolean gewinn(char Spielfeld[][], int am_Zug)
    {
        char zeichen_spieler = 0;
        boolean erg = false;
        if(am_Zug == 1)
        {
            zeichen_spieler = 'X';
        }
        else if(am_Zug == 2)
        {
            zeichen_spieler = '@';
        }

        for(int i = 0; i<6; i++) {
            for (int j = 0; j < 7; j++)
            {
                if (Spielfeld[i][j] == zeichen_spieler)
                {
                    if (i < 3)
                    {
                        // senkrecht
                        if (Spielfeld[i + 1][j] == zeichen_spieler && Spielfeld[i + 2][j] == zeichen_spieler && Spielfeld[i + 3][j] == zeichen_spieler)
                        {
                            erg = true;
                            return erg;
                        }
                        else if(j<3) //diagonal
                        {
                            if (Spielfeld[i +1 ][j +1] == zeichen_spieler && Spielfeld[i + 2][j +2] == zeichen_spieler && Spielfeld[i + 3][j + 3] == zeichen_spieler)
                            {
                                erg = true;
                                return erg;
                            }
                        }
                        else if(j > 3)//diagonal
                        {
                            if(Spielfeld[i + 1][j - 1] == zeichen_spieler && Spielfeld[i + 2][j - 2] == zeichen_spieler && Spielfeld[i + 3][j - 3] == zeichen_spieler)
                            {
                                erg = true;
                                return erg;
                            }
                        }
                        else if(j == 3)//diagonal
                        {
                            if (Spielfeld[i +1 ][j +1] == zeichen_spieler && Spielfeld[i + 2][j +2] == zeichen_spieler && Spielfeld[i + 3][j + 3] == zeichen_spieler)
                            {
                                erg = true;
                                return erg;
                            }
                            if(i>3)
                            {
                                if(Spielfeld[i - 1][j - 1] == zeichen_spieler && Spielfeld[i - 2][j - 2] == zeichen_spieler && Spielfeld[i - 3][j - 3] == zeichen_spieler)
                                {
                                    erg = true;
                                    return erg;
                                }
                            }

                        }
                    }

                  /*  else if (i >= 3)
                    {
                         if(j<3) //diagonal
                         {
                             if (Spielfeld[i - 1][j + 1] == zeichen_spieler && Spielfeld[i - 2][j + 2] == zeichen_spieler && Spielfeld[i - 3][j + 3] == zeichen_spieler) {
                                 erg = true;
                                 return erg;

                             }
                         }
                             else if (j > 3) {
                                 if (Spielfeld[i - 1][j - 1] == zeichen_spieler && Spielfeld[i - 2][j - 2] == zeichen_spieler && Spielfeld[i - 3][j - 3] == zeichen_spieler) {
                                     erg = true;
                                     return erg;
                                 }
                             } else if (j == 3) {
                                 if (Spielfeld[i - 1][j - 1] == zeichen_spieler && Spielfeld[i - 2][j - 2] == zeichen_spieler && Spielfeld[i - 3][j - 3] == zeichen_spieler) {
                                     erg = true;
                                     return erg;
                                 } else if (Spielfeld[i + 1][j + 1] == zeichen_spieler && Spielfeld[i + 2][j + 2] == zeichen_spieler && Spielfeld[i + 3][j + 3] == zeichen_spieler) {
                                     erg = true;
                                     return erg;
                                 }
                             }

                         }*/
                    else if (j < 4) // wagerecht
                    {
                        if (Spielfeld[i][j + 1] == zeichen_spieler && Spielfeld[i][j + 2] == zeichen_spieler && Spielfeld[i][j + 3] == zeichen_spieler)
                        {
                            erg = true;
                            return erg;
                        }
                    }

                }
            }
        }
        return erg;
    }
}
