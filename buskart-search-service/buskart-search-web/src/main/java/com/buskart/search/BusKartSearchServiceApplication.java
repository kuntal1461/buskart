package com.buskart.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.buskart.search")
public class BusKartSearchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusKartSearchServiceApplication.class, args);
        System.out.println( "this is the buskart search application");
    }
}
