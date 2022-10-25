package com.hspedu.ch10.AnonymousInner;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {
    private int n1 = 10;

    public void method() {
        //基于接口的匿名内部类
        //想使用接口,
        //传统要创建对象，使用一次
        Tiger tiger = new Tiger();
        tiger.cry();
        //匿名内部类
         A t=new A( ) {
            @Override
            public void cry() {
                System.out.println("老虎叫喊");
            }
        };
        t.cry();
        //基于类的匿名内部类
        //运行类型是匿名的Outer04$2
        Father father=new Father("杂七杂八.da"){
            @Override
            public void test() {
                super.test();
            }
        };
        father.test();
        System.out.println(father.getClass());//Outer04$2

        Animal animal=new Animal(){
            @Override
            public void eat() {
                System.out.println("小狗");
            }
        };
        animal.eat();
    }
}


interface A {

    void cry();
}

class Tiger implements A {
    @Override
    public void cry() {
        System.out.println("老虎");
    }
}

class Father {
    public Father(String name) {


    }

    public void test() {
        System.out.println("Father");
    }
}

abstract  class Animal{
    public abstract void eat();
}