package br.com.techchalleng4.mslogistica.controller;

import br.com.techchalleng4.mslogistica.base.BaseTest;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.UUID;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrackingControllerIT extends BaseTest {

    public TrackingControllerIT() {
        this.URI = "trackings";
    }

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup(){
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void shouldAllowListTracking(){
        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get(getBaseUri())
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void shouldAllowTracking(){
        var URI = getBaseUri() + "/" + UUID.randomUUID().toString();

        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get(URI)
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
