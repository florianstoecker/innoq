package com.innoq.praktikum.viergewinnt;

public class Counter {

    private int counter = 0;
    private Character checkSign = new Character('?');

    public boolean checkWin(Character zeichen) {

        boolean signChanged = checkSign != null && !checkSign.equals(zeichen);
        if (signChanged) {
            this.counter = 0;
            this.checkSign = '?';
        }

        boolean isNotEmptyField = zeichen != 'O';
        if (isNotEmptyField) {
            this.checkSign = zeichen;
        }

        this.counter++;
        return counter == 4;
    }
}
