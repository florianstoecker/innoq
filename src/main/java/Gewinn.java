public class Gewinn
{
    public static int posxGewinn;
    public static int posyGewinn;
    public static boolean gewinn(char Spielfeld[][], int amZug)
    {
        char zeichenSpieler = 0;
        boolean erg = false;
        if (amZug == 1)
        {
            zeichenSpieler = 'X';
        }
        else if (amZug == 2)
        {
            zeichenSpieler = '@';
        }

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (Spielfeld[i][j] == zeichenSpieler)
                {
                    if (j < 4) // wagerecht
                    {
                        if (Spielfeld[i][j + 1] == zeichenSpieler && Spielfeld[i][j + 2] == zeichenSpieler && Spielfeld[i][j + 3] == zeichenSpieler)
                        {
                            erg = true;
                            return erg;
                        }
                    }
                    else if (j > 3) // wagerecht
                    {
                        if (Spielfeld[i][j - 1] == zeichenSpieler && Spielfeld[i][j - 2] == zeichenSpieler && Spielfeld[i][j - 3] == zeichenSpieler)
                        {
                            erg = true;
                            return erg;
                        }
                    }
                    if (i < 3)
                    {
                        // senkrecht
                        if (Spielfeld[i + 1][j] == zeichenSpieler && Spielfeld[i + 2][j] == zeichenSpieler && Spielfeld[i + 3][j] == zeichenSpieler)
                        {
                            erg = true;
                            return erg;
                        }
                        else if (j < 3) //diagonal
                        {
                            if (Spielfeld[i + 1][j + 1] == zeichenSpieler && Spielfeld[i + 2][j + 2] == zeichenSpieler && Spielfeld[i + 3][j + 3] == zeichenSpieler)
                            {
                                erg = true;
                                return erg;
                            }
                        }
                        else if (j == 3) //diagonal
                        {
                            if (Spielfeld[i + 1][j + 1] == zeichenSpieler && Spielfeld[i + 2][j + 2] == zeichenSpieler && Spielfeld[i + 3][j + 3] == zeichenSpieler)
                            {
                                erg = true;
                                return erg;
                            }
                            else if (Spielfeld[i + 1][j - 1] == zeichenSpieler && Spielfeld[i + 2][j - 2] == zeichenSpieler && Spielfeld[i + 3][j - 3] == zeichenSpieler)
                            {
                                erg = true;
                                return erg;
                            }
                        }
                        else if (j > 3)  //diagonal
                        {
                            if (Spielfeld[i + 1][j - 1] == zeichenSpieler && Spielfeld[i + 2][j - 2] == zeichenSpieler && Spielfeld[i + 3][j - 3] == zeichenSpieler)
                            {
                                erg = true;
                                return erg;
                            }
                        }
                    }

                    else if (i > 2)
                    {
                        // senkrecht
                        if (Spielfeld[i - 1][j] == zeichenSpieler && Spielfeld[i - 2][j] == zeichenSpieler && Spielfeld[i - 3][j] == zeichenSpieler)
                        {
                            erg = true;
                            return erg;
                        }
                        if (j < 3) //diagonal
                        {
                            if (Spielfeld[i - 1][j + 1] == zeichenSpieler && Spielfeld[i - 2][j + 2] == zeichenSpieler && Spielfeld[i - 3][j + 3] == zeichenSpieler)
                            {
                                erg = true;
                                return erg;
                            }
                        }
                        else if (j == 3) //diagonal
                        {
                            if (Spielfeld[i - 1][j + 1] == zeichenSpieler && Spielfeld[i - 2][j + 2] == zeichenSpieler && Spielfeld[i - 3][j + 3] == zeichenSpieler)
                            {
                                erg = true;
                                return erg;
                            }
                            else if (Spielfeld[i - 1][j - 1] == zeichenSpieler && Spielfeld[i - 2][j - 2] == zeichenSpieler && Spielfeld[i - 3][j - 3] == zeichenSpieler)
                            {
                                erg = true;
                                return erg;
                            }
                        }
                        else if (j > 3) //diagonal
                        {
                            if (Spielfeld[i - 1][j - 1] == zeichenSpieler && Spielfeld[i - 2][j - 2] == zeichenSpieler && Spielfeld[i - 3][j - 3] == zeichenSpieler)
                            {
                                erg = true;
                                return erg;
                            }
                        }
                    }
                }
            }
        }
        return erg;
    }





    public static boolean kannGewinnen(char[][]Spielfeld, int amZug)
    {
        char zeichenSpieler = 0;
        boolean kannGewinnen = false;
        if (amZug == 1)
        {
            zeichenSpieler = 'X';
        }
        else if (amZug == 2)
        {
            zeichenSpieler = '@';
        }
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (Spielfeld[i][j] == zeichenSpieler)
                {
                    if (j < 4) // wagerecht
                    {
                        if (Spielfeld[i][j + 1] == zeichenSpieler && Spielfeld[i][j + 2] == zeichenSpieler )
                        {
                            if(Spielfeld[i][j + 3] == 'O')
                            {
                                for(int m = 5; m > i; m -- )
                                {
                                    if(Spielfeld[m][j + 3] == 'O')
                                    {

                                    }
                                    else
                                    {
                                        kannGewinnen = true;
                                        posyGewinn = i;
                                        posxGewinn = j + 3;
                                    }
                                }
                            }
                        }
                    }
                    else if (j > 3) // wagerecht
                    {
                        if (Spielfeld[i][j - 1] == zeichenSpieler && Spielfeld[i][j - 2] == zeichenSpieler )
                        {
                            if(Spielfeld[i][j - 3] == 'O')
                            {
                                for(int m = 5; m > i; m -- )
                                {
                                    if(Spielfeld[m][j - 3] == 'O')
                                    {

                                    }
                                    else
                                    {
                                        kannGewinnen = true;
                                        posyGewinn = i;
                                        posxGewinn = j - 3;
                                    }
                                }
                            }
                            else if(Spielfeld[i][j +1 ] == 'O')
                            {
                                for(int m = 5; m > i; m -- )
                                {
                                    if(Spielfeld[m][j + 1] == 'O')
                                    {

                                    }
                                    else
                                    {
                                        kannGewinnen = true;
                                        posyGewinn = i;
                                        posxGewinn = j + 1;
                                    }
                                }
                            }
                        }
                    }
                    if (i < 3)
                    {
                        // senkrecht
                        if (Spielfeld[i + 1][j] == zeichenSpieler && Spielfeld[i + 2][j] == zeichenSpieler )
                        {
                            if(Spielfeld[i + 3][j] == 'O')
                            {
                                kannGewinnen = true;
                                posyGewinn = i + 3;
                                posxGewinn = j;
                            }
                        }
                        else if (j < 3) //diagonal
                        {
                            if (Spielfeld[i + 1][j + 1] == zeichenSpieler && Spielfeld[i + 2][j + 2] == zeichenSpieler )
                            {
                                if(Spielfeld[i + 3][j + 3] == 'O')
                                {
                                    for(int m = 5; m > i; m -- )
                                    {
                                        if(Spielfeld[m][j + 3] == 'O')
                                        {

                                        }
                                        else
                                        {
                                            kannGewinnen = true;
                                            posyGewinn = i + 3;
                                            posxGewinn = j + 3;
                                        }
                                    }
                                }
                            }
                        }
                        else if (j == 3) //diagonal
                        {
                            if (Spielfeld[i + 1][j + 1] == zeichenSpieler && Spielfeld[i + 2][j + 2] == zeichenSpieler )
                            {
                                if(Spielfeld[i + 3][j + 3] == 'O')
                                {
                                    for(int m = 5; m > i; m -- )
                                    {
                                        if(Spielfeld[m][j + 3] == 'O')
                                        {

                                        }
                                        else
                                        {
                                            kannGewinnen = true;
                                            posyGewinn = i + 3;
                                            posxGewinn = j + 3;
                                        }
                                    }
                                }
                            }
                            else if (Spielfeld[i + 1][j - 1] == zeichenSpieler && Spielfeld[i + 2][j - 2] == zeichenSpieler )
                            {
                                if(Spielfeld[i + 3][j - 3] == 'O')
                                {
                                    for(int m = 5; m > i; m -- )
                                    {
                                        if(Spielfeld[m][j - 3] == 'O')
                                        {

                                        }
                                        else
                                        {
                                            kannGewinnen = true;
                                            posyGewinn = i + 3;
                                            posxGewinn = j - 3;
                                        }
                                    }
                                }
                            }
                        }
                        else if (j > 3)  //diagonal
                        {
                            if (Spielfeld[i + 1][j - 1] == zeichenSpieler && Spielfeld[i + 2][j - 2] == zeichenSpieler )
                            {
                                if(Spielfeld[i + 3][j - 3] == 'O')
                                {
                                    for(int m = 5; m > i; m -- )
                                    {
                                        if(Spielfeld[m][j - 3] == 'O')
                                        {

                                        }
                                        else
                                        {
                                            kannGewinnen = true;
                                            posyGewinn = i + 3;
                                            posxGewinn = j - 3;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    else if (i > 2)
                    {
                        // senkrecht
                        if (Spielfeld[i - 1][j] == zeichenSpieler && Spielfeld[i - 2][j] == zeichenSpieler)
                        {
                            if(Spielfeld[i - 3][j] == 'O')
                            {

                                posyGewinn = i - 3;
                                posxGewinn = j;
                                return true;
                            }
                        }
                        if (j < 3) //diagonal
                        {
                            if (Spielfeld[i - 1][j + 1] == zeichenSpieler && Spielfeld[i - 2][j + 2] == zeichenSpieler)
                            {
                                if(Spielfeld[i - 3][j + 3]  == 'O')
                                {
                                    for(int m = 5; m > i; m -- )
                                    {
                                        if(Spielfeld[m][j - 3] == 'O')
                                        {

                                        }
                                        else
                                        {
                                            kannGewinnen = true;
                                            posyGewinn = i - 3;
                                            posxGewinn = j + 3;
                                        }
                                    }
                                }
                            }
                        }
                        else if (j == 3) //diagonal
                        {
                            if (Spielfeld[i - 1][j + 1] == zeichenSpieler && Spielfeld[i - 2][j + 2] == zeichenSpieler)
                            {

                                    if(Spielfeld[i - 3][j + 3]  == 'O')
                                    {
                                        for(int m = 5; m > i; m -- )
                                        {
                                            if(Spielfeld[m][j - 3] == 'O')
                                            {

                                            }
                                            else
                                            {

                                                posyGewinn = i - 3;
                                                posxGewinn = j + 3;
                                                kannGewinnen = true;
                                            }
                                        }
                                    }

                            }
                            else if (Spielfeld[i - 1][j - 1] == zeichenSpieler && Spielfeld[i - 2][j - 2] == zeichenSpieler)
                            {

                                if (Spielfeld[i - 3][j - 3] == 'O')
                                {
                                    for (int m = 5; m > i; m--) {
                                        if (Spielfeld[m][j - 3] == 'O') {

                                        } else {
                                            kannGewinnen = true;
                                            posyGewinn = i - 3;
                                            posxGewinn = j - 3;
                                        }
                                    }
                                }
                            }

                        }
                        else if (j > 3) //diagonal
                        {
                            if (Spielfeld[i - 1][j - 1] == zeichenSpieler && Spielfeld[i - 2][j - 2] == zeichenSpieler )
                            {
                                if(Spielfeld[i - 3][j - 3]  == 'O')
                                {
                                    for(int m = 5; m > i; m -- )
                                    {
                                        if(Spielfeld[m][j - 3] == 'O')
                                        {

                                        }
                                        else
                                        {
                                            kannGewinnen = true;
                                            posyGewinn = i - 3;
                                            posxGewinn = j - 3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return kannGewinnen;
    }
    public static int getPosxGewinn()
    {
        return posxGewinn;
    }

}
