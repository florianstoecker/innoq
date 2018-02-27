import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Spielfeld {
    public static final String color_RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\033[0;97m";;
    public static int farbe;
    public static int einfStellex;
    public static int einfStelley;
    public static int posxGewinn;
    public static char[][] spielfeld = leeren();
    public static int[][] farbfeld = new int[6][7];
    public static Scanner scan = new Scanner(System.in);

    public void zeichneSpielfeld(int anzZug)
    {

        spielfeld = Main.getMainField();


        System.out.println(BLACK + "|---------------------------|");
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        for(int i = 0; i<6; i++)
        {
            System.out.println(BLACK + "|---------------------------|");
            System.out.print("|");
            for(int j = 0; j<7; j++)
            {


                int farbe = farbfeld[i][j];
                if(anzZug == 0)
                {
                    System.out.printf(WHITE + " %c ", spielfeld[i][j]);
                    System.out.print(BLACK + "|");
                }
                else
                {
                    if (farbe != 0)
                    {
                        switch(farbe)
                        {
                            case 1:
                                System.out.printf(GREEN + " %c ", spielfeld[i][j]);
                                System.out.print(BLACK + "|"); break;
                            case 2:
                                System.out.printf(RED + " %c ", spielfeld[i][j]);
                                System.out.print(BLACK + "|"); break;
                            case 3:
                                System.out.printf(YELLOW + " %c ", spielfeld[i][j]);
                                System.out.print(BLACK + "|"); break;
                            case 4:
                                System.out.printf(BLUE + " %c ", spielfeld[i][j]);
                                System.out.print(BLACK + "|"); break;
                            case 5:
                                System.out.printf(PURPLE + " %c ", spielfeld[i][j]);
                                System.out.print(BLACK + "|"); break;
                            case 6:
                                System.out.printf(CYAN + " %c ", spielfeld[i][j]);
                                System.out.print(BLACK + "|"); break;
                        }

                    }
                        else
                        {
                        System.out.printf(WHITE + " %c ", spielfeld[i][j]);
                        System.out.print(BLACK + "|");
                        }
                }



            }
            System.out.println("");
        }
        System.out.println("|---------------------------|" + color_RESET);

    }
    public void steinEinfügen(int anDerReihe, int anzStein, int anzZugEinz, int difAusw)
    {
        String eingabeSpeichern;
        char zeichenSpieler = 'O';

        if(anzStein ==1)
        {
            for(int i = 0; i<7; i++)
            {
                for(int j = 0; j<6; j++)
                {
                    farbfeld[j][i] = 0;
                }
            }
        }


        if(difAusw == 2 && anDerReihe == 2)
        {
            einfStellex = KI.steinEinfügen(spielfeld, anDerReihe);
            int KI_ausw_spalte = einfStellex +1;
            System.out.println("Die KI nahm Spalte " + KI_ausw_spalte);
        }
        else
        {
            System.out.println("In welcher Spalte wollen Sie Ihren " + anzZugEinz + ". Stein fallen lassen ? (Spieler " + anDerReihe + ")");
            einfStellex = scan.nextInt() - 1;
            Main.clear();
        }
        einfStelley = 5;
        if(einfStellex >= 0 && einfStellex < 7)
        {

            if (anDerReihe == 1) {
                zeichenSpieler = 'X';
                farbe = Spieler.getfEins();
            } else if (anDerReihe == 2) {
                zeichenSpieler = '@';
                farbe = Spieler.getfZwei();
            }

            if (spielfeld[einfStelley][einfStellex] == 'O')
            {
                spielfeld[einfStelley][einfStellex] = zeichenSpieler;
                farbfeld[einfStelley][einfStellex] = farbe;

            }
            else
            {
                while (spielfeld[einfStelley][einfStellex] == 'X' || spielfeld[einfStelley][einfStellex] == '@')
                {
                    einfStelley--;
                    if (abfVoll() == true)
                    {
                        steinEinfügen(anDerReihe, anzStein,anzZugEinz, difAusw);
                    }

                }
                if (abfVoll() == false)
                {
                    spielfeld[einfStelley][einfStellex] = zeichenSpieler;
                    farbfeld[einfStelley][einfStellex] = farbe;
                }

            }
            eingabeSpeichern = Integer.toString(einfStellex);
            schreiben(eingabeSpeichern);
        }
        else
        {
            System.out.println("Falsche Eingabe!");
            steinEinfügen(anDerReihe, anzStein,anzZugEinz, difAusw);
        }
    }
    public static boolean gewinn(int amZug)
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
                if (spielfeld[i][j] == zeichenSpieler)
                {
                    if (j < 4) // wagerecht
                    {
                        if (spielfeld[i][j + 1] == zeichenSpieler && spielfeld[i][j + 2] == zeichenSpieler && spielfeld[i][j + 3] == zeichenSpieler)
                        {
                            return true;
                        }
                    }
                    else if (j > 3) // wagerecht
                    {
                        if (spielfeld[i][j - 1] == zeichenSpieler && spielfeld[i][j - 2] == zeichenSpieler && spielfeld[i][j - 3] == zeichenSpieler)
                        {
                            return true;
                        }
                    }
                    if (i < 3)
                    {
                        // senkrecht
                        if (spielfeld[i + 1][j] == zeichenSpieler && spielfeld[i + 2][j] == zeichenSpieler && spielfeld[i + 3][j] == zeichenSpieler)
                        {
                            return true;
                        }
                        else if (j < 3) //diagonal
                        {
                            if (spielfeld[i + 1][j + 1] == zeichenSpieler && spielfeld[i + 2][j + 2] == zeichenSpieler && spielfeld[i + 3][j + 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                        else if (j == 3) //diagonal
                        {
                            if (spielfeld[i + 1][j + 1] == zeichenSpieler && spielfeld[i + 2][j + 2] == zeichenSpieler && spielfeld[i + 3][j + 3] == zeichenSpieler)
                            {
                                return true;
                            }
                            else if (spielfeld[i + 1][j - 1] == zeichenSpieler && spielfeld[i + 2][j - 2] == zeichenSpieler && spielfeld[i + 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                        else if (j > 3)  //diagonal
                        {
                            if (spielfeld[i + 1][j - 1] == zeichenSpieler && spielfeld[i + 2][j - 2] == zeichenSpieler && spielfeld[i + 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                    }

                    else if (i > 2)
                    {
                        // senkrecht
                        if (spielfeld[i - 1][j] == zeichenSpieler && spielfeld[i - 2][j] == zeichenSpieler && spielfeld[i - 3][j] == zeichenSpieler)
                        {
                            return true;
                        }
                        if (j < 3) //diagonal
                        {
                            if (spielfeld[i - 1][j + 1] == zeichenSpieler && spielfeld[i - 2][j + 2] == zeichenSpieler && spielfeld[i - 3][j + 3] == zeichenSpieler)
                            {

                            }
                        }
                        else if (j == 3) //diagonal
                        {
                            if (spielfeld[i - 1][j + 1] == zeichenSpieler && spielfeld[i - 2][j + 2] == zeichenSpieler && spielfeld[i - 3][j + 3] == zeichenSpieler)
                            {
                                return true;
                            }
                            else if (spielfeld[i - 1][j - 1] == zeichenSpieler && spielfeld[i - 2][j - 2] == zeichenSpieler && spielfeld[i - 3][j - 3] == zeichenSpieler)
                            {
                                return true;
                            }
                        }
                        else if (j > 3) //diagonal
                        {
                            if (spielfeld[i - 1][j - 1] == zeichenSpieler && spielfeld[i - 2][j - 2] == zeichenSpieler && spielfeld[i - 3][j - 3] == zeichenSpieler)
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
    public static void schreiben(String eingabe)
    {
        try
        {
        PrintWriter writer = new PrintWriter(new FileWriter("/Users/user/Documents/GitHub/innoq/src/main/java/Eingabe.txt"));
        writer.println(eingabe);
        writer.println();
        writer.print("neu");
        writer.close();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }

    public boolean abfVoll()
    {
        if(einfStelley == -1)
        {
            System.out.println("Spalte voll !");
            return true;
        }
        return false;
    }

    public static char[][] leeren()
    {
        char[][] spielfeld = new char[6][7];
        for(int i = 0; i<6; i++)
        {
            for(int j = 0; j<7; j++)
            {
                spielfeld[i][j] = 'O';
            }
        }
        return spielfeld;
    }
}
