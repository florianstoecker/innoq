package com.innoq.praktikum.viergewinnt;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class ZeichneSpielfeld {
    private boolean ersterZug = true;
    private static final Map colours = new HashMap<Integer, String>();

    static {

        colours.put(1, "\033[0;97m"); //WHITE
        colours.put(2, "\u001B[0m"); //COLOR_RESET
        colours.put(3, "\u001B[32m"); //GREEN
        colours.put(4, "\u001B[31m"); //RED
        colours.put(5, "\u001B[33m"); //YELLOW
        colours.put(6, "\u001B[34m"); //BLUE
        colours.put(7, "\u001B[35m"); //PURPLE
        colours.put(8, "\u001B[36m"); //CYAN
        colours.put(9, "\u001B[30m"); //BLACK
    }


    //Konstruktor
    public ZeichneSpielfeld()
    {

    }
    //Methoden
    public void zeichneSpielfeld(Spielfeld spielfeld)
    {
        StringWriter strWriter = new StringWriter();
        strWriter.append(colours.get(9) + "|---------------------------|\n");
        strWriter.append(colours.get(9) + "| 1 | 2 | 3 | 4 | 5 | 6 | 7 |\n");
        strWriter.append(colours.get(9) + "|---------------------------|");
        for(int i = 0; i<6; i++)
        {
           strWriter.append("\n|");
            for(int j = 0; j<7; j++)
            {


                int farbe = spielfeld.getZeichenAusFarbfeld(i,j);
                if(ersterZug == true)
                {
                    draw(1,strWriter,spielfeld.getZeichenAusSpielfeld(i,j));
                }
                else
                {
                    switch(farbe)
                    {
                        case 0:
                            draw(1, strWriter,spielfeld.getZeichenAusSpielfeld(i,j));break;
                        case 1:
                            draw(3, strWriter,spielfeld.getZeichenAusSpielfeld(i,j));break;
                        case 2:
                            draw(4, strWriter,spielfeld.getZeichenAusSpielfeld(i,j));break;
                        case 3:
                            draw(5, strWriter,spielfeld.getZeichenAusSpielfeld(i,j));break;
                        case 4:
                            draw(6, strWriter,spielfeld.getZeichenAusSpielfeld(i,j));break;
                        case 5:
                            draw(7, strWriter,spielfeld.getZeichenAusSpielfeld(i,j));break;
                        case 6:
                            draw(8, strWriter,spielfeld.getZeichenAusSpielfeld(i,j));break;
                    }
                }

            }
            strWriter.append(colours.get(2) + "\n|---------------------------|" + colours.get(2));
        }
        strWriter.append("\n");
        System.out.print(strWriter);
        strWriter.getBuffer().setLength(0);
        ersterZug = false;
    }

    private void draw(int colour, StringWriter strWriter, char zeichen) {
        strWriter.append(String.format(colours.get(colour) + " %c ", zeichen));
        strWriter.append(colours.get(9) + "|");
    }
}
