import java.util.Scanner;

public class Spieler {
    public static Scanner scan = new Scanner(System.in);
    public static int farbe;
    public static int fEins;
    public static int fZwei;
    public static int einfStellex;
    public static int einfStelley;

    public static int[][] farbfeld = new int[6][7];

    public static void spielerErstellen(int auswGegner, int auswFarbeEins, int auswFarbeZwei)
    {


        fEins = auswFarbeEins;
        fZwei = auswFarbeZwei;
        if(auswGegner == 1 )
        {


        }
    }
    public static char[][] steinEinfügen(int anDerReihe, int anzStein, char[][]spielfeld, int anzZugEinz, int difAusw)
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
                farbe = fEins;
            } else if (anDerReihe == 2) {
                zeichenSpieler = '@';
                farbe = fZwei;
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
                            return steinEinfügen(anDerReihe, anzStein, spielfeld, anzZugEinz, difAusw);
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
            return steinEinfügen(anDerReihe, anzStein, spielfeld, anzZugEinz, difAusw);
        }
    }

    public static boolean abfVoll()
    {
        if(einfStelley == -1)
        {
        System.out.println("Spalte voll !");
        return true;
        }
    return false;
    }

    public static int[][] getFarbfeld()
    {
        return farbfeld;
    }

    public static boolean kannGewinnen(char[][]Spielfeld, int amZug)
    {
        boolean spieler_gewinn = false;

        if(Gewinn.kannGewinnen(Spielfeld, amZug) == true)
        {
            spieler_gewinn = true;
            return spieler_gewinn;
        }
        return spieler_gewinn;
    }

    public static int wechseln(int am_Zug)
    {
        if(am_Zug == 1)
        {
            am_Zug = 2;
            return am_Zug;
        }
        else if(am_Zug == 2)
        {
            am_Zug = 1;
            return am_Zug;
        }
        return 0;
    }
}
