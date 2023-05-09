package com.type.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.tpe.CarDTO;
import com.type.controller.request.CarRequest;
import com.type.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/car")
public class CarController {

    /*
    {
    "id": 1,
    "brand": "Mercedes",
    "model": "C180",
    "doors": 4,
    "pricePerHour": 1000.0,
    "age": 1
     }
     */

    private CarService carService;


    @PostMapping
    public ResponseEntity<Map<String, String>> saveCar(@RequestBody CarRequest carRequest){
        carService.saveCar(carRequest);
        Map<String, String> map=new HashMap<>();
        map.put("message", "Car successfully saved");
        map.put("success", "true");
        return new ResponseEntity<>(map,HttpStatus.CREATED);


    }
    @GetMapping
    public ResponseEntity<List<CarDTO>> gelAllCars(){

        List<CarDTO> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Long id){
       CarDTO carDTO = carService.getById(id);
        return ResponseEntity.ok(carDTO);
    }



}
