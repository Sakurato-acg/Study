package 刷题;
import java.util.Scanner;

public class C{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a,b,t;
        Scanner kb =new Scanner(System.in);
        a=kb.nextInt();
        b=kb.nextInt();
        //t=a,a=b,b=t;
        t=a;a=b;b=t;


        //a=t,t=b,b=a;
        System.out.println("a = "+a+", b = "+b);

    }

}