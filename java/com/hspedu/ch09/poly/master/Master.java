package com.hspedu.ch09.poly.master;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    //完成喂食
    //public  void feed(Dog dog,Bone bone){
       // System.out.println("主人"+name+"给"+dog.getName()+"吃"+bone.getName());
   // }
    //fed很多   //使用多态机制//多态只能用父子类都有的东西animal.getName
    public void feed(Animal animal,Food food ){
        System.out.println("主人"+name+"给"+animal.getName()+"吃"+food.getName());
    }
}

