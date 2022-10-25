package com.hspedu.ch13.Math00;

public class MathALL {
    public static void main(String[] args) {
        double res=5.5;
        System.out.println(Math.abs(res));//绝对值
        System.out.println(Math.pow(res,3));//求幂
        System.out.println(Math.ceil(res));//向上取整
        System.out.println(Math.floor(res));//向下取整
        System.out.println(Math.round(res));//四舍五入
        System.out.println(Math.sqrt(res));//开平方
        for (int i = 0; i <10 ; i++) {
            System.out.print((int)(Math.random()*6+2)+"—");
            //Math.random()*(7-2+1)+2  取2~7的话
    }
}
}
