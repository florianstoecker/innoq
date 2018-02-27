package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Spielfeld {

    public static final String COLOR_RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\033[0;97m";


    private int farbe;
    private int difficulty ;
    private int einfStellex;
    private int einfStelley;
    private int posxGewinn;
    private char[][] spielfeld;
    private int[][] farbfeld = new int[6][7];
    private Scanner scan = new Scanner(System.in);

    public Spielfeld() {
        spielfeld = init();
    }

    public void zeichneSpielfeld(int anzZug)
    {
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
        System.out.println("|---------------------------|" + COLOR_RESET);

    }

    public void steinEinfügen(int anDerReihe, int anzStein, int anzZugEinz, int difAusw)
    {
        KI ki = new KI();
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
            kiSteinEinfügen(anDerReihe);
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
    public void kiSteinEinfügen(int amZug)
    {
        difficulty = KI.getDifficulty();
        switch(difficulty)
        {
            case 1:
                eigenerStein();
                einfStellex = getPosxGewinn();
                difficulty = 4;
                break;
            case 2:


                if(kannGewinnen( 2) == true) { // Kann KI gewinnen ?
                    einfStellex = getPosxGewinn();
                }
                else if(kannGewinnen(1) == true) // Kann Spieler gewinnen ?
                {
                    einfStellex = getPosxGewinn();
                }
                difficulty = 1;
                break;
            case 3:
                if(kannGewinnen( 2) == true) { // Kann KI gewinnen ?
                    einfStellex = getPosxGewinn();
                }
                else if(kannGewinnen(1) == true) // Kann Spieler gewinnen ?
                {
                    einfStellex = getPosxGewinn();
                }

                break;

            case 4:
                einfStellex = (int)((Math.random()) * 7 + 1)-1;
                break;

        }
    }
    private char[][] init()
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

    public boolean gewinn(int amZug)
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

    public boolean kannGewinnen(int amZug)
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
                xEins = spielfeld[i][j];
                //wagerecht
                if (j < 4)
                {

                    xZwei = spielfeld[i][j + 1];
                    xDrei = spielfeld[i][j + 2];
                    xVier = spielfeld[i][j + 3];
                    switch (KI.dreiGleich(xEins, xZwei, xDrei, xVier, zeichenSpieler))
                    {
                        case 1:
                            if (feldLegbar(i, j) == true) {
                                posxGewinn = j;
                                return true;
                            }
                        case 2:
                            if (feldLegbar(i, j + 1) == true) {
                                posxGewinn = j + 1;
                                return true;
                            }
                        case 3:
                            if (feldLegbar(i, j + 2) == true) {
                                posxGewinn = j + 2;
                                return true;
                            }
                        case 4:
                            if (feldLegbar(i, j + 3) == true) {
                                posxGewinn = j + 3;
                                return true;
                            }

                    }
                }
                // senkrecht
                if(i>2)
                {
                    if(spielfeld[i][j] == zeichenSpieler && spielfeld[i - 1][j] == zeichenSpieler && spielfeld[i - 2][j] == zeichenSpieler)
                    {
                        if(spielfeld[i - 3][j] == 'O')
                        {
                            posxGewinn = j;
                            return true;
                        }
                    }
                }

                //diagonal unten rechts & oben links
                if(i<3 && j < 4)
                {
                    xZwei = spielfeld[i + 1][j + 1];
                    xDrei = spielfeld[i + 2][j + 2];
                    xVier = spielfeld[i + 3][j + 3];
                    switch (KI.dreiGleich(xEins, xZwei, xDrei, xVier, zeichenSpieler))
                    {
                        case 1:
                            if (feldLegbar(i, j) == true) {
                                posxGewinn = j;
                                return true;
                            }
                        case 2:
                            if (feldLegbar(i + 1, j + 1) == true) {
                                posxGewinn = j + 1;
                                return true;
                            }
                        case 3:
                            if (feldLegbar(i + 2, j + 2) == true) {
                                posxGewinn = j + 2;
                                return true;
                            }
                        case 4:
                            if (feldLegbar(i + 3, j + 3) == true) {
                                posxGewinn = j + 3;
                                return true;
                            }

                    }
                }
                //diagonal unten links & oben rechts
                if(i>2 && j < 4)
                {
                    xZwei = spielfeld[i - 1][j + 1];
                    xDrei = spielfeld[i - 2][j + 2];
                    xVier = spielfeld[i - 3][j + 3];
                    switch (KI.dreiGleich(xEins, xZwei, xDrei, xVier, zeichenSpieler))
                    {
                        case 1:
                            if (feldLegbar(i, j) == true) {
                                posxGewinn = j;
                                return true;
                            }
                        case 2:
                            if (feldLegbar(i - 1, j + 1) == true) {
                                posxGewinn = j + 1;
                                return true;
                            }
                        case 3:
                            if (feldLegbar(i - 2, j + 2) == true) {
                                posxGewinn = j + 2;
                                return true;
                            }
                        case 4:
                            if (feldLegbar(i - 3, j + 3) == true) {
                                posxGewinn = j + 3;
                                return true;
                            }

                    }
                }








            }
        }
        return false;
    }
    
    private boolean feldLegbar(int Stellex, int Stelley)
    {
        boolean feldLegbar = false;
        if(spielfeld[Stellex][Stelley] == 'O') {
            if (Stellex == 5) {
                return true;
            } else {
                for (int m = 5; m > Stellex; m --) {
                    if (spielfeld[m][Stelley] == 'O') {
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

    private void eigenerStein()
    {
        boolean feldLegbar = false;
        for(int i = 5; i>= 1; i--)//senkrecht auf eigenen Stein
        {

            for(int j = 0; j<7; j++)
            {
                if(i >2) {
                    if (spielfeld[i][j] == '@' && spielfeld[i - 1][j] == 'O') {
                        einfStellex = j;
                    }
                }
            }
        }

        for(int i = 5; i>= 0; i--) //wagerecht neben eigenen Stein
        {

            for(int j = 0; j<7; j++)
            {
                if(spielfeld[i][j] == '@' && j>0 && spielfeld[i][j-1] == 'O' ) // links neben eigenen Stein
                {

                    int help_i = i;

                    if(i == 5)
                    {
                        einfStellex = j-1;
                    }

                    else  if(help_i < 5)
                    {
                        for (int m = 5; m > i; m--) {
                            if (spielfeld[m][j - 1] == 'O') {
                                feldLegbar = false;
                            }
                            else {
                                feldLegbar = true;
                            }

                        }
                        if (feldLegbar == true)
                        {
                            einfStellex = j - 1;
                        }
                    }

                }
                else if(spielfeld[i][j] == '@' && j<6&& spielfeld[i][j+1] == 'O') // rechts neben eigenen Stein
                {

                    int help_i_ = i;
                    if(i == 5)
                    {
                        einfStellex = j+1;
                    }
                    else  if(help_i_ < 5)
                    {
                        for (int m = 5; m > i; m--) {
                            if (spielfeld[m][j + 1] == 'O') {
                                feldLegbar = false;
                            }
                            else {
                                feldLegbar = true;
                            }

                        }
                        if (feldLegbar == true)
                        {
                            einfStellex = j + 1;
                        }
                    }
                }
            }
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
    public int getPosxGewinn() {
    return posxGewinn;
    }

    public void schreiben(String eingabe)
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
}