package com.type;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// Bu service config server olacak
@EnableConfigServer
//Bu service discoverable bir service olacak. descovery server a kendini kaydiettirmesi icin bu Anno.
@EnableEurekaClient
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }



}
