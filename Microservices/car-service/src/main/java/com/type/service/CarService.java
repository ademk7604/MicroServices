package com.type.service;

import com.type.controller.request.CarRequest;
import com.type.domain.Car;
import com.type.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarService {

    private ModelMapper modelMapper;

    private CarRepository carRepository;

    public void saveCar(CarRequest carRequest) {

        Car car =  modelMapper.map(carRequest, Car.class);
        carRepository.save(car);


    }

}