package com.acme.learning.platform;

import org.hibernate.annotations.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LearningCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningCenterApplication.class, args);
    }

}
