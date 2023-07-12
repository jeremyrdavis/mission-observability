package io.arrogantprogrammer.infrastructure;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class QuotesTest {

    @Test
    public void testRandomQuote() {

        given()
                .when().get("/quotes")
                .then()
                .statusCode(200);
    }
}
