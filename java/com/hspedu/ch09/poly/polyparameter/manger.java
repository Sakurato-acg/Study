package com.hspedu.ch09.poly.polyparameter;

public class manger extends Employee{
    private double bonus;//奖金

    public manger(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getAnnual() {
        return super.getAnnual()+bonus;
    }
    public String manage(){
        return  "经理"+getName()+"工资"+getAnnual();
    }
}
