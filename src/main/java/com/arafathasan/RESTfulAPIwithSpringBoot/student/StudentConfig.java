package com.arafathasan.RESTfulAPIwithSpringBoot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        String name = StringUtils.capitalize(getSaltString(5))
                        + " " + StringUtils.capitalize(getSaltString(6));
        String email = getSaltString(5) + "@gmail.com";
        LocalDate date = LocalDate.of(
                1950 + (int) (Math.random() * (2000 - 1950) + 1),
                (int) (Math.random() * 12 + 1),
                (int) (Math.random() * 30 + 1)
        );

        return args -> {
            Student student = new Student(name, email, date);
            repository.saveAll(List.of(student));
        };
    }

    protected String getSaltString(int len) {
        String SALT_CHARS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < len) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALT_CHARS.length());
            salt.append(SALT_CHARS.charAt(index));
        }
        return  salt.toString();
    }

}
