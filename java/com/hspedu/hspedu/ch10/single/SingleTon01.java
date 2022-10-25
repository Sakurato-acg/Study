package com.hspedu.ch10.single;

public class SingleTon01 {
    public static void main(String[] args) {
        /*Friend jajd = new Friend("jajd");
        Friend plplp = new Friend("plplp");*/
        //报错
 System.out.println(Friend.getInstance());


    }
}
//单例设计 饿汉式----类加载就创建好了(可能造成创建对象没有使用)
class Friend {
    private String name;
    private static Friend gf = new Friend("dajdaw");

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                '}';
    }

    //如何保障我们只能创建一个对象
    //私有化,在类的内部创建,public方法返回gf对象
    /*public Friend(String name) {
        this.name = name;
    }*/
    public static Friend getInstance() {
        return gf;

    }

    private Friend(String name) {
        this.name = name;
    }
}