package com.hspedu.ch09.project.SmallChanage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChanageSysOOP {
    String choice;
    boolean loop = true;
    Scanner kb = new Scanner(System.in);
    String key;

    //完成明细
    String details = "----------零钱通明细----------";
    //完成对账
    double money = 0;
    double balance = 0;
    double moneyout;
    String reason;
    Date date;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//日期格式化


    //主菜单
    public void mainMenu(){
        do {
            System.out.println("----------零钱通菜单----------");
            System.out.println("        1 零钱通明细");
            System.out.println("        2 收益对账");
            System.out.println("        3 消费");
            System.out.println("        4 退出");
            System.out.println("请选择（1-4）:");
            key = kb.next();
            //使用switch分支控制
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("有误");
                    break;
            }

        } while (loop);
    }
    //完成明细
    public  void detail(){
        System.out.println(details);
    }
    //完成入账
    public void income(){
        System.out.println("收益入账金额：");
        money = kb.nextDouble();
        if (money <= 0) {
            System.out.println("收益有误,重新输入");
            return;//退出
        }
        balance += money;
        date = new Date();//当前日期
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额" + balance;

    }
    public  void pay(){
        System.out.println("消费说明：");
        reason = kb.next();
        System.out.println("消费金额：");
        moneyout = kb.nextDouble();
        if (moneyout <= 0 || moneyout > balance) {
            System.out.println("你的消费金额应该在0.0~" + balance);
            return;
        }
        balance -= moneyout;
        date = new Date();
        details += "\n" + reason + "\t-" + moneyout + "\t" + sdf.format(date) + "\t余额" + balance;
    }
 public void  exit() {
     System.out.println("你确定要退出吗 y/n");
     do {
         choice = kb.next();
     } while (!"y".equals(choice) && !"n".equals(choice));
     if ("y".equals(choice)) {
         loop = false;
         System.out.println("----------退出零钱通---------");

     } else {
         System.out.println("取消退出");
     }
 }


}
