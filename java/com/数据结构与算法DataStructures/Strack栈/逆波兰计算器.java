package com.数据结构与算法DataStructures.Strack栈;


import java.util.*;
import java.util.Stack;

public class 逆波兰计算器 {
    public static void main(String[] args) {

//        String ex = "3 4 + 5 * 6 -";
//        System.out.println(cal(getString(ex)));
//1+(2*3)*3
        Scanner kb = new Scanner(System.in);
        String turn = kb.nextLine();
        System.out.println(getBoLan(turn));

    }

    public static String getBoLan(String turn) {
        //+(*)  123+4
        //1+((2+3)*4)-5  123+4*5-;
        ArrayList<String> arrayList = new ArrayList<>();
        String[] split = turn.split("");
        Collections.addAll(arrayList, split);

        Stack<String> zhong = new Stack<>();
        ArrayList<String> hou = new ArrayList<>();

        for (String item : arrayList) {
            if (item.matches("\\d+")) {
                hou.add(item);
            } else if (item.equals("(")) {
                zhong.push(item);
            } else if (item.equals(")")) {
                while (!zhong.peek().equals("(")) {
                    hou.add(zhong.pop());
                }
                zhong.pop();
            } else {
                while (zhong.size() != 0 && dengJi(zhong.peek()) >= dengJi(item)) {
                    hou.add(zhong.pop());
                }
                zhong.push(item);
            }
        }
        while (!zhong.isEmpty()){
            hou.add(zhong.pop());
        }
        String str="";
        for (String s : hou) {
            str += s;
        }
        return str;
//        Stack<String> zhong = new Stack<>();
//        Stack<String> hou = new Stack<>();
//        int num=0;
//        for (String item : arrayList) {
//            if (item.matches("\\d+")) {
//                hou.push(item);
//            } else {
//                if (item.equals("+") || item.equals("-") ||
//                        item.equals("*") || item.equals("/")) {
//                    zhong.push(item);
//                } else if (item.equals("(")) {
//                    zhong.push(item);
//                    num++;
//                } else if (item.equals(")")) {
//                    hou.push(zhong.pop());
//                    zhong.pop();
//                    num--;
//                    if (num==0){
//                        hou.push(zhong.pop());
//                    }
//                }
//            }
//        }
//        String ss = "";
//        if (!zhong.isEmpty()){
//             ss=zhong.pop();
//        }
//        while (!zhong.isEmpty()){
//            String sss=zhong.pop();
//            if (dengJi(ss)<=dengJi(sss)){
//                hou.push(ss);
//                hou.push(sss);
//            }else {
//                hou.push(sss);
//                hou.push(ss);
//            }
//        }
//        String str="";
//        while (!hou.isEmpty()) {
//            str=hou.pop()+str;
//        }
//        return str;
    }

    public static int dengJi(String item) {
        int res=0;
        switch (item){
            case "+":
            case"-":
                res=1;
                break;
            case"*":
            case"/":
                res=2;
                break;
            default:
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return res;
    }

    public static List<String> getString(String ex) {
        String[] s = ex.split(" ");
        ArrayList<String> strings = new ArrayList<String>();
        Collections.addAll(strings, s);
        return strings;
    }


    public static int cal(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num2 + num1;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException();
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
