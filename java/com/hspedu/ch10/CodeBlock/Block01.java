package com.hspedu.ch10.CodeBlock;

public class Block01 {
    public static void main(String[] args) {
      Movie movie=new Movie("杂七杂八.da");
      System.out.println(movie);
    }
}
class Movie{
    private String name;
    private double price;
    static  {
        System.out.println("公告");
    }
    //先调用代码块

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }

    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
        //System.out.println("公告");
    }

    public Movie(String name) {
        this.name = name;
       //System.out.println("公告");
    }
}
