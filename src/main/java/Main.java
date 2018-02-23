import java.util.Scanner;

public class Main {
    public static final String BLACK_BOLD = "\033[1;30m";
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Spielfeld spielfeld = new Spielfeld();
        char[][] main_field = spielfeld.leeren();
        int zahl_spieler = 1;
        int anz_zug = 0;
        int anz_zug_einz = 0;
        int eins = 0;
        int zwei = 0;
        int am_Zug = 1;
        int ausw_gegner = 0;

        ausw_gegner = menue(); // Gegner soll ausgewählt werden
        clear(); // Konsole wird um 10 Einheiten nach oben leer ausgegeben
        if (ausw_gegner != 2 && ausw_gegner != 1) { // Überprüfen auf falsche Eingabe
            System.out.println("Falsche Eingabe !");
            return;
        }
        int auswahl_farbe_eins = auswahlFarbe(zahl_spieler); // Farben für Spieler werden in Zwischenspeichervariabeln gespeichert
        zahl_spieler++;
        clear();
        int auswahl_farbe_zwei = auswahlFarbe(zahl_spieler);
        clear();
        Spieler.spieler_erstellen(ausw_gegner, auswahl_farbe_eins, auswahl_farbe_zwei); //Zwei Spieler werden erstellt, Übergabe von Farbe und Auswahl des Gegners

        anz_zug = 1;
            if(ausw_gegner == 2)
            {
                KI.setDifficulty(KI_staerke());     //KI Stärke wird festgelegt
            }

            System.out.println("Das Spiel beginnt ! \n ");
            Spielfeld.zeichne_spielfeld(main_field, anz_zug, am_Zug, ausw_gegner); // Spielfeld wird gezeichnet
            while (anz_zug < 42) {
                if (am_Zug == 1) {
                    eins++;
                    anz_zug_einz = eins;    // Anzahl der Züge(Spielerbezogen)
                } else if (am_Zug == 2) {
                    zwei++;
                    anz_zug_einz = zwei;
                }
                main_field = Spieler.stein_einfuegen(am_Zug, anz_zug, main_field, anz_zug_einz,ausw_gegner); //Ein Stein wird eingefügt
                if (Gewinn.gewinn(main_field, am_Zug) == true) // Gewinnausgabe
                {
                    clear();
                    Animation.an_Gewinn();
                    clear();
                    Spielfeld.zeichne_spielfeld(main_field, anz_zug, am_Zug, ausw_gegner);
                    System.out.println(BLACK_BOLD + "Der Gewinner ist Spieler " + am_Zug);
                    System.out.println("Das Spiel ist vorbei !");
                    return;
                }
                am_Zug = Spieler.wechseln(am_Zug); // Spieler wechseln
                Spielfeld.zeichne_spielfeld(main_field, anz_zug, am_Zug, ausw_gegner); // Spielfeld wird gezeichnet
                anz_zug++; // Anzahl der Züge insgesamt wird hochgesetzt


            }
            System.out.println(BLACK_BOLD + "Alle Felder sind voll !");
            System.out.println("Das Spiel ist vorbei !");


    }

public static void clear()
{
    for(int i = 0; i<10;i++)    // Konsole um 10 Einheiten leer ausgeben
    {
        System.out.println("\n");
    }
}
    public static int menue()   // Menü - Gegnerauswahl
    {
        int auswahl_gegner;
        System.out.println(BLACK_BOLD + "\n\n           4 Gewinnt!\n\n");

        System.out.println("Wählen Sie gegen wen Sie spielen möchten:\n\n");
        System.out.println("1: Weiterer lokaler Spieler\n");
        System.out.println("2: Künstliche Intelligenz");
        auswahl_gegner = scan.nextInt();
        return auswahl_gegner;
    }

    public static int KI_staerke() // KI - Stärkeauswahl
    {

        System.out.println("Wählen Sie die Stärke der KI:");
        System.out.println("1: Einfach");
        System.out.println("2: Mittel");
        System.out.println("3: Schwer");
        System.out.println("4: Zufallszug");
        int dif = scan.nextInt();
        return dif;
    }
    public static int auswahlFarbe(int zahl_spieler) // Farbe für Spieler auswählen
    {
        int auswahl_Farbe = 0;

        System.out.println("Wählen sie eine Farbe für Spieler " + zahl_spieler);
        System.out.println("1: Grün");
        System.out.println("2: Rot");
        System.out.println("3: Gelb");
        System.out.println("4: Blau");
        System.out.println("5: Lila");
        System.out.println("6: Cyan");

        auswahl_Farbe = scan.nextInt();
        return auswahl_Farbe;
    }
}
