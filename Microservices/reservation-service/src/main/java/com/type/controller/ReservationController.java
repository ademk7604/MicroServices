package com.type.controller;

import com.netflix.discovery.EurekaClient;
import com.tpe.ReservationDTO;
import com.type.controller.request.ReservationRequest;
import com.type.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {

    private ReservationService reservationService;


   @PostMapping("/{carId}")
    public ResponseEntity<Map<String, String>>
                        saveReservation(@PathVariable Long carId, @RequestBody ReservationRequest reservationRequest){
        reservationService.saveReservation(carId, reservationRequest);

        Map<String, String> map = new HashMap<>();
        map.put("message", "Reservation Successfully Created");
        map.put("success", "true");
        return new ResponseEntity<>(map, HttpStatus.CREATED);


   }

   @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservation(){
      List<ReservationDTO> allReservations = reservationService.getAllReservations();
      return ResponseEntity.ok(allReservations);

   }

}
