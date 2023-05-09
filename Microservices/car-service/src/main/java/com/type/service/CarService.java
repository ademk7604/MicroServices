package com.type.service;

import com.tpe.CarDTO;
import com.type.controller.request.CarRequest;
import com.type.domain.Car;
import com.type.exception.ResourceNotFoundException;
import com.type.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
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
    private CarDTO mapCarToCarDTO(Car car){                 // CarDTO yu core servisine maven dan dependency uzerinden ulastik
        CarDTO carDTO = modelMapper.map(car, CarDTO.class); // gelen car i carDTO ya cevirecek
        return carDTO;
    }
    // farkli projelerde bu CarDTO yu kullanabilme imkani saglandi.
    public CarDTO getById(Long id) {
    Car car = carRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Car not found with id:"+id));
    CarDTO carDTO = mapCarToCarDTO(car);
    return carDTO;
    }

}