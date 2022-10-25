package com.hspedu.ch16_ch18.Game;

import java.util.Vector;

public class Enemy extends Tank{
    Vector<Shot> shots=new Vector<>();
    boolean isLive=true;
    public Enemy(int x, int y) {
        super(x, y);
    }
}
