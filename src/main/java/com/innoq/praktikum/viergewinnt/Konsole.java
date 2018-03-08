package com.innoq.praktikum.viergewinnt;

public class Konsole {
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String COLOR_RESET = "\u001B[0m";

    //Konstruktor
    public Konsole()
    {

    }

    //Methoden
    // Ausgabetexte
    public void gewonnen(int amZug)
    {
        System.out.println(BLACK_BOLD + "Der Gewinner ist Spieler " + amZug);
        System.out.println("Das Spiel ist vorbei !");
    }
    public static void clear()
    {
        for(int i = 0; i<10;i++)    // Konsole um 10 Einheiten leer ausgeben
        {
            System.out.println("\n");
        }
    }
    public static void nochmalText()
    {
        System.out.println("Möchten Sie noch einmal spielen ?");
        System.out.println("1: Ja!");
        System.out.println("2: Nein!");
    }
    public void gelegtText(int spaltenauswahl)
    {
        clear();
        System.out.println("Gewählt wurde" + BLACK_BOLD + " Spalte " + spaltenauswahl + COLOR_RESET);

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
        System.out.println("Wählen Sie gegen wen Sie spielen möchten(Spieler 2):\n\n");
        System.out.println("1: Weiterer lokaler Spieler\n");
        System.out.println("2: Künstliche Intelligenz");
    }
    public static void falscheEingabeText()
    {
        System.out.println(BLACK_BOLD + "Falsche Eingabe!" + COLOR_RESET);
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
    public static void macheZugText(int AnDerReihe, int anzZugEinz)
    {
        System.out.println("In welcher Spalte wollen Sie Ihren " + anzZugEinz + ". Stein fallen lassen ? (Spieler " + AnDerReihe + ")");

    }
    public static void staerkeAuswahlText()
    {
        System.out.println("Wählen Sie die Stärke der KI:");
        System.out.println("1: Zufallszug");
        System.out.println("2: Einfach(Eigene Steine belegen)");
        System.out.println("3: Mittel(kann gewinnen?/2 Felder in Verbindung zueinander?)");
        System.out.println("4: Schwer (MinMax");
    }
    public static void gewinnText(int anDerReihe)
    {
        Animation.an_Gewinn();
        System.out.println(BLACK_BOLD + "Der Gewinner ist Spieler " + anDerReihe + "!");
        System.out.println("Das Spiel ist zu Ende!");
    }
}
