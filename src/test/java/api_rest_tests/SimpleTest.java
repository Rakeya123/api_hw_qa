package api_rest_tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SimpleTest {

    @Test
    void checkUnknownNameWithSomeLogs() {
        given()
                .log().uri()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().body()
                .body("data.name", is("fuchsia rose"));
    }



}
