package com.hspedu.ch16_ch18.Game;

public class Bome {
    int x,y;
    int life = 9;
    boolean islive=true;

    public Bome(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifedown(){
        if (life>0){
            life--;
        }else {
            islive=false;
        }
    }
}
