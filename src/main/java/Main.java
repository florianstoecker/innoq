import java.util.Scanner;

public class Main {
    public  static char[][] mainField = Spielfeld.leeren();
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

        auswGegner = menue(); // Gegner soll ausgewählt werden
        clear(); // Konsole wird um 10 Einheiten nach oben leer ausgegeben
        if (auswGegner != 2 && auswGegner != 1) { // Überprüfen auf falsche Eingabe
            System.out.println("Falsche Eingabe !");
            return;
        }
        int auswFarbeEins = auswahlFarbe(zahlSpieler); // Farben für Spieler werden in Zwischenspeichervariabeln gespeichert
        zahlSpieler++;
        clear();
        int auswFarbeZwei = auswahlFarbe(zahlSpieler);
        clear();
        Spieler.spielerErstellen(auswFarbeEins, auswFarbeZwei); //Zwei Spieler werden erstellt, Übergabe von Farbe und Auswahl des Gegners

        anzZug = 1;
            if(auswGegner == 2)
            {
                KI.setDifficulty(staerke());     //KI Stärke wird festgelegt
            }

            System.out.println("Das Spiel beginnt ! \n ");
            Spielfeld.zeichneSpielfeld(anzZug); // Spielfeld wird gezeichnet
            while (anzZug < 43) {
                if (amZug == 1) {
                    eins++;
                    anzZugEinz = eins;    // Anzahl der Züge(Spielerbezogen)
                } else if (amZug == 2) {
                    zwei++;
                    anzZugEinz = zwei;
                }
                mainField = Spielfeld.steinEinfügen(amZug, anzZug, anzZugEinz,auswGegner); //Ein Stein wird eingefügt
                if (Gewinn.gewinn(mainField, amZug) == true) // Gewinnausgabe
                {
                    clear();
                    Animation.an_Gewinn();
                    clear();
                    Spielfeld.zeichneSpielfeld(anzZug);
                    System.out.println(BLACK_BOLD + "Der Gewinner ist Spieler " + amZug);
                    System.out.println("Das Spiel ist vorbei !");
                    return;
                }
                amZug = Spieler.wechseln(amZug); // Spieler wechseln
                Spielfeld.zeichneSpielfeld(anzZug); // Spielfeld wird gezeichnet
                anzZug++; // Anzahl der Züge insgesamt wird hochgesetzt


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
public static char[][] getMainField()
{
    return mainField;
}
    public static int menue()   // Menü - Gegnerauswahl
    {
        int auswGegner;
        System.out.println(BLACK_BOLD + "\n\n           4 Gewinnt!\n\n");

        System.out.println("Wählen Sie gegen wen Sie spielen möchten:\n\n");
        System.out.println("1: Weiterer lokaler Spieler\n");
        System.out.println("2: Künstliche Intelligenz");
        auswGegner = scan.nextInt();
        return auswGegner;
    }

    public static int staerke() // KI - Stärkeauswahl
    {

        System.out.println("Wählen Sie die Stärke der KI:");
        System.out.println("1: Einfach");
        System.out.println("2: Mittel");
        System.out.println("3: Schwer");
        System.out.println("4: Zufallszug");
        int dif = scan.nextInt();
        return dif;
    }
    public static int auswahlFarbe(int zahlSpieler) // Farbe für Spieler auswählen
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
        return auswahlFarbe;
    }
}
