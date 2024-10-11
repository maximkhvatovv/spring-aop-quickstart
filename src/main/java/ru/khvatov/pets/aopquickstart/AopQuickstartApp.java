package ru.khvatov.pets.aopquickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopQuickstartApp {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(AopQuickstartApp.class, args);
    }
}
