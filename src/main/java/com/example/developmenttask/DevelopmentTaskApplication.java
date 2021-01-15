package com.example.developmenttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class DevelopmentTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevelopmentTaskApplication.class, args);
    }

}
