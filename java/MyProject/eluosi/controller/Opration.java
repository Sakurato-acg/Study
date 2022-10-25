package MyProject.eluosi.controller;

import MyProject.eluosi.model.GameData;
import MyProject.eluosi.view.MainWin;
import MyProject.eluosi.view.imgButton;

import javax.swing.*;

public class Opration {
    MainWin mainWin;
    GameData gameData;
    public imgButton left;
    public imgButton righ;
    public imgButton down;
    public imgButton rota;
    public JButton stst;
    public imgButton sett;
    public imgButton logi;

    Opration() {
        left = new imgButton(new ImageIcon("imgs/left.png")) {
            @Override
            public void onClick() {
                gameData.move(true,-1);
                mainWin.getGamePanel().repaint();
            }
        };
        righ = new imgButton(new ImageIcon("imgs/right.png")) {
            @Override
            public void onClick() {
                gameData.move(true,1);
                mainWin.getGamePanel().repaint();
            }
        };
        down = new imgButton(new ImageIcon("imgs/down.png")) {
            @Override
            public void onClick() {
                gameData.move(false,1);
                mainWin.getGamePanel().repaint();
            }
        };
        rota = new imgButton(new ImageIcon("imgs/rotate.png")) {
            @Override
            public void onClick() {
                gameData.move(true,-1);
                mainWin.getGamePanel().repaint();
            }
        };
        stst = new JButton("开始");
        sett = new imgButton(new ImageIcon("imgs/setting.png")) {
            @Override
            public void onClick() {
                gameData.move(true,-1);
                mainWin.getGamePanel().repaint();
            }
        };
        logi = new imgButton(new ImageIcon("imgs/signin.png")) {
            @Override
            public void onClick() {
                gameData.move(true,-1);
                mainWin.getGamePanel().repaint();
            }
        };

    }

    public void setwin(MainWin mainWin) {
        this.mainWin = mainWin;
    }

    public void setDate(GameData gameData) {
        this.gameData = gameData;
    }
}
