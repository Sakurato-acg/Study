package 必看;

import java.util.Scanner;

//递归
public class 递归 {
    public static void main(String[] args) {
        Scanner kb=new Scanner (System.in);
        String s=kb.next();
        long startTime = System.currentTimeMillis();
        System.out.println(s+f(s));
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println(endTime-startTime+"ms");
    }
    public static int f(String cc){
        int key=cc.indexOf("+");
        if (key ==-1){
        return Integer.parseInt(cc.substring(0,cc.length()-1));
        }else {
            return  f(cc.substring(key+1))+Integer.parseInt(cc.substring(0,key));
        }
    }
}

