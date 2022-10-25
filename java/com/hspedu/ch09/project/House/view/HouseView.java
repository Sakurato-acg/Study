package com.hspedu.ch09.project.House.view;

import com.hspedu.ch09.project.House.domain.House;
import com.hspedu.ch09.project.House.service.Houseservie;

import java.util.Scanner;

public class HouseView {
    Scanner kb = new Scanner(System.in);
    private boolean loop = true;
    private String key;
    private Houseservie houseservie = new Houseservie(10);
    private int find;
    //新增
    public void addHouse() {
        System.out.println("----------添加房屋----------");
        System.out.println("姓名：");
        String name = kb.next();
        System.out.println("电话：");
        String phone = kb.next();
        System.out.println("地址：");
        String address = kb.next();
        System.out.println("月租：");
        int rent = kb.nextInt();
        System.out.println("状态：");
        String state = kb.next();
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseservie.add(newHouse)) {
            System.out.println("----------添加房屋成功----------");
        } else {
            System.out.println("----------添加房屋失败----------");
        }


    }
    public void find(){
        System.out.println("查找");
        System.out.println("id");
        find=kb.nextInt();
        House house= houseservie.findid(find);
if (house!=null){System.out.println(house);}
else {System.out.println(" 没有");
}
    }
    //delete
    public void delHouse() {
        System.out.println("==========删除房屋信息==========");
        System.out.println("请输入待删除房屋的编号（-1退出）：");
        int delect=kb.nextInt();
        if (delect==-1){
            System.out.println("放弃删除");
            return;
        }
        System.out.println("你确定要删除吗 y/n");
        String choice;
        do {
            choice = kb.next();
        } while (!"y".equals(choice) && !"n".equals(choice));
        if ("y".equals(choice)) {
           if (houseservie.Delect(delect)) {
               System.out.println("成功");
           }else{
               System.out.println("失败");
           }
        } else {
            System.out.println("取消退出");
        }
        System.out.println("退 出");



    }
    //Revise,update
    public void Revise(){
        System.out.println("==========修改房屋==========");
        System.out.println("请输入待修改房屋的编号（-1退出）：");
         int update=kb.nextInt();
         if (update==-1){
             System.out.println("放弃修改");
         }
          House house=houseservie.findid(update);
         if(house==null){
             System.out.println("不存在");
         }
         System.out.print("姓名（"+house.getName()+")");
         String name=kb.next();
         if (!"".equals(name)){
             house.setName(name);
         }
         System.out.print("电话（"+house.getPhone()+")");
        String phone=kb.next();
        if (!"".equals(phone)){
            house.setPhone(phone);
        }
         System.out.print("地址（"+house.getAddress()+")");
        String address=kb.next();
        if (!"".equals(address)){
            house.setAddress(address);
        }
         System.out.print("月租（"+house.getRent()+")");
        int rent=kb.nextInt();
        if (rent !=-1){
            house.setRent(rent);
        }
        System.out.print("状态（"+house.getState()+")");
        String state=kb.next();
        if (!"".equals(state)){
            house.setState(state);
        }
        System.out.println("修改成功");



    }

    //list
    public void ListHouses() {
        System.out.println("==========房屋列表==========");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseservie.list();//得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            House house = houses[i];
            if (house == null) {
                break;
            }
            System.out.println(house);
        }
        System.out.println("==========房屋列表显示完毕==========");
    }
    public void Choice(){
        String choice;
        do {
            choice = kb.next();
        } while (!"y".equals(choice) && !"n".equals(choice));
        if ("y".equals(choice)) {
            loop = false;
        } else {
            System.out.println("取消退出");
        }
        System.out.println("退 出");
        loop = false;
    }

    public void mainMenu() {
        do {
            System.out.println("\n==========房屋出租系统菜单==========");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 显 示 房 屋 信 息");
            System.out.println("\t\t\t6 退         出");
            System.out.println("请输入你的选择（1-6）：");
            key = kb.next();
            switch (key) {
                case "1" -> addHouse();
                case "2" -> find();
                case "3" -> delHouse();
                case "4" ->Revise();
                case "5" -> ListHouses();
                case "6" -> {
                    System.out.println("你确定要退出吗 y/n");
                    Choice();
                }
            }
        } while (loop);

    }
}
