package com.数据结构与算法DataStructures.Strack栈;

import java.util.Scanner;
@SuppressWarnings("all")
public class 计算器 {
    public static void check(StackNode_ operStack, char ch, StackNode_ number) {
        while (!operStack.getHead().value.equals('(') && operStack.getHead().pre!=null) {
            double num1 = (double) number.pop();
            double num2 = (double) number.pop();
            int oper = (char) operStack.pop();
            if (operStack.getHead().value.equals('-')){
                if (oper=='-'){
                    oper='+';
                }else if (oper=='+'){
                    oper='-';
                }
            }
            double res = number.cal(num1, num2, oper);
            number.push(res);
        }
        if (operStack.getHead().pre==null){
            return;
        }
            operStack.pop();
    }
// I,S,T,J
    public static void main(String[] args) {
        String ex = "11-(6*2-1)+9";
        //大家算一下 5-6*2-10
        //你说别人脑子不动，搞得你很聪明一样，“1-2*2-1”，快去算吧，看看谁脑子不动
        Scanner kb = new Scanner(System.in);
        ex = kb.nextLine();
        StackNode_ number = new StackNode_();//数字栈
        StackNode_ operStack = new StackNode_();//符号栈
        //3-2*6+5也有问题
        int index = 0;
        double num1;
        double num2;
        int oper;
        double res;
        char ch;
        String keepNum = "";
        while (true) {

            ch = ex.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {//判断是否为运算符

                if (!operStack.isEmpty()) {//如果字符栈不为空
                    if (operStack.priority(ch) <= operStack.priority((Character) operStack.getHead().value)) {
                        if (ch == '(') {
                            operStack.push(ch);
                        } else if (ch == ')') {

                            num1 = (double) number.pop();
                            num2 = (double) number.pop();
                            oper = (char) operStack.pop();
                            if (operStack.getHead().value.equals('-')){
                                if (oper=='-'){
                                    oper='+';
                                }else if (oper=='+'){
                                    oper='-';
                                }
                            }
                            res = number.cal(num1, num2, oper);
                            number.push(res);
                            check(operStack, (char) operStack.getHead().value, number);

                        } else {
                            num1 = (double) number.pop();
                            num2 = (double) number.pop();
                            oper = (char) operStack.pop();
                            if (operStack.getHead().value.equals('-')){
                                if (oper=='-'){
                                    oper='+';
                                }else if (oper=='+'){
                                    oper='-';
                                }
                            }
                            res = number.cal(num1, num2, oper);
                            number.push(res);
                            operStack.push(ch);
                        }
                    } else {
                        //入栈
                        operStack.push(ch);
                    }
                } else {//如果字符栈为空
                    operStack.push(ch);
                }
            } else {//数字的情况
                keepNum = keepNum + ch;
                if (index == ex.length() - 1) {
                    number.push(Double.parseDouble(keepNum));
                    check(operStack, (Character) operStack.getHead().value, number);
                } else {

                    if (operStack.isOper(ex.substring(index + 1, index + 2).charAt(0))) {
                        number.push(Double.parseDouble(keepNum));
                        keepNum = "";
                    }

                }
            }
            index++;
            if (index >= ex.length()) {

                break;
            }
        }

        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号并运算
        while (!operStack.isEmpty()) {
            //如果符号栈为空，则计算到了最后的结果，数栈中只有一个数字
            num1 = (double) number.pop();
            num2 = (double) number.pop();

            oper = (char) operStack.pop();
            if ((operStack.getHead().value).equals('-')) {
                if (oper == '-') {
                    oper = '+';
                } else {
                    oper = '-';
                }
                res = number.cal(num1, num2, oper);
                number.push(res);//入栈
            } else {
                res = number.cal(num1, num2, oper);
                number.push(res);//入栈
            }

        }
        System.out.printf("表达式%s = %f", ex, (double) number.pop());
    }
}
@SuppressWarnings("all")
class StackNode_ {
    private Node_ head = new Node_("");
    private int top = 0;

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(Object value) {
        Node_ node = new Node_(value);
        node.pre = head;
        head = node;
        top++;
    }

    public Node_ getHead() {
        return head;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("空");
        }
        Node_ temp = head;
        head = head.pre;
        top--;
        return temp.value;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("空");
        }
        for (int i = top; i > 0; i--) {
            System.out.println(head);
            head = head.pre;
            top--;
        }
    }

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else if (oper == '(' || oper == ')') {
            return -1;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/' || val == '(' || val == ')';
    }

    public double cal(double num1, double num2, int oper) {
        double res = switch (oper) {
            case '+' -> num1 + num2;
            case '-' -> num2 - num1;
            case '*' -> num1 * num2;
            case '/' -> num2 / num1;
            default -> 0;
        };
        return res;
    }
}

class Node_ {
    public Object value;
    public Node_ pre;

    public Node_(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value;
    }

}