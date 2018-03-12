package com.innoq.praktikum.viergewinnt;

public class Counter {

    private int counter;
    private char checkSign = 'X';

    public Counter() {
        this.counter = 1;

    }

    public boolean checkWin(char zeichen) {

        if (zeichen == checkSign)
        {
            counter++;
        }
        else
        {
            if (zeichen != 'O')
            {
                checkSign = zeichen;
                counter = 1;
            }
        }
        if (counter == 4) {
            return true;
        }
        return false;
    }
    public void countSign(char spielerZeichen, char feldZeichen)
    {
        if(spielerZeichen == feldZeichen)
        {
            counter ++;
        }

    }
    public int getCounter()
    {
        return counter;
    }
}
