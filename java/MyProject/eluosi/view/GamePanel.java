package MyProject.eluosi.view;

import MyProject.eluosi.model.GameData;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    GameData gameData;

    public GamePanel(GameData gameData) {
        this.gameData = gameData;
        setOpaque(false);
        setBounds(15, 30, 200, 360);

    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.fillRect(gameData.x * 20, gameData.y * 20, 20, 20);

    }
}
