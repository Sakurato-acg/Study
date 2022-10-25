package 刷题;

public class Main3 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.count);
        sub.display();
        String str = "abcdefghijk";
        String s = "bcde";
        int index = 0;
        index = str.indexOf(s, index);
        System.out.println("----" + index);
        str = str.substring(0, index) + str.substring(index + 4);
        System.out.println(str);
    }
}

class A {
    int i = 12;
    float f1 = 1.2f;
}

 class Base {
    int count = 10;
    public void display() {
        System.out.println(count);
    }
}

class Sub extends Base {
    int count = 100;

    @Override
    public void display() {
        System.out.println(count);
    }
}
