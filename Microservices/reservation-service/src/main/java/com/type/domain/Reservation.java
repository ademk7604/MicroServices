package com.type.domain;

import com.tpe.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "t_reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Long carId; // iliski id uzeriden olacak

    @Column(nullable = false)
    private LocalDateTime pickUpTime;

    //rez baslangic bitis zamani

    @Column(nullable = false)
    private LocalDateTime dropOffTime;

    @Column(length = 150, nullable = false)
    private String pickUpLocation;

    // aracin alis brakilis zamani
    @Column(length = 150, nullable = false)
    private String dropOffLocation;

    @Column(nullable = false)
    private ReservationStatus status;

    @Column(nullable = false)
    private Double totalPrice;

    //totalPrice su metod ile hesaplayacak
    public Long getTotalHours(LocalDateTime pickUpTime, LocalDateTime dropOffTime){
        return ChronoUnit.HOURS.between(pickUpTime, dropOffTime);
    }







}
