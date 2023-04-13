package com.type;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // // discover cleint olarak ekledigim projeleri bu Annot. ile kendilerini register edecekler
@SpringBootApplication
public class DiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }

    /*
     * Bu sinifi ana sinif olmasini belirleyen, daha dogrusu Configuration  classi olmasini belirten Annotation
     * @SpringBootApplication -> @Configuration dur.

     */



}
