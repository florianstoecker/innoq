package com.innoq.praktikum.viergewinnt;

public class Counter {
    private int counter = 0;
    private char checkSign = 'X';

    public Counter() {

    }

    public boolean checkWin(char zeichen) {


        if (zeichen == checkSign) {
            counter++;
        } else {
            counter = 0;
            if (zeichen != 'O') {
                checkSign = zeichen;
                if (counter == 4) {
                    return true;
                }
            }
            counter = 0;
        }
        return false;
    }
}
