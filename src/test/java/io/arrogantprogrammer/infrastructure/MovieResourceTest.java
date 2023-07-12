package io.arrogantprogrammer.infrastructure;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MovieResourceTest {

    @Test
    public void testRootPath() {

        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .body(containsString("Mission:Impossible"));

    }
}
