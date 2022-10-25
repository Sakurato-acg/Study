package com.hspedu.ch16_ch18.Game;

import javax.swing.*;

public class Game01 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        Game01 game01 = new Game01();
    }

    public Game01() {
        mp=new MyPanel();
        this.add(mp);
        Thread thread = new Thread(mp);
        thread.start();
        this.setSize(1000,750);
        this.setTitle("坦克大战");

        this.addKeyListener(mp);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
