package com.hspedu.ch16_ch18.Game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;


public class MyPanel extends JPanel implements KeyListener, Runnable {
    Hero hero;
    Vector<Enemy> enemyVector = new Vector<>();
    Vector<Bome> bomes = new Vector<>();
    int enemySet = 3;

    Image image1=null;
    Image image2=null;
    Image image3=null;
    public MyPanel() {
        hero = new Hero(100, 100);
        hero.speed = 4;
        for (int i = 0; i < enemySet; i++) {
            Enemy enemy = new Enemy(100 * (i + 1), 0);
            enemy.setDirect(2);
            Shot shot = new Shot(enemy.getX() + 20, enemy.getY() + 60, enemy.getDirect());
            enemy.shots.add(shot);
            new Thread(shot).start();
            enemyVector.add(enemy);

        }
        image1=Toolkit.getDefaultToolkit().getImage("imgs/008jCdW0gy1gyp9w4y0hhg305m05p3zf.gif");
        image2=Toolkit.getDefaultToolkit().getImage("imgs/008jCdW0gy1gyp9w2t2owg305m05paav.gif");
        image3=Toolkit.getDefaultToolkit().getImage("imgs/008jCdW0gy1gyp9wbxoukg305m05pmxh.gif");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        DrawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        if (hero.shot != null && hero.shot.islive == true) {
            g.draw3DRect(hero.shot.x, hero.shot.y, 2, 2, true);
        }
        for (int i = 0; i <bomes.size() ; i++) {
            Bome bome=bomes.get(i);
            if (bome.life>6){
                g.drawImage(image1,bome.x,bome.y,60,60,this);
            }else if (bome.life>3){
                g.drawImage(image2,bome.x,bome.y,60,60,this);
            }else {
                g.drawImage(image3,bome.x,bome.y,60,60,this);
            }
            bome.lifedown();
            if (bome.life==0){
                bomes.remove(bome);
            }
        }
        for (int i = 0; i < enemyVector.size(); i++) {
            Enemy enemy = enemyVector.get(i);
            if (enemy.isLive) {
                DrawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 0);
                //
                for (int j = 0; j < enemy.shots.size(); j++) {
                    Shot shot = enemy.shots.get(j);
                    if (shot.islive) {
                        g.draw3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        enemy.shots.remove(shot);
                    }
                }
            }
        }


    }

    public void DrawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
        }
    }

    public  void hitTank(Shot s, Enemy enemy) {
        switch (enemy.getDirect()) {
            case 0:
            case 2:
                if (s.x > enemy.getX() && s.x < enemy.getX() + 40 &&
                        s.y > enemy.getY() && s.y < enemy.getY() + 60) {
                    s.islive = false;
                    enemy.isLive = false;
                    Bome bome = new Bome(enemy.getX(), enemy.getY());
                    bomes.add(bome);
                }
                break;
            case 1:
            case 3:
                if (s.x > enemy.getX() && s.x < enemy.getX() + 60 &&
                        s.y > enemy.getY() && s.y < enemy.getY() + 40) {
                    s.islive = false;
                    enemy.isLive = false;
                    Bome bome = new Bome(enemy.getX(), enemy.getY());
                    bomes.add(bome);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            hero.moveW();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveD();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveS();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveA();
        } else if (e.getKeyCode() == KeyEvent.VK_F) {
            hero.shotEnemy();

        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hero.shot !=null&&hero.shot.islive ) {
                for (int i = 0; i < enemyVector.size(); i++) {
                    Enemy enemy = enemyVector.get(i);
                    hitTank(hero.shot, enemy);
                }
            }
            this.repaint();
        }
    }
}


