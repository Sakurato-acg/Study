package MyProject.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new Main();
    }
    public Main(){
        setBounds(100,100,400,400);
        setTitle("计算器");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}