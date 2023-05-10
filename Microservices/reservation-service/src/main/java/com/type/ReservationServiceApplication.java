package com.type;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    /*
    Bana burda bir tane RestTemplate bean i olusturup verecek.
    RestTemplate nedir?
    car ve reservation servislerimizde bu RestTemplate ile reservation service car i cagirirken onun cleint i olmus oluyor.
    RestTemplate, diğer servisler ile iletişim kurmak için kullanılacak HTTP isteklerini oluşturmak ve göndermek için kullanılabilir.
     */
}
