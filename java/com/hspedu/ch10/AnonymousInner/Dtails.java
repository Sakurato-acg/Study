package com.hspedu.ch10.AnonymousInner;

public class Dtails {
    public static void main(String[] args) {
              new Outer05().f1();
    }
}

class Outer05 {
    private int n1 = 99;

    public void f1() {
        //1.
        Person person=new Person() {
            @Override
            public void hi() {
                System.out.println("重写了"+n1 );
            }
        };
        person.hi();
        //2.匿名内部类本身是对象

      new Person() {
            @Override
            public void hi() {
                System.out.println("重写了hihihi");
            }

          @Override
          public void ok(String str) {
              super.ok(str);
          }
      }.ok("jack");
    }
}

class Person {
    public void hi() {
        System.out.println("Person");
    }
    public void ok(String str){
        System.out.println(str);
    }
}
