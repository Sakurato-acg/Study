package com.hspedu.ch12.Exception;

public class CustomException {
    public static void main(String[] args) {
        int age = 180;
        if (!(age >= 10 && age <= 120)) {
       throw new AgeException("lpl");
        }
    }
}

class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}