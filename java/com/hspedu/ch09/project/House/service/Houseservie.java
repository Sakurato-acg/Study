package com.hspedu.ch09.project.House.service;


import com.hspedu.ch09.project.House.domain.House;

public class Houseservie {
    private int houseNumbers = 1;
    private int idCounter = 1;

    private House[] houses;

    public Houseservie(int size) {
        houses = new House[size];
         houses[0]=new House(1,
                 "s","sc","acca",2000,"NO");
    }
    public House findid(int find){
        for (int i = 0; i < houseNumbers; i++) {
            if (find==houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }
    public  boolean Delect(int delect){
        int index=-1;
        for (int i = 0; i < houseNumbers; i++) {
            if (delect ==houses[i].getId()){
                  index=i;

            }
        }
        if (index==-1){
            return false;
        }
        for (int i = index; i < houseNumbers-1; i++) {
            houses[i]=houses[i+1];
        }
        houses[--houseNumbers]=null;
        return true;

    }
    public boolean add(House newHouse) {

        if (houseNumbers == houses.length) {
            System.out.println("已满");
            return false;
        }

        houses[houseNumbers++] = newHouse;
        newHouse.setId(++idCounter);
        return true;

    }

    public House[] list() {
        return houses;

    }

    }

