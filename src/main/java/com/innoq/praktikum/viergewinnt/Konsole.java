package com.innoq.praktikum.viergewinnt;

public class Konsole {
    private static final String BLACK_BOLD = "\033[1;30m";
    private static final String COLOR_RESET = "\u001B[0m";

    //Konstruktor
    public Konsole()
    {

    }

    //Methoden
    // Ausgabetexte
    public void gewonnen(int amZug)
    {
        System.out.println(BLACK_BOLD + "Der Gewinner ist Spieler " + amZug);
        System.out.println("Das Spiel ist vorbei !"+COLOR_RESET);
    }
    public void clear()
    {
        for(int i = 0; i<10;i++)    // Konsole um 10 Einheiten leer ausgeben
        {
            System.out.println("\n");
        }
    }
    public void nochmalText()
    {
        System.out.println(BLACK_BOLD +"Möchten Sie noch einmal spielen ?");
        System.out.println("1: Ja!");
        System.out.println("2: Nein!"+COLOR_RESET);
    }
    public void gelegtText(int spaltenauswahl)
    {
        clear();
        System.out.println("Gewählt wurde" + BLACK_BOLD + " Spalte " + spaltenauswahl + COLOR_RESET);

    }
    public void feldVollText()
    {
        System.out.println(BLACK_BOLD +"Das Feld ist voll!"+COLOR_RESET);
    }
    public void spalteVollText(int spalte)
    {
        System.out.println(BLACK_BOLD +"Spalte " + spalte + " ist voll!"+COLOR_RESET);
    }
    public void auswahlBeginnText()
    {
        System.out.println(BLACK_BOLD +"Wer Soll anfangen ?");
        System.out.println("1: Spieler 1");
        System.out.println("2: Spieler 2"+COLOR_RESET);
    }
    public void gegnerAuswahlText()
    {
        System.out.println(BLACK_BOLD + "\n\n           4 Gewinnt!\n\n");
        System.out.println("Wählen Sie gegen wen Sie spielen möchten(Spieler 2):\n\n");
        System.out.println("1: Weiterer lokaler Spieler\n");
        System.out.println("2: Künstliche Intelligenz"+COLOR_RESET);
    }
    public void falscheEingabeText()
    {
        System.out.println(BLACK_BOLD + "Falsche Eingabe!" + COLOR_RESET);
    }
    public void spielBeginnText()
    {
        System.out.println(BLACK_BOLD +"Das Spiel beginnt !"+COLOR_RESET);
    }
    public void auswahlFarbeText(int zahlSpieler)
    {
        System.out.println(BLACK_BOLD +"Wählen sie eine Farbe für Spieler " + zahlSpieler);
        System.out.println("1: Grün");
        System.out.println("2: Rot");
        System.out.println("3: Gelb");
        System.out.println("4: Blau");
        System.out.println("5: Lila");
        System.out.println("6: Cyan"+COLOR_RESET);
    }
    public void macheZugText(int currentUser, int anzZugEinz)
    {
        System.out.println(BLACK_BOLD +"In welcher Spalte wollen Sie Ihren " + anzZugEinz + ". Stein fallen lassen ? (Spieler " + currentUser + ")"+COLOR_RESET);

    }
    public void staerkeAuswahlText()
    {
        System.out.println(BLACK_BOLD +"Wählen Sie die Stärke der KI:");
        System.out.println("1: Zufallszug");
        System.out.println("2: Einfach(Eigene Steine belegen)");
        System.out.println("3: Mittel(kann gewinnen?/2 Felder in Verbindung zueinander?)");
        System.out.println("4: Schwer (MinMax"+COLOR_RESET);
    }
    public void gewinnText(int anDerReihe)
    {
        Animation.an_Gewinn();
        System.out.println(BLACK_BOLD + "Der Gewinner ist Spieler " + anDerReihe + "!");
        System.out.println("Das Spiel ist zu Ende!"+COLOR_RESET);
    }
}
