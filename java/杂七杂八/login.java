package 杂七杂八;//LoginUI类：实现界面的设置，构建方法，封装好所有的界面开发代码


//①initUI方法 ：1、创建窗体对象；

//2、设置窗体的相关属性（标题、尺寸、大小、关闭、可视化）；

//3、创建组件对象，按钮，输入框；

//4、界面窗口添加按钮；

//5、按钮添加监听器。

//②main方法 ：用自己的类创建对象，调用自己的方法 


import javax.swing.*;
import java.awt.*;

public class login {
    //一、界面方法
    public void initUI(){
        //1：创建一个窗体的对象；

        JFrame jf = new JFrame();

        //2：设置窗体的相关属性：标题，尺寸，关闭选项操作 可视化

        jf.setTitle("登录界面");
        jf.setSize(500,800);                //像素单位
        jf.setResizable(true);			    //尺寸固定
        //jf.setLocation(1000,400); 		//位置固定 可更改
        jf.setLocationRelativeTo(null);     //居中显示

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //退出方式

        jf.setVisible(true);

        FlowLayout f1 = new FlowLayout();	//流式布局
        jf.setLayout(f1);

        //3：创建组件对象，按钮，输入框
        //按钮
        JButton btn = new JButton ("登录");

        //标签
        JLabel namejla = new JLabel("账号: ");
        JLabel pwdjla = new JLabel ("密码: ");

        //输入框
        JTextField nameJtf = new JTextField();
        JTextField pwdJtf = new JTextField();

        //图片标签
        ImageIcon imgicon = new ImageIcon("src\\MA146001_bg.png");//图片插入，更改图片路径，需要注意后缀

        JLabel imgjla = new JLabel(imgicon);


        //组件设置尺寸
        Dimension dimsize = new Dimension (420,50);
        nameJtf.setPreferredSize(dimsize);
        pwdJtf.setPreferredSize(dimsize);


        //4：界面窗体添加按钮
        jf.add(imgjla);
        jf.add(namejla);
        jf.add(nameJtf);
        jf.add(pwdjla);
        jf.add(pwdJtf);
        jf.add(btn);

        //可视化在所有组件加载之后
        jf.setVisible(true);	//可视化 交给系统渲染到屏幕上

        //按钮添加监听器
//        ButtonAction btnaction = new ButtonAction();
//        btn.addActionListener(btnaction);
//        btnactino.count=100;
//        btnactino.nameJtf= nameJtf;
//        btnactino.pwdJtf= pwdJtf;
    }


    //二、主函数部分
    public static void main(String[] args) {
        //创建自己写的类的对象；
        login loginui = new login();
        //调用方法
        loginui.initUI();
    }

}
 