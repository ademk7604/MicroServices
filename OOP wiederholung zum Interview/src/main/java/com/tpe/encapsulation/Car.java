package com.tpe.encapsulation;

public class Car {
    String brand = "brand not specified";
    private String model = "model not specified";
    private String fuel= "electric";

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }
}
