package com.innoq.praktikum.viergewinnt;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Map;


public class GUI extends JFrame {

    private Spielfeld spielfeld;
    private JButton buttonSpalte, standardButtonOne;
    private JPanel panelButtonMain, panelButton;
    private JLabel title, sign;
    private boolean clicked = false;
    private JFrame window = new JFrame("vierGewinnt v_1.01");
    private static final Map colours = new HashMap<Integer, String>();
    private Config config;
    private int gegnerAuswahl, beginnerAuswahl, farbAuswahl, kiStaerke;

    Component rand = new Rand();

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

    public GUI() {
        window.setSize(new Dimension(700, 700));
        window.setLocation(500, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelButtonMain = new JPanel();
        //Buttons erzeugen

        for (int i = 1; i < 8; i++) {
            buttonSpalte = new JButton("Spalte " + i);
            buttonSpalte.setLocation(20, 100);
            buttonSpalte.addActionListener(this::actionPerformed);
            buttonSpalte.setPreferredSize(new Dimension(75, 40));
            panelButtonMain.add(buttonSpalte);
        }


        standardButtonOne = new JButton();

        //Auf Panel Buttons packen
        title = new JLabel("vier Gewinnt !");
        title.setLocation(50, 65);
        title.setHorizontalAlignment(JLabel.CENTER);
        // window.add(BorderLayout.PAGE_START, title);
        window.setVisible(true);
    }


    public int gegnerAuswahl() {
        panelButton = new JPanel();
        JLabel sign = new JLabel("4 Gewinnt! Wählen Sie gegen wen Sie spielen möchten(Spieler 2):");
        standardButtonOne = new JButton("Weiterer Lokaler Spieler");
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(200, 40));
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Künstliche Intelligenz");
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(200, 40));
        standardButtonOne.setSize(75, 40);
        panelButton.add(standardButtonOne);
        sign.setHorizontalAlignment(JLabel.CENTER);
        sign.setSize(100, 30);
        window.add(BorderLayout.PAGE_START, sign);
        window.add(BorderLayout.CENTER, panelButton);
        SwingUtilities.updateComponentTreeUI(window);
        waitForClick();
        clicked = false;
        clean();

        return gegnerAuswahl;

    }

    public int beginnerAuswahl() {
        panelButton = new JPanel();
        JLabel sign = new JLabel("Wer Soll anfangen ?");
        standardButtonOne = new JButton("Spieler 1");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Spieler 2");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        standardButtonOne.setSize(75, 40);
        panelButton.add(standardButtonOne);
        sign.setHorizontalAlignment(JLabel.CENTER);
        sign.setSize(100, 30);
        window.add(BorderLayout.PAGE_START, sign);
        window.add(BorderLayout.CENTER, panelButton);
        SwingUtilities.updateComponentTreeUI(window);
        waitForClick();
        clicked = false;
        clean();
        return beginnerAuswahl;
    }

    private void waitForClick() {

        while (!clicked) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int farbAuswahl(int zahlSpieler) {
        panelButton = new JPanel();
        JLabel sign = new JLabel("Wählen sie eine Farbe für Spieler " + zahlSpieler);
        sign.setHorizontalAlignment(JLabel.CENTER);
        sign.setSize(100, 30);
        standardButtonOne = new JButton("Grün");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Rot");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Gelb");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Blau");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Lila");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Braun");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Schwarz");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        window.add(BorderLayout.PAGE_START, sign);
        window.add(BorderLayout.CENTER, panelButton);
        SwingUtilities.updateComponentTreeUI(window);
        waitForClick();
        clicked = false;
        clean();
        return farbAuswahl;
    }

    public int staerkeAuswahl() {
        panelButton = new JPanel();
        JLabel sign = new JLabel("Welche Stärke der KI?");
        standardButtonOne = new JButton("Zufall");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Leicht");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        standardButtonOne.setSize(75, 40);
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Mittel");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        standardButtonOne = new JButton("Schwer");
        standardButtonOne.setLocation(20, 100);
        standardButtonOne.addActionListener(this::actionPerformed);
        standardButtonOne.setPreferredSize(new Dimension(75, 40));
        panelButton.add(standardButtonOne);
        sign.setHorizontalAlignment(JLabel.CENTER);
        sign.setSize(100, 30);
        window.add(BorderLayout.PAGE_START, sign);
        window.add(BorderLayout.CENTER, panelButton);
        SwingUtilities.updateComponentTreeUI(window);
        waitForClick();
        clicked = false;
        clean();
        return kiStaerke;
    }

    public void gewinn(char currentUser, String stelle) {
        clean();
        int spieler;
        if (currentUser == '@') {
            spieler = 1;
        } else {
            spieler = 2;
        }
        JLabel sign = new JLabel("Der Gewinner ist Spieler " + spieler + "!");
        sign.setHorizontalAlignment(JLabel.CENTER);
        sign.setSize(100, 30);
        window.add(BorderLayout.PAGE_START, sign);
        sign = new JLabel("Gewonnen wurde " + stelle);
        sign.setHorizontalAlignment(JLabel.CENTER);
        sign.setSize(100, 30);
        window.add(BorderLayout.CENTER,sign);
        sign = new JLabel("Das Spiel ist zu Ende!");
        sign.setHorizontalAlignment(JLabel.CENTER);
        sign.setSize(100, 30);
        window.add(BorderLayout.PAGE_END, sign);
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void fillField(Spielfeld spielfeld) {
        clean();
        panelButtonMain.setSize(600, 50);
        panelButtonMain.setLocation(50, 50);
        window.add(panelButtonMain);
        String zeichen;
        int startX = 104;
        int startY = 12;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int farbe = spielfeld.getZeichenAusFarbfeld(i, j);
                if (spielfeld.getZeichenAusSpielfeld(i, j) == 'X') {
                    zeichen = "X";
                } else if (spielfeld.getZeichenAusSpielfeld(i, j) == '@') {
                    zeichen = "@";
                } else {
                    zeichen = "O";
                }
                sign = new JLabel(zeichen);
                sign.setFont(new Font(Font.SERIF, 0,20));
                sign.setSize(200, 300);
                sign.setLocation(startX + 80 * j, startY + 80 * i);
                switch (farbe) {
                    case 0:sign.setForeground(Color.WHITE);
                        break;
                    case 1:
                        sign.setForeground(new Color(0,153,0));
                        break;
                    case 2:
                        sign.setForeground(new Color(153,0,0));
                        break;
                    case 3:
                        sign.setForeground(new Color(255,204, 0));
                        break;
                    case 4:
                        sign.setForeground(new Color(0, 0,204));
                        break;
                    case 5:
                        sign.setForeground(new Color(102,0,153));
                        break;
                    case 6:
                        sign.setForeground(new Color(102,51,0));
                        break;
                    case 7:
                        sign.setForeground(new Color(0,0,0));
                        break;
                }
                window.add(sign);
            }
        }
        window.add(rand);
        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {

        switch (event.getActionCommand()) {
            case "Spalte 1":
                spielfeld.setInsertPos(0);
                clicked = true;
                break;
            case "Spalte 2":
                spielfeld.setInsertPos(1);
                clicked = true;
                break;
            case "Spalte 3":
                spielfeld.setInsertPos(2);
                clicked = true;
                break;
            case "Spalte 4":
                spielfeld.setInsertPos(3);
                clicked = true;
                break;
            case "Spalte 5":
                spielfeld.setInsertPos(4);
                clicked = true;
                break;
            case "Spalte 6":
                spielfeld.setInsertPos(5);
                clicked = true;
                break;
            case "Spalte 7":
                spielfeld.setInsertPos(6);
                clicked = true;
                break;
            case "Weiterer Lokaler Spieler":
                gegnerAuswahl = 1;
                clicked = true;
                break;
            case "Künstliche Intelligenz":
                gegnerAuswahl = 2;
                clicked = true;
                break;
            case "Spieler 1":
                beginnerAuswahl = 1;
                clicked = true;
                break;
            case "Spieler 2":
                beginnerAuswahl = 2;
                clicked = true;
                break;
            case "Grün":
                farbAuswahl = 1;
                clicked = true;
                break;
            case "Rot":
                farbAuswahl = 2;
                clicked = true;
                break;
            case "Gelb":
                farbAuswahl = 3;
                clicked = true;
                break;
            case "Blau":
                farbAuswahl = 4;
                clicked = true;
                break;
            case "Lila":
                farbAuswahl = 5;
                clicked = true;
                break;
            case "Cyan":
                farbAuswahl = 6;
                clicked = true;
                break;
            case "Zufall":
                kiStaerke = 1;
                clicked = true;
                break;
            case "Leicht":
                kiStaerke = 2;
                clicked = true;
                break;
            case "Mittel":
                kiStaerke = 3;
                clicked = true;
                break;
            case "Schwer":
                kiStaerke = 4;
                clicked = true;
                break;


        }
    }

    private void clean() {
        window.getContentPane().removeAll();
    }

    public void repaint(Spielfeld spielfeld) {
        clean();
        fillField(spielfeld);
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void setSpielfeld(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }

    public void enableButtons() {
        window.getContentPane().removeAll();
        window.add(panelButtonMain);
        fillField(spielfeld);
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void disableButtons() {
        window.getContentPane().removeAll();
        fillField(spielfeld);
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public boolean getClicked() {
        return this.clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    class Rand extends JComponent {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2f));
            g2.setColor(Color.BLACK);
            for (int i = 110; i < 660; i = i + 80) {
                g2.draw(new Line2D.Double(70, i, 630, i));
            }
            for (int i = 70; i < 640; i = i + 80) {
                g2.draw(new Line2D.Double(i, 110, i, 590));
            }
        }
    }
}