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
        boolean feldLegbar = false;
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
                if (Spielfeld[i][j] == zeichenSpieler) {


                    if (j < 4) // wagerecht
                    {
                        if (Spielfeld[i][j + 1] == zeichenSpieler && Spielfeld[i][j + 2] == zeichenSpieler )
                        {
                            if(j > 0)
                            {
                                if(Spielfeld[i][j - 1] == 'O')
                                {
                                    for (int m = 5; m > i; m--) {
                                        if (Spielfeld[m][j - 1] == 'O') {
                                            feldLegbar = false;
                                        }
                                        else {
                                            feldLegbar = true;
                                        }

                                    }
                                    if (feldLegbar == true)
                                    {
                                        posxGewinn = j - 1;
                                        return true;

                                    }
                                }
                            }
                            if(Spielfeld[i][j + 3] == 'O')
                            {
                                if(i == 0)
                                {
                                    posxGewinn = j + 3;
                                    return true;
                                }
                                for (int m = 5; m > i; m--) {
                                    if (Spielfeld[m][j + 3] == 'O') {
                                        feldLegbar = false;
                                    }
                                    else {
                                        feldLegbar = true;
                                    }

                                }
                                if (feldLegbar == true)
                                {
                                    posxGewinn = j + 3;
                                    return true;

                                }
                            }
                        }
                    }
                    else if (j > 3) // wagerecht
                    {
                        if (Spielfeld[i][j - 1] == zeichenSpieler && Spielfeld[i][j - 2] == zeichenSpieler )
                        {

                                if(i == 0)
                                {
                                    posxGewinn = j - 3;
                                    return true;
                                }
                                if(Spielfeld[i][j - 3] == 'O')
                                {
                                    for (int m = 5; m > i; m--) {
                                        if (Spielfeld[m][j - 3] == 'O') {
                                            feldLegbar = false;
                                        }
                                        else {
                                            feldLegbar = true;
                                        }

                                    }
                                    if (feldLegbar == true)
                                    {
                                        posxGewinn = j - 3;
                                        return true;

                                    }
                                }
                            if(j < 6) {


                                if (Spielfeld[i][j + 1] == 'O') {
                                    for (int m = 5; m > i; m--) {
                                        if (Spielfeld[m][j + 1] == 'O') {
                                            feldLegbar = false;
                                        } else {
                                            feldLegbar = true;
                                        }

                                    }
                                    if (feldLegbar == true) {
                                        posxGewinn = j + 1;
                                        return true;

                                    }
                                }
                            }
                        }
                    }
                    if(i<3)
                    {
                        if(Spielfeld[i + 1][j] == zeichenSpieler && Spielfeld[i + 2][j] == zeichenSpieler)
                        {
                            if(Spielfeld[i - 1][j] == 'O')
                            {
                                posxGewinn = j;
                                return true;
                            }
                        }
                    }
                    else if (i > 2) {
                        if (Spielfeld[i - 1][j] == zeichenSpieler && Spielfeld[i - 2][j] == zeichenSpieler)
                        {
                            if(Spielfeld[i - 3][j] == 'O')
                            {
                                posxGewinn = j;
                                return true;
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
