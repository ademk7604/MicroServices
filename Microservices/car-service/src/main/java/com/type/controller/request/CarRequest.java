package com.type.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CarRequest {



    private String brand;


    private String model;


    private Integer doors;


    private Double pricePerHour;


    private Integer age;

}