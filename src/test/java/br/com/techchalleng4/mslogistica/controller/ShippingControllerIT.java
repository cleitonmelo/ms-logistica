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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShippingControllerIT extends BaseTest {

    public ShippingControllerIT() {
        this.URI = "shippings";
    }

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void shouldAllowCreateShipping(){
        var request = getShippingDtoForInsert();

        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when().post(getBaseUri())
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("$", hasKey("id"))
                .body("orderCode", equalTo(request.orderCode()));
    }

    @Test
    void shouldAllowListShipping(){
        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get(getBaseUri())
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void shouldAllowFinishedShipping(){
        var URI = getBaseUri() + "/finished/" + UUID.randomUUID().toString();

        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().put(URI)
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }
}
