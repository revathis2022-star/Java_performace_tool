// SpringBootApp.java
package com.example.vitdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class SpringBootApp {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        SpringApplication.run(SpringBootApp.class, args);
        System.out.println("Hello from Spring Boot Application!");

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Execution Time (ns): " + duration);
    }
}
