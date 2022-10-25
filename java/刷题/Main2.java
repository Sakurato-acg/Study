package 刷题;

public class Main2 {
    public static void main(String[] args) {
        Person p= new Person();
        p.x="dad";
        p.age=90;
        B b = new B();
        b.test(p);
        System.out.println(p.age);
        int []old={1,2,3,3,4,4};
        int [] NewArr=old;
        for (int i = 0; i < NewArr.length ; i++) {
            System.out.println(NewArr[i]);
        }
    }
}
class Person{
    String x;
    int age ;
}
class B{
    public void test(Person p){
        p=new Person();
        p.x="lpl";
        p.age=100;
    }
}
