package com.hspedu.ch09.poly.polyarr;

public class Student extends Person{
    private  double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String say() {
        return super.say()+"Student的"+score;
    }
    public void study(){
        System.out.println("Student在学习");
    }
}
