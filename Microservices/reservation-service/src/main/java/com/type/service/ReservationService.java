package com.type.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.type.controller.request.ReservationRequest;
import com.type.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class ReservationService {

    private ReservationRepository reservationRepository;

    private EurekaClient client; //reservation service bir cleint gibi davranacak!!! tamamen carservice locasyonuun alabilmek icin

    private RestTemplate restTemplate;

    public void saveReservayion(Long carId, ReservationRequest reservationRequest){
        InstanceInfo instanceInfo = client.getApplication("car-service").getInstances().get(0);

    }




}
