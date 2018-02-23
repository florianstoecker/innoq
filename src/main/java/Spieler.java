import java.util.Scanner;

public class Spieler {
    public static Scanner scan = new Scanner(System.in);
    public static int farbe;
    public static int feins;
    public static int fzwei;
    public static int einf_stellex;
    public static int einf_stelley;
    public static int[][] farbfeld = new int[6][7];

    public static void spieler_erstellen(int ausw_gegner, int ausw_farbe_eins, int ausw_farbe_zwei)
    {


        feins = ausw_farbe_eins;
        fzwei = ausw_farbe_zwei;
        if(ausw_gegner == 1 )
        {


        }
    }
    public static char[][] stein_einfuegen(int anDerReihe, int anzStein, char[][]spielfeld, int anz_zug_einz, int dif_ausw)
    {

        char zeichen_spieler = 'O';

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


        if(dif_ausw == 2 && anDerReihe == 2)
        {
            einf_stellex = KI.KI_stein_einfügen(spielfeld);
            int KI_ausw_spalte = einf_stellex +1;
            System.out.println("Die KI nahm Spalte " + KI_ausw_spalte);
        }
        else
        {
            System.out.println("In welcher Spalte wollen Sie Ihren " + anz_zug_einz + ". Stein fallen lassen ? (Spieler " + anDerReihe + ")");
            einf_stellex = scan.nextInt() - 1;
        }
        einf_stelley = 5;
        if(einf_stellex >= 0 && einf_stellex < 7)
        {

            if (anDerReihe == 1) {
                zeichen_spieler = 'X';
                farbe = feins;
            } else if (anDerReihe == 2) {
                zeichen_spieler = '@';
                farbe = fzwei;
            }

            if (spielfeld[einf_stelley][einf_stellex] == 'O')
            {
                spielfeld[einf_stelley][einf_stellex] = zeichen_spieler;
                farbfeld[einf_stelley][einf_stellex] = farbe;

            }
                else
                {
                    while (spielfeld[einf_stelley][einf_stellex] == 'X' || spielfeld[einf_stelley][einf_stellex] == '@')
                    {
                        einf_stelley--;
                        if (abf_voll() == true)
                        {
                            return stein_einfuegen(anDerReihe, anzStein, spielfeld, anz_zug_einz, dif_ausw);
                        }

                    }
                     if (abf_voll() == false)
                    {
                        spielfeld[einf_stelley][einf_stellex] = zeichen_spieler;
                        farbfeld[einf_stelley][einf_stellex] = farbe;
                    }

                }


            return spielfeld;
        }
        else
        {
            System.out.println("Falsche Eingabe!");
            return stein_einfuegen(anDerReihe, anzStein, spielfeld, anz_zug_einz, dif_ausw);
        }
    }

    public static boolean abf_voll()
    {
        if(einf_stelley == -1)
        {
        System.out.println("Spalte voll !");
        return true;
        }
    return false;
    }

    public static int[][] getfarbfeld()
    {
        return farbfeld;
    }

    public static int getEinf_stellex()
    {
        return einf_stellex;
    }

    public static int getEinf_stelley()
    {
        return einf_stelley;
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
