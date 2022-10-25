package 杂七杂八;

public class Main4 {
    public static void main(String[] args) {
        System.out.println(f(5));
    }

    public static int  f(int n){
        if (n==1){
            return n;
        }
        return f(n-1)+n;
    }
}
