package com.hspedu.ch10.Abstract;

public class TestTemplate {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.cal();
        BB bb = new BB();
        bb.cal();
    }
}
abstract class JOB{
    //模板套用
    public abstract void job();
    public void cal() {
        long start = System.currentTimeMillis();
        job();
        long l = System.currentTimeMillis();
        System.out.println(l - start);
    }
}
class AA  extends JOB{
    //1+++++1000000
    /*public void cal() {
        long start = System.currentTimeMillis();
        job();
        long l = System.currentTimeMillis();
        System.out.println(l - start);
    }
*/
    public void job() {

        long num = 0;
        for (long i = 1; i <= 8000000; i++) {
            num += i;
        }


    }

}

class BB extends JOB{
    /*public void cal() {
        long start = System.currentTimeMillis();
        job();
        long l = System.currentTimeMillis();
        System.out.println(l - start);
    }*/

    public void job() {//重写父类
        long num = 0;
        for (long i = 1; i <= 8000000; i++) {
            num *= i;
        }
    }

}
