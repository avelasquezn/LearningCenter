package com.acme.learning.platform.step;

import com.acme.learning.platform.learning.resource.CreateStudentResource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@CucumberContextConfiguration
public class StudentStepDefinitions {

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();

    @LocalServerPort
    private int randomServerPort;

    private String endpointPath;

    private ResponseEntity<String> responseEntity;

    @Given("The Endpoint {string} is available")
    public void theEndpointIsAvailable(String endpointPath) {
        this.endpointPath = String.format(endpointPath, randomServerPort);
    }

    @When("A Post Request is sent with values {string}, {int}, {string}")
    public void aPostRequestIsSentWithValues(String name, int age, String address) {
        CreateStudentResource resource = new CreateStudentResource()
                .withName(name)
                .withAge(age)
                .withAddress(address);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreateStudentResource> request = new HttpEntity<>(resource, headers);
        responseEntity = testRestTemplate.postForEntity(endpointPath, request, String.class);
    }
}
