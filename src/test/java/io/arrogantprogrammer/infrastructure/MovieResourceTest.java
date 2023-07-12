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
                .when().get("/movies")
                .then()
                .statusCode(200)
                .body(containsString("Mission: Impossible"));
    }

    @Test
    public void testAllMovies() {

        String expectedResult = """
                Movie{title='Mission: Impossible'}
                Movie{title='Mission: Impossible II'}
                Movie{title='Mission: Impossible III'}
                Movie{title='Mission: Impossible - Ghost Protocol'}
                Movie{title='Mission: Impossible - Rogue Nation'}
                Movie{title='Mission: Impossible - Fallout'}
                Movie{title='Mission: Impossible - Dead Reckoning Part One'}
                """;

        given()
                .when().get("/movies/all")
                .then()
                .statusCode(200)
                .body(containsString("Mission: Impossible"));
    }
}
