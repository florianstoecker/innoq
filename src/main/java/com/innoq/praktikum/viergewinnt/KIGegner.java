package com.innoq.praktikum.viergewinnt;

public class KIGegner extends Spieler {

    public KIGegner(Spielfeld spielfeld, char sign, int anfänger)
    {
        super(spielfeld, sign, anfänger);
    }
    public static char[][] hilfsfeld;
    public static int entscheidung;
    private  Spielfeld spielfeldTMP;
    public int betrachteterSpieler = spielfeld.getAuswahlAnfänger();

    public void macheZug()
    {
    }
    //KIGegnerStaerkeEins
    public void random()
    {
        int ran = (int)((Math.random()) * 7 + 1)-1;
        spielfeld.setInsertPos(ran);
    }

    //KIGegnerStaerkeZwei
    public boolean eigenerStein()
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
    public boolean kannGewinnen() {
        char zeichenSpieler = 0;
        char xEins, xZwei, xDrei, xVier;
        if (betrachteterSpieler == 1) {
            zeichenSpieler = 'X';
        } else if (betrachteterSpieler == 2) {
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
    public static void zweiGleichHilfe(char xEins,char xZwei, char xDrei, char xVier, char zeichenSpieler, int schonGecheckt)
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
    private boolean zweiÜberprüfen(int i, int j, int schonGecheckt, char zeichenSpieler)
    {
        char xEins, xZwei, xDrei, xVier;
        int ran = (int)((Math.random()) * 7 + 1)-1;
        xEins = spielfeld.getZeichenAusSpielfeld(i,j);
        //wagerecht
        if (j < 4) {
            xZwei = spielfeld.getZeichenAusSpielfeld(i,j + 1);
            xDrei = spielfeld.getZeichenAusSpielfeld(i,j + 2);
            xVier = spielfeld.getZeichenAusSpielfeld(i,j + 3);
            zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
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
            zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
            }
        }
        schonGecheckt = 0;
        //diagonal unten links & oben rechts
        if (i > 2 && j < 4) {
            xZwei = spielfeld.getZeichenAusSpielfeld(i - 1,j + 1);
            xDrei = spielfeld.getZeichenAusSpielfeld(i - 2,j + 2);
            xVier = spielfeld.getZeichenAusSpielfeld(i - 3,j + 3);
            zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);
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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

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
                        zweiGleichHilfe(xEins, xZwei, xDrei, xVier, zeichenSpieler, schonGecheckt);

                    }
            }
        }
        return false;
    }
    public boolean zweiGleicheGewinnMöglich(int schonGecheckt)
    {
        char zeichenSpieler = 'N';
        if(spielfeld.getAnzahlZüge()>=3) {
            if(betrachteterSpieler == 1)
            {
                zeichenSpieler = 'X';
            } else if (betrachteterSpieler == 2) {
                zeichenSpieler = '@';
            }

            for (int i = 5; i >= 0; i--) {
                for (int j = 0; j < 7; j++) {
                    if(zweiÜberprüfen(i,j, schonGecheckt, zeichenSpieler) == true)
                    {
                        return true;
                    }


                }


            }

        }
        return false;
    }
    public void steinWurdeAusgewaehlt()
    {
        int spaltenAuswahl;
        spaltenAuswahl = spielfeld.getInsertPos();;
        spielfeld.wirfSteinEin();
    }

    //KIGegnerStaerkeVier
    private boolean probeEinfügen(int insertPos)
    {
        int insertPosy = 5;
        if (spielfeldTMP.getZeichenAusSpielfeld(insertPosy, insertPos) == 'O') {return true;

        } else {
            while (spielfeldTMP.getZeichenAusSpielfeld(insertPosy, insertPos) == 'X' || spielfeldTMP.getZeichenAusSpielfeld(insertPosy, insertPos) == '@') {
                insertPosy--;
                if(insertPosy == -1)
                {return false;}
            }return true;

        }
    }
    public int findeBestenZug()
    {
        int[] werteFeld = new int [7];
        int suchtiefe = 2;
        int besterZug;

        spielfeldTMP = spielfeld.getCopy();
        for(int j = 0; j < 7; j++)
        {
            if(probeEinfügen(j) == true)
            {
                spielfeldTMP.setInsertPos(j);
                spielfeldTMP.wirfSteinEin();
                werteFeld[j] = berechneMiniMax(suchtiefe);
            }
        }
        besterZug = werteFeld[0];
        for(int i = 0; i < 6; i ++ )
        {
            if(werteFeld[i] == 10 ||werteFeld[i] == -10)
            {
                return besterZug;
            }
            if(werteFeld[i] >= besterZug)
            {
                besterZug = werteFeld[i];
            }
        }
        return besterZug;
    }

    private int berechneMiniMax(int tiefe)
    {
        int minimax;
        int minimaxTMP;
        /*if(tiefe == 0)
        {
            return bewertung(spielfeldTMP);
        }
        else{

                if(probeEinfügen(1, spielfeldTMP) == true)
                {
                    spielfeldTMP.setInsertPos(i);
                    spielfeldTMP.wirfSteinEin(oberflaeche, spielfeldTMP);
                }

        }*/
        minimax = bewertung();
        return minimax;
    }
    private int bewertung()
    {
        int spielerEinsZweier = 0;
        int spielerZweiZweier = 0;
        int spielerEinsDreier = 0;
        int spielerZweiDreier = 0;
        int ergebnis = 0;
        char zeichenSpielerEins = 'X';
        char zeichenSpielerZwei = '@';

        for(int i = 0; i < 6; i ++)
        {
            for(int j = 0; j < 7 ; j++)
            {

                if(j < 4) {
                    //gewonnen wagerecht rechts SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, 0, 1, i, j) == 4) {
                        return 10;
                    }
                    //gewonnen wagerecht rechts SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, 0, 1, i, j) == 4) {
                        return -10;
                    }
                    //Drei Steine wagerecht rechts SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, 0, 1, i, j) == 3) {
                        spielerEinsDreier ++;
                    }
                    //Drei Steine wagerecht rechts SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, 0, 1, i, j) == 3) {
                        spielerZweiDreier ++;
                    }
                    //Zwei Steine wagerecht rechts SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, 0, 1, i, j) == 2) {
                        spielerZweiDreier ++;
                    }
                    //Zwei Steine wagerecht rechts SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, 0, 1, i, j) == 2) {
                        spielerZweiZweier ++;
                    }
                }
                if(i > 2) {
                    //gewonnen senkrecht rechts SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, -1, 0, i, j) == 4) {
                        return 10;
                    }
                    //gewonnen senkrecht rechts SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, -1, 0, i, j) == 4) {
                        return -10;
                    }
                    //Drei Steine senkrecht rechts SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, -1, 0, i, j) == 3) {
                        spielerEinsDreier ++;
                    }
                    //Drei Steine senkrecht rechts SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, -1, 0, i, j) == 3) {
                        spielerZweiDreier ++;
                    }
                    //Zwei Steine senkrecht rechts SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, -1, 0, i, j) == 2) {
                        spielerZweiDreier ++;
                    }
                    //Zwei Steine senkrecht rechts SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, -1, 0, i, j) == 2) {
                        spielerZweiZweier ++;
                    }
                }
                if(j < 4 && i < 3) {
                    //gewonnen diagonal rechts unten SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, 1, 1, i, j) == 4) {
                        return 10;
                    }
                    //gewonnen diagonal rechts unten SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, 1, 1, i, j) == 4) {
                        return -10;
                    }
                    //Drei Steine diagonal rechts unten SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, 1, 1, i, j) == 3) {
                        spielerEinsDreier ++;
                    }
                    //Drei Steine diagonal rechts unten SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, 1, 1, i, j) == 3) {
                        spielerZweiDreier ++;
                    }
                    //Zwei Steine diagonal rechts unten SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, 1, 1, i, j) == 2) {
                        spielerZweiDreier ++;
                    }
                    //Zwei Steine diagonal rechts unten SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, 1, 1, i, j) == 2) {
                        spielerZweiZweier ++;
                    }
                }
                if(j < 4 && i > 2) {
                    //gewonnen diagonal rechts oben SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, -1, 1, i, j) == 4) {
                        return 10;
                    }
                    //gewonnen diagonal rechts oben SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, -1, 1, i, j) == 4) {
                        return -10;
                    }
                    //Drei Steine diagonal rechts oben SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, -1, 1, i, j) == 3) {
                        spielerEinsDreier ++;
                    }
                    //Drei Steine diagonal rechts oben SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, -1, 1, i, j) == 3) {
                        spielerZweiDreier ++;
                    }
                    //Zwei Steine diagonal rechts oben SpielerEins
                    if (reiheZeichenSpieler(zeichenSpielerEins, -1, 1, i, j) == 2) {
                        spielerZweiDreier ++;
                    }
                    //Zwei Steine diagonal rechts oben SpielerZwei
                    if (reiheZeichenSpieler(zeichenSpielerZwei, -1, 1, i, j) == 2) {
                        spielerZweiZweier ++;
                    }
                }
            }
        }
        ergebnis = spielerEinsZweier + spielerEinsDreier - spielerZweiZweier - spielerZweiDreier ;
        return ergebnis;
    }
    private int reiheZeichenSpieler(char zeichenSpieler, int vorfaktorX, int vorfaktorY, int x, int y)
    {
        int ergebnisReihe = 0;
        if(spielfeldTMP.getZeichenAusSpielfeld(x,y) == zeichenSpieler || spielfeldTMP.getZeichenAusSpielfeld(x,y) == 'O'
                && spielfeldTMP.getZeichenAusSpielfeld(x + 1 * vorfaktorX,y + 1 * vorfaktorY) == zeichenSpieler || spielfeldTMP.getZeichenAusSpielfeld(x + 1 * vorfaktorX,y + 1 * vorfaktorY) == 'O'
                && spielfeldTMP.getZeichenAusSpielfeld(x + 2 * vorfaktorX,y + 1 * vorfaktorY) == zeichenSpieler || spielfeldTMP.getZeichenAusSpielfeld(x + 2 * vorfaktorX,y + 1 * vorfaktorY) == 'O'
                && spielfeldTMP.getZeichenAusSpielfeld(x + 3 * vorfaktorX,y + 1 * vorfaktorY) == zeichenSpieler || spielfeldTMP.getZeichenAusSpielfeld(x + 3 * vorfaktorX,y + 1 * vorfaktorY) == 'O')
        {
            for(int i = 0; i < 4; i ++)
            {
                if(spielfeldTMP.getZeichenAusSpielfeld(x + i * vorfaktorX, y + i * vorfaktorY) == zeichenSpieler)
                {
                    ergebnisReihe ++;
                }
            }
        }
        return ergebnisReihe;
    }
    public void copy()
    {
        for(int i = 0; i<6 ; i++)
        {
            for(int j = 0; j < 7; j ++)
            {
                spielfeldTMP.setZeichenAnSpielfeld(i, j, spielfeld.getZeichenAusSpielfeld(i, j));
            }
        }
    }
}
