package api_rest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class simpleTest {

    @Test
    void checkUnknownNameWithSomeLogs() {
        given()
                .log().uri()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().body()
                .body("data.name", is("fuchsia rose"));
    }

    @Test
    void successJobChangeTest() {
        String authData = "{\"name\": \"morpheus\", \"job\": \"zion resident\"}";


        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()

                .when()
                .put("https://reqres.in/api/users/2")

                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("job", is("zion resident"));
    }

    @Test
    void successNameChangeTest() {
        String authData = "{\"name\": \"morpheus1\", \"job\": \"zion resident\"}";


        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()

                .when()
                .put("https://reqres.in/api/users/2")

                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus1"));
    }

    @Test
    void notNameChangeTest() {
        String authData = "{\"job\": \"zion resident\"}";


        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()

                .when()
                .put("https://reqres.in/api/users/2")

                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", nullValue());
    }

    @Test
    void jobIsNotNullTest() {
        String authData = "{\"job\": \"zion resident\"}";

        var request = given()
                .body(authData)
                .contentType(JSON)
                .log().uri()
                .when();

        var response = request.put("https://reqres.in/api/users/2");

        var validateResponse = response.then();
        validateResponse
                .log().status()
                .log().body()
                .statusCode(200)
                .body("job", notNullValue());

    }

    @Test
    void listDataIdTest() {

        var request = given()
                .contentType(JSON)
                .log().uri()
                .when();

        var response = request.get("https://reqres.in/api/unknown");

        var validateResponse = response.then();
        validateResponse
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(List.of(1, 2, 3, 4, 5, 6)));


    }

}
