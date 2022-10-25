package com.hspedu.ch11.Homework;

public class Work03 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", new Horse());
        person.passRiver();
        person.Common();
    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("MA");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("BOAT");
    }
}

class Fatory {
    private static Horse horse=new Horse();
    private Fatory(){}
    public static Horse getHouse() {
        //return new Horse();
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();

    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = Fatory.getBoat();
        }
        vehicles.work();
    }

    public void Common() {
        if (vehicles == null || vehicles instanceof Boat) {
            vehicles = Fatory.getHouse();
        }

        vehicles.work();
    }
}