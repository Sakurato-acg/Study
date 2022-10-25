package com.hspedu.ch10.Abstract;

public class Exercise01 {
    public static void main(String[] args) {
        Employee employee=new Mangerc("dd",1,9000,900);
        employee.work();
         System.out.println();
    }
}

abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}

class Mangerc extends Employee {
    private double bonus;

    public Mangerc(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public void work() {
    System.out.print(getName()+getId()+getSalary()+getBonus());
    }
}
