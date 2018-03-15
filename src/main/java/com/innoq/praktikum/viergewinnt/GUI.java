package com.innoq.praktikum.viergewinnt;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Map;


public class GUI extends JFrame {

    private JButton button1, button2, button3, button4, button5, button6, button7, standardButtonOne, standardButtonTwo;
    private JPanel panelButton;
    private JLabel title, sign;
    private JFrame window = new JFrame("vierGewinnt v_1.01");
    private static final Map colours = new HashMap<Integer, String>();
    Graphics g;
    Component rand = new MyCanvas();
    public GUI() {
        window.setSize(new Dimension(700, 700));
        window.setLocation(500, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //Buttons erzeugen
        button1 = new JButton("Spalte 1");
        button2 = new JButton("Spalte 2");
        button3 = new JButton("Spalte 3");
        button4 = new JButton("Spalte 4");
        button5 = new JButton("Spalte 5");
        button6 = new JButton("Spalte 6");
        button7 = new JButton("Spalte 7");
        standardButtonOne = new JButton();
        standardButtonTwo = new JButton();
        panelButton = new JPanel();

        //Auf Panel Buttons packen
        panelButton.setSize(600,50);
        panelButton.setLocation(50,65);
        panelButton.add(button1);
        panelButton.add(button2);
        panelButton.add(button3);
        panelButton.add(button4);
        panelButton.add(button5);
        panelButton.add(button6);
        panelButton.add(button7);
        title = new JLabel("vier Gewinnt !");
        title.setHorizontalAlignment(JLabel.CENTER);
        window.add(BorderLayout.PAGE_START, title);
        window.add(panelButton);
        window.setVisible(true);
    }


    public void gegnerAuswahl() {
        window.setVisible(false);
        window.getContentPane().removeAll();
        JLabel sign = new JLabel("Wählen Sie gegen wen Sie spielen möchten(Spieler 2):");
        standardButtonOne = new JButton("Weiterer Lokaler Spieler");
        standardButtonTwo= new JButton("Künstliche Intelligenz");
        standardButtonTwo.setSize(75,40);
        standardButtonOne.setSize(75,40);
        panelButton = new JPanel();
        panelButton.add(standardButtonOne);
        panelButton.add(standardButtonTwo);
        sign.setHorizontalAlignment(JLabel.CENTER);
        sign.setSize(100,30);
        window.add(sign);
        window.add(panelButton);
        window.setVisible(true);
    }






    public void fillField(Spielfeld spielfeld) {
        String zeichen = "O";
        int startX = 105;
        int startY = 2;
        for(int i = 0; i<6; i++) {
            for (int j = 0; j < 7; j++) {
                int farbe = spielfeld.getZeichenAusFarbfeld(i,j);
                if(spielfeld.getZeichenAusSpielfeld(i,j) == 'X')
                {
                    zeichen = "X";
                }
                else if(spielfeld.getZeichenAusSpielfeld(i,j) == '@')
                {
                    zeichen = "@";
                }
                else
                    {
                        zeichen = "O";
                    }
                sign = new JLabel(zeichen);
                sign.setSize(200,300);
                sign.setLocation(startX + 80* j, startY + 80*i);
                switch(farbe)
                {
                    case 1:sign.setForeground(Color.GREEN);break;
                    case 2:sign.setForeground(Color.RED);break;
                    case 3:sign.setForeground(Color.YELLOW);break;
                    case 4:sign.setForeground(Color.BLUE);break;
                    case 5:sign.setForeground(Color.MAGENTA);break;
                    case 6:sign.setForeground(Color.CYAN);break;
                    case 7:sign.setForeground(Color.BLACK);break;
                }
                window.add(sign);
            }
        }
        window.add(panelButton);
        window.add(BorderLayout.CENTER,rand);
        window.setVisible(true);
    }

    public void repaint(Spielfeld spielfeld)
    {
        window.setVisible(false);
        window.getContentPane().removeAll();
        fillField(spielfeld);
        window.setVisible(true);
    }
    class MyCanvas extends JComponent {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2f));
            g2.setColor(Color.BLACK);
            for(int i = 100; i<660; i = i+80) {
                g2.draw(new Line2D.Double(70, i, 630, i));
            }
            for(int i = 70; i<640; i = i+80) {
                g2.draw(new Line2D.Double(i, 100, i, 580));
                }
        }


    }
}