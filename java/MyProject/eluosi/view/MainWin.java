package MyProject.eluosi.view;

import MyProject.eluosi.controller.Opration;
import MyProject.eluosi.model.GameData;

import javax.swing.*;
import java.awt.*;


public class MainWin extends JFrame {
    Opration opration;
    GameData gameData;
    GamePanel gamePanel;
    Container mainpanel;

    public MainWin(Opration opration, GameData gameData) {
        this.opration = opration;
        this.gameData = gameData;
        mainpanel = getLayeredPane();
        setBounds(100, 50, 360, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        //设置背景
        setBack();
        //绘制区域
        StaticPanel Jpanel = new StaticPanel(opration);
        mainpanel.add(Jpanel);
        setGamePanel();
    }

    void setBack() {
        ImageIcon imgic = new ImageIcon("imgs/bg.png");
        JLabel jl = new JLabel(imgic);
        jl.setBounds(0, 0, 360, 600);
        getContentPane().add(jl);
    }

    void setGamePanel() {
        gamePanel = new GamePanel(gameData);
        mainpanel.add(gamePanel);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
