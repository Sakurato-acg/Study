package com.hspedu.ch09.finalize;
//垃圾回收，资源释放
public class finalize {
    public static void main(String[] args) {
        Car car = new Car("baoma");
        car=null;//垃圾,回收堆的空间；
        System.gc();
        System.out.println("退出");
    }
}
class Car{
    private  String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
       System.out.println("释放资源"+name);
    }
}