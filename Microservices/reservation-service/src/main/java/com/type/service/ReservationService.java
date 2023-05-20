package com.type.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.tpe.CarDTO;
import com.tpe.ReservationDTO;
import com.tpe.enums.ReservationStatus;
import com.type.controller.request.ReservationRequest;
import com.type.domain.Reservation;
import com.type.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.modelmapper.Converters.Collection.map;

@Service
@AllArgsConstructor
public class ReservationService {

    private ReservationRepository reservationRepository;

    private EurekaClient eurekaClient;
    //reservation service bir cleint gibi davranacak!!! tamamen carservice locasyonuun alabilmek icin
    // birazdan reservation yapilacak arabanin olupolmadigini bu method yoluyla kontrolu yapilacak.

    private RestTemplate restTemplate;
    // eurekaClient ve restTemplate ile, kullanacagimiz neseneleri enjekte ettik, simdi kullanacagiz
    // restTemplate i car servisi cagirirken kullaniyor olacagiz.

    private ModelMapper modelMapper;
    //pom.xml e carService`den hem dependecy hemde poroperti de versiyonuu alip koydum. ayrica ReservationServiceApplication da da Beans olarak olusturdum
    // bu sekilde bagimliliklarini ekleyip kullanilabilir haline getirdik.
    public void saveReservation(Long carId, ReservationRequest reservationRequest){
        InstanceInfo instanceInfo = eurekaClient.getApplication("car-service").getInstances().get(0);
        String beseUrl = instanceInfo.getHomePageUrl(); // discovery uzerinden //localhost:8082 url de valistigini aldim

        String path = "/car/";

        //localhost:8082/car/1 url sini olusturduk. // bundan sonra restTemplate kullanarak bir servis cagrimi yapacagiz, yani bir sorgu olusturacagiz.
        String servicePath = beseUrl+path+carId.toString();

        //restTemplate in bir cok  hazir methodu var bunlardan biri getForEntity
       ResponseEntity<CarDTO> carDTOResponse = restTemplate.getForEntity(servicePath, CarDTO.class);
       //CarDTO yu core da olusturup her iki taraf ile paylastirmistik


        //OK ise car bilgimi alabildim
        if (!(carDTOResponse.getStatusCode()== HttpStatus.OK)){
            throw new ResourceAccessException("Car not found wit id:"+carId);
        }
        CarDTO carDTO =carDTOResponse.getBody();

        Reservation reservation = new Reservation();

        reservation.setCarId(carDTO.getId());
        reservation.setPickUpTime(reservationRequest.getPickUpTime());
        reservation.setDropOffTime(reservationRequest.getDropOffTime());
        reservation.setPickUpLocation(reservationRequest.getPickUpLocation());
        reservation.setDropOffLocation(reservationRequest.getDropOffLocation());

        reservation.setStatus(ReservationStatus.CREATED);
       double tp = totalPrice(reservationRequest.getPickUpTime(), reservationRequest.getDropOffTime(), carDTO);
        reservation.setTotalPrice(tp);
        reservationRepository.save(reservation);
    }

    public List<ReservationDTO> getAllReservations(){
       List<Reservation> rList = reservationRepository.findAll();

       List<ReservationDTO> rDTOList = rList.stream().map(this::mapReservationToDTO).collect(Collectors.toList());
        return rDTOList;
    }
    private ReservationDTO mapReservationToDTO(Reservation reservation){
    ReservationDTO reservationDTO = modelMapper.map(reservation, ReservationDTO.class);
    return reservationDTO;
    }



    private Double totalPrice(LocalDateTime pickupTime, LocalDateTime dropOffTime, CarDTO carDTO) {
        Long hours = (new Reservation()).getTotalHours(pickupTime, dropOffTime);
        return carDTO.getPricePerHour()*hours;

    }




}
