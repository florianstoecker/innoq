package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class Main {
    public static final String BLACK_BOLD = "\033[1;30m";
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Spielfeld Spielfeld = new Spielfeld();
        int zahlSpieler = 1;
        int anzZug = 0;
        int anzZugEinz = 0;
        int eins = 0;
        int zwei = 0;
        int amZug = 1;
        int auswGegner = 0;
        int staerke = 1;

        auswGegner = menue(); // Gegner soll ausgewählt werden
        clear(); // Konsole wird um 10 Einheiten nach oben leer ausgegeben
        if (auswGegner != 2 && auswGegner != 1) { // Überprüfen auf falsche Eingabe
            System.out.println("Falsche Eingabe !");
            main(args);
        }
        int auswFarbeEins = auswahlFarbe(zahlSpieler); // Farben für Spieler werden in Zwischenspeichervariabeln gespeichert
        zahlSpieler++;
        clear();
        int auswFarbeZwei = auswahlFarbe(zahlSpieler);
        clear();
        Spieler Spieler = new Spieler(auswFarbeEins, auswFarbeZwei); //Übergabe von Farbe und Auswahl des Gegners


        if(auswGegner == 2)
        {
            staerke = staerke();
            KI.setDifficulty(staerke);     //KI Stärke wird festgelegt
        }
        int hilfe_start = 0;
        amZug = auswBeginn();
        if (amZug == 1) {
             hilfe_start = 1;    // Anzahl der Züge(Spielerbezogen)
        } else if (amZug == 2) {
            hilfe_start = 2;
            }
        clear();
        System.out.println("Das Spiel beginnt !  ");
        Spielfeld.zeichneSpielfeld(anzZug); // Spielfeld wird gezeichnet
        anzZug = 1;
        while (anzZug < 43) {
            if (amZug == 1) {
                eins++;
                anzZugEinz = eins;    // Anzahl der Züge(Spielerbezogen)
            } else if (amZug == 2) {
                zwei++;
                anzZugEinz = zwei;
            }
            KI.setDifficulty(staerke);
            Spielfeld.steinEinfügen(hilfe_start,amZug, anzZug, anzZugEinz,auswGegner); //Ein Stein wird eingefügt
            if (Spielfeld.gewinn(amZug) == true) // Gewinnausgabe
            {
                Animation.an_Gewinn();
                clear();
                Spielfeld.zeichneSpielfeld(anzZug);
                System.out.println(BLACK_BOLD + "Der Gewinner ist Spieler " + amZug);
                System.out.println("Das Spiel ist vorbei !");
                if(nochmal() == 0)
                {
                    return;
                }

            }
            amZug = Spieler.wechseln(amZug); // Spieler wechseln
            Spielfeld.zeichneSpielfeld(anzZug); // Spielfeld wird gezeichnet
            anzZug++; // Anzahl der Züge insgesamt wird hochgesetzt
            KI.setDifficulty(staerke);
        }

        System.out.println(BLACK_BOLD + "Alle Felder sind voll ! Unentschieden!");
        System.out.println("Das Spiel ist vorbei !");


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
            main(another);

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

    private static int menue()   // Menü - Gegnerauswahl
    {
        int auswGegner;
        System.out.println(BLACK_BOLD + "\n\n           4 Gewinnt!\n\n");

        System.out.println("Wählen Sie gegen wen Sie spielen möchten:\n\n");
        System.out.println("1: Weiterer lokaler Spieler\n");
        System.out.println("2: Künstliche Intelligenz");
        auswGegner = scan.nextInt();
        return auswGegner;
    }
    private static int auswBeginn()
    {
        int amZug = 1;
        clear();
        System.out.println("Wer Soll anfangen ?");
        System.out.println("1: Spieler 1");
        System.out.println("2: Spieler 2");
        int auswAnfänger = scan.nextInt();
        if(auswAnfänger == 2){
            amZug = 2;
        }
        if(auswAnfänger != 2 && auswAnfänger != 1 )
        {
            clear();
            System.out.println("Falsche Eingabe!");
            return auswBeginn();
        }
        return amZug;
    }
    private static int staerke() // KI - Stärkeauswahl
    {
        System.out.println("Wählen Sie die Stärke der KI:");
        System.out.println("1: Einfach");
        System.out.println("2: Mittel");
        System.out.println("3: Schwer");
        System.out.println("4: Zufallszug");
        int dif = scan.nextInt();
        return dif;
    }
    private static int auswahlFarbe(int zahlSpieler) // Farbe für Spieler auswählen
    {
        int auswahlFarbe = 0;

        System.out.println("Wählen sie eine Farbe für Spieler " + zahlSpieler);
        System.out.println("1: Grün");
        System.out.println("2: Rot");
        System.out.println("3: Gelb");
        System.out.println("4: Blau");
        System.out.println("5: Lila");
        System.out.println("6: Cyan");

        auswahlFarbe = scan.nextInt();
        if(auswahlFarbe > 6 || auswahlFarbe < 1)
        {
            System.out.println("Falsche Eingabe!");
            return auswahlFarbe(zahlSpieler);
        }
        return auswahlFarbe;
    }
}
