package com.tpe.encapsulation;

public class CarRunner {
    public static void main(String[] args) {
        Car car1 = new Car();

        car1.brand="Toyota";

        System.out.println(car1.brand);

        car1.setModel("BMW");

        System.out.println(car1.getFuel());

    }
}
