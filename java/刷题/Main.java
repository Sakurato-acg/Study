package 刷题;

import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);
        int in=kb.nextInt();
        SqStack sqStack = new SqStack();
        sqStack.creat();
        for (int i = 0; i <in ; i++) {
            sqStack.push(kb.nextInt());
        }
        sqStack.out_();
        //进栈
        sqStack.push(kb.nextInt());
        sqStack.out_();
        sqStack.remove();
        sqStack.out_();
       // Consumer <SqStack>consumer =()->sqStack.out_();

    }
}

class SqStack {
    public Object[] stackElem;
    public int pop;
    public int maxsize = 20;

    public  void out_(){
        for (int i = pop-1; i >=0; i--) {
            System.out.print(stackElem[i]+" ");
        }
        System.out.println();

    }    public void creat() {
        this.stackElem = new Object[maxsize];
        pop = 0;
    }

    public void push(Object x) throws Exception {
        if (pop + 1 == stackElem.length) {
            throw new Exception("栈已满");
        } else {
            stackElem[pop++] = x;
        }
    }


    public void remove()throws  Exception {
        if (pop > 0) {
            pop--;
        }else
        {
            throw new Exception();
        }
    }
}