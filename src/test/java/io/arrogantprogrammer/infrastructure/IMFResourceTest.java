package io.arrogantprogrammer.infrastructure;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class IMFResourceTest {

    static final Logger LOGGER = LoggerFactory.getLogger(IMFResourceTest.class);
    @Test
    public void testAllIMFAgents() {

        given()
                .when().get("/imf/agents")
                .then()
                .statusCode(200)
                .body(containsString("Luther Stickell"));

    }
}
