import java.util.Scanner;

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
    public char[][] steinEinfügen(int anDerReihe, int anzStein, int anzZugEinz, int difAusw)
    {

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
                        return steinEinfügen(anDerReihe, anzStein,anzZugEinz, difAusw);
                    }

                }
                if (abfVoll() == false)
                {
                    spielfeld[einfStelley][einfStellex] = zeichenSpieler;
                    farbfeld[einfStelley][einfStellex] = farbe;
                }

            }


            return spielfeld;
        }
        else
        {
            System.out.println("Falsche Eingabe!");
            return steinEinfügen(anDerReihe, anzStein,anzZugEinz, difAusw);
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
