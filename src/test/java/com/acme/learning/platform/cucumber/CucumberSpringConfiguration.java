package com.acme.learning.platform.cucumber;

import com.acme.learning.platform.LearningCenterApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = LearningCenterApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = LearningCenterApplication.class,
        loader = SpringBootContextLoader.class)
public class CucumberSpringConfiguration {
}
