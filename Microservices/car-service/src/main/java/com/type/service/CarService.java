package com.type.service;

import com.tpe.CarDTO;
import com.type.controller.request.CarRequest;
import com.type.domain.Car;
import com.type.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {

    private ModelMapper modelMapper;

    private CarRepository carRepository;

    public void saveCar(CarRequest carRequest) {

        Car car =  modelMapper.map(carRequest, Car.class);
        carRepository.save(car);
    }
    public List<CarDTO> getAllCars() {
     List<Car> carList = carRepository.findAll();
     List<CarDTO> carDTOList = carList.stream().map(this::mapCarToCarDTO).collect(Collectors.toList());
    return carDTOList;
    }
    private CarDTO mapCarToCarDTO(Car car){
        CarDTO carDTO = modelMapper.map(car, CarDTO.class);
        return carDTO;
    }


}