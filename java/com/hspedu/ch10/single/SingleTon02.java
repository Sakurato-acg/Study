package com.hspedu.ch10.single;

public class SingleTon02 {
    public static void main(String[] args) {
            System.out.println(Cat.n1);
        Cat instance = Cat.getInstance();
        System.out.println(instance);
        Cat instance1 = Cat.getInstance();
        System.out.println(instance1);
    }
}
//懒汉式
//希望只有一个cat对象
//1.私
//2.静态对象
//3.提供一个public的static方法，可以返回一个Cat对象
class Cat{
    private String name;
    public static int n1=999;
    private static Cat cat;
    private Cat(String name) {
        this.name = name;
    }
    public static Cat getInstance(){
        if (cat==null){
             cat=new Cat("dad");
        }
        return cat;
    }
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}