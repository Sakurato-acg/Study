
package com.hspedu.ch11.Enumeration;

public class Enum01 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
    }
}
//自定义枚举
//1.构造器私有化
//2.只get不set
//3.在类内部，直接创建固定的对象
//4.final
@SuppressWarnings({"all"})
class Season {
    private String name;
    public final static Season SPRING = new Season("春天");
    public final static Season SUMMER = new Season("夏天");
    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                '}';
    }
    private Season(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}