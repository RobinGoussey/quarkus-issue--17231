package org.example.service.extension.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ServiceExtensionResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/service-extension")
                .then()
                .statusCode(200)
                .body(is("Hello service-extension"));
    }
}
