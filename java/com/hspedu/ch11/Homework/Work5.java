package com.hspedu.ch11.Homework;

public class Work5 {
    public static void main(String[] args) {
        Color green=Color.GREEN;
        green.show();
    }
}
interface mm{
    void show();
}
enum Color implements mm{
    RED(255,0,0),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);
    ;
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }


    @Override
    public void show() {
        System.out.println("属性值"+redValue+","+greenValue+","+blueValue);
    }
}
