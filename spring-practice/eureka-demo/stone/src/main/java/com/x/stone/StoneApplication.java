package com.x.stone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoneApplication.class, args);
    }

}
