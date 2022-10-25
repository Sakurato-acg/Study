package MyProject.Tetris;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tetris_ extends JFrame {

    int width = Toolkit.getDefaultToolkit().getScreenSize().width;//屏幕宽度
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//屏幕高度

    public Tetris_() {
        JMenuBar jMenu = new JMenuBar();
        setJMenuBar(jMenu);
        JMenu game = new JMenu("游戏");
        JMenuItem newgame = game.add("新游戏");
        JMenuItem pause = game.add("暂停");
        JMenuItem goon = game.add("继续");
        JMenuItem exit = game.add("退出");
        JMenu help = new JMenu("帮助");
        JMenuItem about = help.add("关于");
        jMenu.add(game);
        jMenu.add(help);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 650);
        setLocation((width - 500) / 2, (height - 700) / 2);
        setTitle("Tetris内测版");
        //setUndecorated(true);无边框

        setVisible(true);
        setResizable(true);
        Tetris_Block tetris_block = new Tetris_Block();
        add(tetris_block);
    }
}

class Tetris_Block extends JPanel implements KeyListener {
    private int blockType;
    private int score = 0;
    // blockType 代表方块类型
    // turnState代表方块状态
    private int turnState;
    public int i;
    public int j;
    public int x;
    public int y;
    //2--围墙 0--空
    int[][] map = new int[22][12];//22行 12列
    //0-21   0-11

    // 方块的形状 第一组代表方块类型有S、Z、L、J、I、O、T 7种
    // 第二组 代表旋转几次 第三四组为 方块矩阵
    private final int shapes[][][] = new int[][][]{
            // i
            {{0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}},
            // s
            {{0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                    {0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}},
            // z
            {{1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}},
            // j
            {{0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
            // o
            {{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
            // l
            {{1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                    {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
            // t
            {{0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                    {1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0}}};

    public Tetris_Block() {
        drawwall();
        newMap();
        newBolck();
    }

    public void drawwall() {
        for (i = 0; i < 12; i++) {
            map[21][i] = 2;
        }
        for (j = 0; j < 22; j++) {
            map[j][0] = 2;
            map[j][11] = 2;
        }
    }

    public void newMap() {
        for (int k = 0; k <= 20; k++) {
            for (int l = 1; l <= 10; l++) {
                map[k][l] = 0;
            }

        }
    }

    // 画方块的的方法
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 画当前方块
        for (j = 0; j < 16; j++) {
            if (shapes[blockType][turnState][j] == 1) {
                g.fillRect((j % 4 + x + 1) * 10, (j / 4 + y) * 10, 10, 10);
            }
        }
        // 画已经固定的方块
        for (j = 0; j < 22; j++) {
            for (i = 0; i < 12; i++) {
                if (map[j][i] == 1) {
                    g.fillRect(i * 25, j * 25, 25, 25);

                }
                if (map[j][i] == 2) {
                    g.drawRect(i * 25, j * 25, 25, 25);

                }
            }
        }
        g.drawString("score=" + score, 325, 10);
        g.drawString("抵制不良游戏，", 325, 50);
        g.drawString("拒绝盗版游戏。", 325, 70);
        g.drawString("注意自我保护，", 325, 90);
        g.drawString("谨防受骗上当。", 325, 110);
        g.drawString("适度游戏益脑，", 325, 130);
        g.drawString("沉迷游戏伤身。", 325, 150);
        g.drawString("合理安排时间，", 325, 170);
        g.drawString("享受健康生活。", 325, 190);
    }

    public void newBolck() {
        blockType = (int) (Math.random() * 7 + 1);//方块类型
        turnState = (int) (Math.random() * 4 + 1);//方块状态
        x = 4;
        y = 0;
    }
    // 下落的方法
    public void down() {
        if (blow(x, y + 1, blockType, turnState) == 1) {
            y = y + 1;
            //delline();
        }

        if (blow(x, y + 1, blockType, turnState) == 0) {
            //add(x, y, blockType, turnState);
            newBolck();
           // delline();
        }
        ;
        repaint();
    }
    // 是否合法的方法
    public int blow(int x, int y, int blockType, int turnState) {
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if (((shapes[blockType][turnState][a * 4 + b] == 1) && (map[x
                        + b + 1][y + a] == 1))
                        || ((shapes[blockType][turnState][a * 4 + b] == 1) && (map[x
                        + b + 1][y + a] == 2))) {

                    return 0;
                }
            }
        }
        return 1;
    }
    // 把当前添加map
    public void add(int x, int y, int blockType, int turnState) {
        int j = 0;
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if (map[x + b + 1][y + a] == 0) {
                    map[x + b + 1][y + a] = shapes[blockType][turnState][j];
                }
                j++;
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
