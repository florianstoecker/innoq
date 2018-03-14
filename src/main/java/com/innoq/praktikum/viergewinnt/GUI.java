package com.innoq.praktikum.viergewinnt;

import javax.swing.*;
import java.awt.*;
//Event brauchen wir für das Ereigniss, wenn ein Button geklickt wird
import java.awt.event.*;

public class GUI extends JFrame{

    private JButton button1,button2,  button3, button4, button5, button6, button7;
    private JPanel panelButton, panelField;
    private JLabel title;
    JFrame window;
    Graphics g;

    public GUI(){
        window = new JFrame("vierGewinnt v_1.01");
        window.setSize(520,600);
        window.setMinimumSize(new Dimension(600,500));
        window.setLocation(500,300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Buttons erzeugen
        button1 = new JButton("Spalte 1");
        button1.setPreferredSize(new Dimension(10, 10));
        button2 = new JButton("Spalte 2");
        button3 = new JButton("Spalte 3");
        button4 = new JButton("Spalte 4");
        button5 = new JButton("Spalte 5");
        button6 = new JButton("Spalte 6");
        button7 = new JButton("Spalte 7");

        //Panels erzeugen auf einem GridLayout
        panelButton = new JPanel();
        panelField = new JPanel();
        panelButton.setMaximumSize(new Dimension(100, 200));
        //Auf Panel Buttons packen
        panelButton.add(button1);
        button1.setPreferredSize(new Dimension(80, 40));
        panelButton.add(button2);
        button2.setPreferredSize(new Dimension(80, 40));
        panelButton.add(button3);
        button3.setPreferredSize(new Dimension(80, 40));
        panelButton.add(button4);
        button4.setPreferredSize(new Dimension(80, 40));
        panelButton.add(button5);
        button5.setPreferredSize(new Dimension(80, 40));
        panelButton.add(button6);
        button6.setPreferredSize(new Dimension(80, 40));
        panelButton.add(button7);
        button7.setPreferredSize(new Dimension(80, 40));


        title = new JLabel("vier Gewinnt !");
        title.setHorizontalAlignment(JLabel.CENTER);

        window.add(BorderLayout.NORTH, title);
        window.add(BorderLayout.WEST, panelButton);
        window.add(BorderLayout.NORTH, title);
        window.setVisible(true);

    }
}