package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class Konsole {
    private static int auswahlFarbeZwei;
    private static int auswahlFarbeEins;
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\033[0;97m";
    private static boolean ersterZug = true;
    private static int amZug;
    private static int auswahlGegner;
    private static int anzZugEinz;
    public static Scanner scan = new Scanner(System.in);


    public static int gegnerAuswahl()   // Menü - Gegnerauswahl
    {

        gegnerAuswahlText();
        auswahlGegner = scan.nextInt();
        if(auswahlGegner != 2 && auswahlGegner != 1 )
        {
            clear();
            falscheEingabeText();
            return gegnerAuswahl();
        }
        return auswahlGegner;
    }
    public static void auswahlBeginn(Spielfeld spielfeld)
    {
        amZug = 1;
        clear();
        auswahlBeginnText();
        int auswAnfänger = scan.nextInt();
        if(auswAnfänger == 2){
            amZug = 2;
        }
        spielfeld.setAnDerReihe(auswAnfänger);
        if(auswAnfänger != 2 && auswAnfänger != 1 )
        {
            clear();
            falscheEingabeText();
            auswahlBeginn(spielfeld);
            return;
        }
    }
    public static void farbeAuswaehlen()
    {
        int zahlSpieler = 1;
        auswahlFarbeEins = auswahlFarbe(zahlSpieler); // Farben für Spieler werden in Zwischenspeichervariabeln gespeichert
        zahlSpieler++;
        clear();
        auswahlFarbeZwei = auswahlFarbe(zahlSpieler);
        clear();//Übergabe von Farbe und Auswahl des Gegners
    }
    public static boolean spalteVoll(int reihe)
    {
        if(reihe == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int getAuswahlFarbeZwei()
    {
        return auswahlFarbeZwei;
    }
    public static int getAuswahlFarbeEins()
    {
        return auswahlFarbeEins;
    }
    public static int staerkeAuswahl() // KI - Stärkeauswahl
    {
        staerkeAuswahlText();
        int dif = scan.nextInt();
        if(dif>0 && dif <5)
        {
            return dif;
        }
        return staerkeAuswahl();
    }
    public static void andereAbfragen(Spielfeld spielfeld)
    {
        auswahlBeginn(spielfeld);
        farbeAuswaehlen();
        clear();
        spielBeginnText();
        zeichneSpielfeld(spielfeld);

    }
    public int getBeginner()
    {
        return amZug;
    }
    public static void zeichneSpielfeld(Spielfeld spielfeld)
    {
        System.out.println(BLACK + "|---------------------------|");
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        for(int i = 0; i<6; i++)
        {
            System.out.println(BLACK + "|---------------------------|");
            System.out.print("|");
            for(int j = 0; j<7; j++)
            {


                int farbe = spielfeld.getZeichenAusFarbfeld(i,j);
                if(ersterZug == true)
                {
                    System.out.printf(WHITE + " %c ", spielfeld.getZeichenAusSpielfeld(i,j));
                    System.out.print(BLACK + "|");

                }
                else
                {

                        switch(farbe)
                        {
                            case 0:
                                System.out.printf(WHITE + " %c ", spielfeld.getZeichenAusSpielfeld(i,j));
                                System.out.print(BLACK + "|");break;
                            case 1:
                                System.out.printf(GREEN + " %c ", spielfeld.getZeichenAusSpielfeld(i,j));
                                System.out.print(BLACK + "|"); break;
                            case 2:
                                System.out.printf(RED + " %c ", spielfeld.getZeichenAusSpielfeld(i,j));
                                System.out.print(BLACK + "|"); break;
                            case 3:
                                System.out.printf(YELLOW + " %c ", spielfeld.getZeichenAusSpielfeld(i,j));
                                System.out.print(BLACK + "|"); break;
                            case 4:
                                System.out.printf(BLUE + " %c ", spielfeld.getZeichenAusSpielfeld(i,j));
                                System.out.print(BLACK + "|"); break;
                            case 5:
                                System.out.printf(PURPLE + " %c ", spielfeld.getZeichenAusSpielfeld(i,j));
                                System.out.print(BLACK + "|"); break;
                            case 6:
                                System.out.printf(CYAN + " %c ", spielfeld.getZeichenAusSpielfeld(i,j));
                                System.out.print(BLACK + "|"); break;
                        }





                }



            }
            System.out.println("");
        }
        System.out.println("|---------------------------|" + COLOR_RESET);
        ersterZug = false;

    }
    public void gewonnen(int amZug)
    {
        System.out.println(BLACK_BOLD + "Der Gewinner ist Spieler " + amZug);
        System.out.println("Das Spiel ist vorbei !");
    }
    public static int auswahlFarbe(int zahlSpieler) // Farbe für Spieler auswählen
    {
        int auswahlFarbe = 0;
        auswahlFarbeText(zahlSpieler);
        auswahlFarbe = scan.nextInt();
        if(auswahlFarbe > 6 || auswahlFarbe < 1)
        {
            falscheEingabeText();
            return auswahlFarbe(zahlSpieler);
        }
        return auswahlFarbe;
    }
    private static KIGegner kiErstellen(int kiStaerke)
    {
        switch(kiStaerke)
        {
            case 1: return new KIGegnerStaerkeEins();

            case 2: return new KIGegnerStaerkeZwei();

            case 3: return new KIGegnerStaerkeDrei();

            case 4: return new KIGegnerStaerkeVier();

        }
        return null;
    }
    public static Spieler spielerZweiAuswaehlen()
    {
        if (auswahlGegner == 2)
        {
            return kiErstellen(staerkeAuswahl());
        }
        if(auswahlGegner == 1)
        {
            return new LokalerSpieler();
        }
        return null;
    }
    private static int nochmal()
    {
        System.out.println("Möchten Sie noch einmal spielen ?");
        System.out.println("1: Ja!");
        System.out.println("2: Nein!");
        int nochmal = scan.nextInt();
        if (nochmal == 1) {
            String[] another = new String[5];
            clear();
        } else if (nochmal == 2)
        {
            return 0;
        }
        return 0;
    }
    public static void clear()
    {
        for(int i = 0; i<10;i++)    // Konsole um 10 Einheiten leer ausgeben
        {
            System.out.println("\n");
        }
    }

    // Ausgabetexte
    public static void kiGelegtText(int KIAuswahl)
    {
        System.out.println("Die KI nahm Spalte " + KIAuswahl);
    }
    public static void spalteVollText(int spalte)
    {
        System.out.println("Spalte " + spalte + " ist voll!");
    }
    public static void auswahlBeginnText()
    {
        System.out.println("Wer Soll anfangen ?");
        System.out.println("1: Spieler 1");
        System.out.println("2: Spieler 2");
    }
    public static void gegnerAuswahlText()
    {
        System.out.println(BLACK_BOLD + "\n\n           4 Gewinnt!\n\n");
        System.out.println("Wählen Sie gegen wen Sie spielen möchten:\n\n");
        System.out.println("1: Weiterer lokaler Spieler\n");
        System.out.println("2: Künstliche Intelligenz");
    }
    public static void falscheEingabeText()
    {
        System.out.println("Falsche Eingabe!");
    }
    public static void spielBeginnText()
    {
        System.out.println("Das Spiel beginnt !  ");
    }
    public static void auswahlFarbeText(int zahlSpieler)
    {
        System.out.println("Wählen sie eine Farbe für Spieler " + zahlSpieler);
        System.out.println("1: Grün");
        System.out.println("2: Rot");
        System.out.println("3: Gelb");
        System.out.println("4: Blau");
        System.out.println("5: Lila");
        System.out.println("6: Cyan");
    }
    public static int macheZugText(Spielfeld spielfeld)
    {
        System.out.println("In welcher Spalte wollen Sie Ihren " + anzZugEinz + ". Stein fallen lassen ? (Spieler " + spielfeld.getAnDerReihe() + ")");
            int spalte = scan.nextInt() - 1;
            return spalte;
    }
    public static void staerkeAuswahlText()
    {
        System.out.println("Wählen Sie die Stärke der KI:");
        System.out.println("1: Einfach");
        System.out.println("2: Mittel");
        System.out.println("3: Schwer");
        System.out.println("4: Zufallszug");
    }

    public static void gewinnText(Spielfeld spielfeld, int  anDerReihe)
    {
        Animation.an_Gewinn();
        zeichneSpielfeld(spielfeld);
        System.out.println("Der Gewinner ist Spieler " + anDerReihe + "!");
        System.out.println("Das Spiel ist zu Ende!");
    }
}
