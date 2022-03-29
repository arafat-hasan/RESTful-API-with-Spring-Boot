package com.arafathasan.RESTfulAPIwithSpringBoot.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner( StudentRepository repository){
        return args -> {
           Student mariam = new Student(
                   "Mariam",
                   "mariam.jamal@gmail.com",
                   LocalDate.of(2000, JANUARY, 1)
           );
            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(1996, FEBRUARY, 5)
            );
            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
