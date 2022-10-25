package MyProject.eluosi.view;

import MyProject.eluosi.controller.Opration;

import javax.swing.*;
import java.awt.*;

public class StaticPanel extends JPanel {
    JButton left;
    JButton righ;
    JButton down;
    JButton rota;
    JButton stst;
    JButton sett;
    JButton logi;

    public StaticPanel(Opration opration) {
        left = opration.left;
        righ = opration.righ;
        down = opration.down;
        rota = opration.rota;
        stst = opration.stst;
        sett = opration.sett;
        logi = opration.logi;
        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, 360, 600);

        left.setBounds(233, 255, 45, 45);
        righ.setBounds(278, 255, 45, 45);
        down.setBounds(233, 300, 45, 45);
        rota.setBounds(278, 300, 45, 45);
        stst.setBounds(233, 350, 90, 50);
        sett.setBounds(240, 510, 48, 48);
        logi.setBounds(290, 510, 48, 48);
        add(left);
        add(righ);
        add(down);
        add(rota);
        add(stst);
        add(sett);
        add(logi);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(150, 150, 150, 70));
        g.fillRect(15, 30, 200, 360);
        g.fillRect(15, 405, 200, 130);
        g.fillRect(223, 20, 110, 400);
        g.setColor(new Color(2, 2, 2, 30));
        g.fillRect(233, 30, 90, 70);
        g.fillRect(233, 105, 90, 140);
        g.fillRect(233, 255, 90, 90);
        g.setColor(Color.white);
        ((Graphics2D) g).setStroke(new BasicStroke(3L));
        g.drawRect(13, 28, 204, 364);
        g.drawRect(13, 403, 204, 134);
        g.setFont(new Font("黑体", Font.PLAIN, 22));
        g.setColor(Color.DARK_GRAY);
        g.drawString("得分", 240, 53);
        g.drawString("下一个", 236, 140);
        g.drawString("荣誉榜", 25, 435);
    }
}
