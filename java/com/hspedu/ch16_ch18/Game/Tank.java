package com.hspedu.ch16_ch18.Game;

public class Tank {
    private int x;
    private int y;
    private int direct=0;
   public int speed=1;
    public void moveW(){
        y-=speed;
    }
    public void moveD(){
        x+=speed;
    } public void moveA(){
        x-=speed;
    } public void moveS(){
        y+=speed;
    }
    public Tank(int direct) {
        this.direct = direct;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
