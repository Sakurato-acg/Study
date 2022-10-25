package com.hspedu.ch15.generic_;
import java.util.ArrayList;
import java.util.Comparator;

public class EX {
    public static void main(String[] args) {
        ArrayList<Employee> lpl = new ArrayList<Employee>();
        lpl.add(new Employee("lpl",19,new MyDate(2002,12,21)));
        lpl.add(new Employee("lpl",787,new MyDate(2004,12,21)));
        lpl.add(new Employee("ikikii",34,new MyDate(2009,12,21)));
        //元素进行降序排x.sort(Comparator.reverseOrder())
        //元素进行升序排sites.sort(Comparator.naturalOrder());
        lpl.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int i=o1.name.compareTo(o2.name);
                System.out.println(i);
                if (i!=0){
                    return i;
                }
                int m=o1.birthday.yy- o2.birthday.yy;
                if (m!=0){
                    return m;
                }
                int k=o1.birthday.mm- o2.birthday.mm;
                if (k!=0){
                    return k;
                }
                return o1.birthday.dd- o2.birthday.dd;
            }
        });
        System.out.println(lpl);
    }
}
class Employee{
    public String name;
    public int sal;
    public MyDate birthday;

    public Employee(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}'+"\n";
    }
}
class MyDate{
    public int yy;
    public int mm;
    public int dd;

    public MyDate(int yy, int mm, int dd) {
        this.yy = yy;
        this.mm = mm;
        this.dd = dd;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "yy=" + yy +
                ", mm=" + mm +
                ", dd=" + dd +
                '}'+"\n";
    }
}
