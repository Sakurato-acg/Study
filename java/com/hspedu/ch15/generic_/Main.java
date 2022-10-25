package com.hspedu.ch15.generic_;

public class Main {
    public static void main(String[] args) {
        Person<String> stringPerson = new Person<String>("LPL");
    }
}
class Person<E>{
    E s;

    public Person(E s) {
        this.s = s;
    }
}