public class Gewinn
{
    public static int posxGewinn;
    public static boolean gewinn(char Spielfeld[][], int amZug)
    {
        char zeichenSpieler = 'D';
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
                            return true;
                        }
                    }
                    else if (j > 3) // wagerecht
                    {
                        if (Spielfeld[i][j - 1] == zeichenSpieler && Spielfeld[i][j - 2] == zeichenSpieler && Spielfeld[i][j - 3] == zeichenSpieler)
                        {
                            return true;
                        }
                    }
                    if (i < 3)
                    {
                        // senkrecht
                        if (Spielfeld[i + 1][j] == zeichenSpieler && Spielfeld[i + 2][j] == zeichenSpieler && Spielfeld[i + 3][j] == zeichenSpieler)
                        {
                            return true;
                        }
                        else if (j < 3) //diagonal
                        {
                            if (Spielfeld[i + 1][j + 1] == zeichenSpieler && Spielfeld[i + 2][j + 2] == zeichenSpieler && Spielfeld[i + 3][j + 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                        else if (j == 3) //diagonal
                        {
                            if (Spielfeld[i + 1][j + 1] == zeichenSpieler && Spielfeld[i + 2][j + 2] == zeichenSpieler && Spielfeld[i + 3][j + 3] == zeichenSpieler)
                            {
                                return true;
                            }
                            else if (Spielfeld[i + 1][j - 1] == zeichenSpieler && Spielfeld[i + 2][j - 2] == zeichenSpieler && Spielfeld[i + 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                        else if (j > 3)  //diagonal
                        {
                            if (Spielfeld[i + 1][j - 1] == zeichenSpieler && Spielfeld[i + 2][j - 2] == zeichenSpieler && Spielfeld[i + 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                    }

                    else if (i > 2)
                    {
                        // senkrecht
                        if (Spielfeld[i - 1][j] == zeichenSpieler && Spielfeld[i - 2][j] == zeichenSpieler && Spielfeld[i - 3][j] == zeichenSpieler)
                        {
                            return true;
                        }
                        if (j < 3) //diagonal
                        {
                            if (Spielfeld[i - 1][j + 1] == zeichenSpieler && Spielfeld[i - 2][j + 2] == zeichenSpieler && Spielfeld[i - 3][j + 3] == zeichenSpieler)
                            {

                            }
                        }
                        else if (j == 3) //diagonal
                        {
                            if (Spielfeld[i - 1][j + 1] == zeichenSpieler && Spielfeld[i - 2][j + 2] == zeichenSpieler && Spielfeld[i - 3][j + 3] == zeichenSpieler)
                            {
                                return true;
                            }
                            else if (Spielfeld[i - 1][j - 1] == zeichenSpieler && Spielfeld[i - 2][j - 2] == zeichenSpieler && Spielfeld[i - 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                        else if (j > 3) //diagonal
                        {
                            if (Spielfeld[i - 1][j - 1] == zeichenSpieler && Spielfeld[i - 2][j - 2] == zeichenSpieler && Spielfeld[i - 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }





    public static boolean kannGewinnen(char[][]Spielfeld, int amZug)
    {
        char zeichenSpieler = 0;
        char xEins, xZwei, xDrei,xVier;
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
                xEins = Spielfeld[i][j];
                //wagerecht
                if (j < 4)
                {

                    xZwei = Spielfeld[i][j + 1];
                    xDrei = Spielfeld[i][j + 2];
                    xVier = Spielfeld[i][j + 3];
                    switch (dreiGleich(xEins, xZwei, xDrei, xVier, zeichenSpieler))
                    {
                        case 1:
                            if (feldLegbar(Spielfeld, i, j) == true) {
                                posxGewinn = j;
                                return true;
                            }
                        case 2:
                            if (feldLegbar(Spielfeld, i, j + 1) == true) {
                                posxGewinn = j + 1;
                                return true;
                            }
                        case 3:
                            if (feldLegbar(Spielfeld, i, j + 2) == true) {
                                posxGewinn = j + 2;
                                return true;
                            }
                        case 4:
                            if (feldLegbar(Spielfeld, i, j + 3) == true) {
                                posxGewinn = j + 3;
                                return true;
                            }

                    }
                }
                // senkrecht
                if(i>2)
                {
                    if(Spielfeld[i][j] == zeichenSpieler && Spielfeld[i - 1][j] == zeichenSpieler && Spielfeld[i - 2][j] == zeichenSpieler)
                    {
                        if(Spielfeld[i - 3][j] == 'O')
                        {
                            posxGewinn = j;
                            return true;
                        }
                    }
                }

                //diagonal unten rechts & oben links
                if(i<3 && j < 4)
                {
                    xZwei = Spielfeld[i + 1][j + 1];
                    xDrei = Spielfeld[i + 2][j + 2];
                    xVier = Spielfeld[i + 3][j + 3];
                    switch (dreiGleich(xEins, xZwei, xDrei, xVier, zeichenSpieler))
                    {
                        case 1:
                            if (feldLegbar(Spielfeld, i, j) == true) {
                                posxGewinn = j;
                                return true;
                            }
                        case 2:
                            if (feldLegbar(Spielfeld, i + 1, j + 1) == true) {
                                posxGewinn = j + 1;
                                return true;
                            }
                        case 3:
                            if (feldLegbar(Spielfeld, i + 2, j + 2) == true) {
                                posxGewinn = j + 2;
                                return true;
                            }
                        case 4:
                            if (feldLegbar(Spielfeld, i + 3, j + 3) == true) {
                                posxGewinn = j + 3;
                                return true;
                            }

                    }
                }
                //diagonal unten links & oben rechts
                if(i>2 && j < 4)
                {
                    xZwei = Spielfeld[i - 1][j + 1];
                    xDrei = Spielfeld[i - 2][j + 2];
                    xVier = Spielfeld[i - 3][j + 3];
                    switch (dreiGleich(xEins, xZwei, xDrei, xVier, zeichenSpieler))
                    {
                        case 1:
                            if (feldLegbar(Spielfeld, i, j) == true) {
                                posxGewinn = j;
                                return true;
                            }
                        case 2:
                            if (feldLegbar(Spielfeld, i - 1, j + 1) == true) {
                                posxGewinn = j + 1;
                                return true;
                            }
                        case 3:
                            if (feldLegbar(Spielfeld, i - 2, j + 2) == true) {
                                posxGewinn = j + 2;
                                return true;
                            }
                        case 4:
                            if (feldLegbar(Spielfeld, i - 3, j + 3) == true) {
                                posxGewinn = j + 3;
                                return true;
                            }

                    }
                }








            }
        }
        return false;
    }
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
