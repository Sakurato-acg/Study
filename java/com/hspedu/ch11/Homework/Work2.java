package com.hspedu.ch11.Homework;

public class Work2 {
    public static void main(String[] args) {
   CellPhone cellPhone=new CellPhone();
   cellPhone.test(new jsj() {
       @Override
       public double work(double n1, double n2) {
            return  n1+n2;
       }
   },10,4);
    }
}
interface jsj{
    double work(double n1,double n2);
}
class  CellPhone{
    public  void test(jsj jsj,double n1,double n2){
        double res=jsj.work(n1,n2);
        System.out.println(res);
    }

}
