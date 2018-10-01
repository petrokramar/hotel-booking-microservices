package com.hotelbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelBookingApp {
    public static void main(String[] args) {
        SpringApplication.run(HotelBookingApp.class, args);
    }
}