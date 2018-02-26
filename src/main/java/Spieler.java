import java.util.Scanner;

public class Spieler {
    public static Scanner scan = new Scanner(System.in);
    public static int fEins;
    public static int fZwei;

    public static void spielerErstellen(int auswFarbeEins, int auswFarbeZwei)
    {


        fEins = auswFarbeEins;
        fZwei = auswFarbeZwei;
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
    public static int getfEins()
    {
        return fEins;
    }
    public static int getfZwei()
    {
        return fZwei;
    }
}
