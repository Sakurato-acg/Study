package com.hspedu.ch16_ch18;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {
    private MyPanel mp=null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        mp=new MyPanel();
        //面板放入窗口
        this.add(mp);
        this.setSize(400,300);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

//定义面板,JFrame窗口
class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {//传入画笔
        super.paint(g);//初始化
        g.drawOval(10, 10, 100, 100);
    }

}