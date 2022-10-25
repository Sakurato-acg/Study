package com.hspedu.ch09.poly.polyparameter;
public class   Test {
    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnual());
        if (e instanceof Ordinaryemployees ){
            System.out.println(((Ordinaryemployees) e).work());
        }else if (e instanceof manger){
         System.out.println(((manger) e).manage());//向下转型
        }
    }


    public static void main(String[] args) {
        Test test = new Test();
        Ordinaryemployees n1 = new Ordinaryemployees("小黄（员工）", 2000);
        manger n2 = new manger("李总", 30000, 10);


            test.showEmpAnnual(n1);
            test.showEmpAnnual(n2);

        }

}
