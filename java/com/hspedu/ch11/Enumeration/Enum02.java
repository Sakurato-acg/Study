package com.hspedu.ch11.Enumeration;

public class Enum02 {
    public static void main(String[] args) {
   System.out.println(Season2.WINTER);
    }
}
enum Season2{
    WINTER("冬天"),
    AUTUMN("秋天");
    private  String name;
    Season2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                '}';
    }
}