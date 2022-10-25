package com.hspedu.ch09.poly.polyparameter;

public class Ordinaryemployees extends Employee{
    public Ordinaryemployees(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
    public String work(){
        return "员工"+getName()+"工资"+getAnnual();
    }
}
