package MyProject.Cpoy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class FiveChess extends JFrame implements MouseListener {
    public static void main(String[] args) {

    }
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;//屏幕宽度
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//屏幕高度



    int[][] allChess = new int[19][19];//用来保存全部棋子
    boolean canPlay = true;//判断游戏是否能继续
    int x = 0;//棋子的坐标
    int y = 0;
    boolean isBlack = true;//判断当前棋子的颜色
    //对窗口进行初始化
    public FiveChess() {
        setTitle("五子棋");
        setSize(500, 500);
        setLocation((width - 500) / 2, (height - 500) / 2);
        setResizable(true);
        addMouseListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        int windowWidth = this.getWidth(); //获得窗口宽

        int windowHeight = this.getHeight(); //获得窗口高
        
    }

    public void paint(Graphics g){
        g.setFont(new Font("黑体", Font.BOLD, 20));
        g.drawString("游戏信息", 120, 60);
        g.setFont(new Font("宋体", Font.BOLD, 12));
        g.drawString("黑方时间", 60, 480);
        g.drawString("白方时间", 260, 480);
        //画线
        //画19条横线
        int y_index = 0;
        for (int i = 0; i < 19; i++) {
            g.drawLine(12, 73 + y_index, 372, 73 + y_index);
            y_index += 20;
        }

        //画19条纵线
        int x_index = 0;
        for (int i = 0; i < 19; i++) {
            g.drawLine(12 + x_index, 73, 12 + x_index, 433);
            x_index += 20;
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
