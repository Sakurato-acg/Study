package com.hspedu.ch09.poly.equals;

public class Equals {
    public static void main(String[] args) {
        Person person = new Person("jakc", '男', 10);
        Person person1 = new Person("jakc", '男', 10);
        Person person2 = new Person("jack", '男', 10);
        String tom=new String("person");
        String tom1=new String("person");
        String tim="person";

            System.out.println(person.equals(person1));
            System.out.println(person.equals(person2));
            System.out.println(person.hashCode());
            System.out.println(person1.hashCode());
            System.out.println("---------------");
            System.out.println(tom.equals(tim));
            System.out.println(tom==tom1);
            System.out.println(tom.equals(tom1));
    }
}
class Person{
    private  String name;
    private  char gender;
    private  int age;

    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public  boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person){
        Person p=(Person)obj;
        return (this.name).equals(p.name)&&(this.age)==p.age&&
                (this.gender)==p.gender;


        }
        return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

