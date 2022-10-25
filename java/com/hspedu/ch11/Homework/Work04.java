package com.hspedu.ch11.Homework;

public class Work04 {
    public static void main(String[] args) {
        Car car = new Car(90);
        car.getAir().flow();
    }
}

class Car {
    private double tem;

    public Car(double tem) {
        this.tem = tem;
    }

    class Air {
        public void flow() {
            if (tem > 40) {
                System.out.println("吹冷气");
            } else if (tem < 0) {
                System.out.println("吹热汽");

            } else {
                System.out.println("关闭空调");
            }
        }

    }
    public  Air getAir(){
        return new Air();
    }
}
