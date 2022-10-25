package com.hspedu.ch10.Static;

import com.hspedu.Tools.Tool;

//Math 看源码
public class StaticMethod {
    public static void main(String[] args) {
       Student student1=new Student("jack");
       student1.pay(1000);
       Student student2=new Student("mike");
       student2.pay(2000);
       System.out.println( Student.getTot());
       System.out.println(Tool.sum(10,20));


    }
}
class  Student{
    public String name;
    public  static  double  tot;

    public Student(String name) {
        this.name = name;
    }
    //有static就是静态方法
    public  void pay(double fee){
        tot+=fee;
    }
    public   static  double getTot(){
        return tot;
    }
}