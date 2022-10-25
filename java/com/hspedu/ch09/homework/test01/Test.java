package com.hspedu.ch09.homework.test01;


public class Test {
    public static void main(String[] args) {
        Person[] p = new Person[3];
        p[0] = new Person("jack", 10, "电子厂");
        p[1] = new Person("Mack", 99, "外卖");
        p[2] = new Person("Milan", 80, "模特");
        for (int i = 0; i < p.length ; i++) {
            System.out.println(p[i].toString());
        }
        Person person = new Person(p);
        person.sort();
        person.exit();
        /*
        for(int i=0;i<p.length-1;i++){
        forj(j=0;j<l-1-i;j++){
        交换}

        }
         */
    }
}
//封装+toString()
class Person {
    private String name;
    private int age;
    private String job;
    Person[] p;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    public Person(Person[] p) {
        this.p = p;
    }

    public void sort() {
        for (int i = 0; i < 2; i++) {
            for (int j = i; j < 2; j++) {
                if (p[j].age > p[j + 1].age) {
                    Person temp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp;
                }
            }
        }
    }

    public void exit() {
        for (int i = 0; i < 3; i++) {
            System.out.println(p[i].name + "\t" + p[i].age + "\t" + p[i].job);
        }
    }
}