package com.type.controller;

import java.util.HashMap;
import java.util.Map;


import com.type.controller.request.CarRequest;
import com.type.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;


    @PostMapping
    public ResponseEntity<Map<String, String>> saveCar(@RequestBody CarRequest carRequest){
        carService.saveCar(carRequest);
        Map<String, String> map=new HashMap<>();
        map.put("message", "Car successfully saved");
        map.put("success", "true");
        return new ResponseEntity<>(map,HttpStatus.CREATED);


    }




}
