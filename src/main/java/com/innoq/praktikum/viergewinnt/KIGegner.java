package com.innoq.praktikum.viergewinnt;

public class KIGegner extends Spieler {
    public static int entscheidung;

    public void macheZug(Konsole oberflaeche, Spielfeld spielfeld)
    {
    }
    //KIGegnerStaerkeEins
    public void random(Spielfeld spielfeld)
    {
        int ran = (int)((Math.random()) * 7 + 1)-1;
        spielfeld.setInsertPos(ran);
    }

    //KIGegnerStaerkeZwei
    public boolean eigenerStein(Spielfeld spielfeld)
    {
        if(spielfeld.getAnzahlZüge() >1) {
            for (int i = 0; i < 6; i++) {

                for (int j = 0; j < 7; j++) {
                    if (spielfeld.getZeichenAusSpielfeld(i, j) == '@') {
                        if (i > 0) {
                            if (spielfeld.feldLegbar(i - 1, j) == true)//senkrecht auf eigenen Stein
                            {
                                spielfeld.setInsertPos(j);
                                return true;
                            }
                        }
                        if (j > 0) {
                            if (spielfeld.feldLegbar(i, j - 1) == true)//links neben eigenen Stein
                            {
                                spielfeld.setInsertPos(j - 1);
                                return true;
                            }
                        }
                        if (j < 6) {
                            if (spielfeld.feldLegbar(i, j + 1) == true) //rechts neben eigenen Stein
                            {
                                spielfeld.setInsertPos(j + 1);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //KIGegner StaerkeDrei
    public boolean kannGewinnen(Spielfeld spielfeld) {
        char zeichenSpieler = 0;
        char xEins, xZwei, xDrei, xVier;
        if (spielfeld.getAnDerReihe() == 1) {
            zeichenSpieler = 'X';
        } else if (spielfeld.getAnDerReihe() == 2) {
            zeichenSpieler = '@';
        }


        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                xEins = spielfeld.getZeichenAusSpielfeld(i,j);
                //wagerecht
                if (j < 4)
                {

                    xZwei = spielfeld.getZeichenAusSpielfeld(i,j + 1);
                    xDrei = spielfeld.getZeichenAusSpielfeld(i,j + 2);
                    xVier = spielfeld.getZeichenAusSpielfeld(i,j + 3);
                    switch (dreiGleich(xEins, xZwei, xDrei, xVier, zeichenSpieler))
                    {
                        case 1:
                            if (spielfeld.feldLegbar(i, j) == true) {
                                spielfeld.setInsertPos(j);
                                return true;
                            }
                        case 2:
                            if (spielfeld.feldLegbar(i, j + 1) == true) {
                                spielfeld.setInsertPos(j + 1);
                                return true;
                            }
                        case 3:
                            if (spielfeld.feldLegbar(i, j + 2) == true) {
                                spielfeld.setInsertPos(j + 2);
                                return true;
                            }
                        case 4:
                            if (spielfeld.feldLegbar(i, j + 3) == true) {
                                spielfeld.setInsertPos(j + 3);
                                return true;
                            }

                    }
                }
                // senkrecht
                if(i>2)
                {
                    if(spielfeld.getZeichenAusSpielfeld(i,j) == zeichenSpieler && spielfeld.getZeichenAusSpielfeld(i - 1,j) == zeichenSpieler && spielfeld.getZeichenAusSpielfeld(i - 2,j) == zeichenSpieler)
                    {
                        if(spielfeld.getZeichenAusSpielfeld(i - 3,j) == 'O')
                        {
                            spielfeld.setInsertPos(j);
                            return true;
                        }
                    }
                }

                //diagonal unten rechts & oben links
                if(i<3 && j < 4)
                {
                    xZwei = spielfeld.getZeichenAusSpielfeld(i + 1,j + 1);
                    xDrei = spielfeld.getZeichenAusSpielfeld(i + 2,j + 2);
                    xVier = spielfeld.getZeichenAusSpielfeld(i + 3,j + 3);
                    switch (dreiGleich(xEins, xZwei, xDrei, xVier, zeichenSpieler))
                    {
                        case 1:
                            if (spielfeld.feldLegbar(i, j) == true) {
                                spielfeld.setInsertPos(j);
                                return true;
                            }
                        case 2:
                            if (spielfeld.feldLegbar(i + 1, j + 1) == true) {
                                spielfeld.setInsertPos(j + 1);
                                return true;
                            }
                        case 3:
                            if (spielfeld.feldLegbar(i + 2, j + 2) == true) {
                                spielfeld.setInsertPos(j + 2);
                                return true;
                            }
                        case 4:
                            if (spielfeld.feldLegbar(i + 3, j + 3) == true) {
                                spielfeld.setInsertPos(j + 3);
                                return true;
                            }

                    }
                }
                //diagonal unten links & oben rechts
                if(i>2 && j < 4)
                {
                    xZwei = spielfeld.getZeichenAusSpielfeld(i - 1,j + 1);
                    xDrei = spielfeld.getZeichenAusSpielfeld(i - 2,j + 2);
                    xVier = spielfeld.getZeichenAusSpielfeld(i - 3,j + 3);
                    switch (dreiGleich(xEins, xZwei, xDrei, xVier, zeichenSpieler))
                    {
                        case 1:
                            if (spielfeld.feldLegbar(i, j) == true) {
                                spielfeld.setInsertPos(j);
                                return true;
                            }
                        case 2:
                            if (spielfeld.feldLegbar(i - 1, j + 1) == true) {
                                spielfeld.setInsertPos(j + 1);
                                return true;
                            }
                        case 3:
                            if (spielfeld.feldLegbar(i - 2, j + 2) == true) {
                                spielfeld.setInsertPos(j + 2);
                                return true;
                            }
                        case 4:
                            if (spielfeld.feldLegbar(i - 3, j + 3) == true) {
                                spielfeld.setInsertPos(j + 3);
                                return true;
                            }

                    }
                }
            }
        }
        return false;
    }
    public static int dreiGleich(char xEins,char xZwei, char xDrei, char xVier, char zeichenSpieler)
    {

        if(xVier == xZwei && xZwei== xDrei && xDrei == zeichenSpieler)
        {
            return 1;
        }
        else if(xVier == xEins && xEins== xDrei && xDrei == zeichenSpieler)
        {
            return 2;
        }
        else if(xVier == xZwei && xZwei == xEins && xEins == zeichenSpieler)
        {
            return 3;
        }
        else if(xEins == xZwei && xZwei == xDrei && xDrei == zeichenSpieler)
        {
            return 4;
        }
        return 0;
    }
    public static void zweiGleichGewinnMoeglich(char xEins,char xZwei, char xDrei, char xVier, char zeichenSpieler, int schonGecheckt)
    {
        if(schonGecheckt < 1)
        {
            if(xEins== xZwei && xZwei == zeichenSpieler && xDrei == 'O' && xDrei == xVier)
            {
                entscheidung = 1;
                return;
            }
        }
        if(schonGecheckt <2) {
            if (xEins == xDrei && xDrei == zeichenSpieler && xZwei == 'O' && xZwei == xVier) {
                entscheidung = 2;
                return;
            }
        }
        if(schonGecheckt <3) {
            if (xEins == xVier && xVier == zeichenSpieler && xZwei == 'O' && xZwei == xDrei) {
                entscheidung = 3;
                return;
            }
        }
        if(schonGecheckt <4) {
            if (xZwei == xDrei && xDrei == zeichenSpieler && xEins == 'O' && xEins == xVier) {
                entscheidung = 4;
                return;
            }
        }
        if(schonGecheckt <5) {
            if (xZwei == xVier && xVier == zeichenSpieler && xEins == 'O' && xEins == xDrei) {
                entscheidung = 5;
                return;
            }
        }
        if(schonGecheckt <6) {
            if (xDrei == xVier && xVier == zeichenSpieler && xEins == 'O' && xEins == xZwei) {
                entscheidung = 6;
                return;
            }
        }
        entscheidung = 0;
    }
    private boolean zweiÜberprüfen(int i, int j, Spielfeld spielfeld, int schonGecheckt, char zeichenSpieler)
    {
        char xEins, xZwei, xDrei, xVier;
        int ran = (int)((Math.random()) * 7 + 1)-1;
        xEins = spielfeld.getZeichenAusSpielfeld(i,j);
        //wagerecht
        if (j < 4) {
            xZwei = spielfeld.getZeichenAusSpielfeld(i,j + 1);
            xDrei = spielfeld.getZeichenAusSpielfeld(i,j + 2);
            xVier = spielfeld.getZeichenAusSpielfeld(i,j + 3);
            zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

            switch (entscheidung) {
                case 0:
                    break;
                case 1:
                    if (spielfeld.feldLegbar(i, j + 2) == true && spielfeld.feldLegbar(i, j + 3) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j + 2);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 3);
                            return true;
                        }

                    } else {
                        schonGecheckt = 1;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
                    }
                case 2:
                    if (spielfeld.feldLegbar(i, j + 1) == true && spielfeld.feldLegbar(i, j + 3) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j + 1);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 3);
                            return true;
                        }

                    } else {
                        schonGecheckt = 2;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
                    }
                case 3:
                    if (spielfeld.feldLegbar(i, j + 1) == true && spielfeld.feldLegbar(i, j + 2) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j + 1);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 2);
                            return true;
                        }

                    } else {
                        schonGecheckt = 3;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
                case 4:
                    if (spielfeld.feldLegbar(i, j) == true && spielfeld.feldLegbar(i, j + 3) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 3);
                            return true;
                        }

                    } else {
                        schonGecheckt = 4;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
                case 5:
                    if (spielfeld.feldLegbar(i, j) == true && spielfeld.feldLegbar(i, j + 2) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 2);
                            return true;
                        }

                    } else {
                        schonGecheckt = 5;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
                case 6:
                    if (spielfeld.feldLegbar(i, j) == true && spielfeld.feldLegbar(i, j + 1) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 1);
                            return true;
                        }

                    } else {
                        schonGecheckt = 6;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
                    }
            }
        }
        schonGecheckt = 0;
        if (i > 2)//senkrecht
        {
            if (spielfeld.getZeichenAusSpielfeld(i,j)== zeichenSpieler && spielfeld.getZeichenAusSpielfeld(i - 1,j) == zeichenSpieler) {
                if (spielfeld.getZeichenAusSpielfeld(i - 2,j) == 'O') {
                    spielfeld.setInsertPos(j);
                    return true;
                }
            }

        }
        //diagonal unten rechts & oben links
        if (i < 3 && j < 4) {
            xZwei = spielfeld.getZeichenAusSpielfeld(i + 1,j + 1);
            xDrei = spielfeld.getZeichenAusSpielfeld(i + 2,j + 2);
            xVier = spielfeld.getZeichenAusSpielfeld(i + 3,j + 3);
            zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
            switch (entscheidung) {
                case 0:
                    break;
                case 1:
                    if (spielfeld.feldLegbar(i + 2, j + 2) == true && spielfeld.feldLegbar(i + 3, j + 3) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j + 2);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 3);
                            return true;
                        }

                    } else {
                        schonGecheckt = 1;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
                    }
                case 2:
                    if (spielfeld.feldLegbar(i + 1, j + 1) == true && spielfeld.feldLegbar(i + 3, j + 3) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j + 1);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 3);
                            return true;
                        }

                    } else {
                        schonGecheckt = 2;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
                    }
                case 3:
                    if (spielfeld.feldLegbar(i + 1, j + 1) == true && spielfeld.feldLegbar(i + 2, j + 2) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j + 1);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 2);
                            return true;
                        }

                    } else {
                        schonGecheckt = 3;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
                case 4:
                    if (spielfeld.feldLegbar(i, j) == true && spielfeld.feldLegbar(i + 3, j + 3) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 3);
                            return true;
                        }

                    } else {
                        schonGecheckt = 4;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
                case 5:
                    if (spielfeld.feldLegbar(i, j) == true && spielfeld.feldLegbar(i + 2, j + 2) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 2);
                            return true;
                        }

                    } else {
                        schonGecheckt = 5;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
                case 6:
                    if (spielfeld.feldLegbar(i, j) == true && spielfeld.feldLegbar(i + 1, j + 1) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 1);
                            return true;
                        }

                    } else {
                        schonGecheckt = 6;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
            }
        }
        schonGecheckt = 0;
        //diagonal unten links & oben rechts
        if (i > 2 && j < 4) {
            xZwei = spielfeld.getZeichenAusSpielfeld(i - 1,j + 1);
            xDrei = spielfeld.getZeichenAusSpielfeld(i - 2,j + 2);
            xVier = spielfeld.getZeichenAusSpielfeld(i - 3,j + 3);
            zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
            switch (entscheidung) {
                case 0:
                    break;
                case 1:
                    if (spielfeld.feldLegbar(i - 2, j + 2) == true && spielfeld.feldLegbar(i - 3, j + 3) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j + 2);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 3);
                            return true;
                        }

                    } else {
                        schonGecheckt = 1;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
                    }
                case 2:
                    if (spielfeld.feldLegbar(i - 1, j + 1) == true && spielfeld.feldLegbar(i - 3, j + 3) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j + 1);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 3);
                            return true;
                        }

                    } else {
                        schonGecheckt = 2;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
                    }
                case 3:
                    if (spielfeld.feldLegbar(i - 1, j + 1) == true && spielfeld.feldLegbar(i - 2, j + 2) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j + 1);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 2);
                            return true;
                        }

                    } else {
                        schonGecheckt = 3;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
                case 4:
                    if (spielfeld.feldLegbar(i, j) == true && spielfeld.feldLegbar(i - 3, j + 3) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 3);
                            return true;
                        }

                    } else {
                        schonGecheckt = 4;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
                case 5:
                    if (spielfeld.feldLegbar(i, j) == true && spielfeld.feldLegbar(i - 2, j + 2) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 2);
                            return true;
                        }

                    } else {
                        schonGecheckt = 5;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
                case 6:
                    if (spielfeld.feldLegbar(i, j) == true && spielfeld.feldLegbar(i - 1, j + 1) == true) {
                        if (ran == 1) {
                            spielfeld.setInsertPos(j);
                            return true;
                        } else {
                            spielfeld.setInsertPos(j + 1);
                            return true;
                        }

                    } else {
                        schonGecheckt = 6;
                        zweiGleichGewinnMoeglich(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
            }
        }
        return false;
    }
    public boolean zweiGleicheGewinnMöglich(int schonGecheckt, Spielfeld spielfeld)
    {
        char zeichenSpieler = 'N';
        if(spielfeld.getAnzahlZüge()>3) {
            if(spielfeld.getAnDerReihe() == 1)
            {
                zeichenSpieler = 'X';
            } else if (spielfeld.getAnDerReihe() == 2) {
                zeichenSpieler = '@';
            }

            for (int i = 5; i >= 0; i--) {
                for (int j = 0; j < 7; j++) {
                    if(zweiÜberprüfen(i,j, spielfeld, schonGecheckt, zeichenSpieler) == true)
                    {
                        return true;
                    }


                }


            }

        }
        return false;
    }
    public void steinWurdeAusgewaehlt(Spielfeld spielfeld, Konsole oberflaeche)
    {
        int spaltenAuswahl;
        spaltenAuswahl = spielfeld.getInsertPos();;
        spielfeld.wirfSteinEin(oberflaeche, spielfeld);
        oberflaeche.kiGelegtText(spaltenAuswahl + 1);
    }

    //KIGegnerStaerkeVier

/* private boolean minmax(int amZug, char zeichenSpieler)
    {

        if(kannGewinnen(amZug) == false)
        {
            hilfsfeld = spielfeld;
            for(int j = 0; j<7; j++)
            {
                if(hilfeSteinEinfügen(j, amZug)== true)
                {

                }
            }





        }
        else
        {
            insertPos = posxGewinn;
        }
        return false;
    }
    private boolean hilfeSteinEinfügen(int hilfeStellex,int amZug)
    {
        char zeichenSpieler = 'D';
        if (amZug == 1)
        {
            zeichenSpieler = 'X';
        }
        else if (amZug == 2)
        {
            zeichenSpieler = '@';
        }
        int hilfeStelley = 5;
        if (spielfeld[hilfeStelley][hilfeStellex] == 'O') {
            spielfeld[hilfeStelley][hilfeStellex] = zeichenSpieler;
        }
        else
        {
            while (spielfeld[insertPosy][insertPos] == 'X' || spielfeld[insertPosy][insertPos] == '@')
            {
                hilfStelley--;
                if (hilfeStelley)
                {
                    return false;
                }

            }
            if (abfVoll() == false)
            {
                spielfeld[insertPosy][insertPos] = zeichenSpieler;
                farbfeld[insertPosy][insertPos] = farbe;
            }

        }
        return false;
    }*/
}
