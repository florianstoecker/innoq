package com.innoq.praktikum.viergewinnt;

import java.util.Scanner;

public class Config {
    private static boolean ersterZug = true;
    private static int auswahlGegner;
    private static int auswAnfänger;
    private static int amZug;
    private static int anzZugEinz;
    private static char zeichenSpielerEins;
    private static char zeichenSpielerZwei;
    private static int auswahlFarbeZwei;
    private static int auswahlFarbeEins;
    private Konsole oberflaeche;
    public static Scanner scan = new Scanner(System.in);


    public Config(Konsole oberflaeche){
        this.oberflaeche = oberflaeche;
        auswahlGegner = gegnerAuswahl();
        andereAbfragen();

    }
    public int gegnerAuswahl()   // Menü - Gegnerauswahl
    {

        oberflaeche.gegnerAuswahlText();
        auswahlGegner = scan.nextInt();
        if(auswahlGegner != 2 && auswahlGegner != 1 )
        {
            oberflaeche.clear();
            oberflaeche.falscheEingabeText();
            return gegnerAuswahl();
        }
        oberflaeche.clear();
        return auswahlGegner;
    }
    public void auswahlBeginn()
    {
        oberflaeche.clear();
        oberflaeche.auswahlBeginnText();
        auswAnfänger = scan.nextInt();
        if(auswAnfänger != 2 && auswAnfänger != 1 )
        {
            oberflaeche.clear();
            oberflaeche.falscheEingabeText();
            auswahlBeginn();
            oberflaeche.clear();
            return;
        }
        oberflaeche.clear();
    }
    public static int getBeginner()
    {
        return auswAnfänger;
    }
    public void farbeAuswaehlen()
    {
        int zahlSpieler = 1;
        auswahlFarbeEins = auswahlFarbe(zahlSpieler); // Farben für Spieler werden in Zwischenspeichervariabeln gespeichert
        zahlSpieler++;
        oberflaeche.clear();
        auswahlFarbeZwei = auswahlFarbe(zahlSpieler);
        oberflaeche.clear();//Übergabe von Farbe und Auswahl des Gegners
    }
    public int auswahlFarbe(int zahlSpieler) // Farbe für Spieler auswählen
    {
        int auswahlFarbe = 0;
        oberflaeche.auswahlFarbeText(zahlSpieler);
        auswahlFarbe = scan.nextInt();
        if(auswahlFarbe > 6 || auswahlFarbe < 1)
        {
            oberflaeche.falscheEingabeText();
            return auswahlFarbe(zahlSpieler);
        }
        return auswahlFarbe;
    }
    private KIGegner kiErstellen(int kiStaerke, Spielfeld spielfeld, char sign, int anfänger)
    {
        switch(kiStaerke)
        {
            case 1: return new KIGegnerStaerkeEins(spielfeld, '@', anfänger);

            case 2: return new KIGegnerStaerkeZwei(spielfeld, '@', anfänger);

            case 3: return new KIGegnerStaerkeDrei(spielfeld, '@', anfänger);

            case 4: return new KIGegnerStaerkeVier(spielfeld, '@', anfänger);

        }
        return null;
    }
    public Spieler spielerZweiAuswaehlen(Spielfeld spielfeld, char sign, int anfänger)
    {
        if (auswahlGegner == 2)
        {
            return kiErstellen(staerkeAuswahl(), spielfeld, sign, anfänger);
        }
        if(auswahlGegner == 1)
        {
            return new LokalerSpieler(spielfeld, sign, anfänger);
        }
        return null;
    }
    public boolean nochmal()
    {
        oberflaeche.nochmalText();
        int nochmal = scan.nextInt();
        if (nochmal == 1) {
            oberflaeche.clear();
            return true;
        } else if (nochmal == 2)
        {
            return false;
        }
        return false;
    }

    public static int getAuswAnfänger()
    {
        return auswAnfänger;
    }
    public static void wechsleAuswAnfänger()
    {
        if(auswAnfänger == 1)
        {
            auswAnfänger = 2;
        }
        else if(auswAnfänger == 2)
        {
            auswAnfänger = 1;
        }
    }
    public static void setAuswAnfänger(int choose)
    {
        auswAnfänger = choose;
    }
    public static int getAuswahlFarbeZwei()
    {
        return auswahlFarbeZwei;
    }
    public static int getAuswahlFarbeEins()
    {
        return auswahlFarbeEins;
    }
    public int staerkeAuswahl() // KI - Stärkeauswahl
    {
        oberflaeche.staerkeAuswahlText();
        int dif = scan.nextInt();
        if(dif>0 && dif <5)
        {
            return dif;
        }
        return staerkeAuswahl();
    }
    public void andereAbfragen()
    {
        auswahlBeginn();
        farbeAuswaehlen();
        oberflaeche.clear();
        oberflaeche.spielBeginnText();
    }
}