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

    private EurekaClient eurekaClient; //reservation service bir cleint gibi davranacak!!! tamamen carservice locasyonuun alabilmek icin
    // birazdan reservation yapilacak arabanin olupolmadigini bu method yoluyla kontrolu yapilacak.

    private RestTemplate restTemplate; // eurekaClient ve restTemplate ile, kullanacagimiz neseneleri enjekte ettik, simdi kullanacagiz

    public void saveReservation(Long carId, ReservationRequest reservationRequest){
        InstanceInfo instanceInfo = eurekaClient.getApplication("car-service").getInstances().get(0);
        String beseUrl = instanceInfo.getHomePageUrl(); // discovery uzerinden //localhost:8082

        String path = "/car/";

        //localhost:8082/car/1
        String servicePath = beseUrl+path+carId.toString();


    }




}
